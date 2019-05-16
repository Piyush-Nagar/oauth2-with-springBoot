package com.piyush.resourceserver.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.piyush.resourceserver.Login;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

  @RequestMapping(value = "/users-list", method = RequestMethod.GET)
  public ResponseEntity<Login> printHello() {

    Login login = new Login();
    log.info("Test Push done done done done ");
    login.setUsername("piyush");
    login.setPassword("123456789100");
    return ResponseEntity.ok(login);
  }
}
