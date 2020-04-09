package com.chinmay.oauth2androidclient.api;

import com.chinmay.oauth2androidclient.request.AuthCodeRequest;
import com.chinmay.oauth2androidclient.response.AuthCodeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static com.chinmay.oauth2androidclient.APIEndpoints.AUTH_CODE_ENDPOINT;

/**
 * Created by grandolf49 on 09-04-2020
 */
public interface AuthCodeAPI {
    @POST(AUTH_CODE_ENDPOINT)
    Call<AuthCodeResponse> getAuthCode(@Body AuthCodeRequest authCodeRequest);
}
