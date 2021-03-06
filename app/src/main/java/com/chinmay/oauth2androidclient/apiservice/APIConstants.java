package com.chinmay.oauth2androidclient.apiservice;

/**
 * Created by grandolf49 on 09-04-2020
 */
public class APIConstants {

    private static String SERVER_IP_ADDRESS = "192.168.0.102";

    private static String OAUTH_SERVER_PORT = "8080";

    private static String OAUTH_WEB_CLIENT_PORT = "4200";

    public static final String CLIENT_IDENTIFICATION_ENDPOINT = "auth";

    private static final String CLIENT_ID = "1234";

    static String getServerIpAddress() {
        return SERVER_IP_ADDRESS;
    }

    static String getOauthServerPort() {
        return OAUTH_SERVER_PORT;
    }

    static void setServerIpAddress(String serverIpAddress) {
        SERVER_IP_ADDRESS = serverIpAddress;
    }

    static void setOauthServerPort(String oauthServerPort) {
        OAUTH_SERVER_PORT = oauthServerPort;
    }

    static String getClientId() {
        return CLIENT_ID;
    }

    static String getOAuthBaseUrl() {
        return "http://" + SERVER_IP_ADDRESS + ":" + OAUTH_SERVER_PORT + "/";
    }

    static String getOauthWebClientUrl() {
        return "http://" + SERVER_IP_ADDRESS + ":" + OAUTH_WEB_CLIENT_PORT + "/";
    }
}
