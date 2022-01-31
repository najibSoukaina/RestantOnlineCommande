package com.example.unme.app.Products;

import
        android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.unme.R;
import com.example.unme.app.controller.adapters.ProduitAdapter;
import com.example.unme.app.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ForOne extends Fragment {
    ArrayList<Product> products=new ArrayList<>();
    ListView listProduct;

    private static final String TAG = "Deals";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listProduct = (ListView) view.findViewById(R.id.listproduit);
        String data = null;
        try {
            data = lirecontactsDepuisAsset();
            chargerLesProduit(data,"For One");
            if(products.size()>0){
                listProduct.setVisibility(view.VISIBLE);
                ProduitAdapter produitAdapter = new ProduitAdapter( ForOne.this, products);
                listProduct.setAdapter(produitAdapter);
                ( (BaseAdapter)listProduct.getAdapter()).notifyDataSetChanged ();

            }else{
                Log.i(TAG,"onItemSelected: liste problem");
            }


        } catch (IOException ex) {
            ex.printStackTrace();
            Log.i(TAG, "onCreate: lireContactsDepuisAsset NOK");
        }catch (JSONException ex) {
            ex.printStackTrace();
            Log.i(TAG, "onCreate: Charges les produit feild NOK");
        }
    }
    private String lirecontactsDepuisAsset() throws IOException {
        InputStream inputstream = getActivity().getAssets().open("Products.json");
        byte[] buffer = new byte[inputstream.available()];
        inputstream.read(buffer);
        Log.i(TAG, "onCreate: lireContactsDepuisAsset OK");
        inputstream.close();
        return new String(buffer, "UTF-8");

    }
    private void chargerLesProduit (String data,String type) throws JSONException {
        JSONArray jsonArray = new JSONArray(data);
        products.clear();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonobject = jsonArray.getJSONObject(i);
            if (jsonobject.getString ("category").equals (type)) {

                Product product = new Product();
                product.setDesignation(jsonobject.getString("desination"));
                Log.i(TAG, "onCreate: 1");
                product.setDescription(jsonobject.getString("descreption"));
                Log.i(TAG, "onCreate: 2");
                product.setCategory(jsonobject.getString("category"));
                Log.i(TAG, "onCreate: 3");
                product.setPrice(jsonobject.getLong("price"));
                Log.i(TAG, "onCreate: 4");


                List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

                Context context=this.getContext(); // context
                Resources resources = context.getResources();
                HashMap<String, String> hm = new HashMap<String,String>();
                // get image name from JSON
                String imageName = jsonobject.getString("image");
                // get resource id by image name
                final int resourceId = resources.getIdentifier(imageName, "drawable", context.getPackageName());
                hm.put("flag", Integer.toString(resourceId) );
                aList.add(hm);
                product.setImage(resourceId);


                products.add(product);
            }
        }
    }
}
