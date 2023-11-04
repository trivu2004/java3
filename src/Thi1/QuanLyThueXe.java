/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thi1;

import java.util.Date;

/**
 *
 * @author admin
 */
public class QuanLyThueXe {

    public String Biensoxe;
    private String Loaixe;
    private Date Ngaymuon, NgayTra;
    private Double Thanhtien;

    public QuanLyThueXe() {
    }

    public QuanLyThueXe(String Biensoxe, String Loaixe, Date Ngaymuon, Date NgayTra, Double Thanhtien) {
        this.Biensoxe = Biensoxe;
        this.Loaixe = Loaixe;
        this.Ngaymuon = Ngaymuon;
        this.NgayTra = NgayTra;
        this.Thanhtien = Thanhtien;
    }

    public String getBiensoxe() {
        return Biensoxe;
    }

    public void setBiensoxe(String Biensoxe) {
        this.Biensoxe = Biensoxe;
    }

    public String getLoaixe() {
        return Loaixe;
    }

    public void setLoaixe(String Loaixe) {
        this.Loaixe = Loaixe;
    }

    public Date getNgaymuon() {
        return Ngaymuon;
    }

    public void setNgaymuon(Date Ngaymuon) {
        this.Ngaymuon = Ngaymuon;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public Double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien(Double Thanhtien) {
        this.Thanhtien = Thanhtien;
    }

//    public double getDTB() {
//        return ;
//    }
}
