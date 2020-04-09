package com.chinmay.oauth2androidclient.api;

import com.chinmay.oauth2androidclient.request.ResourceRequest;
import com.chinmay.oauth2androidclient.response.ResourceResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static com.chinmay.oauth2androidclient.APIEndpoints.RESOURCE_ENDPOINT;

/**
 * Created by grandolf49 on 09-04-2020
 */
public interface ResourceAPI {
    @POST(RESOURCE_ENDPOINT)
    Call<ResourceResponse> getResources(@Body ResourceRequest resourceRequest);
}
