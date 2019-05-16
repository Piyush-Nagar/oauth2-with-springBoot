package com.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.mvc.service.OauthEndPointImpl;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
@ComponentScan(value = "com.mvc")
public class Application implements CommandLineRunner {

  @Autowired
  private OauthEndPointImpl oauthEndPoint;

  public static void main(String[] args) throws Exception {
    new SpringApplicationBuilder(Application.class)
        .contextClass(AnnotationConfigApplicationContext.class)
        .run(args);
    Runtime.getRuntime().exit(0);
  }

  @Override
  public void run(String... strings) throws Exception {
    oauthEndPoint.getApiData()
    .ifPresent(login -> log.info("api data is: username {} and password {}",
                                        login.getUsername(),
                                        login.getPassword()));
  }
}
