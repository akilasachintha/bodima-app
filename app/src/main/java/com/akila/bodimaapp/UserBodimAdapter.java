package com.akila.bodimaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UserBodimAdapter extends RecyclerView.Adapter<UserBodimAdapter.MyViewHolder> {
    ArrayList<BodimModel> userBodimList;
    Context context;

    public UserBodimAdapter(Context context, ArrayList<BodimModel> userBodimList){
        this.userBodimList = userBodimList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.bodim_cart, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserBodimAdapter.MyViewHolder holder, int position) {
        BodimModel model = userBodimList.get(position);
        holder.name.setText(model.getName());
        holder.phone.setText(model.getPhone());
        holder.address.setText(model.getAddress());
        holder.beds.setText(model.getBeds());
    }

    @Override
    public int getItemCount() {
        return userBodimList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, phone, address, beds;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_user_list);
            phone = itemView.findViewById(R.id.phone_user_list);
            address = itemView.findViewById(R.id.address_user_list);
            beds = itemView.findViewById(R.id.beds_user_list);
        }
    }
}
