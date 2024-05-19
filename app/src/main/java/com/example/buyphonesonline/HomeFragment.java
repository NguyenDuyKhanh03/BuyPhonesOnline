package com.example.buyphonesonline;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buyphonesonline.adapter.ProductListAdapter;
import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.Product;
import com.example.buyphonesonline.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    List<Product> products=new ArrayList<>();
    ProductListAdapter adapter;
    RecyclerView rvProduct;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DatabaseHandler databaseHandler=new DatabaseHandler(view.getContext());
        ProductRepository productRepository=new ProductRepository(databaseHandler);
        products=productRepository.getAllProducts();

        rvProduct=view.findViewById(R.id.rvPhoneChargeCord);
        adapter=new ProductListAdapter(products);
        rvProduct.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvProduct.setAdapter(adapter);
        rvProduct.addItemDecoration(new HorizontalItemDecoration(50));


    }
}