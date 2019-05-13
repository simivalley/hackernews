package org.homework.hackernews;

import org.homework.hackernews.module.NewsServicesLinks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean oneAction( ActionServlet actionServlet){
        return new ServletRegistrationBean(actionServlet, "/moviefun/*");
    }


    @Bean
    NewsServicesLinks newsServicesLinks(@Value("${top.news.service}") String topNewsService) {
        return new NewsServicesLinks(topNewsService);
    }


}
