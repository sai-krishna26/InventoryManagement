package com.xworkz.inventory.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.inventory")
@EnableWebMvc
public class ApplicationConfiguration  {

public ApplicationConfiguration()
{
    System.out.println("created ApplicationConfiguration");
}

public InternalResourceViewResolver internalResourceViewResolver()
{
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/");
    resolver.setSuffix(".jsp");
    return resolver;
}
}
