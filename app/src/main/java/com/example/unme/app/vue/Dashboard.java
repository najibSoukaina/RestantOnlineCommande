package com.example.unme.app.vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.unme.R;
import com.example.unme.app.MainActivity;
import com.example.unme.app.fragment.AboutUsFragment;
import com.example.unme.app.fragment.AccountFragment;
import com.example.unme.app.fragment.FeedBackFragment;
import com.example.unme.app.fragment.FoodFragment;
import com.example.unme.app.fragment.MapsFragment;
import com.example.unme.app.fragment.HomeFragment;
import com.example.unme.app.vue.authentification.RegisterActivity;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Button ExploreBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        getSupportActionBar().hide();

        final DrawerLayout drawerLayout =findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);


        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        // Default start fragment.
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        switch (item.getItemId()) {
            case R.id.m_home : selectedFragment = new HomeFragment();
                break;
            case R.id.m_resto:  selectedFragment = new MapsFragment();
                break;
            case R.id.m_feedbak:  selectedFragment = new FeedBackFragment();
                break;
            case R.id.about_us:  selectedFragment = new AboutUsFragment();
                break;
            case R.id.m_account:  selectedFragment = new AccountFragment();
                break;
            case R.id.m_food:  selectedFragment = new FoodFragment();
                break;


        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
        return true;

    }


}
