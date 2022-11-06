package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


public class form extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        System.out.println("DEBUG>> form>> onCreate");
        final EditText name = findViewById(R.id.formname);
        final EditText age = findViewById(R.id.myformage);
        final EditText address = findViewById(R.id.myformaddress);
        final EditText phno = findViewById(R.id.myformphno);
        final EditText date = findViewById(R.id.myformdate);

        Button btn = findViewById(R.id.sentbtn);
        Button btn_open = findViewById(R.id.viewbtn);


        DAOUsers dao = new DAOUsers();
        registeredusers emp_edit = (registeredusers)getIntent().getSerializableExtra("EDIT");
        if(emp_edit !=null)
        {
            btn.setText("UPDATE");
            name.setText(emp_edit.getName());
            age.setText(emp_edit.getAge());
            address.setText(emp_edit.getAddress());
            phno.setText(emp_edit.getPhno());
            date.setText(emp_edit.getDate());

//            btn_open.setVisibility(View.GONE);
        }
        else
        {
            btn.setText("SUBMIT");
            //btn_open.setVisibility(View.VISIBLE);
        }
       btn.setOnClickListener(v ->
        {
             registeredusers regiusers = new registeredusers(name.getText().toString(),age.getText().toString(),address.getText()
                     .toString(),phno.getText().toString(),date.getText().toString());
             if(emp_edit==null) {
                 String vname = name.getText().toString().trim();
                 String vage = age.getText().toString().trim();
                 String vadd = address.getText().toString().trim();
                 String vphno = phno.getText().toString().trim();
                 String vdate = date.getText().toString().trim();
                 if (vname.isEmpty()) {
                     name.setError("Name is required!");
                     name.requestFocus();
                     return;
                 }

                 if (vage.isEmpty()) {
                     age.setError("Count is required!");
                     age.requestFocus();
                     return;
                 }

                 if (vadd.isEmpty()) {
                     address.setError("Address is required!");
                     address.requestFocus();
                     return;
                 }

                 if (vphno.isEmpty()) {
                     phno.setError("Contact number is required!");
                     phno.requestFocus();
                     return;
                 }

                 if (vphno.length() < 10 || vphno.length() > 10) {
                     phno.setError("Enter Valid Phone number!");
                     phno.requestFocus();
                     return;
                 }

                 if (vdate.isEmpty()) {
                     date.setError("E-mail is required!");
                     date.requestFocus();
                     return;
                 }
                 System.out.println("DEBUG>> emp_edit == null ");
                 dao.add(regiusers).addOnSuccessListener(suc ->
                 {
                     Toast.makeText(this, "Charity Details is inserted", Toast.LENGTH_SHORT).show();
                 }).addOnFailureListener(er ->
                 {
                     Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();


                 });
             }
             else
             {
                 String vname = name.getText().toString().trim();
                 String vage = age.getText().toString().trim();
                 String vadd = address.getText().toString().trim();
                 String vphno = phno.getText().toString().trim();
                 String vdate = date.getText().toString().trim();
                 if (vname.isEmpty()) {
                     name.setError("Name is required!");
                     name.requestFocus();
                     return;
                 }

                 if (vage.isEmpty()) {
                     age.setError("Count is required!");
                     age.requestFocus();
                     return;
                 }

                 if (vadd.isEmpty()) {
                     address.setError("Address is required!");
                     address.requestFocus();
                     return;
                 }

                 if (vphno.isEmpty()) {
                     phno.setError("Contact number is required!");
                     phno.requestFocus();
                     return;
                 }

                 if (vdate.isEmpty()) {
                     date.setError("E-mail is required!");
                     date.requestFocus();
                     return;
                 }

                 System.out.println("DEBUG>> emp_edit != null ");
                 System.out.println("DEBUG>> emp_edit.getKey() " + emp_edit.getKey());
                 HashMap<String, Object> hashMap = new HashMap<>();
                 hashMap.put("name", name.getText().toString());
                 hashMap.put("age", age.getText().toString());
                 hashMap.put("address", address.getText().toString());
                 hashMap.put("phno", phno.getText().toString());
                 hashMap.put("date", date.getText().toString());
                 dao.update(emp_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                 {
                     Toast.makeText(this, "Charity Details is updated", Toast.LENGTH_SHORT).show();
                     finish();
                 }).addOnFailureListener(er ->
                 {
                     Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                 });
             }
        });


    }
}