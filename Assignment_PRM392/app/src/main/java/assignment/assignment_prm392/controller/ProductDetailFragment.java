package assignment.assignment_prm392.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import assignment.assignment_prm392.R;
import assignment.assignment_prm392.databinding.FragmentProductDetailBinding;
import assignment.assignment_prm392.model.dto.ProductDTO;
import org.jetbrains.annotations.NotNull;

public class ProductDetailFragment extends Fragment {
    ImageView imgProductDt;
    TextView tvHeaderProductDt, tvDescProductDt;
    Button btnBuyNow, btnAddToCart;
    private FragmentProductDetailBinding binding;

    @Override
    public View onCreateView(
            @NotNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgProductDt = view.findViewById(R.id.imgProductDt);
        tvHeaderProductDt = view.findViewById(R.id.tvProductDtlHeader);
        tvDescProductDt = view.findViewById(R.id.tvProductDtlDesc);
        btnBuyNow = view.findViewById(R.id.btnBuyNow);
        btnAddToCart = view.findViewById(R.id.btnAddToCart);

        ProductDTO product = new ProductDTO();
        Bundle args = getArguments();
        if (args != null && args.containsKey("Product Detail")) {
            product = (ProductDTO) args.getSerializable("Product Detail");
        }

        imgProductDt.setImageResource(R.drawable.ic_launcher_background);
        tvHeaderProductDt.setText(product.getName());
        tvDescProductDt.setText(product.getDescription());

        binding.btnBuyNow.setOnClickListener(click -> {

        });
        binding.btnAddToCart.setOnClickListener(click -> {

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}