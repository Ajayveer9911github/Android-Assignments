package com.example.q3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText fname1, lname1, mname1, email1, address1, dob1;
    Button subBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname1 = findViewById(R.id.fname);
        lname1 = findViewById(R.id.lname);
        mname1 = findViewById(R.id.mname);
        email1 = findViewById(R.id.email);
        address1 = findViewById(R.id.address);
        dob1 = findViewById(R.id.dob);
        subBtn = findViewById(R.id.sub);

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String fname, lname, mname, email, address, dob;
                fname = fname1.getText().toString();
                lname = lname1.getText().toString();
                mname = mname1.getText().toString();
                email = email1.getText().toString();
                address = address1.getText().toString();
                dob = dob1.getText().toString();

                intent.putExtra("fname",fname);
                intent.putExtra("mname",mname);
                intent.putExtra("lname",lname);
                intent.putExtra("dob",dob);
                intent.putExtra("address",address);
                intent.putExtra("email",email);

                startActivity(intent);


            }
        });
    }
}