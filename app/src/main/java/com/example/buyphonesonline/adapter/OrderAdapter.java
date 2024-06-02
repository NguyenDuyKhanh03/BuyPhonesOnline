package com.example.buyphonesonline.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buyphonesonline.GetData;
import com.example.buyphonesonline.activity.ProductDetailsActivity;
import com.example.buyphonesonline.callback.AddProductCallback;
import com.example.buyphonesonline.callback.GetProductCallback;
import com.example.buyphonesonline.databinding.ItemProductHistoryBinding;
import com.example.buyphonesonline.databinding.ItemProductInCartBinding;
import com.example.buyphonesonline.dtos.ProductDto;
import com.example.buyphonesonline.models.Product;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder>{
    List<ProductDto> productDtos;

    public OrderAdapter(List<ProductDto> productDtos) {
        this.productDtos = productDtos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductHistoryBinding binding= ItemProductHistoryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
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

        ItemProductHistoryBinding binding;
        public MyViewHolder(@NonNull ItemProductHistoryBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
       }

        public void bindData(ProductDto product){
            Glide.with(binding.imgProduct).load(product.image()).into(binding.imgProduct);
            binding.tvName.setText(product.name());
            binding.tvQuantity.setText("x"+String.valueOf(product.quantity()));
            double total=product.price()*product.quantity();
            binding.tvPrice.setText(String.valueOf(total));

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GetData getData=new GetData("http://192.168.2.34:8080/products/findProductById/"+product.id(),v.getContext());
                    getData.getProductById(new GetProductCallback() {
                        @Override
                        public void onSuccess(Product product) {
                            Product product1 = new Product(product.id(),product.getImage(),product.getName(),product.getPrice(),product.description(),product.getQuantity(),product.getCategoryId());
                            Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                            intent.putExtra("id_product", product.id());
                            intent.putExtra("name", product.getName());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("image", product.getImage());
                            intent.putExtra("description", product.description());
                            Log.d("Chuyendi",product.description());
                            v.getContext().startActivity(intent);
                        }

                        @Override
                        public void onError(String errorMessage) {
                            Log.d("Chuyendi",errorMessage);
                        }
                    });
                }
            });
        }



    }
}
