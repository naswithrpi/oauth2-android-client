package com.chinmay.oauth2androidclient.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chinmay.oauth2androidclient.R;
import com.chinmay.oauth2androidclient.apiservice.APIManager;
import com.chinmay.oauth2androidclient.apiservice.JavaScriptNativeInterface;
import com.chinmay.oauth2androidclient.apiservice.request.ClientIdentificationRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private TextView tv_response;
    private EditText et_server_ip, et_server_port;

    private APIManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.pb);
        tv_response = findViewById(R.id.tv_response);
        et_server_ip = findViewById(R.id.et_server_ip);
        et_server_port = findViewById(R.id.et_server_port);

        apiManager = new APIManager();

        et_server_ip.setText(apiManager.getServerIpAddress());
        et_server_port.setText(apiManager.getOauthServerPort());
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_select_oauth) {
            loginOAuth();
        }
    }

    private void loginOAuth() {
        pb.setVisibility(View.VISIBLE);

        String server_ip = et_server_ip.getText().toString().trim();
        String server_port = et_server_port.getText().toString().trim();

        apiManager.setServerIpAddress(server_ip);
        apiManager.setServerPort(server_port);

        apiManager.initializeRetrofit();

        Call<ClientIdentificationRequest> call = apiManager.getClientIdentificationAPI()
                .getClientIdentification(new ClientIdentificationRequest(
                        apiManager.getClientId(), "", "[userName, email, mobile, dateOfBirth]"));
        call.enqueue(new Callback<ClientIdentificationRequest>() {
            @Override
            public void onResponse(Call<ClientIdentificationRequest> call
                    , Response<ClientIdentificationRequest> response) {
                pb.setVisibility(View.INVISIBLE);
                // do something with response
                tv_response.setText("====Response====\n");
                tv_response.append(response.toString() + "\n");
                ClientIdentificationRequest body = response.body();
                if (body != null) {
                    String redirectUrl = body.getRedirectionURL();
                    tv_response.append("====Body====\n");
                    tv_response.append("Client ID: " + body.getClientID() + "\n");
                    tv_response.append("Redirect URL: " + redirectUrl + "\n");
                    redirectTo(redirectUrl);
                }
            }

            @Override
            public void onFailure(Call<ClientIdentificationRequest> call, Throwable t) {
                pb.setVisibility(View.INVISIBLE);
                tv_response.setText("Error: " + t.getMessage());
            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void redirectTo(String redirectUrl) {
        Dialog dialog = new Dialog(this);
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_webpage
                , null);
        WebView webView = view.findViewById(R.id.web_view);
        webView.setClickable(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JavaScriptNativeInterface(this), "Android");
        webView.loadUrl(redirectUrl);

        dialog.setContentView(view);
        dialog.show();
    }

}
