package com.example.unme.app.categories;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.example.unme.R;
import com.example.unme.app.controller.adapters.CatBaseAdapter;
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

public class Pizza extends AppCompatActivity {
    ArrayList<Product> products=new ArrayList<>();
    ListView listProduct;

    private static final String TAG = "Coffee";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);


        listProduct =findViewById(R.id.listproduit);
        String data = null;
        try {
            data = lirecontactsDepuisAsset();
            chargerLesProduit(data,"Pizza");
            if(products.size()>0){
                listProduct.setVisibility(View.VISIBLE);
                CatBaseAdapter catBaseAdapter = new CatBaseAdapter( Pizza.this, products);
                listProduct.setAdapter(catBaseAdapter);
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
        InputStream inputstream = this.getAssets().open("Categories.json");
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

                product.setDescription(jsonobject.getString("descreption"));

                product.setCategory(jsonobject.getString("category"));

                product.setPrice(jsonobject.getLong("price"));



                List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

                Context context=this; // context
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
