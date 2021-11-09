package com.example.e_commerce;

import android.app.Application;
import android.widget.Toast;

import com.example.e_commerce.models.CartItem;
import com.example.e_commerce.models.Cart;
import com.example.e_commerce.models.Product;

public class MyApp extends Application {
    public Cart cart = new Cart();

    public void addProductToCart(Product product, int qty)
    {
        boolean found = false;
        for (CartItem item: this.cart.items){
            if (item.product.name.equals(product.name)){
                item.qty += qty;
                item.total = product.harga * item.qty;
                found = true;
            }
        }
        if (!found){
            this.cart.items.add(new CartItem(product, qty));
        }
        this.updateCart();
        Toast.makeText(getApplicationContext(), "Added to cart.", Toast.LENGTH_SHORT).show();
    }

    public void increaseProductCart(CartItem item)
    {
        this.addProductToCart(item.product, 1);
    }

    public void decreaseProductCart(CartItem item)
    {
        if (item.qty == 1){
            this.cart.items.remove(item);
            Toast.makeText(getApplicationContext(), "Product removed.", Toast.LENGTH_SHORT).show();
        } else {
            item.qty -= 1;
            item.total = item.product.harga * item.qty;
        }
        this.updateCart();
    }

    public void updateCart()
    {
        int total = 0;
        for (CartItem item: this.cart.items){
            total += item.total;
        }
        this.cart.total = total;
    }
}
