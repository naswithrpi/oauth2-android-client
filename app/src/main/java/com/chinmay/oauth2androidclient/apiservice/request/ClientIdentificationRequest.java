package com.chinmay.oauth2androidclient.apiservice.request;

/**
 * Created by grandolf49 on 26-04-2020
 */
public class ClientIdentificationRequest {

    private String clientID;

    private String redirectionURL;

    public ClientIdentificationRequest(String clientID, String redirectionURL) {
        this.clientID = clientID;
        this.redirectionURL = redirectionURL;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getRedirectionURL() {
        return redirectionURL;
    }

    public void setRedirectionURL(String redirectionURL) {
        this.redirectionURL = redirectionURL;
    }
}
