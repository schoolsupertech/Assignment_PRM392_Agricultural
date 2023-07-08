package assignment.assignment_prm392.controller;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import assignment.assignment_prm392.R;
import assignment.assignment_prm392.databinding.ActivityProductBinding;
import com.parse.ParseObject;

public class ProductActivity extends AppCompatActivity {
    AppBarConfiguration appBarConfiguration;
    ActivityProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        initBack4App();

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

    private void initBack4App() {
        // Init class for Back4App
        ParseObject person = new ParseObject("Product");
        person.put("name", "Carrot");
        person.put("description", "Vegetable for rabbit");
        person.put("number", 1399);
        person.put("price", 27);
        person.saveInBackground(e -> {
            if(e != null) {
                Log.d("ERROR", e.getMessage());
            }
            else {
                Log.d("Info", "Object saved");
                Toast.makeText(this, "Successfully saved", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_product);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}