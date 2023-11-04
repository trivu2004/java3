/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5.View;

import Lab5.Bai1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author USER
 */
public class ViewLab5Bai1 {
     public static void main(String[] args) {
        try {
            Connection conn = Bai1.getConnection();

            // Tạo đối tượng Statement
            Statement stmt = conn.createStatement();

            // Thực hiện truy vấn SELECT
            String sql = "SELECT * FROM STUDENTS";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            System.out.println("Danh sách sinh viên:");
            while (rs.next()) {
                String masv = rs.getString("MaSV");
                String name = rs.getString("Hoten");
                String email = rs.getString("Email");
                String soDT = rs.getString("SoDT");
                String gioitinh = rs.getString("Gioitinh");
                 String diachi = rs.getString("Diachi");
                

                System.out.println("MaSV: " + masv + ", Hoten: " + name + ", Email: " + email+ ", SoDT: " + soDT + ", GioiTinh: " +gioitinh + ", DiaChi: "+diachi);
            }

            // Đóng kết nối và các tài nguyên
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
