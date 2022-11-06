package com.example.ucareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Join extends AppCompatActivity {
    EditText name,school,qalification,email,phone,address;
    Button join;
    private Button button;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        name=(EditText)findViewById(R.id.ma_name);
        school=(EditText)findViewById(R.id.ma_school);
        phone=(EditText)findViewById(R.id.ma_phone);
        address=(EditText)findViewById(R.id.ma_address);
        email=(EditText)findViewById(R.id.ma_email);
        qalification=(EditText)findViewById(R.id.ma_qalification);


        button=(Button)findViewById(R.id.ma_next2_2);
        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.ma_name, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.ma_school, RegexTemplate.NOT_EMPTY,R.string.invalid_name_2);
        awesomeValidation.addValidation(this,R.id.ma_qalification, RegexTemplate.NOT_EMPTY,R.string.invalid_name_2);
        awesomeValidation.addValidation(this,R.id.ma_phone, RegexTemplate.NOT_EMPTY,R.string.invalid_name_1);
        awesomeValidation.addValidation(this,R.id.ma_address, RegexTemplate.NOT_EMPTY,R.string.invalid_name_2);
        awesomeValidation.addValidation(this,R.id.ma_email, RegexTemplate.NOT_EMPTY,R.string.invalid_name_4);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Vac_bookinglist.class));
                finish();
            }
        });

        join=(Button)findViewById(R.id.ma_next2_2);
        join.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processinsert();
            }

        }));
    }
    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("phone",phone.getText().toString());
        map.put("email",email.getText().toString());
        map.put("address",address.getText().toString());
        map.put("qualification",qalification.getText().toString());
        map.put("school",school.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("Workshop").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        name.setText("");
                        phone.setText("");
                        address.setText("");
                        email.setText("");
                        qalification.setText("");
                        school.setText("");
                        Toast.makeText(getApplicationContext(),"You Have Joined Successfully",Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Sorry Your Process Have Some Error", Toast.LENGTH_LONG).show();
                    }
                });





    }
}