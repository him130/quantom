package com.raysapp.quantom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.raysapp.quantom.Model.ProductModel;
import com.raysapp.quantom.R;
import com.squareup.picasso.Picasso;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
//private ArrayList<ProductModel> listdata;
Context context;
// RecyclerView recyclerView;
ProductModel[] listdata;
    String mainid,maintitle,mainprice,maindefprice,mainimage;
public ProductAdapter(Context context, ProductModel[] listdata) {
        this.listdata = listdata;
        this.context = context;
        }

    @Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout_product, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
final ProductModel productModel = listdata[position];


    mainid = productModel.getId();
    maintitle = productModel.getTitle();
    mainprice = productModel.getPrice();
    maindefprice = productModel.getDefprice();
    mainimage = productModel.getImg_url();

    try {
        holder.title.setText(productModel.getTitle());
        holder.price.setText(productModel.getPrice());
        holder.defprice.setText(productModel.getDefprice());
        String img_url = productModel.getImg_url();
        System.out.println("Name of title is : "+holder.title);
            Picasso.get()
                    .load(img_url)
                    .placeholder(R.drawable.kurtatwo)
                    .error(R.drawable.kurtaone)
                    .into(holder.image);

    }catch (Exception e){

    }
    
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          /*  mainid = productModel.getId();
            maintitle = productModel.getTitle();
            mainprice = productModel.getPrice();
            maindefprice = productModel.getDefprice();
            mainimage = productModel.getImg_url();


            Intent intent = new Intent(context, DescriptionActivity.class);
            intent.putExtra("id",mainid);
            intent.putExtra("name",maintitle);
            intent.putExtra("price",mainprice);
            intent.putExtra("defprice",maindefprice);
            intent.putExtra("img_url",mainimage);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);*/

        }
    });
}

@Override
public int getItemCount() {
        return listdata.length;
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView price ;
    TextView defprice;
    ImageView image ;

    public ViewHolder(View itemView) {
        super(itemView);
         title = itemView.findViewById(R.id.product_name);
         price = itemView.findViewById(R.id.product_price);
         defprice = itemView.findViewById(R.id.default_price);
         image = itemView.findViewById(R.id.product_image);
    }
}

}  
