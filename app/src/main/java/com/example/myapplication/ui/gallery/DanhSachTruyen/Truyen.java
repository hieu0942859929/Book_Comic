package com.example.myapplication.ui.gallery.DanhSachTruyen;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Truyen implements Serializable {
    private String iDTruyen, maTruyen, tenTruyen, soLuongChap, ngayPhatHanh, tacGia, nguoiDich, noiDung, linkAnh, maLoaiTruyen;

    public String getSoLuongChap() {
        return soLuongChap;
    }

    public void setSoLuongChap(String soLuongChap) {
        this.soLuongChap = soLuongChap;
    }

    public String getiDTruyen() {
        return iDTruyen;
    }

    public void setiDTruyen(String iDTruyen) {
        this.iDTruyen = iDTruyen;
    }

    public String getMaTruyen() {
        return maTruyen;
    }

    public void setMaTruyen(String maTruyen) {
        this.maTruyen = maTruyen;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNguoiDich() {
        return nguoiDich;
    }

    public void setNguoiDich(String nguoiDich) {
        this.nguoiDich = nguoiDich;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMaLoaiTruyen() {
        return maLoaiTruyen;
    }

    public void setMaLoaiTruyen(String maLoai) {
        this.maLoaiTruyen = maLoaiTruyen;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }

    public Truyen(String iDTruyen, String maTruyen, String tenTruyen, String soLuongChap, String ngayPhatHanh, String tacGia, String nguoiDich, String noiDung, String linkAnh, String maLoaiTruyen) {
        this.iDTruyen = iDTruyen;
        this.maTruyen = maTruyen;
        this.tenTruyen = tenTruyen;
        this.soLuongChap = soLuongChap;
        this.ngayPhatHanh = ngayPhatHanh;
        this.tacGia = tacGia;
        this.nguoiDich = nguoiDich;
        this.noiDung = noiDung;
        this.linkAnh = linkAnh;
        this.maLoaiTruyen = maLoaiTruyen;
    }

    public Truyen(String maTruyen, String tenTruyen, String soLuongChap, String ngayPhatHanh, String tacGia, String nguoiDich, String noiDung, String linkAnh, String maLoaiTruyen) {
        this.maTruyen = maTruyen;
        this.tenTruyen = tenTruyen;
        this.soLuongChap = soLuongChap;
        this.ngayPhatHanh = ngayPhatHanh;
        this.tacGia = tacGia;
        this.nguoiDich = nguoiDich;
        this.noiDung = noiDung;
        this.linkAnh = linkAnh;
        this.maLoaiTruyen = maLoaiTruyen;
    }

    public Truyen() {
    }

    public Truyen(JSONObject o) throws JSONException {
        maTruyen = o.getString("maTruyen");
        tenTruyen = o.getString("tenTruyen");
        soLuongChap = o.getString("soLuongChap");
        ngayPhatHanh = o.getString("ngayPhatHanh");
        tacGia = o.getString("tacGia");
        nguoiDich = o.getString("nguoiDich");
        noiDung = o.getString("noiDung");
        linkAnh = o.getString("linkAnh");
        maLoaiTruyen = o.getString("maLoaiTruyen");
    }
}

