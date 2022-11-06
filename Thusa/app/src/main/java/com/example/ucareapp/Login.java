package com.example.ucareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private TextView regilink;
    private EditText edittextEmail,editextPass;
    private Button loginbtn;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        regilink =(TextView) findViewById(R.id.relink);
        regilink.setOnClickListener(this);

        loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(this);

        edittextEmail = (EditText) findViewById(R.id.logtextemail);
        editextPass = (EditText) findViewById(R.id.logtextpass);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.relink:
                startActivity(new Intent(this, Register.class));
                break;

            case R.id.loginbtn:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String logemail = edittextEmail.getText().toString().trim();
        String logepass = editextPass.getText().toString().trim();

        if(logemail.isEmpty()){
            edittextEmail.setError("Email is required!");
            edittextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(logemail).matches()){
            edittextEmail.setError("please provide valid email!");
            edittextEmail.requestFocus();
            return;

        }
        if(logepass.isEmpty()){
            editextPass.setError("password is required!");
            editextPass.requestFocus();
            return;
        }
        if(logepass.length() < 6){
            editextPass.setError("Min password length should be 6 characters");
            editextPass.requestFocus();
            return;
        }

        progressBar.setVisibility((View.VISIBLE));

        mAuth.signInWithEmailAndPassword(logemail,logepass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //redirect to homepage
                    startActivity(new Intent(Login.this, Cardview.class));
                }else {
                    Toast.makeText(Login.this, "Failed to Login!Try Again!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}