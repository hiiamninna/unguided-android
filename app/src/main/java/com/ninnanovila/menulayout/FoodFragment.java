package com.ninnanovila.menulayout;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FoodFragment extends Fragment {

    public static String FULL_NAME = "";

    public FoodFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        //GET FULL NAME
        TextView fullNameText = view.findViewById(R.id.fullname_text);
        String message = getArguments().getString(FULL_NAME);

        if (!message.equals("")){
            fullNameText.setText(message);
        }else {
            fullNameText.setText(getString(R.string.failed));
            fullNameText.setBackgroundColor(Color.parseColor("#ff0000"));
        }

        //DROPDOWN SNACKS
        final String[] SNACKS = new String[]{" Mie Kremes", " Oreo", " Wafer Nabati", " Taro", " Doritos"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), R.layout.support_simple_spinner_dropdown_item, SNACKS);
        AutoCompleteTextView snackDropdown = view.findViewById(R.id.snack_dropdown);
        snackDropdown.setAdapter(adapter);
        snackDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), getString(R.string.eat_snack) + SNACKS[position], Toast.LENGTH_SHORT).show();
            }
        });

        //FINISH ACTIVITY
        Button doneButton = view.findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finishAffinity();
            }
        });

        //HIDE FRAME LAYOUT
        Button backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(FoodFragment.this).commit();
            }
        });

        return view;
    }

}