package com.example.e_commerce.models;

import java.util.ArrayList;

public class Cart {
    public ArrayList<CartItem> items;
    public int total = 0;

    public Cart() {
        this.items = new ArrayList<>();
    }
}
