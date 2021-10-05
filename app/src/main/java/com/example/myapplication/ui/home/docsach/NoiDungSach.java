package com.example.myapplication.ui.home.docsach;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class NoiDungSach implements Serializable {
    private String iDNoiDungSach;
    private String noiDung;
    private String maSach;
    private String maChuong;

    public NoiDungSach(String iDNoiDungSach, String noiDung, String maSach, String maChuong) {
        this.iDNoiDungSach = iDNoiDungSach;
        this.noiDung = noiDung;
        this.maSach = maSach;
        this.maChuong = maChuong;
    }

    public NoiDungSach(String noiDung, String maSach, String maChuong) {
        this.noiDung = noiDung;
        this.maSach = maSach;
        this.maChuong = maChuong;
    }

    public NoiDungSach() {
    }

    public String getiDNoiDungSach() {
        return iDNoiDungSach;
    }

    public void setiDNoiDungSach(String iDNoiDungSach) {
        this.iDNoiDungSach = iDNoiDungSach;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
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

    public void setMaChuong(String maChuong) {
        this.maChuong = maChuong;
    }

    public NoiDungSach(JSONObject o) throws JSONException {
        iDNoiDungSach = o.getString("iDNoiDungSach");
        noiDung = o.getString("noiDung");
        maSach = o.getString("maSach");
        maChuong = o.getString("maChuong");
    }
}
