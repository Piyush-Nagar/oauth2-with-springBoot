package com.mvc.service;

import com.mvc.model.Login;
import com.mvc.model.TokenModel;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigParseOptions;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


@Slf4j
public class OauthEndPointImpl {
  private static final String GRANT_TYPE = "password";
  private static final String USER_NAME = "piyush";
  private static final String PASSWORD = "1234567890";
  private final OauthEndPoint endPoint;
  private final Config config;

  public OauthEndPointImpl(String confFilePath) {
    config =
        ConfigFactory.load(ConfigFactory.parseFile(new File(confFilePath),
                                                   ConfigParseOptions.defaults()
                                                       .setAllowMissing(false)));
    this.endPoint = new Retrofit.Builder()
        .baseUrl(config.getString("my-server.base-url"))
        .addConverterFactory(JacksonConverterFactory.create())
        .build().create(OauthEndPoint.class);
  }


  public Optional<Login> getApiData() {

    try {
      Optional<TokenModel> tokenModel = getToken();
      String token = tokenModel
          .map(TokenModel::getAccessToken)
          .orElse("");
      return getApiData(token);
    } catch (IOException e) {
      log.error("Exception while accessing api data:", e);
    }
    return Optional.empty();
  }

  private Optional<TokenModel> getToken () throws IOException {
    String encodedAuthorizationHeader = getEncodedAuthorizationHeader();
    Call<TokenModel> token =
        endPoint.getToken(GRANT_TYPE, USER_NAME, PASSWORD, encodedAuthorizationHeader);
    Response<TokenModel> execute1 = token.execute();
    if (execute1.isSuccessful()) {
      return Optional.of(execute1.body());
    }
    return Optional.empty();
  }

  private Optional<Login> getApiData(String token) throws IOException {
    Call<Login> userData = endPoint.getApiData(token);
    Response<Login> execute1 = userData.execute();
    if (execute1.isSuccessful()) {
      return Optional.of(execute1.body());
    }
    return Optional.empty();
  }

  private String getEncodedAuthorizationHeader() {

    String clientIdAndSecretString =
        MessageFormat.format("{0}:{1}",
                             config.getString("my-server.client_id"),
                             config.getString("my-server.client_secret"));
    byte clientIdAndSecretBytes[] = clientIdAndSecretString.getBytes();
    return "Basic " + Base64.getEncoder()
        .encodeToString(clientIdAndSecretBytes);
  }

}
