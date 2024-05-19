package com.example.buyphonesonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.buyphonesonline.databinding.ActivityProductDetailsBinding;

public class ProductDetailsActivity extends AppCompatActivity {
    ActivityProductDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityProductDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Intent intent=getIntent();
        String url=intent.getStringExtra("image");
        String name=intent.getStringExtra("name");
        double price=intent.getDoubleExtra("price",0);

        Glide.with(binding.imageMain).load(url).into(binding.imageMain);
        binding.tvName.setText(name);
        binding.tvPrice.setText(String.valueOf(price));
        binding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}