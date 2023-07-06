package assignment.assignment_prm392.controller;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import assignment.assignment_prm392.R;

public class ProductDetailActivity extends AppCompatActivity {
    ImageView img;
    TextView tvHeader, tvDesc;
    Button btnBuyNow, btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        tvHeader = findViewById(R.id.tvProductDtlHeader);
        tvDesc = findViewById(R.id.tvProductDtlDesc);
        btnBuyNow = findViewById(R.id.btnBuyNow);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        btnBuyNow.setOnClickListener(click -> {
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
        });
        btnAddToCart.setOnClickListener(click -> {
            Toast.makeText(this, "Added!", Toast.LENGTH_SHORT).show();
        });
    }
}