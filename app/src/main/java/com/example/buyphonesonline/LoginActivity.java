package com.example.buyphonesonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.buyphonesonline.databinding.ActivityLoginBinding;
import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.User;
import com.example.buyphonesonline.repository.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private Button btnDangKy;
    private ActivityLoginBinding binding;
    private UserRepository userRepository;
    private DatabaseHandler databaseHandler;
    private SharedPreferences userDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        databaseHandler=DatabaseHandler.newInstance(getApplicationContext());
        userRepository=new UserRepository(databaseHandler);
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
                int result= userRepository.LoginUser(binding.edtUsername.getText().toString(),binding.edtPassword.getText().toString());
                if(result==-1){
                    Toast.makeText(LoginActivity.this,"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    SharedPreferences.Editor edit = userDetails.edit();
                    edit.putString("username", binding.edtUsername.getText().toString());
                    edit.putInt("role", result);
                    edit.putBoolean("isLoggedIn", true);
                    edit.apply();
                    startActivity(intent);
                }
            }
        });
    }
}