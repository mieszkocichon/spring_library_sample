package com.mieszkocichon.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringLibraryApplication extends SpringBootServletInitializer {

    private static final Class THIS_CLASS = SpringLibraryApplication.class;
    private static final String CLASS_NAME = THIS_CLASS.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(THIS_CLASS);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(THIS_CLASS);
    }

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/SimpleLibrarySpring");
        SpringApplication.run(SpringLibraryApplication.class, args);
        LOGGER.info(String.format("%s has started", CLASS_NAME));
    }
}
