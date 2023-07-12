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
import assignment.assignment_prm392.model.ProductDAO;
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

        listView = view.findViewById(R.id.lvProduct);

        ProductDAO productDAO = new ProductDAO();

        listProduct = new ArrayList<>();
        listProduct = productDAO.getListProduct();
        productAdapter = new ProductAdapter(requireActivity(), R.layout.list_product, listProduct);
        listView.setAdapter(productAdapter);
        listView.setOnItemClickListener((adapterView, v, i, l) -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("Product Detail", listProduct.get(i));
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_ListProductFragment_to_ProductDetailFragment, bundle);
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}