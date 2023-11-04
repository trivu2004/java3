/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exam;

import java.util.Date;

/**
 *
 * @author admin
 */
public class QuanLyThueXe {

    public String MaSP;
    private String Loai;
    private int soLuong;
    private Double gia,Thanhtien;

    public QuanLyThueXe() {
    }

    public QuanLyThueXe(String MaSP, String Loai, int soLuong, Double gia, Double Thanhtien) {
        this.MaSP = MaSP;
        this.Loai = Loai;
        this.soLuong = soLuong;
        this.gia = gia;
        this.Thanhtien = Thanhtien;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien(Double Thanhtien) {
        this.Thanhtien = Thanhtien;
    }
    private double Thanhtien(){
        return soLuong*gia;
    }



}
