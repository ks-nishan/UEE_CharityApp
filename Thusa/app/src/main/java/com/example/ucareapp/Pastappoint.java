package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Pastappoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastappoint);

        Button btn1 = findViewById(R.id.imageView6);
        Button btn2 = findViewById(R.id.th_butt10);
        btn1.setOnClickListener(v->
        {
            Intent intent = new Intent(Pastappoint.this,Cardview.class);
            startActivity(intent);
        });

        btn2.setOnClickListener(v->
        {
            Intent intent = new Intent(Pastappoint.this,viewbooking.class);
            startActivity(intent);
        });


    }
}