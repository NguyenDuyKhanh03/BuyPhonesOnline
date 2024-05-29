package com.example.buyphonesonline.adapter;


import android.content.Intent;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buyphonesonline.ProductDetailsActivity;
import com.example.buyphonesonline.databinding.LayoutItemProductBinding;
import com.example.buyphonesonline.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> implements Filterable {

    List<Product> listProduct;
    private List<Product> productListFiltered;

    public ProductListAdapter(List<Product> listProduct) {
        this.listProduct = listProduct;
        this.productListFiltered=listProduct;
    }

    public void setFilteredList(List<Product> filteredList) {
        this.listProduct = filteredList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutItemProductBinding binding=LayoutItemProductBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(productListFiltered.get(position));
    }

    @Override
    public int getItemCount() {
        return productListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString=constraint.toString();
                if(charString.isEmpty()){
                    productListFiltered=listProduct;
                }else{
                    List<Product> filteredList=new ArrayList<>();
                    for (Product p: listProduct) {
                        if(p.getName().toLowerCase().contains(charString.toLowerCase())||
                                p.description().toLowerCase().contains(charString.toLowerCase())||
                                String.valueOf(p.getPrice()).equals(charString)
                        ){
                            filteredList.add(p);
                        }
                    }
                    productListFiltered=filteredList;
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=productListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                productListFiltered= (ArrayList<Product>) results.values;
                notifyDataSetChanged();
            }
        };
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
                    intent.putExtra("id_product",product.getId());
                    intent.putExtra("name",product.getName());
                    intent.putExtra("price",product.getPrice());
                    intent.putExtra("image",product.getImage());
                    intent.putExtra("description",product.description());
                    v.getContext().startActivities(new Intent[]{intent});
                }
            });


        }
    }

}
