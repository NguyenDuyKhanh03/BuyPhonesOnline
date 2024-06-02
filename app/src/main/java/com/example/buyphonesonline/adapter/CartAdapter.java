package com.example.buyphonesonline.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buyphonesonline.GetData;
import com.example.buyphonesonline.OnQuantityChangeListener;
import com.example.buyphonesonline.callback.AddProductCallback;
import com.example.buyphonesonline.databinding.ItemProductInCartBinding;
import com.example.buyphonesonline.dtos.ProductDto;


import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    List<ProductDto> productDtos;
    private final OnQuantityChangeListener quantityChangeListener;

    public CartAdapter(List<ProductDto> productDtos,OnQuantityChangeListener quantityChangeListener) {
        this.productDtos = productDtos;
        this.quantityChangeListener = quantityChangeListener;
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
            binding.tvIncrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){
                        productDtos.get(pos).increaseQuantity();
                        notifyItemChanged(pos);
                        binding.tvQuantity.setText(String.valueOf(productDtos.get(pos).quantity()));
                        quantityChangeListener.onQuantityChanged();
                        SharedPreferences userDetails=v.getContext().getSharedPreferences("userdetails", MODE_PRIVATE);
                        String username = userDetails.getString("username", "khanh1");
                        String url="http://192.168.2.34:8080/cart/add-product?username="+username+"&productId="+productDtos.get(pos).id()+"&quantity=1";
                        GetData getDatax=new GetData(url, v.getContext());
                        getDatax.addProductToCartOrReduce(new AddProductCallback() {
                            @Override
                            public void onSuccess(List<ProductDto> cartItems) {

                            }

                            @Override
                            public void onError(String error) {
                                Log.d("ADDPRODUCT",error);
                            }
                        });
                    }
                }
            });
            binding.tvReduce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        Long productId=productDtos.get(position).id();
                        Log.d("Ghi",String.valueOf(productId));
                        productDtos.get(position).decreaseQuantity();
                        notifyItemChanged(position);
                        binding.tvQuantity.setText(String.valueOf(productDtos.get(position).quantity()));


                        if(productDtos.get(position).quantity()<=0)
                            productDtos.remove(productDtos.get(position));
                        notifyDataSetChanged();
                        quantityChangeListener.onQuantityChanged();

                        SharedPreferences userDetails=v.getContext().getSharedPreferences("userdetails", MODE_PRIVATE);
                        String username = userDetails.getString("username", "khanh1");
                        String url="http://192.168.2.34:8080/cart/update-product?username="+username+"&productId="+productId+"&quantity=1";
                        GetData getDatax=new GetData(url, v.getContext());
                        getDatax.addProductToCartOrReduce(new AddProductCallback() {
                            @Override
                            public void onSuccess(List<ProductDto> cartItems) {

                            }

                            @Override
                            public void onError(String error) {

                            }
                        });
                    }
                }
            });

        }

        public void bindData(ProductDto product){
            Glide.with(binding.imgProduct).load(product.image()).into(binding.imgProduct);
            binding.tvName.setText(product.name());
            binding.tvQuantity.setText(String.valueOf(product.quantity()));
            binding.tvPrice.setText(String.valueOf(product.price()));

        }
        private long getTotalPrice(List<ProductDto> productDtos){
            long total=0;
            for (ProductDto i:
                    productDtos) {
                total+=i.price()*i.quantity();
            }
            return total;

        }

    }
}
