package com.example.q7db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private EditText name, mobile, del, message;
    private Button addButton, delButton;
    private DBHandler dbHandler;
    private InputMethodManager imm;
    private View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mobile = findViewById(R.id.number);
        del = findViewById(R.id.delInput);
        message = findViewById(R.id.message);
        addButton = findViewById(R.id.addBtn);
        delButton = findViewById(R.id.delBtn);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        v = this.getCurrentFocus();

        dbHandler = new DBHandler(MainActivity.this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String NAME = name.getText().toString();
                String MOBILE = mobile.getText().toString();

                if(NAME.isEmpty() || MOBILE.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please insert all values",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(dbHandler.addStudent(NAME, MOBILE)) {
                    Toast.makeText(MainActivity.this, "Record Inserted", Toast.LENGTH_LONG).show();
                    name.setText("");
                    mobile.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this, "Record Not Inserted", Toast.LENGTH_SHORT).show();
                }
                showMessage();
//                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String delInp = del.getText().toString();

                if(delInp.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please insert values",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(dbHandler.delStudent(delInp)) {
                    Toast.makeText(MainActivity.this, "Record Deleted", Toast.LENGTH_SHORT).show();
                    del.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this, "Record Not Found", Toast.LENGTH_SHORT).show();
                }
                showMessage();
//                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
            }
        });


    }
    public void showMessage(){
        Cursor cursor = dbHandler.ShowData();
        if(cursor.getCount() == 0){
            message.setText("No Data Added");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            buffer.append("Id : " + cursor.getString(0))
                    .append(" | Name : " + cursor.getString(1))
                    .append(" | Phone : " + cursor.getString(2) + "\n");
        }

        message.setText(buffer.toString());

    }
}