package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Cardview extends AppCompatActivity {
    private CardView context;
     private TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);

       t1  = (TextView)findViewById(R.id.thcard_1);
        t2  = (TextView)findViewById(R.id.thcard_2);
        t3  = (TextView)findViewById(R.id.thcard_3);
        t1 .setOnClickListener(v->

        {
            Intent intent = new Intent(Cardview.this,MainActivity.class);
            startActivity(intent);

        });

        t2 .setOnClickListener(v->

        {
            Intent intent = new Intent(Cardview.this,Pastappoint.class);
            startActivity(intent);

        });


        t3 .setOnClickListener(v->

        {
            Intent intent = new Intent(Cardview.this,infoact.class);
            startActivity(intent);

        });


    }
}