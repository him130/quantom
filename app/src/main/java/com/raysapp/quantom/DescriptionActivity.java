package com.raysapp.quantom;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {

    ImageView image_img;
    TextView text_title,text_price,text_defprice;
    String mainid,maintitle,mainprice,maindefprice,mainimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        image_img = findViewById(R.id.product_image);
        text_title = findViewById(R.id.product_name);
        text_price = findViewById(R.id.product_price);
        text_defprice = findViewById(R.id.default_price);

        ImageSlider imageSlider = findViewById(R.id.productimage);

        List<SlideModel> slideModels = new ArrayList<>();
        /*slideModels.add(new SlideModel(R.drawable.kurtaone, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.kurtaone,ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.kurtaone,ScaleTypes.CENTER_CROP));*/
        imageSlider.setImageList(slideModels,ScaleTypes.CENTER_CROP);


        System.out.println("name of the title is : " + maintitle);

        text_title.setText(getIntent().getStringExtra("name"));
        text_price.setText(getIntent().getStringExtra("price"));
        text_defprice.setText(getIntent().getStringExtra("defprice"));
        Picasso.get().load(getIntent().getStringExtra("image")).into(image_img);



       /* maintitle = getIntent().getStringExtra("name");
        mainprice = getIntent().getStringExtra("price");
        maindefprice = getIntent().getStringExtra("defprice");
        mainimage = getIntent().getStringExtra("img_url");*/

        /*try {
            Picasso.get()
                    .load(mainimage)
                    .placeholder(R.drawable.kurtaone)
                    .error(R.drawable.kurtatwo)
                    .into(imageView);
        }catch (Exception e){
            System.out.println("Error occured:");
        }*/

    }


}