package projectpackage.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import projectpackage.components.VerticalDatabaseMessageSource;

import java.io.FileInputStream;
import java.io.IOException;
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
        DataSource dataSource = new DataSource();
        Properties props = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("application.properties");
            props.load(fis);
            dataSource.setUrl(props.getProperty("dataSource.url"));
            dataSource.setName(props.getProperty("dataSource.username"));
            dataSource.setPassword(props.getProperty("dataSource.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    //    Custom MessageSource for database internationalization
    @Bean
    MessageSource verticalDatabaseMessageSource() {
        return new VerticalDatabaseMessageSource();
    }
}
