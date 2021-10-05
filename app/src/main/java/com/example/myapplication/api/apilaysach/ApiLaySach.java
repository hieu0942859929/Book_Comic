package com.example.myapplication.api.apilaysach;

import android.os.AsyncTask;

import com.example.myapplication.interfaces.laysach.LaySachVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiLaySach extends AsyncTask<Void, Void, Void> {
    String data;
    LaySachVe laySachVe;

    public ApiLaySach(LaySachVe laySachVe) {
        this.laySachVe = laySachVe;
        this.laySachVe.BatDau();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//                .url("https://api.mocki.io/v1/59ab1e90")
                .url("http://doctruyensach.000webhostapp.com/laySach.php")
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
            this.laySachVe.biLoi();
        } else {
            this.laySachVe.KetThuc(data);
        }
    }
}
