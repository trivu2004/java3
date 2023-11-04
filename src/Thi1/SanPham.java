/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thi1;

/**
 *
 * @author 123tu
 */
public class SanPham {
    private String MaSP, Loai, Gia, SoLuong, ThanhTien;

    public SanPham() {
    }

    public SanPham(String MaSP, String Loai, String Gia, String SoLuong, String ThanhTien) {
        this.MaSP = MaSP;
        this.Loai = Loai;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(String ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
