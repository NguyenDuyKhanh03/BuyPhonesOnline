package com.example.buyphonesonline.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buyphonesonline.databinding.ItemProductInCartBinding;
import com.example.buyphonesonline.dtos.ProductDto;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    List<ProductDto> productDtos;

    public CartAdapter(List<ProductDto> productDtos) {
        this.productDtos = productDtos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductInCartBinding binding= ItemProductInCartBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(productDtos.get(position));
    }

    @Override
    public int getItemCount() {
        return productDtos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ItemProductInCartBinding binding;
        public MyViewHolder(@NonNull ItemProductInCartBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bindData(ProductDto product){
            Glide.with(binding.imgProduct).load(product.image()).into(binding.imgProduct);
            binding.tvName.setText(product.name());
            binding.tvPrice.setText(String.valueOf(product.price()));
        }
    }
}
