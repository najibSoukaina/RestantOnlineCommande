package com.example.unme.app.vue.authentification;


import
        android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unme.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {
    Button submit, back;
    EditText emailField;

    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        mAuth = FirebaseAuth.getInstance();

        findViews();

        submit.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn:
                finish();
                break;
            case R.id.submit_fp:
                onResetPassword();
                break;
        }
    }

    public void findViews() {
        submit = (Button) findViewById(R.id.submit_fp);
        back = (Button) findViewById(R.id.back_btn);
        emailField = (EditText) findViewById(R.id.email_field);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    public void onResetPassword() {
        String email = emailField.getText().toString().trim();

        if (validateEmail()) {
            progressBar.setVisibility(View.VISIBLE);
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(ForgotPassword.this, "Email sent.", Toast.LENGTH_SHORT).show();
                            } else {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(ForgotPassword.this, "Something went wrong, Try again !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private boolean validateEmail() {
        String email = emailField.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "Email is required !", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please provide valid email !", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}
