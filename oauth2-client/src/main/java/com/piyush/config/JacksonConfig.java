package com.piyush.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class JacksonConfig {

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper()
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }

}