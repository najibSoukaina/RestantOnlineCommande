package com.example.unme.app.vue.authentification;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unme.R;
import com.example.unme.app.vue.Dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressBar progressBar;
    Button LoginBtn;
    EditText etEmail, etPassword;
    final int MIN_PASSWORD_LENGTH = 6;
    final int MAX_PASSWORD_LENGTH = 60;

    private FirebaseAuth mAuth;
    private FirebaseDatabase rootNode;
    private DatabaseReference references;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewInitializations();
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        LoginBtn.setOnClickListener(this);


    }



    void viewInitializations() {
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        LoginBtn = findViewById(R.id.LoginBtn);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.LoginBtn) {
            onLogin();
        }
    }

    //errors
    //checking that ets not empty
    boolean validateInput() {

        if (etEmail.getText().toString().equals("")) {
            etEmail.setError("Email is required");
            return false;
        }
        if (etPassword.getText().toString().equals("")) {
            etPassword.setError("Password is required");
            return false;
        }

        // checking email format
        if (!isEmailValid(etEmail.getText().toString())) {
            etEmail.setError("Please enter a valid email address");
            return false;
        }


        // checking  password Length
        if (etPassword.getText().length() < MIN_PASSWORD_LENGTH || etPassword.getText().length() > MAX_PASSWORD_LENGTH) {
            etPassword.setError("Password Length should be between  " + MIN_PASSWORD_LENGTH +" and "+MAX_PASSWORD_LENGTH+" characters");
            return false;
        }

        return true;
    }

    boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public void onLogin() {
        final String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        if (validateInput() ) {
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this, Dashboard.class));
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Something went wrong, Try again !", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this, "Error :"+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void goToSignup(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void goToDashboard(View v) {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    public void forgetPassword(View v) {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }

}