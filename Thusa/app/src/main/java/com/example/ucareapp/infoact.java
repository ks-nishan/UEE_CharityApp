package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class infoact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoact);
        Button btn10 = findViewById(R.id.th_butt21);
        btn10.setOnClickListener(v->
        {
            Intent intent = new Intent(infoact.this,activity_contactus.class);
            startActivity(intent);
        });
    }
}