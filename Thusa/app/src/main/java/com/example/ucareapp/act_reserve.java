package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class act_reserve extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_reserve);


        Button th_butt_p = findViewById(R.id.th_butt_p);
        Button th_butt_r = findViewById(R.id.th_butt_r);
        Button th_butt_m = findViewById(R.id.th_butt_m);
        Button btn10 = findViewById(R.id.imageView6);

        btn10.setOnClickListener(v->
        {
            Intent intent = new Intent(act_reserve .this,Cardview.class);
            startActivity(intent);
        });


        th_butt_p.setOnClickListener(v->

        {
            Intent intent = new Intent(act_reserve.this,activity_update.class);
            startActivity(intent);

        });

        th_butt_r.setOnClickListener(v->

        {
            Intent intent = new Intent(act_reserve.this,viewbooking.class);
            startActivity(intent);

        });

        th_butt_m.setOnClickListener(v->
        {
            Intent intent = new Intent(act_reserve.this,checkrating.class);
            startActivity(intent);
        });








    }
}