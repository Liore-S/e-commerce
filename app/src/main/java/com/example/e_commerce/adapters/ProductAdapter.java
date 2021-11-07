package com.example.e_commerce.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.EspressoDetail;
import com.example.e_commerce.Helper;
import com.example.e_commerce.R;
import com.example.e_commerce.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends
        RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private ArrayList<Product> products;
    private Context context;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        Product product = this.products.get(position);

        holder.nama.setText(product.name);

        Picasso.get().load(product.image).into(holder.imgProduct);

        if (product.diskon > 0) {
            int total = product.harga - product.diskon;
            holder.dicount.setText(Helper.toRp(product.harga));
            holder.harga.setText(Helper.toRp(total));
            holder.dicount.setVisibility(View.VISIBLE);
        } else {
            holder.harga.setText(Helper.toRp(product.harga));
        }

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, EspressoDetail.class);
            intent.putExtra("relocate",product);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgProduct;
        public TextView nama;
        public TextView harga;
        public TextView dicount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imgProduct = itemView.findViewById(R.id.card_img);
            this.nama = itemView.findViewById(R.id.card_title);
            this.harga = itemView.findViewById(R.id.card_price);
            this.dicount = itemView.findViewById(R.id.card_diskon);
        }
    }
}
