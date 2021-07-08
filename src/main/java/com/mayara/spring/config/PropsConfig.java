package com.mayara.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PropsConfig {

  @Bean
  public PropertySourcesPlaceholderConfigurer config(){
    PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setLocation(new FileSystemResource("/home/mayara/Documents/Configuracao/application.properties"));
    return configurer;
  }

}
