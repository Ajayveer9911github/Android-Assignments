package com.example.slip11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText a,b;
    Button avg, pow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.num1);
        b = findViewById(R.id.num2);
        avg = findViewById(R.id.avgBtn);
        pow = findViewById(R.id.powBtn);

        avg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = Integer.parseInt(a.getText().toString());
                int n2 = Integer.parseInt(b.getText().toString());
                float res = (n1+n2)/2;
                String res1 = String.valueOf(res);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("result",res1);
                startActivity(intent);
            }
        });

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(a.getText().toString());
                int n2 = Integer.parseInt(b.getText().toString());
                int res = (int) Math.pow(n1,n2);
                String res1 = String.valueOf(res);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("result",res1);
                startActivity(intent);
            }
        });

    }
}