package assignment.assignment_prm392.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import assignment.assignment_prm392.R;
import assignment.assignment_prm392.databinding.ActivityProductBinding;
import assignment.assignment_prm392.utils.Back4AppUtil;

public class ProductActivity extends AppCompatActivity {
    AppBarConfiguration appBarConfiguration;
    ActivityProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Back4AppUtil.Init.initCustomer();
//        Back4AppUtil.Init.initProduct();
//        Back4AppUtil.Init.initOrder();
//        Back4AppUtil.Init.initCart();
//        Back4AppUtil.Init.initPayment();
//        Back4AppUtil.Init.initStatus();

        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_product);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_product);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}