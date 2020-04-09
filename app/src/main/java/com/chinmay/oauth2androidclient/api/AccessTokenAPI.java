package com.chinmay.oauth2androidclient.api;

import com.chinmay.oauth2androidclient.request.AccessTokenRequest;
import com.chinmay.oauth2androidclient.response.AccessTokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static com.chinmay.oauth2androidclient.APIEndpoints.ACCESS_TOKEN_ENDPOINT;

/**
 * Created by grandolf49 on 09-04-2020
 */
public interface AccessTokenAPI {
    @POST(ACCESS_TOKEN_ENDPOINT)
    Call<AccessTokenResponse> getAccessToken(@Body AccessTokenRequest accessTokenRequest);
}
