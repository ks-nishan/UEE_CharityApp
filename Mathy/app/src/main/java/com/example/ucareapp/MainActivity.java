package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button ma_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ma_button=(Button)findViewById(R.id.button_01);
        ma_button.setOnClickListener(v1 -> {
//                openActivity1();
            startActivity(new Intent(MainActivity.this,workshop.class));

        });


    }
    public void openActivity1(){
        Intent intent =new Intent(this,workshop.class);
        startActivity(intent);
    }

//    @Override
//    public void onClick(View v){
//        Intent i;
//
//        i = new Intent(this,workshop.class);
//        startActivity(i);
//    }

}