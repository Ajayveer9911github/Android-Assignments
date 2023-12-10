package com.example.slip13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EmailBox extends AppCompatActivity {

    Button btnSend;
    EditText toEmail, message, subject;
    String txtToEmail, txtMessage, txtSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_box);

        subject = findViewById(R.id.editTextTextPersonName2);
        btnSend = findViewById(R.id.button2);
        toEmail = findViewById(R.id.editTextTextPersonName);
        message = findViewById(R.id.editTextTextMultiLine);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtToEmail = toEmail.getText().toString();
                txtMessage = message.getText().toString();
                txtSubject = subject.getText().toString();
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("message/rfc822");
                intent1.putExtra(Intent.EXTRA_EMAIL,txtToEmail);
                intent1.putExtra(Intent.EXTRA_TEXT,txtMessage);
                intent1.putExtra(Intent.EXTRA_SUBJECT,txtSubject);
                startActivity(Intent.createChooser(intent1,"Choose an Email Client"));
            }
        });
    }
}
