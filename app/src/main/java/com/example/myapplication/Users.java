package com.example.myapplication;

public class Users {
    private String tenTaiKhoan;
    private String hoTen;
    private String email;
    private String sdt;
    private String matKhau;
    private Integer phanQuyen;

    public Users(String tenTaiKhoan, String hoTen, String email, String sdt, String matKhau) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.hoTen = hoTen;
        this.email = email;
        this.sdt = sdt;
        this.matKhau = matKhau;
    }

    public Users(String tenTaiKhoan, String hoTen, String email, String sdt, String matKhau, Integer phanQuyen) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.hoTen = hoTen;
        this.email = email;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.phanQuyen = phanQuyen;
    }

    public Integer getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(Integer phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    public Users() {
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
