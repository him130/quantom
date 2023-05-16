package com.raysapp.quantom.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.raysapp.quantom.Constant;
import com.raysapp.quantom.DetailsActivity;
import com.raysapp.quantom.Model.ProductResponse.Datum;
import com.raysapp.quantom.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductResponseAdapter extends RecyclerView.Adapter<ProductResponseAdapter.ViewHolder> {

   Context context;
   List<Datum> data;

    public ProductResponseAdapter(Context context, List<Datum> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_product_resourse,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Datum datum = data.get(position);

        holder.title.setText(datum.getName());
        holder.txt_price.setText(datum.getMainPrice());
        holder.txt_defprice.setText(datum.getStrokedPrice());
        Picasso.get().load(Constant.PUBLIC_URL+datum.getThumbnailImage()).into(holder.image_img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("productid",datum.getId());
                intent.putExtra("name",datum.getName());
                intent.putExtra("price",datum.getMainPrice());
                intent.putExtra("defprice",datum.getStrokedPrice());
                intent.putExtra("image",datum.getThumbnailImage());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title,txt_price,txt_defprice;
        ImageView image_img;

        public ViewHolder( View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.name);
            txt_price = itemView.findViewById(R.id.pprice);
            txt_defprice = itemView.findViewById(R.id.defprice);
            image_img = itemView.findViewById(R.id.image);


        }
    }


}
