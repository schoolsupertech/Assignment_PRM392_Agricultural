package com.example.prm392;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392.database.ProductRepository;

public class ProductDetailsActivity extends AppCompatActivity {
    private TextView productName;
    private TextView productPrice;
    private ProductRepository productRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

    }
}