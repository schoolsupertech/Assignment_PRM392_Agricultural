package com.example.lab10.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class api {
    public interface ProductService {
        String PRODUCTS = "Product";

        @GET(PRODUCTS)
        Call<List<Product>> getAllProducts();
    }
}
