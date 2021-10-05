package com.example.myapplication.ui.gallery.DocTruyen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.api.apilaytruyen.ApiLayNoiDungTruyen;
import com.example.myapplication.interfaces.laytruyen.LayNoiDungTruyenVe;
import com.example.myapplication.ui.gallery.DanhSachTruyen.Truyen;
import com.example.myapplication.ui.gallery.ThongTinTruyen.ChapTruyen;
import com.example.myapplication.ui.gallery.ThongTinTruyen.ChiTietThongTinTruyen;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class DocTruyen extends AppCompatActivity implements LayNoiDungTruyenVe {
    ImageView imgBackDocTruyen, imgNextDocTruyen, imgLinkAnh;
    TextView tvTenChapTruyen;
    ArrayList<String> noiDungTruyenArrayList;
    ChapTruyen chapTruyen;
    int soTrang, soTrangDangDoc;
    Truyen truyen;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_truyen);
        anhxa();
        init();
        setUp();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        new ApiLayNoiDungTruyen(this, chapTruyen.getMaTruyen(), chapTruyen.getMaChap()).execute();

    }

    private void init() {
//        noiDungTruyenArrayList = new ArrayList<>();
        Bundle c = getIntent().getBundleExtra("data1");
        chapTruyen = (ChapTruyen) c.getSerializable("maChap");

    }

    private void anhxa() {
        imgBackDocTruyen = findViewById(R.id.imgBackDocTruyen);
        imgNextDocTruyen = findViewById(R.id.imgNextDocTruyen);
        tvTenChapTruyen = findViewById(R.id.tvTenChapTruyen);
        imgLinkAnh = findViewById(R.id.imgLinkAnh);
    }

    private void setUp() {
        tvTenChapTruyen.setText(chapTruyen.getTenChap());
    }

    private void docTheoTrang(int i) {
        soTrangDangDoc = soTrangDangDoc + i;
        if (soTrangDangDoc == 0) {
            soTrangDangDoc = 1;
        }
        if (soTrangDangDoc > soTrang) {
            soTrangDangDoc = soTrang;
        }
        Glide.with(this)
                .load(noiDungTruyenArrayList.get(soTrangDangDoc - 1))
                .into(imgLinkAnh);
    }

    @Override
    public void BatDau() {

    }

    @Override
    public void KetThuc(String data) {
        noiDungTruyenArrayList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                noiDungTruyenArrayList.add(jsonArray.getString(i));
            }
            soTrangDangDoc = 1;
            soTrang = noiDungTruyenArrayList.size();
            docTheoTrang(0);
        } catch (JSONException e) {
        }
    }

    @Override
    public void biLoi() {

    }

    public void right(View view) {
        docTheoTrang(1);
    }

    public void left(View view) {
        docTheoTrang(-1);
    }

    public void back(View view){
        onBackPressed();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
