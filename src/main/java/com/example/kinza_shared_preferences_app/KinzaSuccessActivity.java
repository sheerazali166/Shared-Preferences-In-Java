package com.example.kinza_shared_preferences_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class KinzaSuccessActivity extends AppCompatActivity {

    Shared_Kinza_Preferences_Config shared_kinza_preferences_config;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinza_success);

        shared_kinza_preferences_config = new Shared_Kinza_Preferences_Config(getApplicationContext());
    }

    public void kinza_logout(View view) {

        shared_kinza_preferences_config.write_kinza_preferences(false);

        startActivity(new Intent(KinzaSuccessActivity.this, MainActivity.class));

        finish();
    }
}