package com.example.buyphonesonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.buyphonesonline.GetData;
import com.example.buyphonesonline.callback.RegisterCallback;

import com.example.buyphonesonline.databinding.ActivityRegisterBinding;
import com.example.buyphonesonline.models.User;


public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());



        binding.btnDkdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(
                        binding.edtUsername.getText().toString().isEmpty() ||
                        binding.edtEmail.getText().toString().isEmpty() ||
                        binding.edtPassword.getText().toString().isEmpty()||
                        binding.edtAddress.getText().toString().isEmpty()||
                        binding.edtPhoneNumber.getText().toString().isEmpty()
                ){
                    Toast.makeText(RegisterActivity.this,"Vui lòng nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else{
                    User user=new User(
                            binding.edtUsername.getText().toString(),
                            binding.edtEmail.getText().toString(),
                            binding.edtPassword.getText().toString(),
                            binding.edtAddress.getText().toString(),
                            binding.edtPhoneNumber.getText().toString(),
                            1);
                    GetData getData=new GetData("http://192.168.5.119:8080/user/register",RegisterActivity.this);
                    getData.registerUser(user, new RegisterCallback() {
                        @Override
                        public void onSuccess(String response) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onError(String errorMessage) {
                            Log.d("MET",errorMessage);
                            Toast.makeText(RegisterActivity.this, "Đăng ký thất bại: " + errorMessage, Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });
    }
}