package projectpackage.configuration;

import lombok.extern.log4j.Log4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Gvozd on 30.12.2016.
 */
@Log4j
//@Configuration
public class ContextConfiguration {

    //    JdbcTemplate for internationalized messages loading
    @Bean
    JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(customDataSource());
        return jdbcTemplate;
    }

    //    DataSource for JdbcTemplate
    @Bean
    DataSource customDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        Properties props = new Properties();
        FileInputStream fis = null;
        try {
            String fileName = "application.properties";
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            fis = new FileInputStream(file);

            props.load(fis);
            dataSource.setUrl(props.getProperty("dataSource.url"));
            dataSource.setUsername(props.getProperty("dataSource.username"));
            dataSource.setPassword(props.getProperty("dataSource.password"));
            try {
                Class.forName(props.getProperty("dataSource.driverClassName"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            dataSource.setDriverClassName(props.getProperty("dataSource.driverClassName"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
