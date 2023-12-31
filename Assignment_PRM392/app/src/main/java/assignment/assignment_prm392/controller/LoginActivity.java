package assignment.assignment_prm392.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRole;
import com.parse.ParseUser;

import assignment.assignment_prm392.R;

import assignment.assignment_prm392.model.CustomerDAO;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    TextView tvSignup;
    boolean a = false;
    Button btLogin;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btLogin);
        tvSignup = findViewById(R.id.tvSignup);
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);


            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String admin = "admin";
                ParseUser.logInInBackground(etEmail.getText().toString(), etPassword.getText().toString(), (parseUser, e) -> {
                    if (parseUser != null) {
                        Toast.makeText(LoginActivity.this, "Successful Login!", Toast.LENGTH_LONG).show();
                        //check phân quyền
                        ParseQuery<ParseUser> query = ParseUser.getQuery();
                        query.whereEqualTo("email", etEmail.getText().toString());
                        query.getFirstInBackground(new GetCallback<ParseUser>() {
                            @Override
                            public void done(ParseUser object, ParseException e) {
                                if (e == null) {
                                    String userRole = object.getString("role");
                                    if(userRole.equals("admin")){
                                        Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                                        startActivity(intent);
                                        finish();}
                                } else {
                                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
            else {
                ParseUser.logOut();
                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
});


        }
        }