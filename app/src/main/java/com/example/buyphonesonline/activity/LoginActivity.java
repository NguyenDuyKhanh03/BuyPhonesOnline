package com.example.buyphonesonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.buyphonesonline.GetData;
import com.example.buyphonesonline.R;
import com.example.buyphonesonline.callback.LoginCallback;
import com.example.buyphonesonline.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private Button btnDangKy;
    private ActivityLoginBinding binding;

    private SharedPreferences userDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        btnDangKy = findViewById(R.id.btn_dangky);

        userDetails = getSharedPreferences("userdetails", MODE_PRIVATE);
        if(userDetails.getBoolean("isLoggedIn",false)) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        binding.btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int[] rs = {-1};
                GetData getData=new GetData("",LoginActivity.this);
                getData.login(binding.edtUsername.getText().toString(), binding.edtPassword.getText().toString(), new LoginCallback() {
                    @Override
                    public void onSuccess(int status) {
                        rs[0] = status;
                        if(rs[0] == -1) {
                            Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            SharedPreferences.Editor edit = userDetails.edit();
                            edit.putString("username", binding.edtUsername.getText().toString());
                            edit.putBoolean("isLoggedIn", true);
                            edit.apply();
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onError(String errorMessage) {
                        Log.d("Loi111", errorMessage);
                    }
                });
            }
        });
    }
}