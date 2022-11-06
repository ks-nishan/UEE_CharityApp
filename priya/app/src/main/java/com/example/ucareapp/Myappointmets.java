package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Myappointmets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myappointmets);

        EditText name = findViewById(R.id.formname);
        EditText age = findViewById(R.id.myformage);
        EditText address = findViewById(R.id.myformaddress);
        EditText phno = findViewById(R.id.myformphno);
        EditText date = findViewById(R.id.myformdate);

        Button btn = findViewById(R.id.sentbtn);
        DAOUsers dao = new DAOUsers();
        btn.setOnClickListener(v ->
        {
           /* registeredusers regiusers = new registeredusers(name.getText().toString(),age.getText().toString(),address.getText().toString(),phno.getText().toString(),date.getText().toString());
            dao.add(regiusers).addOnSuccessListener(suc ->
            {
                Toast.makeText(this,"Record is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
            {
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();


            });*/
            /*HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("name", name.getText().toString());
            hashMap.put("age", age.getText().toString());
            hashMap.put("address", address.getText().toString());
            hashMap.put("phno", phno.getText().toString());
            hashMap.put("date", date.getText().toString());
            dao.update("MjzGWB6R01uJlsnwC",hashMap).addOnSuccessListener(suc ->
            {
                Toast.makeText(this,"Record is updated", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
            {
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();


            });*/
        });


    }
}