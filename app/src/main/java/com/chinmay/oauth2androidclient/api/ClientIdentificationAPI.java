package com.chinmay.oauth2androidclient.api;

import com.chinmay.oauth2androidclient.request.ClientIdentificationRequest;
import com.chinmay.oauth2androidclient.response.ClientIdentificationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static com.chinmay.oauth2androidclient.APIEndpoints.CLIENT_IDENTIFICATION_ENDPOINT;

/**
 * Created by grandolf49 on 09-04-2020
 */
public interface ClientIdentificationAPI {
    @POST(CLIENT_IDENTIFICATION_ENDPOINT)
    Call<ClientIdentificationResponse> getClientIdentification(@Body ClientIdentificationRequest client);
}
