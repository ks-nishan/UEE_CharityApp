package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class Vac_bookinglist extends AppCompatActivity {
    RecyclerView recview;
    Mathy_adapter mathy_adapter;
    ArrayList<Vaccin> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vac_bookinglist);
        recview=(RecyclerView)findViewById(R.id.ma_recycle);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Vaccin> options =
                new FirebaseRecyclerOptions.Builder<Vaccin>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("VaccinBooking"), Vaccin.class)
                        .build();

        mathy_adapter=new Mathy_adapter(options);
        recview.setAdapter(mathy_adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mathy_adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mathy_adapter.stopListening();

    }
}