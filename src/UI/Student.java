    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

/**
 *
 * @author USER
 */
public class Student {
    String hoTen,maSV;
    Double tiengAnh,tinHoc,giaoDucTC,diemTB;

    public Student(String hoTen, String maSV, Double tiengAnh, Double tinHoc, Double giaoDucTC, Double diemTB) {
        this.hoTen = hoTen;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.giaoDucTC = giaoDucTC;
        this.diemTB = diemTB;
    }



    public Student() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public Double getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(Double tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public Double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(Double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public Double getGiaoDucTC() {
        return giaoDucTC;
    }

    public void setGiaoDucTC(Double giaoDucTC) {
        this.giaoDucTC = giaoDucTC;
    }
    public Double getDiemTB() {
        return (this.tiengAnh +this.tinHoc+this.giaoDucTC)/3;
    }

    public void setDiemTB(Double diemTB) {
        this.diemTB = diemTB;
    }

}
