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
import org.thymeleaf.spring4.messageresolver.SpringMessageResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
import projectpackage.components.DatabaseThymeleafMessageResolver;
import projectpackage.components.VerticalDatabaseMessageSource;

import java.util.HashSet;

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
        springTemplateEngine.setDefaultMessageResolvers(messageResolvers());
        return springTemplateEngine;
    }

//    Общий резольвер
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(springTemplateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

//    Резольвер локалей, заточенный под Default русскую локаль
//    @Bean
//    LocaleResolver localeResolver(){
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(new Locale("ru"));
//        return sessionLocaleResolver;
//    }
    @Bean
    HashSet<IMessageResolver> messageResolvers(){
        HashSet<IMessageResolver> hashSet = new HashSet<>();
        hashSet.add(iMessageResolver());
        hashSet.add(customMessageResolver());
        return hashSet;
    }

    @Bean
    SpringMessageResolver iMessageResolver(){
        SpringMessageResolver messageResolver = new SpringMessageResolver();
        messageResolver.setMessageSource(MymessageSource());
        return messageResolver;
    }

//    Самодельный message resolver под интернационализацию из БД
    @Bean
    IMessageResolver customMessageResolver(){
        log.info("Creating custom message resolver bean.");
        return new DatabaseThymeleafMessageResolver(verticalDatabaseMessageSource());
    }

//    Самодельный Message Source, достающий сообщения через JDBCTemplate из БД
    @Bean
    VerticalDatabaseMessageSource verticalDatabaseMessageSource(){
        log.info("Creating vertical database message source bean.");
        return new VerticalDatabaseMessageSource();
    }

//    Класс интернационализации сообщений из interface_ru.properties
    @Bean
    MessageSource MymessageSource(){
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