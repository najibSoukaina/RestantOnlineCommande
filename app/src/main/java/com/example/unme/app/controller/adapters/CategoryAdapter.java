package com.example.unme.app.controller.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unme.R;
import com.example.unme.app.model.Foods;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<Foods> foods;
    Context context;
    ItemClickListener itemClickListener;

    public CategoryAdapter(Context context,ArrayList<Foods> foods,ItemClickListener itemClickListener) {
        this.context=context;
        this.foods = foods;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
       holder.categoryPic.setImageResource(foods.get(position).getImage());
        holder.categoryName.setText(foods.get(position).getDesination());
        holder.itemView.setOnClickListener(view -> {
            itemClickListener.onItemClick(foods.get(position),position);
        });
    }
    public interface ItemClickListener {
        void onItemClick(Foods foods, int pos);
    }


    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView categoryName;
    ImageView categoryPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPic=itemView.findViewById(R.id.categoryPic);
        }
    }
}
