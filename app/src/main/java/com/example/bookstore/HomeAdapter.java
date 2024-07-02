package com.example.bookstore;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ProductInHomeViewHolder> {

    ArrayList<Products> products;
    OnRecyclerViewClickListener listener;

    public HomeAdapter(ArrayList<Products> products, OnRecyclerViewClickListener listener) {
        this.products = products;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductInHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_card_home,null,false);
        ProductInHomeViewHolder pvh = new ProductInHomeViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductInHomeViewHolder holder, int position) {
        Products p = products.get(position);

        int img = p.getImage();
        if (img != 0) {
            try {
                holder.img.setImageResource(img);
            } catch (Resources.NotFoundException e) {
                // Log the error and use a default image
                Log.e("HomeAdapter", "Image resource not found: " + img, e);
                holder.img.setImageResource(R.drawable.history_image);
            }
        } else {
            holder.img.setImageResource(R.drawable.history_image); // Ensure R.drawable.products exists
        }

        holder.name.setText(p.getName());
        holder.price.setText(String.format("%.2f$", p.getPrice()));
        holder.rating.setRating(p.getRating());

        if (p.getDiscount() > 0) {
            double discountedPrice = p.getPrice() - (p.getPrice() * (p.getDiscount() / 100.0));
            holder.priceAfter.setText(String.format("%.2f$", discountedPrice));
            holder.price.setPaintFlags(holder.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.price.setTextColor(Color.parseColor("#BFBFBF"));
        } else {
            holder.priceAfter.setText("");
            holder.price.setPaintFlags(0);
            holder.price.setTextColor(Color.parseColor("#000000"));
        }

        holder.img.setTag(position + 1); // Use position + 1 as tag for img
    }



    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductInHomeViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name,price,priceAfter;
        RatingBar rating;

        public ProductInHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_car_home);
            name = itemView.findViewById(R.id.tv_name_card_home);
            price = itemView.findViewById(R.id.tv_price_card_home);
            rating = itemView.findViewById(R.id.rating_card_home);
            priceAfter = itemView.findViewById(R.id.tv_priceafter_card_home);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = (int)img.getTag();
                    listener.OnItemClick(id);
                }
            });
        }
    }
}
