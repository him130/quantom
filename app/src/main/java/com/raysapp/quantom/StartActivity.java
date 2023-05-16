package com.raysapp.quantom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    SharedPreferences.Editor myEdit;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sharedPreferences = getSharedPreferences("LoginShp",MODE_PRIVATE);
        myEdit = sharedPreferences.edit();

        if(sharedPreferences.getString("loginid","00").equals("00")){

        }else{
            startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
        }

    }

    public void signin(View view) {
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }

    public void signup(View view) {
        startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
    }

    public void guest(View view) {
        startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
    }
}