package com.example.ucareapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.util.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private TextView alreadyhave;
    private EditText edittextname, edittextemail, edittextpass, edittextcopass;
    private ProgressBar progressBar;
    private Button registerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        registerbtn = (Button) findViewById(R.id.buttonregi);
        registerbtn.setOnClickListener(this);

        edittextname = (EditText) findViewById(R.id.Reginame);
        edittextemail = (EditText) findViewById(R.id.reemail);
        edittextpass = (EditText) findViewById(R.id.repass);
        edittextcopass = (EditText) findViewById(R.id.copass);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alreadytext:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.buttonregi:
                registerbtn();
        }

    }

    private void registerbtn() {

        String name = edittextname.getText().toString().trim();
        String email = edittextemail.getText().toString().trim();
        String pass = edittextpass.getText().toString().trim();
        String copass = edittextcopass.getText().toString().trim();

        if (name.isEmpty()) {
            edittextname.setError("Name is required!");
            edittextname.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            edittextemail.setError("Email is required!");
            edittextemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edittextemail.setError("please provide valid email!");
            edittextemail.requestFocus();
            return;

        }
        if (pass.isEmpty()) {
            edittextpass.setError("password is required!");
            edittextpass.requestFocus();
            return;
        }
        if (pass.length() < 6) {
            edittextpass.setError("Min password length should be 6 characters");
            edittextpass.requestFocus();
            return;
        }
        if (!pass.equals(copass)) {
            edittextcopass.setError("Not match with password");
            edittextcopass.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            RUsers user = new RUsers(name, email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Register.this, "User has been registered successfully", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(Register.this, "Failed to register!Try Again!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);

                                    }
                                }
                            });
                        } else {
                            Toast.makeText(Register.this, "Failed to register!Try Again!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);


                        }
                    }
                });

    }
}