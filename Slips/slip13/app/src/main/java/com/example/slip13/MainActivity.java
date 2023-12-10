package com.example.slip13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText username;
    EditText password;
    private static final String user = "Ajayveer";
    private static final String pass = "123456789";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userText = username.getText().toString();
                String passText = password.getText().toString();
                if(!userText.equals(user) || !passText.equals(pass)){
                    Toast.makeText(MainActivity.this,"Invalid Username or Password!",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, EmailBox.class);
                intent.putExtra("from",userText);
                startActivity(intent);

            }
        });

    }
}