package com.example.e_commerce;

import com.example.e_commerce.models.Product;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Product> getProducts() {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(
                "Espresso",
                25000,
                3000,
                "https://asset.kompas.com/crops/_SfcFYf71wzjEp-eNLHB_subNpI=/0x0:1000x667/750x500/data/photo/2020/10/05/5f7a1e1a209d9.jpg",
                ""));
        products.add(new Product(
                "Kopi susu",
                22000,
                5000,
                "https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2020/08/31/3352595278.jpg",
                ""));
        products.add(new Product(
                "Green Tea",
                20000,
                0,
                "https://www.kitchenofindonesia.com/wp-content/uploads/2020/02/green-tea.jpg",
                ""));
        products.add(new Product(
                "Parfait",
                24000,
                0,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRn9fSIC7NcdQLLmTwtfWgVer1YNc1i8LHw5Q&usqp=CAU",
                ""));
        products.add(new Product(
                "Chocolate",
                25000,
                2000,
                "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F23%2F2020%2F12%2F14%2Fhot-chocolate-bombs-2-2000.jpg&q=85",
                ""));
        products.add(new Product(
                "Jamu",
                18000,
                0,
                "https://asset.kompas.com/crops/JXww5v6HkvVnvkxM9uv0ZEpiISo=/0x0:1000x667/750x500/data/photo/2021/01/16/60026c961bf44.jpg",
                ""));
        products.add(new Product(
                "Es Teh",
                10000,
                0,
                "https://awsimages.detik.net.id/community/media/visual/2020/05/14/0af32d8b-36b7-4555-8e79-4fd54c98f795.jpeg?w=700&q=90",
                ""));
        products.add(new Product(
                "Coca-Cola",
                14000,
                3000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLTCDbA65YsJRZoLsc53fkT1ALGL8UNkegAA&usqp=CAU",
                ""));
        return products;
    }
}
