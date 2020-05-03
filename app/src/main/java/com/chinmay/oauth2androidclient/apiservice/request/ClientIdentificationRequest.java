package com.chinmay.oauth2androidclient.apiservice.request;

/**
 * Created by grandolf49 on 26-04-2020
 */
public class ClientIdentificationRequest {

    private String clientID;

    private String redirectionURL;

    private String scope;

    public ClientIdentificationRequest(String clientID, String redirectionURL, String scope) {
        this.clientID = clientID;
        this.redirectionURL = redirectionURL;
        this.scope = scope;
    }

    public String getClientID() {
        return clientID;
    }

    public String getRedirectionURL() {
        return redirectionURL;
    }

    public String getScope() {
        return scope;
    }
}
