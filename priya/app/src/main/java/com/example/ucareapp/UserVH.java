package com.example.ucareapp;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.jar.Attributes;

public class UserVH extends RecyclerView.ViewHolder {
    public TextView name, age, address, phno, date, txt_option;

    public UserVH(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.formname);
        age = itemView.findViewById(R.id.myformage);
        address = itemView.findViewById(R.id.myformaddress);
        phno = itemView.findViewById(R.id.myformphno);
        date = itemView.findViewById(R.id.myformdate);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}