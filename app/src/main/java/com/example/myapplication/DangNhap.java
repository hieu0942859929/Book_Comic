package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangNhap extends AppCompatActivity {
    DBNguoiDung dbNguoiDung;
    EditText edtLogin, edtPass;
    Button btnLogin, btnForgotpass, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_nhap);
        dbNguoiDung = new DBNguoiDung(this);
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnForgotpass = (Button) findViewById(R.id.btnForgotpass);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DangNhap.this, DangKy.class);
                startActivity(intent1);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tentk = edtLogin.getText().toString();
                String matkhau = edtPass.getText().toString();
                if (tentk.equals("") && matkhau.equals("")) {
                    Toast.makeText(DangNhap.this, "Điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (tentk.equals("")) {
                    Toast.makeText(DangNhap.this, "Nhập tên tài khoản", Toast.LENGTH_SHORT).show();
                } else if (matkhau.equals("")) {
                    Toast.makeText(DangNhap.this, "Điền mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkUserandPass = dbNguoiDung.checkUserandPassword(tentk, matkhau);
                    Boolean checkAdmin = dbNguoiDung.checkAdmin(tentk);
                    if (checkUserandPass == true) {
                        Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(DangNhap.this, MainActivity.class);
                        startActivity(intent1);
                    } else {
                        Toast.makeText(DangNhap.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}