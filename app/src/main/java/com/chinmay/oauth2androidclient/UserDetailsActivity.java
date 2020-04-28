package com.chinmay.oauth2androidclient;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView tv_user_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        tv_user_details = findViewById(R.id.tv_user_details);
        String userDetails = getIntent().getStringExtra("user");
        if (userDetails != null) {
            tv_user_details.setText(userDetails);
        } else {
            tv_user_details.setText("No user details found.");
        }
    }
}
