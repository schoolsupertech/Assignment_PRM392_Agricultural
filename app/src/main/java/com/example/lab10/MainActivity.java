package com.example.lab10;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab10.Model.PraseAPI;
import com.example.lab10.Model.Product;
import com.example.lab10.Model.ProductAdapter;
import com.parse.Parse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Product> productList = new ArrayList<>();
    ProductAdapter adapter;
    PraseAPI praseAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView_Product);
        praseAPI = new PraseAPI();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);



        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());

        // Gọi phương thức getProductData() để lấy dữ liệu từ Parse
        praseAPI.getProductData(adapter);
    }


}
