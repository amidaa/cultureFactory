package com.first.group.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
    @Configuration
    public class UploadFileConfiguration {


        @Bean
        public MultipartConfigElement configElement() {
            MultipartConfigFactory factory = new MultipartConfigFactory();
            factory.setMaxFileSize("2048MB");
            factory.setMaxRequestSize("2048MB");

            return factory.createMultipartConfig();
        }
//	 @Bean
//	 public MultipartResolver multipartResolver() {
//	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//	        multipartResolver.setMaxUploadSizePerFile(104857600L);
//	        return multipartResolver;
//	 }


    }

