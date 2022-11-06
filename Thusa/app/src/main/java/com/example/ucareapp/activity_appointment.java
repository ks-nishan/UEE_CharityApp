package com.example.ucareapp;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class activity_appointment extends AppCompatActivity {
    private activity_appointment context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        EditText e_name = findViewById(R.id.th_name);
        EditText e_nic = findViewById(R.id.th_nic);
        EditText e_age = findViewById(R.id.th_age);
        EditText e_address = findViewById(R.id.th_address);
        EditText e_mobile = findViewById(R.id.th_mobile);
        EditText e_date = findViewById(R.id.th_date);
       EditText e_time = findViewById(R.id.th_time);
       Button btn = findViewById(R.id.th_make_as);
        Button btn1 = findViewById(R.id.open);
        Button th_view = findViewById(R.id.th_view);
        Button btn10 = findViewById(R.id.imageView6);
        btn1.setOnClickListener(v->
        {
            Intent intent = new Intent(activity_appointment.this,RVActivity.class);
            startActivity(intent);
        });
        th_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_appointment.this,act_reserve.class);
                startActivity(intent);
            }

        });
        btn10.setOnClickListener(v->
        {
            Intent intent = new Intent(activity_appointment.this,Cardview.class);
            startActivity(intent);
        });


      DAOemployee dao = new DAOemployee();
       employee emp_edit = (employee)getIntent().getSerializableExtra("EDIT");
       if(emp_edit !=null){
           btn.setText("UPDATE");
           e_name.setText(emp_edit.getName());
           e_nic.setText(emp_edit.getNic());
           e_age.setText(emp_edit.getAge());
           e_address.setText(emp_edit.getAddress());
           e_mobile.setText(emp_edit.getMobile());
           e_date.setText(emp_edit.getDate());
           e_time.setText(emp_edit.getTime());
           btn1.setVisibility(View.GONE);
       }
       else {
           btn.setText("Add");
           btn1.setVisibility(View.VISIBLE);
       }
       btn.setOnClickListener(v ->
       {
           employee emp = new employee(e_name.getText().toString(), e_nic.getText().toString(), e_age.getText().toString(),
                   e_address.getText().toString(), e_mobile.getText().toString(), e_date.getText().toString(), e_time.getText().toString());
           if (emp_edit == null) {
               String tname = e_name.getText().toString().trim();
               String tnic = e_nic.getText().toString().trim();
               String tage = e_age.getText().toString().trim();
               String tadd = e_address.getText().toString().trim();
               String tphno = e_mobile.getText().toString().trim();
               String tdate = e_date.getText().toString().trim();
               String ttime = e_time.getText().toString().trim();
               if (tname.isEmpty()) {
                   e_name.setError("Name is required!");
                   e_name.requestFocus();
                   return; }
               if (tnic.isEmpty()) {
                   e_nic.setError("Nic is required!");
                   e_nic.requestFocus();
                   return; }
               if (tage.isEmpty()) {
                   e_age.setError("Age is required!");
                   e_age.requestFocus();
                   return; }
               if (tadd.isEmpty()) {
                   e_address.setError("Address is required!");
                   e_address.requestFocus();
                   return;
               }

               if (tphno.isEmpty()) {
                   e_mobile.setError("Phone number is required!");
                   e_mobile.requestFocus();
                   return;
               }
               if (tdate.isEmpty()) {
                   e_date.setError("Date is required!");
                   e_date.requestFocus();
                   return;
               }
               if (ttime.isEmpty()) {
                   e_time.setError("Date is required!");
                   e_time.requestFocus();
                   return;
               }
               dao.add(emp).addOnSuccessListener(suc -> {
                   Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show();

               }).addOnFailureListener(er ->
                       {
                           Toast.makeText(this, "cancel" + er.getMessage(), Toast.LENGTH_SHORT).show();
                       }
                       );
           } else {
               {
                   HashMap<String, Object> hashMap = new HashMap<>();
                   hashMap.put("name", e_name.getText().toString());
                   hashMap.put("nic", e_nic.getText().toString());
                   hashMap.put("age", e_age.getText().toString());
                   hashMap.put("address", e_address.getText().toString());
                   hashMap.put("mobile", e_mobile.getText().toString());
                   hashMap.put("date", e_date.getText().toString());
                   hashMap.put("time", e_time.getText().toString());


                   dao.update(emp_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                   {
                       Toast.makeText(this, "Record is updated", Toast.LENGTH_SHORT).show();
                       finish();
                   }).addOnFailureListener(er ->
                   {
                       Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                   });
               }
           };





});
    }
}
