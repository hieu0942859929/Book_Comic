package com.example.myapplication.api.apilaysach;

import android.os.AsyncTask;

import com.example.myapplication.interfaces.laysach.LayNoiDungSachVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiLayNoiDungSach extends AsyncTask<Void, Void, Void> {
    String data;
    LayNoiDungSachVe layNoiDungSachVe;
    String maSach,maChuong;

    public ApiLayNoiDungSach(LayNoiDungSachVe layNoiDungSachVe, String maSach, String maChuong) {
        this.layNoiDungSachVe = layNoiDungSachVe;
        this.layNoiDungSachVe.BatDau();
        this.maSach = maSach;
        this.maChuong = maChuong;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
 //            .url("https://api.mocki.io/v1/dc26aeac")
                .url("http://doctruyensach.000webhostapp.com/layNoiDungSach.php?maSach="+maSach+"&maChuong="+maChuong)
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
            this.layNoiDungSachVe.biLoi();
        } else {
            this.layNoiDungSachVe.KetThuc(data);
        }
    }
}
