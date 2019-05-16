package com.piyush.resourceserver;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Login {
  private String username;
  private String password;
}
