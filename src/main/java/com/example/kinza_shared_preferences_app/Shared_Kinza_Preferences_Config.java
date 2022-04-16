package com.example.kinza_shared_preferences_app;

import android.content.Context;
import android.content.SharedPreferences;

public class Shared_Kinza_Preferences_Config {

    Context context;

    SharedPreferences sharedPreferences;

    public Shared_Kinza_Preferences_Config(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.kinza_preferences), Context.MODE_PRIVATE);
    }

    public void write_kinza_preferences(boolean kinza_status){

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(context.getResources().getString(R.string.kinza_status), kinza_status);

        editor.commit();

    }

    public boolean read_kinza_preferences(){

        boolean status = false;

        sharedPreferences.getBoolean(context.getResources().getString(R.string.kinza_status), status);

        return status;
    }
}
