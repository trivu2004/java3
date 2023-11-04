/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class NhanVien implements Serializable {

    private String MaNV;
    private String HoVaTen;
    private int Tuoi;
    private String Email;
    private float Luong;

    public NhanVien(String MaNV, String HoVaTen, int Tuoi, String Email, float Luong) {
        this.MaNV = MaNV;
        this.HoVaTen = HoVaTen;
        this.Tuoi = Tuoi;
        this.Email = Email;
        this.Luong = Luong;
    }

    public NhanVien() {
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public float getLuong() {
        return Luong;
    }

    public void setLuong(float Luong) {
        this.Luong = Luong;
    }

}
