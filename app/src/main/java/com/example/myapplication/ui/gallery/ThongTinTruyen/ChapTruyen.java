package com.example.myapplication.ui.gallery.ThongTinTruyen;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class ChapTruyen implements Serializable {
    public String iDChapTruyen,tenChap,maTruyen,maChap;

    public ChapTruyen(String iDChapTruyen, String tenChap, String maTruyen, String maChap) {
        this.iDChapTruyen = iDChapTruyen;
        this.tenChap = tenChap;
        this.maTruyen = maTruyen;
        this.maChap = maChap;
    }

    public ChapTruyen(String tenChap, String maTruyen, String maChap) {
        this.tenChap = tenChap;
        this.maTruyen = maTruyen;
        this.maChap = maChap;
    }

    public ChapTruyen() {
    }

    public String getiDChapTruyen() {
        return iDChapTruyen;
    }

    public void setiDChapTruyen(String iDChapTruyen) {
        this.iDChapTruyen = iDChapTruyen;
    }

    public String getTenChap() {
        return tenChap;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public String getMaTruyen() {
        return maTruyen;
    }

    public void setMaTruyen(String maTruyen) {
        this.maTruyen = maTruyen;
    }

    public String getMaChap() {
        return maChap;
    }

    public void setMaChap(String maChap) {
        this.maChap = maChap;
    }

    public ChapTruyen(JSONObject o) throws JSONException {
        iDChapTruyen = o.getString("iDChapTruyen");
        tenChap = o.getString("tenChap");
        maTruyen = o.getString("maTruyen");
        maChap = o.getString("maChap");
    }
}
