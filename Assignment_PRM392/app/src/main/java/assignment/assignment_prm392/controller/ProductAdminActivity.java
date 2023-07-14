package assignment.assignment_prm392.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import assignment.assignment_prm392.R;
import assignment.assignment_prm392.databinding.FragmentListProductBinding;
import assignment.assignment_prm392.model.ProductDAO;
import assignment.assignment_prm392.model.dto.ProductDTO;

public class ProductAdminActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<ProductDTO> listProduct = null;
    ProductAdminAdapter productAdminAdapter = null;
    FragmentListProductBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_admin);


        listView = findViewById(R.id.lvProductAdmin);

        ProductDAO productDAO = new ProductDAO();
        listProduct = new ArrayList<>();
        listProduct = productDAO.getListProduct();
        productAdminAdapter = new ProductAdminAdapter(this, R.layout.list_product_admin, listProduct);
        listView.setAdapter(productAdminAdapter);
//        listView.setOnItemClickListener((adapterView, v, i, l) -> {
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("Product Detail", listProduct.get(i));
//            NavHostFragment.findNavController(this)
//                    .navigate(R.id.action_ListProductFragment_to_ProductDetailFragment, bundle);
//        });
    }



    public void onDestroyView() {
        super.onDestroy();
        binding = null;
    }


}