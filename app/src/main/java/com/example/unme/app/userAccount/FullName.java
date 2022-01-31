package com.example.unme.app.userAccount;

import
        android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unme.R;


public class FullName extends AppCompatActivity implements View.OnClickListener {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_name);

        back = (Button) findViewById(R.id.back_btn);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn :
                finish();
                break;
            case R.id.submitBtn :

                break;
        }
    }
}