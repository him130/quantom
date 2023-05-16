package com.raysapp.quantom;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SplashScreenActivity extends AppCompatActivity {

    TextView logo1;
    TextView logo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        logo1= findViewById(R.id.logo1);
        logo2= findViewById(R.id.logo2);
        YoYo.with(Techniques.BounceInDown)
                .duration(1000)
                .repeat(0)
                .playOn(logo1);
        YoYo.with(Techniques.BounceInDown)
                .duration(1000)
                .repeat(0)
                .playOn(logo2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),StartActivity.class));
                finish();
            }
        }, 2000);
    }
}