package com.raysapp.quantom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MenBlockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_block);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageSlider imageSlider = findViewById(R.id.image_slider);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.slideo, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slideo,ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slideo,ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(slideModels,ScaleTypes.CENTER_CROP);

    }

    public void suit(View view) {
        startActivity(new Intent(getApplicationContext(),BusinessSuitActivity.class));
    }

    public void trous(View view) {
        startActivity(new Intent(getApplicationContext(),TrouserActivity.class));
    }

    public void jacket(View view) {
        startActivity(new Intent(getApplicationContext(),JacketActivity.class));
    }

    public void kurta(View view) {
        startActivity(new Intent(getApplicationContext(),ProductKurtaActivity.class));
    }

    public void blazer(View view) {
        startActivity(new Intent(getApplicationContext(),BlezerActivity.class));
    }

    public void shirt(View view) {
        startActivity(new Intent(getApplicationContext(),ShirtActivity.class));
    }
}