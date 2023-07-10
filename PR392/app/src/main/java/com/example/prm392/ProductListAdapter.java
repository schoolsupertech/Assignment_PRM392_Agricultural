package com.example.prm392;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392.database.ProductModel;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    private List<ProductModel> products;
    private final LayoutInflater layoutInflater;

    public ProductListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setProducts(List<ProductModel> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        if (products != null) {
            ProductModel currentProduct = products.get(position);
            holder.idTextView.setText(String.valueOf(currentProduct.getId()));
            holder.nameTextView.setText(currentProduct.getName());
            holder.priceTextView.setText(String.valueOf(currentProduct.getPrice()));
            holder.numberTextView.setText(String.valueOf(currentProduct.getNumber())); // Hiển thị số lượng

            // Sử dụng thư viện hình ảnh như Picasso hoặc Glide để tải và hiển thị hình ảnh từ URL hoặc mảng byte
            // holder.imgImageView.setImageURI(currentProduct.getImg());
            // Sử dụng URI nếu hình ảnh là URL
            // holder.imgImageView.setImageBitmap(currentProduct.getImg());
            // Sử dụng Bitmap nếu hình ảnh là mảng byte
        } else {
            holder.idTextView.setText("");
            holder.nameTextView.setText("");
            holder.priceTextView.setText("");
            holder.numberTextView.setText("");
        }
    }

    @Override
    public int getItemCount() {
        if (products != null) {
            return products.size();
        }
        return 0;
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final TextView idTextView;
        private final TextView nameTextView;
        private final TextView priceTextView;
        private final TextView numberTextView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.product_id);
            nameTextView = itemView.findViewById(R.id.product_name);
            priceTextView = itemView.findViewById(R.id.product_price);
            numberTextView = itemView.findViewById(R.id.product_number);
        }
    }
}
