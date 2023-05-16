package com.raysapp.quantom;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.raysapp.quantom.Model.SignupModel;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RegistrationActivity extends AppCompatActivity {

    EditText e_name,e_username,e_password;
    String s_name, s_username,s_password;

    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        CardView card = findViewById(R.id.card);
        card.setCardBackgroundColor(Color.parseColor("#ffffff"));

        e_name = findViewById(R.id.name);
        e_username = findViewById(R.id.username);
        e_password = findViewById(R.id.password);

    }

    public void signup(View view) {

        s_name = e_name.getText().toString();
        s_username =e_username.getText().toString();
        s_password =e_password.getText().toString();

        if (s_name.length()==0){
            e_name.setText("Enter your name");
        }else if (s_username.length()==0){
            e_username.setText("Enter username");
        }else if(s_password.length()<8){
            e_password.setText("Minimum length must greater than 8 charecter");
        }else{
            registration();
        }

    }

    private void registration() {
        String url = Constant.main_url+"signup";

        RequestQueue queue = Volley.newRequestQueue(RegistrationActivity.this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                System.out.println(response);
                Gson gson = new Gson();

                try {
                    SignupModel signupModel = gson.fromJson(response,SignupModel.class);
                    System.out.println("Profile USER ID :: "+signupModel.getUserId());

                     if (signupModel.getResult()){
                        success();
                        System.out.println("Success method");
                    }else if (signupModel.getUserId()==null){
                        Toast.makeText(RegistrationActivity.this, signupModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            private String response;
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    Gson gson = new Gson();
                    SignupModel signupModel = gson.fromJson(response,SignupModel.class);

                    if (s_name.length()==0){
                        e_name.setText("Enter your name");
                    }else if (s_username.length()==0){
                        e_username.setText("Enter username");
                    }else if(s_password.length()<8){
                        e_password.setText("Minimum length must greater than 8 charecter");
                    }else{
                        error();
                    }
                }catch (Exception e){

                }

            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("name",s_name);
                params.put("email_or_phone", s_username);
                params.put("password", s_password);
                return params;
            }
        };

        queue.add(request);
    }
    public void error(){
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText(message)
                .show();
    }
    public void success(){
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Good job!")
                .setContentText("Registration Successful")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        finish();
                    }
                })
                .show();
    }

}