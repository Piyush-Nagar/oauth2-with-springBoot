package com.mvc.service;

import com.mvc.model.Login;
import com.mvc.model.TokenModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface OauthEndPoint {
    @GET("users-list")
    Call<Login> getApiData(@Query("access_token") String token);
    @POST("oauth/token")
    Call<TokenModel> getToken(@Query("grant_type")String grantType,
                              @Query("username")String userName,
                              @Query("password")String password,
                              @Header("Authorization")  String header);


}
