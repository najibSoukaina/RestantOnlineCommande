package com.example.unme.app.controller.adapters;

import
        android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.unme.R;
import com.example.unme.app.model.Product;

import java.util.ArrayList;

public class ProduitAdapter extends BaseAdapter {

    Fragment fragment;
    ArrayList<Product> products=new ArrayList<>();

    public ProduitAdapter(Fragment fragment, ArrayList<Product> products) {
        super () ;
        this.fragment = fragment;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = (Product) getItem (position);
        if (convertView == null) {
            LayoutInflater inflater = fragment.getLayoutInflater();
            convertView = inflater.inflate(R.layout.produit_item, null);
        }
        TextView designation = convertView.findViewById (R.id.designation);
        TextView description = convertView.findViewById(R.id.description) ;
        TextView price = convertView.findViewById(R.id.price);
        ImageView imageproduit = convertView.findViewById(R.id.imageproduit);

        designation.setText(product.getDesignation());
        description.setText(product.getDescription());
        price.setText(product.getPrice()+"");
        imageproduit.setImageResource(product.getImage());
        return convertView;
    }
}
