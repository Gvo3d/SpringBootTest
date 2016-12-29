package projectpackage.configuration;

/**
 * Created by Gvozd on 30.12.2016.
 */
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}
