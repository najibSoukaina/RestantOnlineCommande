package com.example.unme.app.model;



import com.example.unme.R;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodData extends ArrayList<Foods> {



    public FoodData() {
        this.add(new Foods(1,"burger",18, R.drawable.burger)) ;
        this.add(new Foods(2,"pizza",20,R.drawable.pizza)) ;
        this.add(new Foods(3,"tacos",25,R.drawable.taco)) ;
        this.add(new Foods(4,"sandwich",14,R.drawable.sandwich)) ;
        this.add(new Foods(3,"coffee",25,R.drawable.coffe)) ;
        this.add(new Foods(4,"ice cream",14,R.drawable.icecream)) ;
    }
    public ArrayList<HashMap<String,String>> parseToListOfHashMaps(){
        ArrayList<HashMap<String,String>> list=new ArrayList<>();
        for (Foods foods:this){
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("id",foods.getId()+"");
            hashMap.put("desenation",foods.getDesination());
            hashMap.put("price",foods.getPrice()+" DH");
            hashMap.put("image",foods.getImage() +"");
            list.add(hashMap);
        }

        return list;
    }
}
