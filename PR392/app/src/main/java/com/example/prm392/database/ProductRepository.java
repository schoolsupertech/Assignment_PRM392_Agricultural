package com.example.prm392.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final DatabaseHelper databaseHelper;

    public ProductRepository() {
        databaseHelper = new DatabaseHelper();
    }

    public List<ProductModel> getAllProducts() {
        List<ProductModel> products = new ArrayList<>();
        String query = "SELECT id, name, price, number, img FROM product";

        ResultSet resultSet = databaseHelper.executeQuery(query);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    int number = resultSet.getInt("number");
                    byte[] img = resultSet.getBytes("img");

                    ProductModel product = new ProductModel(id, name, price, number, img);
                    products.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                databaseHelper.close();
            }
        }

        return products;
    }
}
