package projectpackage.configuration;

import lombok.extern.log4j.Log4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
import projectpackage.components.DatabaseThymeleafMessageResolver;
import projectpackage.components.VerticalDatabaseMessageSource;

/**
 * Created by Gvozd on 30.12.2016.
 */
@Log4j
@Configuration
@EnableWebMvc
public class WebMVCConfigurer extends WebMvcConfigurerAdapter {

//    Ищет View(Template) для отображения страниц
    @Bean
    TemplateResolver templateResolver() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

//    Общий класс для отображения страниц и интернационализации сообщений
    @Bean
    SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(templateResolver());
        springTemplateEngine.setMessageSource(messageSource());
        springTemplateEngine.addMessageResolver(customMessageResolver());
        return springTemplateEngine;
    }

//    Общий резольвер
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(springTemplateEngine());
        return resolver;
    }

//    Самодельный message resolver под интернационализацию из БД
    @Bean
    IMessageResolver customMessageResolver(){
        return new DatabaseThymeleafMessageResolver(verticalDatabaseMessageSource());
    }

//    Самодельный Message Source, достающий сообщения через JDBCTemplate из БД
    @Bean
    VerticalDatabaseMessageSource verticalDatabaseMessageSource(){
        return new VerticalDatabaseMessageSource();
    }

//    Класс интернационализации сообщений из interface.properties
    @Bean
    MessageSource messageSource(){
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("classpath:interface");
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        reloadableResourceBundleMessageSource.setFallbackToSystemLocale(false);
        return reloadableResourceBundleMessageSource;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}