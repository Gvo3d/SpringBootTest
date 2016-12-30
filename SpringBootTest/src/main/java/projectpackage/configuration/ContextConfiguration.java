package projectpackage.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Comparator;

/**
 * Created by Gvozd on 30.12.2016.
 */
@Configuration
public class ContextConfiguration {

    @Bean
    DataSource getDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass();
    }
}
