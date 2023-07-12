package com.example.lab10.Model;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Arrays;

public class PraseAPI {
    public void getProductData(ProductAdapter adapter) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Product");
        query.selectKeys(Arrays.asList("name", "price", "number", "description"));
        query.findInBackground((objects, e) -> {
            if (e == null) {
                // Xử lý danh sách đối tượng trả về
                for (ParseObject object : objects) {
                    // Lấy giá trị của các cột từ đối tượng
                    String name = object.getString("name");
                    int price = object.getInt("price");
                    int number = object.getInt("number");
                    String description = object.getString("description");

                    // Tạo đối tượng Product và thêm vào danh sách productList
                    Product product = new Product(price, name, number, description);
                    adapter.addProduct(product);
                }
            } else {
                // Xử lý khi có lỗi xảy ra
                System.err.println("Lỗi: " + e.getMessage());
            }
        });
    }
}