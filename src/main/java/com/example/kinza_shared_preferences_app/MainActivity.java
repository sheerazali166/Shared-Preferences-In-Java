package com.example.kinza_shared_preferences_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Shared_Kinza_Preferences_Config shared_kinza_preferences_config;

    EditText editTextUserKinza;

    EditText editTextKinzaPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shared_kinza_preferences_config = new Shared_Kinza_Preferences_Config(getApplicationContext());

        editTextUserKinza = findViewById(R.id.editTextUserKinza);

        editTextKinzaPassword = findViewById(R.id.editTextTextPasswordKinza);

        if(shared_kinza_preferences_config.read_kinza_preferences()){

            startActivity(new Intent(MainActivity.this, KinzaSuccessActivity.class));

            finish();
        }
    }

    public void kinza_submit(View view) {

        String kinzaUser = editTextUserKinza.getText().toString();

        String kinzaPassword = editTextKinzaPassword.getText().toString();

        String kinza = getResources().getString(R.string.kinza_username);

        String chocolatyKinzaPassword = getResources().getString(R.string.kinza_password);

        if (kinzaUser.equals(kinza) && kinzaPassword.equals(chocolatyKinzaPassword)){

            shared_kinza_preferences_config.write_kinza_preferences(true);

            startActivity(new Intent(MainActivity.this, KinzaSuccessActivity.class));

            finish();

            Toast.makeText(this, "Kinza Login Successful", Toast.LENGTH_SHORT).show();
        }

        else{

            Toast.makeText(this, "Kinza Login Failed", Toast.LENGTH_SHORT).show();

            editTextUserKinza.setText("");

            editTextKinzaPassword.setText("");

            Toast.makeText(this, kinza, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, chocolatyKinzaPassword, Toast.LENGTH_SHORT).show();

        }

    }


}