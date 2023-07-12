package assignment.assignment_prm392.controller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import assignment.assignment_prm392.R;
import assignment.assignment_prm392.databinding.FragmentOrderBinding;
import assignment.assignment_prm392.model.dto.ProductDTO;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class OrderFragment extends Fragment {
    ImageView imgProductDt;
    TextView tvHeaderProductDt, tvDescProductDt;
    EditText edtQuantity, edtPrice;
    Button btnPay;
    FragmentOrderBinding binding;

    @Override
    public View onCreateView(
            @NotNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentOrderBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgProductDt = view.findViewById(R.id.imgProductDt);
        tvHeaderProductDt = view.findViewById(R.id.tvProductDtlHeader);
        tvDescProductDt = view.findViewById(R.id.tvProductDtlDesc);
        btnPay = view.findViewById(R.id.btnPay);
        edtQuantity = view.findViewById(R.id.order_quantity);
        edtPrice = view.findViewById(R.id.order_total_price);

        ProductDTO product = new ProductDTO();
        Bundle args = getArguments();
        if (args != null && args.containsKey("Product Detail")) {
            product = (ProductDTO) args.getSerializable("Product Detail");
        }

        imgProductDt.setImageResource(R.drawable.ic_launcher_background);
        tvHeaderProductDt.setText(product.getName());
        tvDescProductDt.setText(product.getDescription());
        edtQuantity.setText("1");
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        edtPrice.setText("Total: "+ decimalFormat.format(product.getPrice()));

        binding.btnPay.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "All done, thank you!", Toast.LENGTH_LONG).show();
            NavController navController = NavHostFragment.findNavController(this);
            navController.popBackStack(navController.getGraph().getStartDestinationId(), false);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
