package com.example.myapplication.ui.home.DanhSachSach;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.DiaLogSach;
import com.example.myapplication.R;
import com.example.myapplication.api.apilaysach.ApiLaySach;
import com.example.myapplication.interfaces.laysach.LaySachVe;
import com.example.myapplication.ui.home.ThongTinSach.ChiTietThongTinSach;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DanhSachSach extends Fragment implements LaySachVe {
    GridView gvDanhSachSach;
    SachAdapter sachAdapter;
    ArrayList<Sach> sachArrayList;
    ImageButton sapXep, btnSearch,btnRefresh;
    private DiaLogSach diaLogSach;
    EditText edtTimKiem;
    public List<Sach> sachs = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        gvDanhSachSach = (GridView) root.findViewById(R.id.gvDanhSachSach);
        edtTimKiem = root.findViewById(R.id.edtTimKiem);
        anhxa();
        init();
        sapXep = root.findViewById(R.id.sapXep);
        btnSearch = root.findViewById(R.id.btnSearch);
        sapXep.setOnClickListener(v -> {
            diaLogSach = new DiaLogSach();
            diaLogSach.show(getChildFragmentManager(), "DiaLogSach");
            ;
//            sachAdapter.clear();
//            sachArrayList.clear();
//            new ApiLaySach(this).execute();
//            sachAdapter = new SachAdapter(getActivity(), 0, sachArrayList);
        });
        btnSearch.setOnClickListener(v -> {
            new ApiLaySach(this).execute();
        });
        setUp();
        setClick();
        new ApiLaySach(this).execute();
        return root;
    }

    private void init() {
        sachArrayList = new ArrayList<>();
        sachAdapter = new SachAdapter(getActivity(), 0, sachArrayList);
//        diaLogSach = new DiaLogSach();
        new ApiLaySach(this).execute();
    }

    public void anhxa() {

    }

    public void onStart() {

        super.onStart();

    }
    private void setUp() {
        gvDanhSachSach.setAdapter(sachAdapter);
    }

    @Override
    public void BatDau() {
        sachAdapter = new SachAdapter(getActivity(), 0, sachArrayList);
    }

    @Override
    public void KetThuc(String data) {
        try {
            sachArrayList.clear();
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                sachArrayList.add(new Sach(o));
            }

//            List condition = diaLogSach.arrayList;
//
//
//            if (condition.size() > 0) {
//                sachs = new ArrayList<>();
//                for (Sach sach : sachArrayList) {
//                    for (Object i : condition) {
//                        if (sach.getMaLoaiSach().equals(String.valueOf(i))) {
//                            sachs.add(sach);
//                            break;
//                        }
//                    }
//                }
//            }
//            if (edtTimKiem.getText().length() > 0) {
//                if (sachs == null) {
//                    sachs = new ArrayList<>();
//                    for (Sach sach : sachArrayList) {
//                        if (sach.getTenSach().contains(edtTimKiem.getText().toString())) {
//                            sachs.add(sach);
//                            break;
//                        }
//                    }
//                } else {
//                    for (Sach sach : sachs) {
//                        if (!sach.getTenSach().contains(edtTimKiem.getText().toString())) {
//                            sachs.remove(sach);
//                            Toast.makeText(getActivity(), "Không tìm thấy sách", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                    }
//                }
//            }
//            if (condition.size() > 0 || edtTimKiem.getText().length() > 0) {
//                sachAdapter = new SachAdapter(getActivity(), 0, sachs);
//            } else {
//                BatDau();
//            }
            sachAdapter = new SachAdapter(getActivity(), 0, sachArrayList);
            gvDanhSachSach.setAdapter(sachAdapter);
        } catch (JSONException e) {
        }
    }

    @Override
    public void biLoi() {
    }


    private void setClick() {
        gvDanhSachSach.setOnItemClickListener((parent, view, i, id) -> {
            if (sachs == null) {
                Sach sach = sachArrayList.get(i);
                Bundle b = new Bundle();
                b.putSerializable("sach", sach);
                Intent intent = new Intent(getActivity(), ChiTietThongTinSach.class);
                intent.putExtra("data", b);
                startActivity(intent);
            } else {
                Sach sach = sachs.get(i);
                Bundle b = new Bundle();
                b.putSerializable("sach", sach);
                Intent intent = new Intent(getActivity(), ChiTietThongTinSach.class);
                intent.putExtra("data", b);
                startActivity(intent);
            }
        });

        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String x = edtTimKiem.getText().toString();
                sachAdapter.sortSach(x);
            }
        });
    }
}