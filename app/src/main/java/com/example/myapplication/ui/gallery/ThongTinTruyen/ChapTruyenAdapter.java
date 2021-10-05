package com.example.myapplication.ui.gallery.ThongTinTruyen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.myapplication.R;
import com.example.myapplication.ui.gallery.DanhSachTruyen.Truyen;

import java.util.ArrayList;
import java.util.List;

public class ChapTruyenAdapter extends ArrayAdapter<ChapTruyen> {
    private Context context;
    private ArrayList<ChapTruyen> arrayList;
    Truyen truyen;

    public ChapTruyenAdapter(@NonNull Context context, int resource, @NonNull List<ChapTruyen> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_chap_truyen, null);
        }
        if (arrayList.size() > 0) {
            ChapTruyen chapTruyen = this.arrayList.get(position);
            TextView tvChapTruyen =  convertView.findViewById(R.id.tvChapTruyen);

            tvChapTruyen.setText(chapTruyen.getTenChap());
        }
        return convertView;
    }
}
