package com.example.buyphonesonline.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buyphonesonline.databinding.ItemNotificationBinding;

import java.util.List;

public class NotiAdapter extends RecyclerView.Adapter<NotiAdapter.MyViewHolder> {

    private List<String> noti;

    public NotiAdapter(List<String> noti) {
        this.noti = noti;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNotificationBinding binding=ItemNotificationBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(noti.get(position));
    }

    @Override
    public int getItemCount() {
        return noti.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ItemNotificationBinding binding;
        public MyViewHolder(@NonNull ItemNotificationBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        void bindData(String title){
            binding.tvName.setText(title);
        }
    }

}
