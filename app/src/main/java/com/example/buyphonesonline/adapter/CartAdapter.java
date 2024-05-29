package com.example.buyphonesonline.adapter;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buyphonesonline.CartActivity;
import com.example.buyphonesonline.OnQuantityChangeListener;
import com.example.buyphonesonline.databinding.ItemProductInCartBinding;
import com.example.buyphonesonline.dtos.ProductDto;
import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.repository.CartRepository;
import com.example.buyphonesonline.repository.ProductRepository;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    List<ProductDto> productDtos;
    private final CartRepository cartRepository;
    private final OnQuantityChangeListener quantityChangeListener;

    public CartAdapter(List<ProductDto> productDtos, DatabaseHandler databaseHandler,OnQuantityChangeListener quantityChangeListener) {
        this.productDtos = productDtos;
        ProductRepository productRepository=new ProductRepository(databaseHandler);
        this.cartRepository=new CartRepository(databaseHandler,productRepository);
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
                        cartRepository.updateCartItemQuantity(productDtos.get(pos).id(),productDtos.get(pos).quantity());
                        cartRepository.updateCart("Khanh",getTotalPrice(productDtos));
                        quantityChangeListener.onQuantityChanged();
                    }
                }
            });
            binding.tvReduce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        productDtos.get(position).decreaseQuantity();
                        notifyItemChanged(position);
                        binding.tvQuantity.setText(String.valueOf(productDtos.get(position).quantity()));
                        cartRepository.updateCartItemQuantity(productDtos.get(position).id(),productDtos.get(position).quantity());
                        cartRepository.updateCart("Khanh",getTotalPrice(productDtos));
                        quantityChangeListener.onQuantityChanged();
                        if(productDtos.get(position).quantity()<=0){
                            new AlertDialog.Builder(v.getContext())
                                    .setTitle("Bạn có chắc không?")
                                    .setMessage("Bạn muốn xóa sản phẩm này khỏi giỏ hàng!")
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            int productId = productDtos.get(position).id();
                                            productDtos.remove(position);
                                            notifyDataSetChanged();
                                            int result=cartRepository.deleteProduct(productId);
                                            if(result==0)
                                                Toast.makeText(v.getContext(), "Không tìm thấy sản phẩm hoặc lỗi!", Toast.LENGTH_SHORT).show();
                                            else{
                                                Toast.makeText(v.getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                    })
                                    .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                        }
                                    })
                                    .show();
                        }
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
