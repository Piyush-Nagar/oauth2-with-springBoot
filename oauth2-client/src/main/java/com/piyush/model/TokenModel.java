package com.mvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TokenModel {
  @JsonProperty(value = "access_token")
  String accessToken;
  @JsonProperty(value = "token_type")
  String tokenType;
  @JsonProperty(value = "expires_in")
  String expiresIn;
  @JsonProperty(value = "scope")
  String scope;
}
