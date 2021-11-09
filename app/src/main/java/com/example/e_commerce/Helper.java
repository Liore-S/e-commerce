package com.example.e_commerce;

public class Helper {
    public static String toRp(int number) {
        return "Rp " + String.format("%,d", number).replace(',', '.');
    }
}
