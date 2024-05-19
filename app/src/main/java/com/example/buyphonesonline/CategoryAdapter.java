package com.example.buyphonesonline;


import android.view.LayoutInflater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buyphonesonline.databinding.LayoutItemProductBinding;
import com.example.buyphonesonline.models.Product;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    List<Product> listProduct;

    public CategoryAdapter(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutItemProductBinding binding=LayoutItemProductBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(listProduct.get(position));
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        LayoutItemProductBinding binding;

        public MyViewHolder(@NonNull LayoutItemProductBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        void bindData(Product product){
            Glide.with(binding.imgProduct)
                    .load(product.getImage())
                    .into(binding.imgProduct);

            binding.tvProductName.setText(product.getName());
            binding.tvProductPrice.setText(String.valueOf(product.getPrice()));
        }
    }

}
