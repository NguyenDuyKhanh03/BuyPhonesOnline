package com.example.buyphonesonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buyphonesonline.databinding.ActivityRegisterBinding;
import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.User;
import com.example.buyphonesonline.repository.RoleRepository;
import com.example.buyphonesonline.repository.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private DatabaseHandler databaseHandler;
    private UserRepository userRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        databaseHandler=DatabaseHandler.newInstance(getApplicationContext());
        userRepository=new UserRepository(databaseHandler);
//        RoleRepository repository=new RoleRepository(databaseHandler);
//        repository.addRole("USER");
        binding.btnDkdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(
                        binding.edtUsername.getText().toString().isEmpty() ||
                        binding.edtEmail.getText().toString().isEmpty() ||
                        binding.edtPassword.getText().toString().isEmpty()
                ){
                    Toast.makeText(RegisterActivity.this,"Vui lòng nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else{
                    User user=new User(binding.edtUsername.getText().toString(),binding.edtEmail.getText().toString(),binding.edtPassword.getText().toString());
                    long result= userRepository.RegisterUser(user);
                    if(result==-1)
                        Toast.makeText(RegisterActivity.this,"Đăng kí không thành công",Toast.LENGTH_SHORT).show();
                    else{
                        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}