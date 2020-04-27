package com.chinmay.oauth2androidclient.apiservice;

/**
 * Created by grandolf49 on 09-04-2020
 */
public class APIConstants {

    private static final String SERVER_IP_ADDRESS = "192.168.0.103";

    private static final String OAUTH_SERVER_PORT = "8080";

    private static final String OAUTH_WEB_CLIENT_PORT = "4200";

    public static final String CLIENT_IDENTIFICATION_ENDPOINT = "auth";

    public static final String CLIENT_ID = "1234";

    static String getOAuthBaseUrl() {
        return "http://" + SERVER_IP_ADDRESS + ":" + OAUTH_SERVER_PORT + "/";
    }

    static String getOauthWebClientUrl() {
        return "http://" + SERVER_IP_ADDRESS + ":" + OAUTH_WEB_CLIENT_PORT + "/";
    }
}
