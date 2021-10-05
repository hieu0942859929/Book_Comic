package com.example.myapplication.ui.gallery.DanhSachTruyen;

import android.content.Intent;
import android.os.Build;
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
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.myapplication.DiaLogTruyen;
import com.example.myapplication.R;
import com.example.myapplication.api.apilaytruyen.ApiLayTruyen;
import com.example.myapplication.interfaces.laytruyen.LayTruyenVe;
import com.example.myapplication.ui.gallery.ThongTinTruyen.ChiTietThongTinTruyen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DanhSachTruyen extends Fragment implements LayTruyenVe {
    EditText edtTimKiem;
    public GridView gvDanhSachTruyen;
    public static TruyenAdapter truyenAdapter;
    public static ArrayList<Truyen> truyenArrayList;
    ImageButton sapXep, btnSearch;
    private DiaLogTruyen diaLogTruyen;
    public List<Truyen> truyens = null;


    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        gvDanhSachTruyen = root.findViewById(R.id.gvDanhSachTruyen);
        edtTimKiem = root.findViewById(R.id.edtTimKiem);
        anhxa();
        init();
        sapXep = root.findViewById(R.id.sapXep);
        btnSearch = root.findViewById(R.id.btnSearch);
        sapXep.setOnClickListener(v -> {
            diaLogTruyen = new DiaLogTruyen();
            diaLogTruyen.show(getChildFragmentManager(), "DiaLogTruyen");
        });
        btnSearch.setOnClickListener(v -> {
            new ApiLayTruyen(this).execute();
        });
        setUp();
        setClick();
        new ApiLayTruyen(this).execute();
        return root;
    }

    private void init() {
        truyenArrayList = new ArrayList<>();
        truyenAdapter = new TruyenAdapter(getActivity(), 0, truyenArrayList);
//        diaLogTruyen = new DiaLogTruyen();
        new ApiLayTruyen(this).execute();
    }

    private void anhxa() {
    }

    private void setUp() {
        gvDanhSachTruyen.setAdapter(truyenAdapter);
    }

    @Override
    public void BatDau() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void KetThuc(String data) {
        try {
            truyenAdapter.clear();
            JSONArray jsonArray = new JSONArray(data);
            truyenArrayList = new ArrayList<Truyen>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                truyenArrayList.add(new Truyen(o));
            }
//            List condition = diaLogTruyen.arrayList;
//            if (condition.size() > 0) {
//                truyens = new ArrayList<>();
//                for (Truyen truyen : truyenArrayList) {
//                    for (Object i : condition) {
//                        if (truyen.getMaLoaiTruyen().equals(String.valueOf(i))) {
//                            truyens.add(truyen);
//                            break;
//                        }
//                    }
//                }
//            }
//            if (edtTimKiem.getText().length() > 0) {
//                if (truyens == null) {
//                    truyens = new ArrayList<>();
//                    for (Truyen truyen : truyenArrayList) {
//                        if (truyen.getTenTruyen().contains(edtTimKiem.getText().toString())) {
//                            truyens.add(truyen);
//                            break;
//                        }
//                    }
//                } else {
//                    for (Truyen truyen : truyens) {
//                        if (!truyen.getTenTruyen().contains(edtTimKiem.getText().toString())) {
//                            Toast.makeText(getActivity(), "Không tìm thấy truyện", Toast.LENGTH_SHORT).show();
//                            truyens.remove(truyen);
//                            break;
//                        }
//                    }
//                }
//            }
//            if (condition.size() > 0 || edtTimKiem.getText().length() > 0) {
//                truyenAdapter = new TruyenAdapter(getActivity(), 0, truyens);
//            } else {
//                truyenAdapter = new TruyenAdapter(getActivity(), 0, truyenArrayList);
//            }
            truyenAdapter = new TruyenAdapter(getActivity(),0,truyenArrayList);
            gvDanhSachTruyen.setAdapter(truyenAdapter);
        } catch (JSONException e) {
        }
    }

    @Override
    public void biLoi() {
    }

    private void setClick() {
        gvDanhSachTruyen.setOnItemClickListener((parent, view, i, id) -> {
            if (truyens == null) {
                new ApiLayTruyen(this).execute();
                Truyen truyen = truyenArrayList.get(i);
                Bundle b = new Bundle();
                b.putSerializable("truyen", truyen);
                Intent intent = new Intent(getActivity(), ChiTietThongTinTruyen.class);
                intent.putExtra("data", b);
                startActivity(intent);
            } else {
                Truyen truyen = truyens.get(i);
                Bundle b = new Bundle();
                b.putSerializable("truyen", truyen);
                Intent intent = new Intent(getActivity(), ChiTietThongTinTruyen.class);
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
                truyenAdapter.sortTruyen(x);
            }
        });
    }
}
