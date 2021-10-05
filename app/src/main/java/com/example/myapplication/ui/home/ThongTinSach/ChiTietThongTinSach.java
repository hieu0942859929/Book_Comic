package com.example.myapplication.ui.home.ThongTinSach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.api.apilaysach.ApiLayChuongSach;
import com.example.myapplication.interfaces.laysach.LayChuongSachVe;
import com.example.myapplication.ui.home.DanhSachSach.Sach;
import com.example.myapplication.ui.home.docsach.DocSach;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ChiTietThongTinSach extends AppCompatActivity implements LayChuongSachVe {
    ImageView imgChiTietSach;
    Button btnDocSach;
    TextView tenSachChiTiet, maLoaiSachChiTiet, ngayPhatHanhChiTiet, tacGiaChiTiet, nguoiDichChiTiet, noiDungChiTiet;
    Sach sach;
    ListView lvChuongSach;
    ArrayList<ChuongSach> arrChuongSach;
    ChuongSachAdapter chuongSachAdaper;
    String maChuong;
    ChuongSach chuongSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_thong_tin_sach);
        anhxa();
        init();
        setUpChiTietThongTinSach();
        setClick();
        new ApiLayChuongSach(this, sach.getMaSach(), maChuong).execute();

    }

    private void setClick() {
        lvChuongSach.setOnItemClickListener((adapterView, view, i, id) -> {
            ChuongSach chuongSach = arrChuongSach.get(i);
            Bundle c = new Bundle();
            c.putString("maChuong", arrChuongSach.get(i).getMaChuong());
            c.putSerializable("maChuong", chuongSach);
            Intent intent = new Intent(ChiTietThongTinSach.this, DocSach.class);
            intent.putExtra("data1", c);
            startActivity(intent);
        });
    }

    public void anhxa() {
        imgChiTietSach = findViewById(R.id.imgChiTietSach);
        btnDocSach = findViewById(R.id.btnDocSach);
        tenSachChiTiet = findViewById(R.id.tenSachChiTiet);
        maLoaiSachChiTiet = findViewById(R.id.maLoaiSachChiTiet);
        ngayPhatHanhChiTiet = findViewById(R.id.ngayPhatHanhChiTiet);
        tacGiaChiTiet = findViewById(R.id.tacGiaChiTiet);
        nguoiDichChiTiet = findViewById(R.id.nguoiDichChiTiet);
        noiDungChiTiet = findViewById(R.id.noiDungChiTiet);
        lvChuongSach = findViewById(R.id.lvChuongSach);
    }

    public void init() {
        arrChuongSach = new ArrayList<>();
        Bundle b = getIntent().getBundleExtra("data");
        sach = (Sach) b.getSerializable("sach");
    }

    public void setUpChiTietThongTinSach() {
        tenSachChiTiet.setText(sach.getTenSach());
        ngayPhatHanhChiTiet.setText(sach.getNgayPhatHanh());
        tacGiaChiTiet.setText(sach.getTacGia());
        nguoiDichChiTiet.setText(sach.getNguoiDich());
        noiDungChiTiet.setText(sach.getNoiDung());
        maLoaiSachChiTiet.setText(sach.getMaLoaiSach());
        Glide.with(this).load(sach.getLinkAnh()).into(imgChiTietSach);
    }

    @Override
    public void BatDau() {
    }

    @Override
    public void KetThuc(String data) {
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                ChuongSach chuongSach = new ChuongSach(jsonArray.getJSONObject(i));
                arrChuongSach.add(chuongSach);
            }
            chuongSachAdaper = new ChuongSachAdapter(this, 0, arrChuongSach);
            lvChuongSach.setAdapter(chuongSachAdaper);
        } catch (JSONException e) {
        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(ChiTietThongTinSach.this, "Bị lỗi", Toast.LENGTH_SHORT).show();
    }


    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}