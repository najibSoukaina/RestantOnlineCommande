package com.example.unme.app.fragment;

import android.content.Intent;
import android.net.Uri;
import
        android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.unme.R;
import com.example.unme.app.vue.authentification.ForgotPassword;


public class AboutUsFragment extends Fragment implements View.OnClickListener{
    String fbUrl="https://www.facebook.com/";
    String igUrl="https://www.instagram.com/";
    String tgUrl="http://www.telegram.me/";
    ImageView fbButton;
    ImageView igButton;
    ImageView tgButton;
    private static final int APPEL_ACTIV2 = 1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_about_us, container, false);
        fbButton = (ImageView)view.findViewById(R.id.fb);
        igButton = (ImageView)view.findViewById(R.id.insta);
        tgButton = (ImageView)view.findViewById(R.id.tg);
        fbButton.setOnClickListener(this);
        igButton.setOnClickListener(this);
        tgButton.setOnClickListener(this);
        return view;
    }
    public void toFacebook(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(fbUrl));
        startActivity(intent);
    }
    public void toInstagram(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(igUrl));
        startActivity(intent);
    }
    public void toTelegram(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tgUrl));
        startActivityForResult(intent, APPEL_ACTIV2);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fb) {
            toFacebook(v);
        }else if(v.getId() == R.id.insta){
            toInstagram(v);
        }else if(v.getId() == R.id.tg){
            toTelegram(v);
        }

    }
}