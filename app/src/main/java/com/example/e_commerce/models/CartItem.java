package com.example.e_commerce.models;

public class CartItem {
    public Product product;
    public int qty;
    public int total;

    public CartItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
        this.total = product.harga * qty;
    }
}
