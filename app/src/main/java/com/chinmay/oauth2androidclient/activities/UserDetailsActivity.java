package com.chinmay.oauth2androidclient.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chinmay.oauth2androidclient.R;

import org.json.JSONException;
import org.json.JSONObject;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView tv_username, tv_email, tv_mobile, tv_dob;

    private static final String KEY_USERNAME = "userName";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_DOB = "dateOfBirth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        tv_username = findViewById(R.id.tv_username);
        tv_mobile = findViewById(R.id.tv_mobile);
        tv_email = findViewById(R.id.tv_email);
        tv_dob = findViewById(R.id.tv_dob);

        String user = getIntent().getStringExtra("user");
        if (user != null) {
            try {
                JSONObject userDetails = new JSONObject(user);
                String name = String.valueOf(userDetails.get(KEY_USERNAME));
                String email = String.valueOf(userDetails.get(KEY_EMAIL));
                String mobile = String.valueOf(userDetails.get(KEY_MOBILE));
                String dob = String.valueOf(userDetails.get(KEY_DOB));

                tv_username.setText(name);
                tv_email.setText(email);
                tv_mobile.setText(mobile);
                tv_dob.setText(dob);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
