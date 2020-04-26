package com.chinmay.oauth2androidclient.apiservice.api;

import com.chinmay.oauth2androidclient.apiservice.request.ClientIdentificationRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static com.chinmay.oauth2androidclient.apiservice.APIConstants.CLIENT_IDENTIFICATION_ENDPOINT;

/**
 * Created by grandolf49 on 09-04-2020
 */
public interface ClientIdentificationAPI {
    @POST(CLIENT_IDENTIFICATION_ENDPOINT)
    Call<ClientIdentificationRequest> getClientIdentification(@Body ClientIdentificationRequest client_id);
}
