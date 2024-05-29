package com.example.buyphonesonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.buyphonesonline.adapter.ProductListAdapter;
import com.example.buyphonesonline.databinding.ActivitySearchBinding;
import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.Product;
import com.example.buyphonesonline.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    ActivitySearchBinding binding;
    DatabaseHandler databaseHandler;
    ProductRepository productRepository;
    ProductListAdapter adapter;
    private List<Product> products=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySearchBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        databaseHandler=DatabaseHandler.newInstance(getApplicationContext());
        productRepository=new ProductRepository(databaseHandler);
        adapter=new ProductListAdapter(products);
        binding.lvProduct.addItemDecoration(new CharacterItemDecoration(50));
        binding.lvProduct.setLayoutManager(new GridLayoutManager(SearchActivity.this,2));
        binding.lvProduct.setAdapter(adapter);
        binding.searchHome.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });

    }
    private void filterList(String text) {
        List<Product> filteredList = new ArrayList<>();
        if(!text.equals("")){
            filteredList= productRepository.getListProductByTitle(text);
        }
        if(!filteredList.isEmpty()){
            adapter.setFilteredList(filteredList);
        }
    }
}