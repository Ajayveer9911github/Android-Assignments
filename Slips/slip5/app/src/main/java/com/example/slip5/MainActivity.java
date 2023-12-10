package com.example.slip5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    private static final String[] coffee = {"Filter", "Americano", "Latte", "Espresso", "Cappucino", "Mocha", "Skinny Latte"};
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> coffeeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,coffee);

        coffeeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(coffeeAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coffeeAdapter.setDropDownViewResource(R.layout.my_spinner);
                spinner.setAdapter(coffeeAdapter);
            }
        });

    }
}