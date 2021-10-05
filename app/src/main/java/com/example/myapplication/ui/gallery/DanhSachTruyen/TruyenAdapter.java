package com.example.myapplication.ui.gallery.DanhSachTruyen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.ui.home.DanhSachSach.Sach;

import java.util.ArrayList;
import java.util.List;

public class TruyenAdapter extends ArrayAdapter<Truyen> {
    private Context context;
    private ArrayList<Truyen> arrayList;

    public TruyenAdapter(Context context, int resource,List<Truyen> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = new ArrayList<>(objects);
    }

    public void sortTruyen(String x){
        x = x.toUpperCase();
        int k = 0;
        for(int i = 0;i<arrayList.size();i++){
            Truyen t = arrayList.get(i);
            String ten = t.getTenTruyen().toUpperCase();
            if (ten.indexOf(x)>=0){
                arrayList.set(i,arrayList.get(k));
                arrayList.set(k,t);
                k++;
            }
        }
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_truyen, null);
        }
        if (arrayList.size() > 0) {
            Truyen truyen = this.arrayList.get(position);
            TextView tvTenTruyen = convertView.findViewById(R.id.tvTenTruyen);
            ImageView imgTruyen = convertView.findViewById(R.id.imgTruyen);

            tvTenTruyen.setText(truyen.getTenTruyen());
            Glide.with(this.context).load(truyen.getLinkAnh()).into(imgTruyen);
        }
        return convertView;
    }
}

