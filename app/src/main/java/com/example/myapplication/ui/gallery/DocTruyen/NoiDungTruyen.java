package com.example.myapplication.ui.gallery.DocTruyen;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class NoiDungTruyen implements Serializable {
    public String iDNoiDungTruyen, linkAnh, maTruyen, maChap;

    public NoiDungTruyen(String iDNoiDungTruyen, String linkAnh, String maTruyen, String maChap) {
        this.iDNoiDungTruyen = iDNoiDungTruyen;
        this.linkAnh = linkAnh;
        this.maTruyen = maTruyen;
        this.maChap = maChap;
    }

    public NoiDungTruyen(String linkAnh, String maTruyen, String maChap) {
        this.linkAnh = linkAnh;
        this.maTruyen = maTruyen;
        this.maChap = maChap;
    }

    public NoiDungTruyen(String linkAnh) {
        this.linkAnh = linkAnh;
    }

    public NoiDungTruyen() {
    }

    public String getiDNoiDungTruyen() {
        return iDNoiDungTruyen;
    }

    public void setiDNoiDungTruyen(String iDNoiDungTruyen) {
        this.iDNoiDungTruyen = iDNoiDungTruyen;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
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

    public NoiDungTruyen(JSONObject o) throws JSONException {
        iDNoiDungTruyen = o.getString("iDNoiDungTruyen");
        linkAnh = o.getString("linkAnh");
        maTruyen = o.getString("maTruyen");
        maChap = o.getString("maChap");
    }
}
