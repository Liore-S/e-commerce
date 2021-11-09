package com.example.e_commerce.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.Helper;
import com.example.e_commerce.R;
import com.example.e_commerce.models.CartItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartAdapter extends
        RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private ArrayList<CartItem> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onDecreaseButtonClick(CartItem item);

        void onIncreaseButtonClick(CartItem item);
    }

    public CartAdapter(ArrayList<CartItem> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem item = this.items.get(position);
        holder.bind(item, this.listener);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProduct;
        private TextView vTitle;
        private TextView vPriceTotal;
        private ImageView decQty;
        private ImageView incQty;
        private TextView qtyProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imgProduct = itemView.findViewById(R.id.card_img);
            this.vTitle = itemView.findViewById(R.id.card_title);
            this.vPriceTotal = itemView.findViewById(R.id.cart_price);
            this.decQty = itemView.findViewById(R.id.minus);
            this.incQty = itemView.findViewById(R.id.add);
            this.qtyProduct = itemView.findViewById(R.id.quantity);
        }

        public void bind(CartItem item, OnItemClickListener listener) {
            Picasso.get().load(item.product.image).into(this.imgProduct);
            this.vTitle.setText(item.product.name);
            this.vPriceTotal.setText(Helper.toRp(item.total));
            this.qtyProduct.setText(item.qty + "");
            this.decQty.setOnClickListener(v -> listener.onDecreaseButtonClick(item));
            this.incQty.setOnClickListener(v -> listener.onIncreaseButtonClick(item));
        }
    }
}
