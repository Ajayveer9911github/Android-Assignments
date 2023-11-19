package com.example.q18;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameInp, addressInp, phnoInp;
    TextView txtOut;
    Button btn;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInp = findViewById(R.id.nameInp);
        addressInp = findViewById(R.id.addressInp);
        phnoInp = findViewById(R.id.phnoInp);
        txtOut = findViewById(R.id.textOut);
        btn = findViewById(R.id.btn);

        clearAll();

        dbHandler = new DBHandler(MainActivity.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, address, txt, phno;
                name = nameInp.getText().toString();
                address = addressInp.getText().toString();
                phno =  phnoInp.getText().toString();

                if(name.isEmpty() || address.isEmpty() || phno.isEmpty()){
                    Toast.makeText(MainActivity.this,"One or More Fields are empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(dbHandler.addCompany(name,address,phno)){
                    Toast.makeText(MainActivity.this, "Record Added", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
                clearAll();
                showDetails();
            }
        });

    }

    public void showDetails(){
        Cursor cursor;
        cursor = dbHandler.showCompany();
        if(cursor.getCount() == 0){
            txtOut.setText("No Company Registered!");
            return;
        }
        String str = "";
        while(cursor.moveToNext()){
            str = str + "\nID: " + cursor.getString(0) + " | Name: " + cursor.getString(1) + " | Address: " + cursor.getString(2)
                    + " | Phone Number: " + cursor.getString(3);
            txtOut.setText(str);
        }
        clearAll();
    }

    public void clearAll(){
        nameInp.setText("");
        addressInp.setText("");
        phnoInp.setText("");
        txtOut.setText("");
    }
}