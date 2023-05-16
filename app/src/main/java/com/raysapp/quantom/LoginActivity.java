package com.raysapp.quantom;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.raysapp.quantom.Model.ErrorModel;
import com.raysapp.quantom.Model.LoginResponse;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends AppCompatActivity {

    EditText e_username,e_password;
    String s_username,s_password;
    SharedPreferences.Editor myEdit;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sharedPreferences = getSharedPreferences("LoginShp",MODE_PRIVATE);
        myEdit = sharedPreferences.edit();

        CardView card = findViewById(R.id.card);
        card.setCardBackgroundColor(Color.parseColor("#ffffff"));

        e_username = findViewById(R.id.edit_username);
        e_password = findViewById(R.id.edit_password);


    }

    public void signin(View view) {
        s_username = e_username.getText().toString();
        s_password = e_password.getText().toString();

        if(s_username.length()==0){
            e_username.setError("Please enter username");

        }else if(s_password.length()<8){

            e_password.setError("Minimum length must greater than 8 charecter");
        }else{
            login();
        }
    }

    private void login() {



        String url = Constant.main_url+"login";

        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println(response);
               /* Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();*/
                Gson gson = new Gson();

                try {

                    LoginResponse profileModel = gson.fromJson(response,LoginResponse.class);
                    System.out.println("Profile USER ID :: "+profileModel.getUser().getId());

                    if (profileModel.getResult().equals("true")){
                        success();
                    }else if (profileModel.getResult().equals("false")){

                    }

                }catch (Exception e){

                    Toast.makeText(LoginActivity.this, "Error Profile", Toast.LENGTH_SHORT).show();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            private String response;

            public void onErrorResponse(VolleyError error) {
                try {

                    Gson gson = new Gson();
                    ErrorModel errorModel = gson.fromJson(response, ErrorModel.class);
                    error();

                    Toast.makeText(getApplicationContext(), errorModel.getMessage(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                    System.out.println("Error occured");
                    Toast.makeText(LoginActivity.this, "Error Error", Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("user_type","Customer");
                params.put("email", s_username);
                params.put("identity_matrix", String.valueOf(true));
                params.put("password", s_password);

                return params;
            }
        };

        queue.add(request);
    }
    public void error(){
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText("User not found")
                .show();
    }
    public void success(){
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Good job!")
                .setContentText("You clicked the button!")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                        startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
                    }
                })
                .show();
    }

    public void forgetpassword(View view) {
        startActivity(new Intent(getApplicationContext(),FPMobileActivity.class));
    }

    public void sign_up(View view) {
        startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
    }
}