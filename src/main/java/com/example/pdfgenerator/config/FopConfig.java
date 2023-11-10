package com.example.pdfgenerator.config;

import org.apache.fop.apps.FopFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FopConfig {

    @Bean
    public FopFactory fopFactory() throws Exception {
        FopFactory fopFactory = FopFactory.newInstance();
        // Additional FOP configuration can be added here
        return fopFactory;
    }
}
