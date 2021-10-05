package com.example.myapplication.ui.home.ThongTinSach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ChuongSachAdapter extends ArrayAdapter<ChuongSach> {
    private Context context;
    private ArrayList<ChuongSach> arrayList;

    public ChuongSachAdapter(@NonNull Context context, int resource, @NonNull List<ChuongSach> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_chuong_sach, null);
        }
        if (arrayList.size() > 0) {
            ChuongSach chuongSach = this.arrayList.get(position);
            TextView tvChuongSach = convertView.findViewById(R.id.tvChuongSach);

            tvChuongSach.setText(chuongSach.getTenChuong());
        }
        return convertView;
    }
}
