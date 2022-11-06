package com.example.ucareapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class workshop extends Activity {
    Button share;
    Button join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        share = (Button) findViewById(R.id.share);
        join = (Button) findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openActivity2();

            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                openActivity3();

            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Join.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, Join.class);
        startActivity(intent);
    }



}
