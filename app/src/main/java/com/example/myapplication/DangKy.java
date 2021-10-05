package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class DangKy extends AppCompatActivity {
    DBNguoiDung dbNguoiDung;
    EditText edttenTaiKhoan, edthoTen, edtemail, edtsdt, edtmatKhau;
    Button btnRegisterOfRegister, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_ky);
        mapping();
        dbNguoiDung = new DBNguoiDung(this);
        btnRegisterOfRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenTaiKhoan = edttenTaiKhoan.getText().toString();
                String hoTen = edthoTen.getText().toString();
                String email = edtemail.getText().toString();
                String sdt = edtsdt.getText().toString();
                String matKhau = edtmatKhau.getText().toString();
                if (dbNguoiDung.checkUser(tenTaiKhoan) == false) {
                    Users users = new Users(tenTaiKhoan, hoTen, email, sdt, matKhau);
                    dbNguoiDung.addUsers(users);
                    Toast.makeText(DangKy.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(DangKy.this, DangNhap.class);
                    startActivity(intent1);
                } else if (tenTaiKhoan.equals("") || hoTen.equals("")|| email.equals("")|| sdt.equals("") || matKhau.equals("")){
                    Toast.makeText(DangKy.this, "Điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else if (edtmatKhau.getText().length() < 5 ){
                    Toast.makeText(DangKy.this, "Mật khẩu phải lớn hơn 5 kí tự", Toast.LENGTH_SHORT).show();
                }else if (dbNguoiDung.checkUser(tenTaiKhoan) == true){
                    Toast.makeText(DangKy.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DangKy.this, DangNhap.class);
                startActivity(intent1);
            }
        });
    }

    public void mapping() {
        btnRegisterOfRegister = (Button) findViewById(R.id.btnRegisterOfRegister);
        edttenTaiKhoan = (EditText) findViewById(R.id.edttenTaiKhoan);
        edthoTen = (EditText) findViewById(R.id.edthoTen);
        edtemail = (EditText) findViewById(R.id.edtemail);
        edtsdt = (EditText) findViewById(R.id.edtsdt);
        edtmatKhau = (EditText) findViewById(R.id.edtmatKhau);
        btnBack = (Button) findViewById(R.id.btnBack);
    }
}
