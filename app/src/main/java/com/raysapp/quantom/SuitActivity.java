package com.raysapp.quantom;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SuitActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private String response;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        getProducts();

    }

    void getProducts(){

        String url = Constant.get_jeans_category_url;
        StringRequest request = new StringRequest( url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println("RESPONSE IS : " + response);

                try{


                }catch (Exception e){

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println("error is : " + error.getMessage());

            }
        });
        RequestQueue queue = Volley.newRequestQueue(SuitActivity.this);
        queue.add(request);
    }

}