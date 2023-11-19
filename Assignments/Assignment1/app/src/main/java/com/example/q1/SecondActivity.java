package com.example.q1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView secondTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        secondTxt = (TextView) findViewById(R.id.secondTxt);

        Intent intent = getIntent();
        String secondStr = intent.getStringExtra("Message");

        secondTxt.setText(secondStr);


    }
}
