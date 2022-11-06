package com.example.ucareapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class employeeVH extends RecyclerView.ViewHolder {
    public TextView t1,t2,t3,t4,t5,t6,t7,option,btn_res ;

    public employeeVH(@NonNull View itemView) {
        super(itemView);
        t1 = itemView.findViewById(R.id.t1);
        t2 = itemView.findViewById(R.id.t2);
        t3 = itemView.findViewById(R.id.t3);
        t4 = itemView.findViewById(R.id.t4);
        t5 = itemView.findViewById(R.id.t5);
        t6 = itemView.findViewById(R.id.t6);
        t7 = itemView.findViewById(R.id.t7);
        option = itemView.findViewById(R.id.option);


    }
}
