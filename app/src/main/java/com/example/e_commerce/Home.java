package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.e_commerce.adapters.ProductAdapter;
import com.example.e_commerce.models.Product;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.outu_coffe, R.drawable.jco_coffe};

    RecyclerView recyTerlaris;
    RecyclerView recyPromo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        ArrayList<Product> allPrducts = Database.getProducts();
        ArrayList<Product> promoProducts = new ArrayList<>();
        for (Product product: allPrducts){
            if (product.diskon > 0 ){
                promoProducts.add(product);
            }
        }

        this.recyTerlaris = findViewById(R.id.recy_terlaris);
        ProductAdapter productAdapter = new ProductAdapter(this, allPrducts);
        this.recyTerlaris.setAdapter(productAdapter);
        this.recyTerlaris.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        this.recyTerlaris.setHasFixedSize(true);

        this.recyPromo = findViewById(R.id.recy_promo);
        ProductAdapter promoAdapter = new ProductAdapter(this, promoProducts);
        this.recyPromo.setAdapter(promoAdapter);
        this.recyPromo.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        this.recyPromo.setHasFixedSize(true);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}