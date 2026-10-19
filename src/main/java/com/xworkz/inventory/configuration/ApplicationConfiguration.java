package com.xworkz.inventory.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.inventory")
@EnableWebMvc
public class ApplicationConfiguration implements WebMvcConfigurer {

public ApplicationConfiguration()
{
    System.out.println("created ApplicationConfiguration");
}

public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
}

@Bean
public InternalResourceViewResolver internalResourceViewResolver()
{
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/");
    resolver.setSuffix(".jsp");
    return resolver;
}

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/images/**")
            .addResourceLocations("/images/");
    registry.addResourceHandler("/css/**")
            .addResourceLocations("/css/");
}
}
