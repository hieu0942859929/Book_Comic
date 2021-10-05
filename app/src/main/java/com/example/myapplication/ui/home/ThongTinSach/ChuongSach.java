package com.example.myapplication.ui.home.ThongTinSach;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class ChuongSach implements Serializable {
    private String iDChuongSach;
    private String tenChuong;
    private String maSach;
    private String maChuong;

    public String getiDChuongSach() {
        return iDChuongSach;
    }

    public void setiDChuongSach(String iDChuongSach) {
        this.iDChuongSach = iDChuongSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaChuong() {
        return maChuong;
    }

    public String getTenChuong() {
        return tenChuong;
    }

    public void setMaChuong(String maChuong) {
        this.maChuong = maChuong;
    }

    public ChuongSach(JSONObject o) throws JSONException {
        iDChuongSach = o.getString("iDChuongSach");
        tenChuong = o.getString("tenChuong");
        maSach = o.getString("maSach");
        maChuong = o.getString("maChuong");
    }


    public void setTenChuong(String tenChuong) {
        this.tenChuong = tenChuong;
    }

    public ChuongSach(String iDChuongSach, String tenChuong, String maSach, String maChuong) {
        this.iDChuongSach = iDChuongSach;
        this.tenChuong = tenChuong;
        this.maSach = maSach;
        this.maChuong = maChuong;
    }

    public ChuongSach(String tenChuong, String maSach, String maChuong) {
        this.tenChuong = tenChuong;
        this.maSach = maSach;
        this.maChuong = maChuong;
    }

}
