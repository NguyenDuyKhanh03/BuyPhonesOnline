package com.example.buyphonesonline.adapter;


import android.content.Intent;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buyphonesonline.ProductDetailsActivity;
import com.example.buyphonesonline.databinding.LayoutItemProductBinding;
import com.example.buyphonesonline.models.Product;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    List<Product> listProduct;

    public ProductListAdapter(List<Product> listProduct) {
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

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(), ProductDetailsActivity.class);
                    intent.putExtra("name",product.getName());
                    intent.putExtra("price",product.getPrice());
                    intent.putExtra("image",product.getImage());
                    v.getContext().startActivities(new Intent[]{intent});
                }
            });


        }
    }

}
