package com.raysapp.quantom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddtocartActivity extends AppCompatActivity {

    public ImageView minus,plus;
    public TextView quantity,price,tprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtocart);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        minus = findViewById(R.id.minusbtn);
        plus = findViewById(R.id.plusbtn);
        quantity = findViewById(R.id.quantitytxt);
        price = findViewById(R.id.product_price);
        tprice = findViewById(R.id.totalprice);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = 1;
                quantity++;
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
    public void confirm(View view) {

        startActivity(new Intent(getApplicationContext(),AddressActivity.class));

    }

}