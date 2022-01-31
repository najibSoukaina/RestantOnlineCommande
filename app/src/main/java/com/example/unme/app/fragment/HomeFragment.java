package com.example.unme.app.fragment;

import android.content.Intent;
import
        android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unme.R;
import com.example.unme.app.MainActivity;
import com.example.unme.app.categories.Burger;
import com.example.unme.app.categories.Coffee;
import com.example.unme.app.categories.IceCream;
import com.example.unme.app.categories.Pizza;
import com.example.unme.app.controller.adapters.CategoryAdapter;
import com.example.unme.app.controller.adapters.SlideAdapter;
import com.example.unme.app.model.Foods;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {
    RecyclerView recyclerView;
    ArrayList<Foods> Lfoods;
    CategoryAdapter categoryAdapter;

    ImageView imageMenu;
    SliderView sliderView;

    ImageView imageDeals;
    ImageView imageOne;
    ImageView imageSharing;
    ImageView imageSides;
    ImageView imageBev;

    View view;
    int[] images={R.drawable.one,
            R.drawable.two,
            R.drawable.three};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.home_fragment,container,false);
        imageDeals=view.findViewById(R.id.deals);
        imageOne=view.findViewById(R.id.forone);
        imageSharing=view.findViewById(R.id.forshare);
        imageSides=view.findViewById(R.id.sides);
        imageBev=view.findViewById(R.id.bev);

        imageDeals.setOnClickListener(this);
        imageOne.setOnClickListener(this);
        imageSharing.setOnClickListener(this);
        imageSides.setOnClickListener(this);
        imageBev.setOnClickListener(this);


        recycleImage();
        recyclerView();
        return view;

    }
    private void recycleImage(){
        sliderView=view.findViewById(R.id.image_slider);
        SlideAdapter slideAdapter=new SlideAdapter(images);
        sliderView.setSliderAdapter(slideAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }
    private void recyclerView(){
        recyclerView=view.findViewById(R.id.recycler_view);
        Integer[] catlogos={R.drawable.pizza,R.drawable.ice,R.drawable.coffe,R.drawable.burger,R.drawable.pizza};
        String[] catName={"pizza","ice cream","coffee","burger","pizza"};
        Lfoods=new ArrayList<>();
        for(int i=0;i<catlogos.length;i++){
            Foods foods=new Foods(catName[i],catlogos[i]);
            Lfoods.add(foods);
        }
        LinearLayoutManager layoutManager=new LinearLayoutManager(
          getActivity(),LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        categoryAdapter=new CategoryAdapter(getActivity(), Lfoods, new CategoryAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Foods foods,int pos) {
                if (pos==0){
                    Intent intent11 = new Intent(getActivity(), Pizza.class);
                    startActivity(intent11);
                }else  if (pos==1){
                    Intent intent12 = new Intent(getActivity(), IceCream.class);
                    startActivity(intent12);
                }else  if (pos==2){
                    Intent intent13 = new Intent(getActivity(), Coffee.class);
                    startActivity(intent13);
                }else  if (pos==3){
                    Intent intent14 = new Intent(getActivity(), Burger.class);
                    startActivity(intent14);
                }else  if (pos==4){
                    Intent intent15 = new Intent(getActivity(), Pizza.class);
                    startActivity(intent15);
                }


            }
        });
        recyclerView.setAdapter(categoryAdapter);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.deals) {
            Intent intent1 = new Intent(getActivity(), MainActivity.class);
            startActivity(intent1);
        }else if(v.getId() == R.id.forone){
            Intent intent2 = new Intent(getActivity(), MainActivity.class);
            startActivity(intent2);
        }else if(v.getId() == R.id.forshare){
            Intent intent3 = new Intent(getActivity(), MainActivity.class);
            startActivity(intent3);
        }else if(v.getId() == R.id.sides){
            Intent intent4 = new Intent(getActivity(), MainActivity.class);
            startActivity(intent4);
        }else if(v.getId() == R.id.bev){
            Intent intent5 = new Intent(getActivity(), MainActivity.class);
            startActivity(intent5);

        }
    }

}
