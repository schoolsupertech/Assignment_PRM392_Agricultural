package assignment.assignment_prm392.controller;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import assignment.assignment_prm392.R;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseQuery<ParseObject> searchQuery = ParseQuery.getQuery("Employee");
        searchQuery.findInBackground((objects, e) -> {
            if (e != null){
                Log.e("MainActivity", e.getLocalizedMessage());
            }else{
                objects.forEach(object -> {
                    Log.d("Full Name", object.getString("full_name"));
                    Log.d("Email", object.getString("email"));
                    Log.d("Gender", object.getBoolean("Gender") ? "Male" : "Female");
                    Log.d("Email", String.valueOf(object.getNumber("credit_card")));
                });
            }
        });
    }
}