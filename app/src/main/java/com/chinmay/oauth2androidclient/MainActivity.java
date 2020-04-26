package com.chinmay.oauth2androidclient;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chinmay.oauth2androidclient.apiservice.APIManager;
import com.chinmay.oauth2androidclient.apiservice.request.ClientIdentificationRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.chinmay.oauth2androidclient.apiservice.APIConstants.CLIENT_ID;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private TextView tv_response;
    private APIManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.pb);
        tv_response = findViewById(R.id.tv_response);

        apiManager = new APIManager();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_select_oauth) {
            loginOAuth();
        }
    }

    private void loginOAuth() {
        pb.setVisibility(View.VISIBLE);
        Call<ClientIdentificationRequest> call = apiManager.getClientIdentificationAPI()
                .getClientIdentification(new ClientIdentificationRequest(
                        CLIENT_ID, ""));
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
                    tv_response.append("====Body====\n");
                    tv_response.append("Client ID: " + body.getClientID() + "\n");
                    tv_response.append("Redirect URL: " + body.getRedirectionURL());
                }
            }

            @Override
            public void onFailure(Call<ClientIdentificationRequest> call, Throwable t) {
                pb.setVisibility(View.INVISIBLE);
                tv_response.setText("Error: " + t.getMessage());
            }
        });
    }
}
