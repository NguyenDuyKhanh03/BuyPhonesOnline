package com.example.buyphonesonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.buyphonesonline.GetData;
import com.example.buyphonesonline.R;
import com.example.buyphonesonline.callback.UserCallBack;
import com.example.buyphonesonline.databinding.ActivityEditProfileBinding;
import com.example.buyphonesonline.models.User;

public class EditProfileActivity extends AppCompatActivity {
    ActivityEditProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityEditProfileBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        SharedPreferences userDetails=getSharedPreferences("userdetails", MODE_PRIVATE);
        String username = userDetails.getString("username", "khanh1");
        GetData getData1=new GetData("http://192.168.2.34:8080/user/get/"+username,EditProfileActivity.this);
        final User[] user1 = {new User()};
        getData1.getUser(username, new UserCallBack() {
            @Override
            public void onSuccess(User user) {
                user1[0] =user;
                binding.edtAddress.setText(user1[0].address());
                binding.edtEmail.setText(user1[0].email());
                binding.edtPhoneNumber.setText(user1[0].numberPhone());
            }

            @Override
            public void onError(String errorMessage) {

            }
        });


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.button.getText().toString().toLowerCase().equals("sửa thông tin")) {
                    binding.edtEmail.setEnabled(true);
                    binding.edtPhoneNumber.setEnabled(true);
                    binding.edtAddress.setEnabled(true);
                    binding.button.setText("Cập nhật thông tin");
                    Log.d("UPDATEA", "OK");
                } else if (binding.button.getText().toString().toLowerCase().equals("cập nhật thông tin")) {
                    User user = new User(username, binding.edtPhoneNumber.getText().toString(), binding.edtEmail.getText().toString(), binding.edtAddress.getText().toString());
                    GetData getData = new GetData("http://192.168.2.34:8080/user/update/" + username, EditProfileActivity.this);
                    getData.updateUser(username, user);
                }
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