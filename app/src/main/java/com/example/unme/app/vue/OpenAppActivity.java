package com.example.unme.app.vue;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unme.R;
import com.example.unme.app.vue.authentification.LoginActivity;

public class OpenAppActivity extends AppCompatActivity {
       private static int TIME_OUT = 2000; //Time to launch the another activity
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window. FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
            setContentView(R.layout.activity_open_app);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(OpenAppActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }, TIME_OUT);

}}