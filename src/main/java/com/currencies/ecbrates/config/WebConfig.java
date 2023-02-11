package com.currencies.ecbrates.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// see https://stackoverflow.com/questions/59914965/spring-mvc-requestmapping-requires-trailing-slash
// https://github.com/spring-projects-experimental/spring-boot-migrator/issues/206
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
      configurer.setUseTrailingSlashMatch(true);
  }

}