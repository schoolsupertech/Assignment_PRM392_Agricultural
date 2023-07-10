package com.example.lab10.Model;

public class ProductRepository {
    public static api.ProductService getProductService() {
        return APIClient.getClient().create(api.ProductService.class);
    }
}
