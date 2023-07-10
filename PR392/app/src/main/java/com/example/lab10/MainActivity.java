package com.example.lab10;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab10.Model.Product;
import com.example.lab10.Model.ProductRepository;
import com.example.lab10.Model.api.ProductService;
import com.parse.Parse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProductService productService;
    RecyclerView recyclerView;
    List<Product> productList = new ArrayList<>();
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView_Product);
        productService = ProductRepository.getProductService();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);

        fetchData();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());

    }

    private void fetchData() {
        Call<List<Product>> call = productService.getAllProducts();
        call.enqueue(new Callback<List<Product>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> products = response.body();
                    if (products != null) {
                        productList.addAll(products);
                        adapter.notifyDataSetChanged(); // Thông báo cho Adapter biết rằng dữ liệu đã thay đổi
                    }
                } else {
                    int statusCode = response.code();
                    String errorMessage = "Lỗi " + statusCode + ": Đã xảy ra lỗi khi tải danh sách mặt hàng nông sản";
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Product>> call, @NonNull Throwable t) {
                // Xử lý khi gặp lỗi
            }
        });
    }
}
