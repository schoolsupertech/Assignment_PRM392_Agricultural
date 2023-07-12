package assignment.assignment_prm392.controller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import assignment.assignment_prm392.R;
import assignment.assignment_prm392.model.CartDAO;
import assignment.assignment_prm392.model.dto.CartDTO;

import java.io.Serializable;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    TextView tvTotalPrice;
    Button btnCheckOut;
    ListView lvCart;
    ArrayList<CartDTO> cartDTOS = null;
    CartAdapter cartAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tvTotalPrice = findViewById(R.id.tvTotalCart);
        btnCheckOut = findViewById(R.id.btnCheckOut);
        lvCart = findViewById(R.id.lvCart);

        CartDAO cartDAO = new CartDAO();
        cartDTOS = new ArrayList<>();
        cartDTOS = cartDAO.getListProduct();

        if(cartDTOS != null) {
            cartAdapter = new CartAdapter(this, R.layout.list_product, cartDTOS);
            lvCart.setAdapter(cartAdapter);
            lvCart.setOnItemClickListener((adapterView, view, i, l) -> {
                Bundle bundle = new Bundle();
                bundle.putSerializable("Product Detail", (Serializable) cartDTOS.get(i));
                NavHostFragment.findNavController(new ProductDetailFragment())
                        .navigate(R.id.action_ListProductFragment_to_ProductDetailFragment, bundle);
            });
        }
        else {
            tvTotalPrice.setText("Waiting to add product...");
            btnCheckOut.setEnabled(false);
            Toast.makeText(this, "Empty cart", Toast.LENGTH_SHORT).show();
        }

        btnCheckOut.setOnClickListener(v -> {
            NavHostFragment.findNavController(new OrderFragment())
                    .navigate(R.id.action_ProductDetailFragment_to_OrderFragment);
        });
    }
}