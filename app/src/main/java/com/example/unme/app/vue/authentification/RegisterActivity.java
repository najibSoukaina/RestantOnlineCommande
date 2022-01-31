
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
import androidx.appcompat.app.AppCompatActivity;

import com.example.unme.R;
import com.example.unme.app.model.User;
import com.example.unme.app.vue.Dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;

    private ProgressBar progressBar;

        EditText etFirstName, etLastName, etEmail, etPassword, etRepeatPassword;
        Button buttonSignUp;
        final int MIN_PASSWORD_LENGTH = 6;
        final int MAX_PASSWORD_LENGTH = 60;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);
            getSupportActionBar().setTitle("Join Us");
            mAuth = FirebaseAuth.getInstance();
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("user");
            viewInitializations();

            buttonSignUp.setOnClickListener(this);
        }

        void viewInitializations() {
            etFirstName = findViewById(R.id.et_first_name);
            etLastName = findViewById(R.id.et_last_name);
            etEmail = findViewById(R.id.et_email);
            etPassword = findViewById(R.id.et_password);
            etRepeatPassword = findViewById(R.id.et_repeat_password);
            buttonSignUp = (Button) findViewById(R.id.buttonSignUp);

            // To show back button in actionbar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSignUp) {
            createUserAccount();
        }
    }
    private void createUserAccount() {
        String firstname = etFirstName.getText().toString().trim();
        String lastname = etLastName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String repeatPassword = etRepeatPassword.getText().toString().trim();

        if (validateInput()) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                User user = new User(firstname,lastname,email,password);
                                reference.child(mAuth.getCurrentUser().getUid()).setValue(user)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(RegisterActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                                                // Here you can call you API
                                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                                startActivity(intent);
                                            }else{
                                                Toast.makeText(RegisterActivity.this,"Something went wrong, Try again !",Toast.LENGTH_LONG).show();
                                                }
                                            }

                                        });
                            }else{
                                Toast.makeText(RegisterActivity.this,"Something went wrong, Try again !",Toast.LENGTH_LONG).show();

                            }
                        }
                    });
        }
    }

        // Checking if the input in form is valid
        boolean validateInput() {
            if (etFirstName.getText().toString().equals("")) {
                etFirstName.setError("Please Enter First Name");
                return false;
            }
            if (etLastName.getText().toString().equals("")) {
                etLastName.setError("Please Enter Last Name");
                return false;
            }
            if (etEmail.getText().toString().equals("")) {
                etEmail.setError("Please Enter Email");
                return false;
            }
            if (etPassword.getText().toString().equals("")) {
                etPassword.setError("Please Enter Password");
                return false;
            }
            if (etRepeatPassword.getText().toString().equals("")) {
                etRepeatPassword.setError("Please Enter Repeat Password");
                return false;
            }

            // checking the proper email format
            if (!isEmailValid(etEmail.getText().toString())) {
                etEmail.setError("Please Enter Valid Email");
                return false;
            }

            // checking minimum password Length
            if (etPassword.getText().length() < MIN_PASSWORD_LENGTH || etPassword.getText().length() > MAX_PASSWORD_LENGTH) {
                etPassword.setError("Password Length should be between  " + MIN_PASSWORD_LENGTH +" and "+MAX_PASSWORD_LENGTH+" characters");
                return false;
            }

            // Checking if repeat password is same
            if (!etPassword.getText().toString().equals(etRepeatPassword.getText().toString())) {
                etRepeatPassword.setError("Password does not match");
                return false;
            }
            return true;
        }

        boolean isEmailValid(String email) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

        // Hook Click Event

        public void performSignUp (View v) {
            if (validateInput()) {

                // Input is valid, here send data to your server

                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String repeatPassword = etRepeatPassword.getText().toString();

                Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
                // Here you can call you API
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);

            }
        }

    public void goToLogin(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}