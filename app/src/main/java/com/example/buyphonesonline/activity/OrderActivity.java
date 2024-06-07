package com.example.buyphonesonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.buyphonesonline.GetData;
import com.example.buyphonesonline.VerticalItemDecoration;
import com.example.buyphonesonline.adapter.OrderAdapter;
import com.example.buyphonesonline.callback.AddProductCallback;
import com.example.buyphonesonline.callback.OrderCallback;
import com.example.buyphonesonline.databinding.ActivityOrderBinding;
import com.example.buyphonesonline.dtos.ProductDto;
import com.example.buyphonesonline.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;

    List<ProductDto> productDtos=new ArrayList<>();
    OrderAdapter orderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        SharedPreferences userDetails =getSharedPreferences("userdetails", MODE_PRIVATE);
        String name= userDetails.getString("username","khanh");

        GetData getData=new GetData(OrderActivity.this);
        getData.setUrl("http://192.168.2.34:8080/orders/get-order?username="+name);
        final Order[] order1 = {new Order()};
        getData.getDataOrder(new OrderCallback() {
            @Override
            public void onSuccess(Order order) {
                order1[0] =order;
                Log.d("OK","OK");
                if(order1[0]!=null){
                    binding.tvDate.setText(order1[0].orderDate());
                    binding.tvTotal.setText(String.valueOf(order1[0].totalAmount()));
                    binding.tvId.setText("#"+String.valueOf(order1[0].id()));
                }
            }

            @Override
            public void onError(String errorMessage) {

            }
        });

        orderAdapter=new OrderAdapter(productDtos);
        binding.rvOrderDetails.setLayoutManager(new LinearLayoutManager(this));
        binding.rvOrderDetails.setAdapter(orderAdapter);
        binding.rvOrderDetails.addItemDecoration(new VerticalItemDecoration(40));
        binding.tvDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData.setUrl("http://192.168.2.34:8080/orders/get-order-detail?username="+name);
                getData.getCartItemToCart(new AddProductCallback() {
                    @Override
                    public void onSuccess(List<ProductDto> cartItems) {
                        productDtos.clear();
                        productDtos.addAll(cartItems);
                        orderAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(String error) {

                    }
                });
            }
        });

        binding.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}