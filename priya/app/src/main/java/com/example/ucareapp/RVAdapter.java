package com.example.ucareapp;

import android.view.ViewGroup;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private Context context;
    ArrayList<registeredusers> list = new ArrayList<>();
    public RVAdapter(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<registeredusers> regiusers)
    {
        list.addAll(regiusers);
    }


    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new UserVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        registeredusers e = null;
        this.onBindViewHolder(holder,position,e);
    }


    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position,registeredusers e) {
        UserVH vh = (UserVH) holder;
        registeredusers regiusers = e==null? list.get(position):e;
        vh.name.setText(regiusers.getName());
        vh.age.setText(regiusers.getAge());
        vh.address.setText(regiusers.getAddress());
        vh.phno.setText(regiusers.getPhno());
        vh.date.setText(regiusers.getDate());
        vh.txt_option.setOnClickListener(v->
        {
            PopupMenu popupMenu =new PopupMenu(context,vh.txt_option);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item->
            {
                switch (item.getItemId()) {
                    case R.id.menu_edit:
                        Intent intent = new Intent(context, form.class);
                        intent.putExtra("EDIT", regiusers);
                        context.startActivity(intent);
                        break;

                    case R.id.menu_remove:
                        DAOUsers dao=new DAOUsers();
                        dao.remove(regiusers.getKey()).addOnSuccessListener(suc->
                        {
                            Toast.makeText(context, "You cancelled the appointment", Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(position);
                            list.remove(regiusers);
                        }).addOnFailureListener(er->
                        {
                            Toast.makeText(context, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                        });

                        break;
                }
                return false;

            });
            popupMenu.show();

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
