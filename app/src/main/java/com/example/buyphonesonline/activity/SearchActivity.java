package com.example.buyphonesonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import com.example.buyphonesonline.CharacterItemDecoration;
import com.example.buyphonesonline.GetData;
import com.example.buyphonesonline.adapter.ProductListAdapter;
import com.example.buyphonesonline.callback.ProductCallback;
import com.example.buyphonesonline.databinding.ActivitySearchBinding;

import com.example.buyphonesonline.models.Images;
import com.example.buyphonesonline.models.Product;


import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    ActivitySearchBinding binding;

    ProductListAdapter adapter;
    private List<Product> productss=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySearchBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());





        adapter=new ProductListAdapter(productss);
        binding.lvProduct.addItemDecoration(new CharacterItemDecoration(50));
        binding.lvProduct.setLayoutManager(new GridLayoutManager(SearchActivity.this,2));
        binding.lvProduct.setAdapter(adapter);

        GetData getData=new GetData("http://192.168.2.34:8080/products/get-all",SearchActivity.this);
        getData.getDataAllProduct(new ProductCallback() {
            @Override
            public void onSuccess(List<Product> products) {
                productss.addAll(products);
                adapter.notifyDataSetChanged();
                Log.d("ProductListSize", "Size of productDtos: " + productss.size());

            }

            @Override
            public void onSuccess1(List<Images> images) {

            }

            @Override
            public void onError(String errorMessage) {

            }
        });

        binding.searchHome.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                filterList(newText);
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getFilter().filter("1");
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getFilter().filter("2");
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getFilter().filter("3");
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getFilter().filter("4");
            }
        });
        binding.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
//    private void filterList(String text) {
//        List<Product> filteredList = new ArrayList<>();
//        if(!text.equals("")){
//            filteredList= productRepository.getListProductByTitle(text);
//        }
//        if(!filteredList.isEmpty()){
//            adapter.setFilteredList(filteredList);
//        }
//    }
}