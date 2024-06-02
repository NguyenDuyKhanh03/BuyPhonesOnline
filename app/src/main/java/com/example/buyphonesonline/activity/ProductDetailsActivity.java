package com.example.buyphonesonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.buyphonesonline.GetData;
import com.example.buyphonesonline.callback.AddProductCallback;
import com.example.buyphonesonline.callback.ProductCallback;
import com.example.buyphonesonline.databinding.ActivityProductDetailsBinding;
import com.example.buyphonesonline.dtos.ProductDto;
import com.example.buyphonesonline.models.Images;
import com.example.buyphonesonline.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {
    ActivityProductDetailsBinding binding;
    List<Images> images1 =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityProductDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Intent intent=getIntent();
        Long id=intent.getLongExtra("id_product",1);
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
        getListImageByIdProduct(id);
        evenClickImage();
        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences userDetails=getSharedPreferences("userdetails", MODE_PRIVATE);
                String username = userDetails.getString("username", "khanh1");
                String url="http://192.168.2.34:8080/cart/add-product?username="+username+"&productId="+id+"&quantity=1";
                GetData getDatax=new GetData(url,ProductDetailsActivity.this);
                getDatax.addProductToCartOrReduce(new AddProductCallback() {
                    @Override
                    public void onSuccess(List<ProductDto> cartItems) {

                    }

                    @Override
                    public void onError(String error) {
                        Log.d("ADDPRODUCT",error);
                    }
                });
                Log.d("Ghi",String.valueOf(id));
            }
        });
    }
    private void getListImageByIdProduct(Long id){
        GetData getData=new GetData("http://192.168.2.34:8080/images/product/"+id,getApplicationContext());
        getData.getDataImageByProductId(new ProductCallback() {
            @Override
            public void onSuccess(List<Product> products) {

            }

            @Override
            public void onSuccess1(List<Images> images) {
                images1.addAll(images);
                setListImageToImageView(images1);
                Toast.makeText(ProductDetailsActivity.this,String.valueOf(images1.size()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
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
                if(images1.size()>0) {
                    Glide.with(binding.imageMain).load(images1.get(0).url()).into(binding.imageMain);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Null",Toast.LENGTH_LONG).show();
                }

            }
        });
        binding.frameImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(images1.size()>0) {
                    Glide.with(binding.imageMain).load(images1.get(1).url()).into(binding.imageMain);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Null",Toast.LENGTH_LONG).show();
                }

            }
        });
        binding.frameImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(images1.size()>0) {
                    Glide.with(binding.imageMain).load(images1.get(2).url()).into(binding.imageMain);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Null",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}