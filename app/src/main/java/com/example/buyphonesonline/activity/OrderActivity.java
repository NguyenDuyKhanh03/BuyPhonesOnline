package com.example.buyphonesonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.buyphonesonline.GetData;
import com.example.buyphonesonline.R;
import com.example.buyphonesonline.callback.OrderCallback;
import com.example.buyphonesonline.databinding.ActivityOrderBinding;
import com.example.buyphonesonline.models.Order;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        SharedPreferences userDetails =getSharedPreferences("userdetails", MODE_PRIVATE);
        String name= userDetails.getString("username","khanh");

        GetData getData=new GetData(OrderActivity.this);
        getData.setUrl("http://192.168.2.34:8080/orders/get-order-detail?username="+name);
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


    }
}