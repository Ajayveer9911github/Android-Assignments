package com.example.q4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentA extends Fragment {

    ListView lv;
    SearchView searchView;
    ArrayAdapter<String> adapter;
    String[] data = {"Item1","Item2","item3","Item3","Item4","Item5"};

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        lv = view.findViewById(R.id.idListView);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getAdapter().getItem(i).toString();
//                String selectedItem = lv.toString();
//                Intent intent = new Intent(view.getContext(), FragmentB.class);
//                intent.putExtra("item",selectedItem);
//                startActivity(intent);

                FragmentB frag = new FragmentB();
                Bundle args = new Bundle();
                args.putString("item", selectedItem);
                frag.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.idFragment2,frag).commit();
            }
        });
        return view;
    }
}