package projectpackage.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import projectpackage.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Gvozd on 30.12.2016.
 */
@Configuration
public class ContextConfiguration {

    //    JdbcTemplate for internationalized messages loading
    @Bean
    JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    //    DataSource for JdbcTemplate
    @Bean
    DataSource dataSource() {
        System.out.println("TRYING PROPS");
        DataSource dataSource = new DataSource();
        Properties props = new Properties();
//        FileInputStream fis = null;
        try {
            InputStream fis = Application.class.getResourceAsStream("application.properties");
//            fis = new FileInputStream("classpath:application.properties");
            props.load(fis);
            System.out.println(props.getProperty("dataSource.url"));
            dataSource.setUrl(props.getProperty("dataSource.url"));
            dataSource.setName(props.getProperty("dataSource.username"));
            dataSource.setPassword(props.getProperty("dataSource.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
