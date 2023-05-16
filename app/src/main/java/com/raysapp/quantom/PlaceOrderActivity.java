package com.raysapp.quantom;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PlaceOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        CardView carda = findViewById(R.id.card1);
        CardView cardb = findViewById(R.id.card2);
        CardView cardc = findViewById(R.id.card3);
        carda.setCardBackgroundColor(Color.parseColor("#1E1B1B"));
        cardb.setCardBackgroundColor(Color.parseColor("#1E1B1B"));
        cardc.setCardBackgroundColor(Color.parseColor("#1E1B1B"));
    }

    public void placeorder(View view) {
        startActivity(new Intent(getApplicationContext(),PopupActivity.class));
    }
}