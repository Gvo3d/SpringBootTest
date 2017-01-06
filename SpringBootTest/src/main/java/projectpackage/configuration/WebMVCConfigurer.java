package projectpackage.configuration;

import lombok.extern.log4j.Log4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
import projectpackage.components.AbstractDatabaseMessageSource;

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
        templateResolver.setCacheable(false);
        return templateResolver;
    }

//    Общий класс для отображения страниц и интернационализации сообщений
    @Bean
    SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(templateResolver());
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

//    Самодельный Message Source, достающий сообщения через JDBCTemplate из БД
    @Bean
    MessageSource messageSource(){
        AbstractDatabaseMessageSource vdms = new AbstractDatabaseMessageSource();
        vdms.setDefaultLocale("ru");
        return vdms;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}