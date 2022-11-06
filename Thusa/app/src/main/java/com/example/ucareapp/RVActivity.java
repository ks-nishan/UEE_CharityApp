package com.example.ucareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    Rvadapter adapter;
    DAOemployee dao;
    boolean isloading = false;
    String key=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);
        swipeRefreshLayout = findViewById(R.id.swip);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter = new Rvadapter(this);
      recyclerView.setAdapter(adapter);
      dao = new DAOemployee();
      loaddata();
      recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
          @Override
          public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
              LinearLayoutManager linearLayoutManager =(LinearLayoutManager) recyclerView.getLayoutManager();
            int totalItem = linearLayoutManager.getItemCount();
            int lastVisible = linearLayoutManager.findLastCompletelyVisibleItemPosition();
             if(totalItem<lastVisible+3){
                 if(!isloading){
                  isloading=true;
                  loaddata();
              } }
          }
      }); }
    private void loaddata(){
        swipeRefreshLayout.setRefreshing(true);
        dao.get(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<employee> emps = new ArrayList<>();
             for(DataSnapshot data : snapshot.getChildren())
             {
                employee emp = data.getValue(employee.class);
                emp.setKey(data.getKey());
                emps.add(emp);
                key= data.getKey();
             }
             adapter.setItems(emps);
             adapter.notifyDataSetChanged();
             isloading = false;
                swipeRefreshLayout.setRefreshing(false);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                swipeRefreshLayout.setRefreshing(false); }
        }); }}