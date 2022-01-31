package com.example.unme.app.controller.adapters;

import
        android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.unme.R;
import com.example.unme.app.model.Menu;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<Menu> {

    public MenuAdapter(Context ctx, List<Menu> items) {
        super(ctx, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position.
        Menu item = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_menu, parent, false);
        }

        // Lookup view for data population.
        TextView item_text = (TextView) convertView.findViewById(R.id.item_text);
        ImageView item_icon = (ImageView) convertView.findViewById(R.id.item_icon);

        // Populate the data into the template view using the data object.
        item_text.setText(item.getItem_text());
        item_icon.setImageResource(item.getItem_icon());

        // Return the completed view to render on screen.
        return convertView;
    }
}
