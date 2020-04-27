package com.chinmay.oauth2androidclient.apiservice;

import com.chinmay.oauth2androidclient.apiservice.api.ClientIdentificationAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.chinmay.oauth2androidclient.apiservice.APIConstants.getOAuthBaseUrl;
import static com.chinmay.oauth2androidclient.apiservice.APIConstants.getOauthWebClientUrl;

/**
 * Created by grandolf49 on 09-04-2020
 */
public class APIManager {

    private Retrofit retrofit;
    private ClientIdentificationAPI clientIdentificationAPI;

    public APIManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(getOAuthBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        initApis();
    }

    private void initApis() {
        clientIdentificationAPI = retrofit.create(ClientIdentificationAPI.class);
    }

    public ClientIdentificationAPI getClientIdentificationAPI() {
        return clientIdentificationAPI;
    }

    public String getOAuthWebClientUrl() {
        return getOauthWebClientUrl();
    }
}
