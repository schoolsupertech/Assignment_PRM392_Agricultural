package assignment.assignment_prm392.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;


import com.parse.SignUpCallback;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import assignment.assignment_prm392.R;

public class RegistrationActivity extends AppCompatActivity {
EditText etPhone, etEmail, etFullname,etPassword,etAddress,etGender;
Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        etAddress = findViewById(R.id.etAddress);
        etFullname = findViewById(R.id.etFullname);
        etGender = findViewById(R.id.etGender);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser user = new ParseUser();
                // Set the user's username and password, which can be obtained by a forms
                user.setUsername(etFullname.getText().toString());
                user.setEmail(etEmail.getText().toString());
                user.setPassword(etPassword.getText().toString());
                user.put("address",etAddress.getText().toString());
                user.put("gender",etGender.getText().toString());
                user.put("phone",etPhone.getText().toString());
                user.put("role","member");
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {

                            showAlert("Successful Sign Up!", "Welcome" + "<Your username here>" +"!");
                        } else {
                            ParseUser.logOut();
                            Toast.makeText(RegistrationActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });






            }
        });




    }
    private void showAlert(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        // don't forget to change the line below with the names of your Activities
                        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }
}