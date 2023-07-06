package assignment.assignment_prm392.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import assignment.assignment_prm392.R;
import assignment.assignment_prm392.databinding.FragmentListProductBinding;
import assignment.assignment_prm392.model.dto.ProductDTO;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ListProductFragment extends Fragment {
    ListView listView;
    ArrayList<ProductDTO> listProduct = null;
    ProductAdapter productAdapter = null;
    FragmentListProductBinding binding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentListProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ProductDTO product = new ProductDTO();
        product.setId(1L);
        product.setName("Product A");
        product.setDescription("The best product that help you to survive");
        product.setPrice(99.99);
        product.setNumber(99);

        listView = view.findViewById(R.id.lvProduct);

        listProduct = new ArrayList<>();
        listProduct.add(product);
        listProduct.add(product);
        listProduct.add(product);

        productAdapter = new ProductAdapter(this.getActivity(), R.layout.list_product, listProduct);
        listView.setAdapter(productAdapter);
        listView.setOnItemClickListener((adapterView, v, i, l) -> NavHostFragment.findNavController(this)
                .navigate(R.id.action_ListProductFragment_to_ProductDetailFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}