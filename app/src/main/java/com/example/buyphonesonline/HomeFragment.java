package com.example.buyphonesonline;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.buyphonesonline.activity.CartActivity;
import com.example.buyphonesonline.activity.SearchActivity;
import com.example.buyphonesonline.adapter.ProductListAdapter;
import com.example.buyphonesonline.adapter.VPAdapter;
import com.example.buyphonesonline.callback.ProductCallback;

import com.example.buyphonesonline.models.Category;
import com.example.buyphonesonline.models.Images;
import com.example.buyphonesonline.models.Product;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment{



    List<Integer> images=new ArrayList<>();
    ViewPager2 viewPager2;

    List<Product> products1=new ArrayList<>();
    ProductListAdapter adapter1;
    RecyclerView rvProduct1;

    RecyclerView rvProduct2;

    List<Product> products2=new ArrayList<>();

    ProductListAdapter adapter2;

    RecyclerView rvProduct3;

    List<Product> products3=new ArrayList<>();
    ProductListAdapter adapter3;

    RecyclerView rvProduct4;

    List<Product> products4=new ArrayList<>();
    ProductListAdapter adapter4;
    ImageView imgCart;

    SearchView searchView;

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

        imgCart=view.findViewById(R.id.imgCart);
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), CartActivity.class);
                v.getContext().startActivities(new Intent[]{intent});
            }
        });


        rvProduct1=view.findViewById(R.id.rvPhoneChargeCord);
        adapter1=new ProductListAdapter(products1);
        rvProduct1.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvProduct1.setAdapter(adapter1);
        rvProduct1.addItemDecoration(new HorizontalItemDecoration(50));

        GetData getData=new GetData("http://192.168.5.119:8080/products/category/1/6",view.getContext());
        getData.getDataProductByCategoryId(new ProductCallback() {
            @Override
            public void onSuccess(List<Product> products) {
                products1.addAll(products);
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onSuccess1(List<Images> products) {

            }

            @Override
            public void onError(String errorMessage) {

            }
        });




        rvProduct2=view.findViewById(R.id.rvCharger);
        adapter2=new ProductListAdapter(products2);
        rvProduct2.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvProduct2.setAdapter(adapter2);
        rvProduct2.addItemDecoration(new HorizontalItemDecoration(50));


        GetData getData2=new GetData("http://192.168.5.119:8080/products/category/2/6",view.getContext());
        getData2.getDataProductByCategoryId(new ProductCallback() {
            @Override
            public void onSuccess(List<Product> products) {
                products2.addAll(products);
                adapter2.notifyDataSetChanged();
            }
            @Override
            public void onSuccess1(List<Images> products) {

            }

            @Override
            public void onError(String errorMessage) {
                Log.d("Loia",errorMessage);
            }
        });

        // dien thoai
        rvProduct3=view.findViewById(R.id.rvTelephone);
        adapter3=new ProductListAdapter(products3);
        rvProduct3.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvProduct3.setAdapter(adapter3);
        rvProduct3.addItemDecoration(new HorizontalItemDecoration(50));


        GetData getData3=new GetData("http://1192.168.5.119:8080/products/category/3/6",view.getContext());
        getData3.getDataProductByCategoryId(new ProductCallback() {
            @Override
            public void onSuccess(List<Product> products) {
                products3.addAll(products);
                adapter3.notifyDataSetChanged();
            }
            @Override
            public void onSuccess1(List<Images> products) {

            }

            @Override
            public void onError(String errorMessage) {
                Log.d("Loia",errorMessage);
            }
        });
        //Ipad
        rvProduct4=view.findViewById(R.id.rvIpad);
        adapter4=new ProductListAdapter(products4);
        rvProduct4.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvProduct4.setAdapter(adapter4);
        rvProduct4.addItemDecoration(new HorizontalItemDecoration(50));

        GetData getData4=new GetData("http://192.168.5.119:8080/products/category/4/6",view.getContext());
        getData4.getDataProductByCategoryId(new ProductCallback() {
            @Override
            public void onSuccess(List<Product> products) {
                products4.addAll(products);
                adapter4.notifyDataSetChanged();
            }

            @Override
            public void onSuccess1(List<Images> products) {

            }
            @Override
            public void onError(String errorMessage) {
                Log.d("Loib",errorMessage);
            }
        });
        searchView=view.findViewById(R.id.search_home);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        images.add(R.drawable.galaxys20);
        images.add(R.drawable.oppoa92);
        images.add(R.drawable.redminot9);

        viewPager2=view.findViewById(R.id.viewPager);
        viewPager2.setAdapter(new VPAdapter(images));
    }


}