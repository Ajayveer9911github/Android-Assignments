package com.example.q18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nameInp, addressInp, phnoInp;
    TextView txtOut;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInp = findViewById(R.id.nameInp);
        addressInp = findViewById(R.id.addressInp);
        phnoInp = findViewById(R.id.phnoInp);
        txtOut = findViewById(R.id.textOut);
        btn = findViewById(R.id.btn);

        String name, address, phno, txt;
        name = nameInp.getText().toString();
        address = addressInp.getText().toString();
        phno = phnoInp.getText().toString();



    }
}