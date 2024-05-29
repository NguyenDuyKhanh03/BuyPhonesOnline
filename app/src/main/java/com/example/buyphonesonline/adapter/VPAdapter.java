package com.example.buyphonesonline.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buyphonesonline.databinding.ViewpagerItemBinding;

import java.util.List;

public class VPAdapter extends RecyclerView.Adapter<VPAdapter.MyViewHolder> {

    List<Integer> images;

    public VPAdapter(List<Integer> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewpagerItemBinding binding=ViewpagerItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        ViewpagerItemBinding binding;
        public MyViewHolder(@NonNull ViewpagerItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        void bindData(int imgId){
            binding.banner.setImageResource(imgId);
        }
    }
}
