package projectpackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import projectpackage.configuration.JPAConfiguration;

/**
 * Created by Gvozd on 30.12.2016.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Class<?>[] {Application.class, JPAConfiguration.class}, args);
    }


}
