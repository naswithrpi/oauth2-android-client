package com.chinmay.oauth2androidclient.apiservice;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

import com.chinmay.oauth2androidclient.UserDetailsActivity;

/**
 * Created by grandolf49 on 27-04-2020
 */
public class JavaScriptNativeInterface {
    private Context context;

    public JavaScriptNativeInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void showToast(String message) {
        Intent intent = new Intent(context, UserDetailsActivity.class);
        intent.putExtra("user", message);
        context.startActivity(intent);
    }
}
