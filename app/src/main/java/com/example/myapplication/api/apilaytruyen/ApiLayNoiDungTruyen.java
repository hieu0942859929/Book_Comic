package com.example.myapplication.api.apilaytruyen;

import android.os.AsyncTask;

import com.example.myapplication.interfaces.laytruyen.LayNoiDungTruyenVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;


public class ApiLayNoiDungTruyen extends AsyncTask<Void, Void, Void> {
    String data;
    LayNoiDungTruyenVe layNoiDungTruyenVe;
    String maTruyen,maChap;

    public ApiLayNoiDungTruyen(LayNoiDungTruyenVe layNoiDungTruyenVe,String maTruyen,String maChap) {
        this.layNoiDungTruyenVe = layNoiDungTruyenVe;
        this.layNoiDungTruyenVe.BatDau();
        this.maTruyen = maTruyen;
        this.maChap = maChap;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//              .url("https://api.mocki.io/v1/54752b9b")
                .url("http://doctruyensach.000webhostapp.com/layNoiDungTruyen.php?maTruyen="+maTruyen+"&maChap="+maChap)
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
            this.layNoiDungTruyenVe.biLoi();
        } else {
            this.layNoiDungTruyenVe.KetThuc(data);
        }
    }
}

