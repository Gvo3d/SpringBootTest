package projectpackage.configuration;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
POM.XML configuration:
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb -->
 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-data-mongodb</artifactId>
 <version>1.4.3.RELEASE</version>
 </dependency>
 */

@Configuration
@EnableMongoRepositories
public class MongoConfiguration {

    @Bean
    public MongoClient mongoClient(){
        return new MongoClient();
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(), "DBNAME");
    }
}
