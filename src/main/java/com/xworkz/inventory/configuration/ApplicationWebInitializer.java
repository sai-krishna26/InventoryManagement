package com.xworkz.inventory.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public ApplicationWebInitializer()
    {
        System.out.println("created ApplicationWebInitializer");
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("ApplicationWebInitializer getRootConfigClasses()");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("ApplicationWebInitializer getServletConfigClasses()");
        return new Class[]{ApplicationConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("ApplicationWebInitializer getServletMappings()");
        return new String[]{"/"};
    }
}
