package com.piyush.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Login {
  @JsonProperty(value = "username")
  private String username;
  @JsonProperty(value = "password")
  private String password;
}
