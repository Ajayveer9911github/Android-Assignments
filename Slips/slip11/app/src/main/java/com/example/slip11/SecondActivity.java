package com.example.slip11;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String res = getIntent().getStringExtra("result");

        Log.d(TAG, "onCreate: "+res);
        txt = findViewById(R.id.newTV);
        txt.setText("Result: "+res);

    }
}
