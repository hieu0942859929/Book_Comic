package com.example.myapplication.api.apilaytruyen;

import android.os.AsyncTask;

import com.example.myapplication.interfaces.laytruyen.LayChapVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiLayChap extends AsyncTask<Void, Void, Void> {
    String data;
    LayChapVe layChapVe;
    String maTruyen,maChap;

    public ApiLayChap(LayChapVe layChapVe,String maTruyen,String maChap) {
        this.layChapVe = layChapVe;
        this.layChapVe.BatDau();
        this.maTruyen = maTruyen;
        this.maChap = maChap;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//                .url("https://api.mocki.io/v1/59ab1e90")
                .url("http://doctruyensach.000webhostapp.com/layChapTruyen.php?maTruyen="+maTruyen)
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
            this.layChapVe.biLoi();
        } else {
            this.layChapVe.KetThuc(data);
        }
    }
}
