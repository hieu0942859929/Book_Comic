package com.example.myapplication.api.apilaysach;

import android.os.AsyncTask;

import com.example.myapplication.interfaces.laysach.LayChuongSachVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiLayChuongSach extends AsyncTask<Void, Void, Void> {
    String data;
    LayChuongSachVe layChuongSachVe;
    String maSach,maChuong;

    public ApiLayChuongSach(LayChuongSachVe layChuongSachVe,String maSach,String maChuong) {
        this.layChuongSachVe = layChuongSachVe;
        this.layChuongSachVe.BatDau();
        this.maSach = maSach;
        this.maChuong = maChuong;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//                .url("https://api.mocki.io/v1/59ab1e90")
                .url("http://doctruyensach.000webhostapp.com/layChuongSach.php?maSach="+maSach)
                .build();
        data = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data = body.string();
        } catch (IOException e) {
            data = null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (data == null) {
            this.layChuongSachVe.biLoi();
        } else {
            this.layChuongSachVe.KetThuc(data);
        }
    }
}
