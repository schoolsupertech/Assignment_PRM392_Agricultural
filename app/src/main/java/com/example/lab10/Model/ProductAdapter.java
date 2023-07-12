package com.example.lab10.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab10.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final List<Product> productList;
    private final List<Product> cartList;

    public ProductAdapter(List<Product> productList, List<Product> cartList) {
        this.productList = productList;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.nameTextView.setText(product.getName());
        holder.priceTextView.setText(String.valueOf(product.getPrice()));
        holder.numberTextView.setText(String.valueOf(product.getNumber()));
        holder.descriptionTextView.setText(String.valueOf(product.getDescription()));

        holder.addToCartButton.setOnClickListener(v -> {
            // Thêm sản phẩm vào giỏ hàng
            addToCart(product, v);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView priceTextView;
        public TextView numberTextView;
        public TextView descriptionTextView;
        public Button addToCartButton;

        public ProductViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            numberTextView = itemView.findViewById(R.id.numberTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }
    }

    public void addProduct(Product product) {
        productList.add(product);
        notifyItemInserted(productList.size() - 1);
    }

    private void addToCart(Product product, View view) {
        // Thực hiện thêm sản phẩm vào giỏ hàng tại đây
        // Ví dụ: lưu sản phẩm vào danh sách giỏ hàng
        cartList.add(product);
        // Hiển thị thông báo cho người dùng rằng sản phẩm đã được thêm vào giỏ hàng
        String message = "Sản phẩm " + product.getName() + " đã được thêm vào giỏ hàng";
        Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }

}
