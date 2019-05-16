package com.mvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mvc.service.OauthEndPointImpl;

/**
 * @author Piyush Nagar.
 */
@Configuration
public class Config {
  @Value(value = "/home/piyush/ALL/evive/allproject/myprojects/Oauth/OauthClient/properties/my-oauth-server.conf")
  String filePath;
  @Bean
  public OauthEndPointImpl getOauthImplementation() {
    return new OauthEndPointImpl(filePath);
  }
}
