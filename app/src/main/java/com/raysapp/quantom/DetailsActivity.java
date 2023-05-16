package com.raysapp.quantom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView txttitle,txtprice,txtdefprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        imageView = findViewById(R.id.pimage);
        txttitle = findViewById(R.id.titlename);
        txtprice = findViewById(R.id.aprice);
        txtdefprice = findViewById(R.id.dprice);

        String id  = getIntent().getStringExtra("productid");
        String title = getIntent().getStringExtra("name");
        String mainprice = getIntent().getStringExtra("price");
        String standardprice = getIntent().getStringExtra("defprice");
        String mainimage = getIntent().getStringExtra("image");


        txttitle.setText(title);
        txtprice.setText(mainprice);
        txtdefprice.setText(standardprice);
        /*imageView.setImageResource(mainimage);*/
        Picasso.get().load(Constant.PUBLIC_URL+mainimage).into(imageView);

    }

    public void addtocart(View view) {

        Toast.makeText(this, "Product Added!!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),AddtocartActivity.class));
    }

    public void customize(View view) {
        startActivity(new Intent(getApplicationContext(),CustomizeActivity.class));
    }

    public void buy(View view) {
        startActivity(new Intent(getApplicationContext(),BuyNowActivity.class));
    }


}