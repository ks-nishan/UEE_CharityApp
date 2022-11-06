package com.example.ucareapp;

import android.os.Parcelable;
import android.util.Patterns;
import android.view.ViewGroup;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class Rvadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
 private Context context;
 ArrayList<employee>list= new ArrayList<>();
   

    public Rvadapter(Context ctx)
   {
       this.context=ctx;
   }
    public  void setItems(ArrayList<employee> emp){
        list.addAll(emp);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_layout_item,parent,false);

        return new employeeVH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        employee e = null;
        this.onBindViewHolder(holder,position,e);
    }
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position,employee e) {

      employeeVH vh =(employeeVH) holder;
      employee emp = e==null? list.get(position):e;
      vh.t1.setText(emp.getName());
      vh.t2.setText(emp.getNic());
      vh.t3.setText(emp.getAge());
      vh.t4.setText(emp.getAddress());
      vh.t5.setText(emp.getMobile());
      vh.t6.setText(emp.getDate());
      vh.t7.setText(emp.getTime());
      vh.option.setOnClickListener(v->{
          PopupMenu popupMenu = new PopupMenu(context,vh.option);
          popupMenu.inflate(R.menu.option_menu);
          popupMenu.setOnMenuItemClickListener(item ->
          {
              switch (item.getItemId()){
                  case  R.id.menuedit:
                      Intent intent = new Intent(context,activity_appointment.class);
                      intent.putExtra("EDIT", emp);
                      context.startActivity(intent);
                      break;

                  case R.id.delete:
                      DAOemployee dao=new DAOemployee();
                      dao.remove(emp.getKey()).addOnSuccessListener(suc->
                      {
                          Toast.makeText(context, "Record is removed", Toast.LENGTH_SHORT).show();
                          notifyItemRemoved(position);
                          list.remove(emp);
                      }).addOnFailureListener(er->
                      {
                          Toast.makeText(context, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                      });
                      break;
              }
              return false;
          });
          popupMenu.show();
              }
              );

    }

    @Override
    public int getItemCount() {

       return list.size();
    }
}
