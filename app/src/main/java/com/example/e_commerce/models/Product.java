package com.example.e_commerce.models;

import java.io.Serializable;

public class Product implements Serializable {
    public String name;
    public int harga;
    public int diskon;
    public String image;
    public String desc;

    public Product(String name, int harga, int diskon, String image ,String desc) {
        this.name = name;
        this.harga = harga;
        this.diskon = diskon;
        this.image = image;
        this.desc = desc;
    }
}
