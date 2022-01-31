package com.example.unme.app.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.unme.R;
import com.example.unme.app.controller.adapters.SlideAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SlideShowActivity extends AppCompatActivity {

    SliderView sliderView;
    int[] images={R.drawable.one,
    R.drawable.two,
    R.drawable.three};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);
        sliderView=findViewById(R.id.image_slider);
        SlideAdapter slideAdapter=new SlideAdapter(images);
        sliderView.setSliderAdapter(slideAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }

}