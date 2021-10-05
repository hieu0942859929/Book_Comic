package com.example.myapplication.ui.home.docsach;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.api.apilaysach.ApiLayNoiDungSach;
import com.example.myapplication.interfaces.laysach.LayNoiDungSachVe;
import com.example.myapplication.ui.home.DanhSachSach.Sach;
import com.example.myapplication.ui.home.ThongTinSach.ChiTietThongTinSach;
import com.example.myapplication.ui.home.ThongTinSach.ChuongSach;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DocSach extends AppCompatActivity implements LayNoiDungSachVe {
    ImageView imgBackDocSach, imgNextDocSach;
    TextView tvTenChuongSach, tvNoiDungChuongSach;
    ChiTietThongTinSach chiTietThongTinSach;
    ArrayList<String> arrNoiDung;
    ChuongSach chuongSach;
    int soChuong, soChuongDangDoc;
    NoiDungSach noiDungSach;
    Sach sach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_sach);
        anhxa();
        init();
        new ApiLayNoiDungSach(this, chuongSach.getMaSach(), chuongSach.getMaChuong()).execute();
        setUp();
    }


    private void init() {
        arrNoiDung = new ArrayList<String>();
        Bundle c = getIntent().getBundleExtra("data1");
        chuongSach = (ChuongSach) c.getSerializable("maChuong");
    }

    private void anhxa() {
        tvTenChuongSach = findViewById(R.id.tvTenChuongSach);
        tvNoiDungChuongSach = findViewById(R.id.tvNoiDungChuongSach);
    }

    private void setUp() {
        tvTenChuongSach.setText(chuongSach.getTenChuong());
    }

    @Override
    public void BatDau() {

    }

    @Override
    public void KetThuc(String data) {
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonobject = jsonArray.getJSONObject(i);
                String noiDung = jsonobject.getString("noiDung");
                tvNoiDungChuongSach.setText(noiDung);
            }
        } catch (JSONException e) {
        }
    }

    @Override
    public void biLoi() {
    }

    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}