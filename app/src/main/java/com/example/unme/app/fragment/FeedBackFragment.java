package com.example.unme.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.unme.R;

public class FeedBackFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    TextView tvFeedback;
    RatingBar rbStars;
    Spinner spinner;
    ImageView imageView;
    Toolbar mActionBarToolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feedback_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvFeedback = (TextView) getView().findViewById(R.id.tvFeedback);
        rbStars = (RatingBar) getView().findViewById(R.id.rbStars);
        imageView=(ImageView)getView().findViewById(R.id.emoji);
        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating == 1 || rating == 0.5) {
                    tvFeedback.setText("Not So Good");
                    imageView.setImageResource(R.drawable.emj1);
                } else if (rating == 2|| rating == 1.5 ) {
                    tvFeedback.setText("Can be Better");
                    imageView.setImageResource(R.drawable.emj2);
                } else if (rating == 3|| rating == 2.5) {
                    tvFeedback.setText("Satisfactory");
                    imageView.setImageResource(R.drawable.emj3);
                } else if (rating == 4 || rating == 3.5) {
                    tvFeedback.setText("Delightful");
                    imageView.setImageResource(R.drawable.emj4);
                } else if (rating == 5 || rating == 4.5) {
                    tvFeedback.setText("Mouth Watering");
                    imageView.setImageResource(R.drawable.emj5);
                }else{
                    tvFeedback.setText("Rate Us");
                    imageView.setImageResource(R.drawable.emj0);
                }
            }
        });
        spinner = (Spinner)getView().findViewById(R.id.spReason);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.reason,
                R.layout.my_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setDropDownVerticalOffset(130);
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
