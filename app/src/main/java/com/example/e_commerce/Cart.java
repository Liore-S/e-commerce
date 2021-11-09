package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_commerce.adapters.CartAdapter;
import com.example.e_commerce.models.CartItem;

public class Cart extends AppCompatActivity {

    private MyApp app;
    private RecyclerView recyCart;
    private TextView totalItem;
    private TextView totalPrice;
    private CardView order;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        this.app = (MyApp) getApplication();

        this.recyCart = findViewById(R.id.recy_cart);
        this.totalItem = findViewById(R.id.quantity);
        this.totalPrice = findViewById(R.id.cart_price);
        this.order = findViewById(R.id.order);

        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, Home.class);
            this.startActivity(intent);
        });
        this.cartAdapter = new CartAdapter(app.cart.items, new CartAdapter.OnItemClickListener() {
            @Override
            public void onDecreaseButtonClick(CartItem item) {
                app.decreaseProductCart(item);
                refreshCart();
            }

            @Override
            public void onIncreaseButtonClick(CartItem item) {
                app.increaseProductCart(item);
                refreshCart();
            }
        });
        this.recyCart.setAdapter(cartAdapter);
        this.recyCart.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        this.recyCart.setHasFixedSize(true);
        order.setOnClickListener(v -> {
            String content = String.format("Halo, saya ingin membayar pembelian furniture di aplikasi *Kuy Drink*. Dengan total pembayaran %s.", Helper.toRp(this.app.cart.total));
            String whatsappUrl = String.format("https://wa.me/6285641560600?text=%s", content);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(whatsappUrl));
            startActivity(intent);
        });
        this.refreshCart();
    }

    private void refreshCart() {
        this.totalItem.setText(String.format("Total (%s)", this.app.cart.items.size()));
        this.totalPrice.setText(Helper.toRp(this.app.cart.total));
        this.cartAdapter.notifyDataSetChanged();
        if (this.app.cart.items.size() > 0) {
            this.order.setEnabled(true);
        } else {
            this.order.setEnabled(false);
        }
    }
}