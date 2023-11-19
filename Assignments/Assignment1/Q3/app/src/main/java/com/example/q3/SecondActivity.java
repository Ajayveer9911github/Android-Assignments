package com.example.q3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView show = findViewById(R.id.show);
        TextView show1 = findViewById(R.id.show1);
        TextView show2 = findViewById(R.id.show2);
        TextView show3 = findViewById(R.id.show3);
        TextView show4 = findViewById(R.id.show4);
        TextView show5 = findViewById(R.id.show5);

        show.setText(getIntent().getStringExtra("fname").toString());
        show1.setText(getIntent().getStringExtra("mname").toString());
        show2.setText(getIntent().getStringExtra("lname").toString());
        show3.setText(getIntent().getStringExtra("dob").toString());
        show4.setText(getIntent().getStringExtra("email").toString());
        show5.setText(getIntent().getStringExtra("address").toString());

    }
}
