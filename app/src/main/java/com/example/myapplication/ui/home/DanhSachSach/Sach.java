package com.example.myapplication.ui.home.DanhSachSach;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Sach implements Serializable {
    private String iDSach, maSach, tenSach, ngayPhatHanh, tacGia, maTacGia, nguoiDich, noiDung, linkAnh, maLoaiSach;

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public Sach() {
    }

    public Sach(JSONObject o) throws JSONException {
        maSach = o.getString("maSach");
        tenSach = o.getString("tenSach");
        ngayPhatHanh = o.getString("ngayPhatHanh");
        tacGia = o.getString("tacGia");
        maTacGia = o.getString("maTacGia");
        nguoiDich = o.getString("nguoiDich");
        noiDung = o.getString("noiDung");
        linkAnh = o.getString("linkAnh");
        maLoaiSach = o.getString("maLoaiSach");
    }

    public String getiDSach() {
        return iDSach;
    }

    public void setiDSach(String iDSach) {
        this.iDSach = iDSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
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

    public String getMaLoaiSach() {
        return maLoaiSach;
    }

    public void setMaLoaiSach(String maLoaiSach) {
        this.maLoaiSach = maLoaiSach;
    }

    public Sach(String iDSach, String maSach, String tenSach, String ngayPhatHanh, String tacGia, String maTacGia, String nguoiDich, String noiDung, String linkAnh, String maLoaiSach) {
        this.iDSach = iDSach;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.ngayPhatHanh = ngayPhatHanh;
        this.tacGia = tacGia;
        this.maTacGia = maTacGia;
        this.nguoiDich = nguoiDich;
        this.noiDung = noiDung;
        this.linkAnh = linkAnh;
        this.maLoaiSach = maLoaiSach;
    }

    public Sach(String maSach, String tenSach, String ngayPhatHanh, String tacGia, String maTacGia, String nguoiDich, String noiDung, String linkAnh, String maLoaiSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.ngayPhatHanh = ngayPhatHanh;
        this.tacGia = tacGia;
        this.maTacGia = maTacGia;
        this.nguoiDich = nguoiDich;
        this.noiDung = noiDung;
        this.linkAnh = linkAnh;
        this.maLoaiSach = maLoaiSach;
    }

    public Sach(String tenSach, String linkAnh) {
        this.tenSach = tenSach;
        this.linkAnh = linkAnh;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }

    public Sach(String tenSach, String ngayPhatHanh, String tacGia, String maTacGia, String nguoiDich, String noiDung, String linkAnh, String maLoaiSach) {
        this.tenSach = tenSach;
        this.ngayPhatHanh = ngayPhatHanh;
        this.tacGia = tacGia;
        this.maTacGia = maTacGia;
        this.nguoiDich = nguoiDich;
        this.noiDung = noiDung;
        this.linkAnh = linkAnh;
        this.maLoaiSach = maLoaiSach;
    }
}
