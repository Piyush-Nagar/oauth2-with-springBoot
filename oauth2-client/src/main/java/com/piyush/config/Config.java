package com.piyush.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.piyush.service.OauthEndPointImpl;

/**
 * @author Piyush Nagar.
 */
@Configuration
public class Config {
  @Value(value = "/home/piyushnagar/mediaiq/projects/github/oauth2-with-springBoot/oauth2-client/properties/my-oauth-server.conf")
  String filePath;
  @Bean
  public OauthEndPointImpl getOauthImplementation() {
    return new OauthEndPointImpl(filePath);
  }
}
