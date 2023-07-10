package com.example.prm392;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392.database.ProductModel;
import com.example.prm392.database.ProductRepository;

import java.util.List;

public class ListProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

        RecyclerView productList = findViewById(R.id.product_list);
        productList.setLayoutManager(new LinearLayoutManager(this));
        ProductListAdapter adapter = new ProductListAdapter(this);
        productList.setAdapter(adapter);

        ProductRepository productRepository = new ProductRepository();
        List<ProductModel> products = productRepository.getAllProducts();
        adapter.setProducts(products);

    }
}
