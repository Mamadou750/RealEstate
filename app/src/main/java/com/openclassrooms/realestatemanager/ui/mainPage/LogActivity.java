package com.openclassrooms.realestatemanager.ui.mainPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.openclassrooms.realestatemanager.R;

public class LogActivity extends AppCompatActivity  {

    public static String  PREFS_NAME="mypre";
    public static String PREF_USERNAME="email";
    public static String PREF_PASSWORD="password";
    EditText edtMail,edtPassword;
    String username="camara750@realestate.com";
    String password="feelsafe";
    Button login;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String userna = pref.getString(PREF_USERNAME, null);
        String pass = pref.getString(PREF_PASSWORD, null);
        if (userna != null || pass != null) {
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("user",username);
            startActivity(intent);
        }
        edtMail = (EditText)findViewById(R.id.edtEmail);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        login = findViewById(R.id.btn_sign_in);
        login.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if(edtMail.getText().toString().equals(username) && edtPassword.getText().toString().equals(password)) {

                    {
                        getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                                .edit()
                                .putString(PREF_USERNAME, username)
                                .putString(PREF_PASSWORD, password)
                                .commit();

                        Intent intent=new Intent

                                (getApplicationContext(), MainActivity.class);
                        intent.putExtra("user",username);
                        startActivity(intent);
                    }


                }
                else{
                    Toast.makeText(LogActivity.this,

                            "Invalid username or password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }












   /* private Button btn_email_sign_in;
    private EditText edtEmail;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        btn_email_sign_in = findViewById(R.id.btn_sign_in);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        // Set a click listener for the login button
        btn_email_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve entered username and password
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                // Implement authentication logic here
                if (email.equals("camara750@realestate.com") && password.equals("feelsafe")) {
                    // Successful login
                    Toast.makeText(LogActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LogActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Failed login
                    Toast.makeText(LogActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



*/
}