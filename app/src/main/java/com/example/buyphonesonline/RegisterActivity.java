package com.example.buyphonesonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private Button btnDangKy1;
    private EditText etTaiKhoan, etEmail, etMatKhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etTaiKhoan = findViewById(R.id.dktaikhoan);
        etEmail = findViewById(R.id.dkemail);
        etMatKhau = findViewById(R.id.dkmatkhau);
        btnDangKy1 = findViewById(R.id.btn_dkdangky);
        btnDangKy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin từ các EditText
                String fullName = etTaiKhoan.getText().toString();
                String email = etEmail.getText().toString();
                String password = etMatKhau.getText().toString();

                // Xử lý đăng ký tại đây
                // ...

                // Sau khi đăng ký thành công, quay lại trang đăng nhập
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Kết thúc RegisterActivity để không thể quay lại bằng nút Back
            }

        });
    }
}