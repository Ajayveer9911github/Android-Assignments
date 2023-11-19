package com.example.q20;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    View view;
    Button btn;
    Spinner spinner;
private static final String[] colors = {"black", "white", "tangerine", "red", "green", "yellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        layout = findViewById(R.id.layout);
        spinner.setSelected(true);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, colors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btn = findViewById(R.id.changeColorBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color = spinner.getSelectedItem().toString();
                layout.setBackgroundColor(Color.parseColor(color));
                spinner.setBackgroundColor(Color.parseColor("white"));
            }
        });
    }
}