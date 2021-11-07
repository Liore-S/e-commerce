package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_commerce.models.Product;
import com.squareup.picasso.Picasso;

public class EspressoDetail extends AppCompatActivity {

    TextView desc;
    TextView title;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Product product = (Product) extras.getSerializable("relocate");
            desc = findViewById(R.id.detail_desc);
            desc.setText(product.desc);

            title = findViewById(R.id.detail_nama);
            title.setText(product.name);

            img = findViewById(R.id.detail_img);
            Picasso.get().load(product.image).into(img);
        }
    }
}