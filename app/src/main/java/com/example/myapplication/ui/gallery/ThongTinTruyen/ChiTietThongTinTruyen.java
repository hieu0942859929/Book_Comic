package com.example.myapplication.ui.gallery.ThongTinTruyen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.api.apilaytruyen.ApiLayChap;
import com.example.myapplication.interfaces.laytruyen.LayChapVe;
import com.example.myapplication.ui.gallery.DanhSachTruyen.Truyen;
import com.example.myapplication.ui.gallery.DocTruyen.DocTruyen;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ChiTietThongTinTruyen extends AppCompatActivity implements LayChapVe {
    ImageView imgChiTietTruyen;
    Button btnDocTruyen;
    TextView tenTruyenChiTiet, maLoaiTruyenChiTiet, ngayPhatHanhChiTiet, tacGiaChiTiet, nguoiDichChiTiet, noiDungChiTiet;
    Truyen truyen;
    ListView lvChapTruyen;
    ArrayList<ChapTruyen> arrChapTruyen;
    ChapTruyenAdapter chapTruyenAdapter;
    String maChap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_thong_tin_truyen);
        anhxa();
        init();
        setUpChiTietThongTinTruyen();
        setClick();
        new ApiLayChap(this, truyen.getMaTruyen(), maChap).execute();

    }

    private void setClick() {
        lvChapTruyen.setOnItemClickListener((adapterView, view, i, id) -> {
            ChapTruyen chapTruyen = arrChapTruyen.get(i);
            Bundle c = new Bundle();
            c.putString("maChap", arrChapTruyen.get(i).getMaChap());
            c.putSerializable("maChap", chapTruyen);
            Intent intent = new Intent(ChiTietThongTinTruyen.this, DocTruyen.class);
            intent.putExtra("data1", c);
            startActivityForResult(intent, 1);
        });
    }

    public void anhxa() {
        imgChiTietTruyen = findViewById(R.id.imgChiTietTruyen);
        btnDocTruyen = findViewById(R.id.btnDocTruyen);
        tenTruyenChiTiet = findViewById(R.id.tenTruyenChiTiet);
        maLoaiTruyenChiTiet = findViewById(R.id.maLoaiTruyenChiTiet);
        ngayPhatHanhChiTiet = findViewById(R.id.ngayPhatHanhChiTiet);
        tacGiaChiTiet = findViewById(R.id.tacGiaChiTiet);
        nguoiDichChiTiet = findViewById(R.id.nguoiDichChiTiet);
        noiDungChiTiet = findViewById(R.id.noiDungChiTiet);
        lvChapTruyen = findViewById(R.id.lvChapTruyen);
    }

    public void init() {
        arrChapTruyen = new ArrayList<>();
        Bundle b = getIntent().getBundleExtra("data");
        truyen = (Truyen) b.getSerializable("truyen");
    }

    public void setUpChiTietThongTinTruyen() {
        tenTruyenChiTiet.setText(truyen.getTenTruyen());
        ngayPhatHanhChiTiet.setText(truyen.getNgayPhatHanh());
        tacGiaChiTiet.setText(truyen.getTacGia());
        nguoiDichChiTiet.setText(truyen.getNguoiDich());
        noiDungChiTiet.setText(truyen.getNoiDung());
        maLoaiTruyenChiTiet.setText(truyen.getMaLoaiTruyen());
        Glide.with(this).load(truyen.getLinkAnh()).into(imgChiTietTruyen);
    }

    @Override
    public void BatDau() {
    }

    @Override
    public void KetThuc(String data) {
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                ChapTruyen chapTruyen = new ChapTruyen(jsonArray.getJSONObject(i));
                arrChapTruyen.add(chapTruyen);
            }
            chapTruyenAdapter = new ChapTruyenAdapter(this, 0, arrChapTruyen);
            lvChapTruyen.setAdapter(chapTruyenAdapter);
        } catch (JSONException e) {
        }
    }


    @Override
    public void biLoi() {
        Toast.makeText(ChiTietThongTinTruyen.this, "Bị lỗi", Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {
       onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
