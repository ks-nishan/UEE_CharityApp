package com.example.teammark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myproject.Booking;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private Myadapter adapter;
    private List<Model> list;

    private EditText edtSerch;
    private ImageView imgSerch;
    private DatabaseReference dbAD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        adapter = new Myadapter(this,list);
        recyclerView.setAdapter(adapter);
        dbAD = FirebaseDatabase.getInstance().getReference("Advertisements");

        ItemTouchHelper touchHelper = new ItemTouchHelper(new TouchHelper(adapter));
        touchHelper.attachToRecyclerView(recyclerView);


//        ImageView img = (ImageView)findViewById(R.id.logo);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String EMAIL;
//                Intent intent2 = getIntent();
//                EMAIL = intent2.getStringExtra("EMAIL");
//                Intent intent = new Intent(ShowActivity.this,Booking.class);
//                intent.putExtra("EMAIL",EMAIL);
//                intent.putExtra("Model","Benz");
//                startActivity(intent);
//            }
//        });

        edtSerch = (EditText)findViewById(R.id.searchBar);
//        imgSerch = (ImageView)findViewById(R.id.imgSerch);

//        imgSerch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String searchtxt = edtSerch.getText().toString();
//                adSearch(searchtxt);
//            }
//
//            private void adSearch(String searchtxt) {
//                Toast.makeText(ShowActivity.this, "Search started", Toast.LENGTH_SHORT).show();
//                Query searchQuery = dbAD.orderByChild("title").startAt(searchtxt).endAt(searchtxt + "\uf8ff");
//            }
//        });

        showData();
    }
    public void showData(){
        db.collection("Advertisements").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        for (DocumentSnapshot snapshot : task.getResult()){
                            Model model = new Model(snapshot.getString("id"),snapshot.getString("title"),snapshot.getString("district"),snapshot.getString("person"),snapshot.getString("amount"),snapshot.getString("mobile"),snapshot.getString("engine"));
                            list.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {
                Toast.makeText(ShowActivity.this, "Somthing went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}