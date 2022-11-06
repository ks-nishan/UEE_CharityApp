package com.example.ucareapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Mathy_adapter extends FirebaseRecyclerAdapter<Vaccin,Mathy_adapter.myviewholder> {
    public Mathy_adapter(@NonNull FirebaseRecyclerOptions<Vaccin> options)
    {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull @NotNull Mathy_adapter.myviewholder holder, int position, @NonNull @NotNull Vaccin Vaccin) {
        holder.name.setText(Vaccin.getName());
        holder.address.setText(Vaccin.getAddress());
        holder.phone.setText(Vaccin.getPhone());
        holder.qualification.setText(Vaccin.getQualification());
        holder.school.setText(Vaccin.getSchool());
        holder.email.setText(Vaccin.getEmail());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.updatelayout))
                        .setExpanded(true,1500)
                        .create();

                View myview=dialogPlus.getHolderView();
                final EditText name=myview.findViewById(R.id.edit_name);
                final EditText address=myview.findViewById(R.id.edit_address);
                final EditText phone=myview.findViewById(R.id.edit_phone);
                final EditText email=myview.findViewById(R.id.edit_email);
                final EditText qualification=myview.findViewById(R.id.edit_qualification);
                final EditText school=myview.findViewById(R.id.edit_school);

                Button submit=myview.findViewById(R.id.ma_view_edit_1);

                name.setText(Vaccin.getName());
                address.setText(Vaccin.getAddress());
                phone.setText(Vaccin.getPhone());
                qualification.setText(Vaccin.getQualification());
                email.setText(Vaccin.getEmail());
                school.setText(Vaccin.getSchool());



                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("phone",phone.getText().toString());
                        map.put("address",address.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("qualification",qualification.getText().toString());
                        map.put("school",school.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("VaccinBooking")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });


            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Do You Want To Cancel Your Reservation");


                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Workshops")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });


    }

    @NonNull
    @NotNull
    @Override
    public Mathy_adapter.myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }
    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        ImageView edit,delete;
        TextView name,phone,email,qualification,school,address;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(CircleImageView) itemView.findViewById(R.id.img1);
            name=(TextView)itemView.findViewById(R.id.ma_det_name);
            phone=(TextView)itemView.findViewById(R.id.ma_det_vacname);
            address=(TextView)itemView.findViewById(R.id.ma_det_date);
            email=(TextView)itemView.findViewById(R.id.ma_det_time);
            qualification=(TextView)itemView.findViewById(R.id.ma_det_time);
            school=(TextView)itemView.findViewById(R.id.ma_det_time);

            edit=(ImageView)itemView.findViewById(R.id.editicon);
            delete=(ImageView)itemView.findViewById(R.id.deleteicon);
        }
    }
}
