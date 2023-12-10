package com.example.slip9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    ImageButton nextBtn, prevBtn;
    int[] imageSwitcherImages = {R.drawable.samp1, R.drawable.samp2, R.drawable.samp3, R.drawable.samp4, R.drawable.samp5};
    int switchImageLength = imageSwitcherImages.length;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = findViewById(R.id.imageView);
        prevBtn = findViewById(R.id.imageButton);
        nextBtn = findViewById(R.id.imageButton2);
        prevBtn.setImageResource(R.drawable.left);
        nextBtn.setImageResource(R.drawable.right);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView = new ImageView(MainActivity.this);
                switcherImageView.setImageResource(R.drawable.samp1);
                return switcherImageView;
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter==switchImageLength-1){
                    counter=0;
                }
                else{
                    counter++;
                }
                imageSwitcher.setImageResource(imageSwitcherImages[counter]);
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter==0){
                    counter=switchImageLength-1;
                }
                else{
                    counter--;
                }
                imageSwitcher.setImageResource(imageSwitcherImages[counter]);
            }
        });
    }
}