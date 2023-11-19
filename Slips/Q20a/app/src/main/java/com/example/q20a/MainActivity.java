package com.example.q20a;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner, spinner1;
    Button btn;
    TextView txt;
    RelativeLayout layout;
    private static final String[] colors = {"red", "white", "black", "green", "yellow", "blue"};
    private static final Integer[] sizes = {14, 16, 20, 24, 34};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        btn = findViewById(R.id.button);
        txt = findViewById(R.id.txt);
        layout = findViewById(R.id.layout);

        ArrayAdapter<String> colorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,colors);
        ArrayAdapter<Integer> txtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sizes);

        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setSelected(true);
        spinner1.setSelected(true);

        spinner.setAdapter(colorAdapter);
        spinner1.setAdapter(txtAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color = spinner.getSelectedItem().toString();
                Integer size = (Integer) spinner1.getSelectedItem();

                layout.setBackgroundColor(Color.parseColor(color));
                txt.setTextSize(size);
                spinner.setBackgroundColor(Color.WHITE);
                spinner1.setBackgroundColor(Color.GRAY);
            }
        });

    }
}