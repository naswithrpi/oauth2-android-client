package com.chinmay.oauth2androidclient;

import com.chinmay.oauth2androidclient.api.AccessTokenAPI;
import com.chinmay.oauth2androidclient.api.AuthCodeAPI;
import com.chinmay.oauth2androidclient.api.ClientIdentificationAPI;
import com.chinmay.oauth2androidclient.api.ResourceAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.chinmay.oauth2androidclient.APIEndpoints.BASE_URL;

/**
 * Created by grandolf49 on 09-04-2020
 */
public class APIManager {

    private Retrofit retrofit;
    private AccessTokenAPI accessTokenAPI;
    private AuthCodeAPI authCodeAPI;
    private ClientIdentificationAPI clientIdentificationAPI;
    private ResourceAPI resourceAPI;

    public APIManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        initApis();
    }

    private void initApis() {
        accessTokenAPI = retrofit.create(AccessTokenAPI.class);
        authCodeAPI = retrofit.create(AuthCodeAPI.class);
        clientIdentificationAPI = retrofit.create(ClientIdentificationAPI.class);
        resourceAPI = retrofit.create(ResourceAPI.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public AccessTokenAPI getAccessTokenAPI() {
        return accessTokenAPI;
    }

    public AuthCodeAPI getAuthCodeAPI() {
        return authCodeAPI;
    }

    public ClientIdentificationAPI getClientIdentificationAPI() {
        return clientIdentificationAPI;
    }

    public ResourceAPI getResourceAPI() {
        return resourceAPI;
    }
}
