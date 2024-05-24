package com.example.buyphonesonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.buyphonesonline.databinding.ActivityProductDetailsBinding;
import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.Images;
import com.example.buyphonesonline.repository.CartRepository;
import com.example.buyphonesonline.repository.ImagesRepository;
import com.example.buyphonesonline.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {
    ActivityProductDetailsBinding binding;
    List<Images> images=new ArrayList<>();
    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityProductDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Intent intent=getIntent();
        int id=intent.getIntExtra("id_product",2);
        String url=intent.getStringExtra("image");
        String name=intent.getStringExtra("name");
        double price=intent.getDoubleExtra("price",0);
        String des=intent.getStringExtra("description");
        Glide.with(binding.imageMain).load(url).into(binding.imageMain);
        binding.tvName.setText(name);
        binding.tvPrice.setText(String.valueOf(price));
        binding.tvDescription.setText(des);
        binding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        databaseHandler=new DatabaseHandler(ProductDetailsActivity.this);
        getListImageByIdProduct(databaseHandler,id);
        setListImageToImageView(images);
        evenClickImage();
        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductRepository productRepository=new ProductRepository(databaseHandler);
                CartRepository cartRepository=new CartRepository(databaseHandler,productRepository);
                cartRepository.addProduct(id,"Khanh",1);
            }
        });
    }
    private void getListImageByIdProduct(DatabaseHandler databaseHandler,int id){
        ImagesRepository imagesRepository=new ImagesRepository(databaseHandler);
        images=imagesRepository.getAllImages(id);
    }

    private void setListImageToImageView(List<Images> images){
        Glide.with(this)
                .load(images.get(0).url())
                .into(binding.image1);

        Glide.with(this)
                .load(images.get(1).url())
                .into(binding.image2);

        Glide.with(this)
                .load(images.get(2).url())
                .into(binding.image3);
    }

    private void evenClickImage(){
        binding.frameImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(images.get(0)!=null) {
                    Glide.with(binding.imageMain).load(images.get(0).url()).into(binding.imageMain);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Null",Toast.LENGTH_LONG).show();
                }

            }
        });
        binding.frameImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(images.get(1)!=null) {
                    Glide.with(binding.imageMain).load(images.get(1).url()).into(binding.imageMain);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Null",Toast.LENGTH_LONG).show();
                }

            }
        });
        binding.frameImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(images.get(2)!=null) {
                    Glide.with(binding.imageMain).load(images.get(2).url()).into(binding.imageMain);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Null",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}