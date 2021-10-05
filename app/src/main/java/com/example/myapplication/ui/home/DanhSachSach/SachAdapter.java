package com.example.myapplication.ui.home.DanhSachSach;

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
import com.example.myapplication.ui.gallery.DanhSachTruyen.Truyen;


import java.util.ArrayList;
import java.util.List;

public class SachAdapter extends ArrayAdapter<Sach> {
    private Context context;
    private ArrayList<Sach> arrayList;

    public SachAdapter(@NonNull Context context, int resource, @NonNull List<Sach> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = new ArrayList<>(objects);
    }

    public void sortSach(String x){
        x = x.toUpperCase();
        int k = 0;
        for(int i = 0;i<arrayList.size();i++){
            Sach s = arrayList.get(i);
            String ten = s.getTenSach().toUpperCase();
            if (ten.indexOf(x)>=0){
                arrayList.set(i,arrayList.get(k));
                arrayList.set(k,s);
                k++;
            }
        }
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_sach, null);
        }
        if (arrayList.size() > 0) {
            Sach sach = this.arrayList.get(position);
            TextView tvTenSach = convertView.findViewById(R.id.tvTenSach);
            ImageView imgSach = convertView.findViewById(R.id.imgSach);

            tvTenSach.setText(sach.getTenSach());
            Glide.with(this.context).load(sach.getLinkAnh()).into(imgSach);
        }
        return convertView;
    }
}
