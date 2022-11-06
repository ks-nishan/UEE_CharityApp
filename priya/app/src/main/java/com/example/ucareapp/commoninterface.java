package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class commoninterface extends AppCompatActivity implements View.OnClickListener {
    private TextView blodtest,imaging,urynalisis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commoninterface);

        blodtest =(TextView) findViewById(R.id.bloodtest);
        blodtest.setOnClickListener(this);

        imaging =(TextView) findViewById(R.id.bloodtest);
        imaging.setOnClickListener(this);

        urynalisis =(TextView) findViewById(R.id.bloodtest);
        urynalisis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bloodtest:
                startActivity(new Intent(this, form.class));
                break;

            case R.id.imagingtest:
                startActivity(new Intent(this, form.class));
                break;

            case R.id.urytest:
                startActivity(new Intent(this, form.class));
                break;
        }
    }
}