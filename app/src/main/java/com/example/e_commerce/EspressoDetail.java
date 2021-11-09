package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_commerce.models.Product;
import com.squareup.picasso.Picasso;

public class EspressoDetail extends AppCompatActivity {

    TextView desc;
    TextView title;
    ImageView img;
    ImageView back;
    CardView toCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_espresso_detail);
        Bundle extras = getIntent().getExtras();
        MyApp app = (MyApp) getApplication();
        if (extras != null) {
            Product product = (Product) extras.getSerializable("relocate");
            desc = findViewById(R.id.detail_desc);
            desc.setText(product.desc);
            CardView toCart = (CardView) findViewById(R.id.to_cart);
            toCart.setOnClickListener(v -> {
                app.addProductToCart(product, 1);
                Intent intent = new Intent(this, Cart.class);
                this.startActivity(intent);
            });

            title = findViewById(R.id.detail_nama);
            title.setText(product.name);

            img = findViewById(R.id.detail_img);
            Picasso.get().load(product.image).into(img);
        }
        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, Home.class);
            this.startActivity(intent);
        });

    }
}