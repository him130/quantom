package com.raysapp.quantom;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.raysapp.quantom.Adapter.ProductResponseAdapter;
import com.raysapp.quantom.Model.ProductResponse.ProductResponse;

public class ProductKurtaActivity extends AppCompatActivity {


    private static final String url = Constant.get_Kurta_category_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_product);

        final RecyclerView rectview = (RecyclerView) findViewById(R.id.recyclerView);
        rectview.setLayoutManager(new GridLayoutManager(this,2));

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("response is : ",response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                ProductResponse productResponse = gson.fromJson(response,ProductResponse.class);
                rectview.setAdapter(new ProductResponseAdapter(ProductKurtaActivity.this,productResponse.getData()));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

}