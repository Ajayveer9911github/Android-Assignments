package com.example.q4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentB extends Fragment {

    TextView heading, details;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        heading = view.findViewById(R.id.idHeading);
        details = view.findViewById(R.id.idDetail);

        String inp = getArguments().getString("item");
        populateFragment(inp);
        return view;
    }

    public void populateFragment(String inp){
        heading.setText(inp);
        switch(inp){
            case "Item1":
                details.setText("This is the description for Item 1");
                break;
            case "Item2":
                details.setText("This is the description for Item 2");
                break;
            case "Item3":
                details.setText("This is the description for Item 3");
                break;
            case "Item4":
                details.setText("This is the description for Item 4");
                break;
            case "Item5":
                details.setText("This is the description for Item 5");
                break;
            case "Item6":
                details.setText("This is the description for Item 6");
                break;
            default:
                details.setText("Something went wrong!");
                break;
        }
    }
}

