package com.example.unme.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.unme.R;
import com.example.unme.app.controller.adapters.MenuAdapter;
import com.example.unme.app.model.Menu;
import com.example.unme.app.userAccount.EditEmail;
import com.example.unme.app.userAccount.EditPassword;
import com.example.unme.app.userAccount.FullName;

import java.util.ArrayList;

public class AccountFragment extends Fragment {
    final ArrayList<Menu> items = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_account_settings, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MenuAdapter adapter = new MenuAdapter(getActivity(),getItems());

        // Get listView & Attach the adapter to a ListView.
        ListView lv = (ListView)getView().findViewById(R.id.list_menu_items);
        lv.setAdapter(adapter);

        // Set Item Click On List View.
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), FullName.class));
                        break;
                    case 1 :
                        startActivity(new Intent(getActivity(), EditEmail.class));
                        break;
                    case 2 :
                        startActivity(new Intent(getActivity(), EditPassword.class));

                }
            }
        });

        // Back To Previous Activity Button.
        Button back = (Button)getView().findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

    }


    public ArrayList<Menu> getItems() {
        items.clear();

        final String[] mTitles = {"Full name","Email", "Password"};
        final int[] mIcons = { R.drawable.ic_details, R.drawable.ic_mail, R.drawable.ic_lock};

        // Add Titles & Icons to items
        for(int i=0; i<mTitles.length; i++) {
            items.add(new Menu(mIcons[i], mTitles[i]));
        }

        return items;   // Data has now returned.
    }
}
