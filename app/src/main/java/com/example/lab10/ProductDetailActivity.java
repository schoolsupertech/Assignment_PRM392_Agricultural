package com.example.lab10;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab10.Model.PraseAPI;
import com.example.lab10.Model.Product;
import com.example.lab10.Model.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    PraseAPI praseAPI;
    ProductAdapter adapter;
    List<Product> productList = new ArrayList<>();
    private TextView nameTextView;
    private TextView priceTextView;
    private TextView numberTextView;
    private Product product;

    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Ánh xạ các TextView từ layout
        nameTextView = findViewById(R.id.nameTextView);
        priceTextView = findViewById(R.id.priceTextView);
        numberTextView = findViewById(R.id.numberTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);

        product = getIntent().getParcelableExtra("product");

        nameTextView.setText(product.getName());
        priceTextView.setText(String.valueOf(product.getPrice()));
        numberTextView.setText(String.valueOf(product.getNumber()));
        descriptionTextView.setText(product.getDescription());
    }
}
