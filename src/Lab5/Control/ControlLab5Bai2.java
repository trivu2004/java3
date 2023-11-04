/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5.Control;

import Lab5.Model.ModelBai2;
import Lab5.Student;
import Lab5.View.ViewLab5Bai2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class ControlLab5Bai2 {

    int current = 0;
    String url = "jdbc:mysql://localhost:3306/Lab5Bai1";
    String user = "root";
    String password = "123456";

    public int getCurrent() {
        return current;
    }
    private final ViewLab5Bai2 viewLab5Bai2;
    ArrayList<ModelBai2> array = new ArrayList<ModelBai2>();
    private final JButton btnAdd, btnDelete, btnUpdate, btnSave, btnFirst, btnNext, btnPrevious, btnLast, btnTimKiem;
    private final JTextArea txtDiaChi;
    private final JTextField txtMaSV, txtHoTen, txtEmail, txtSoDT, txtTimKiem;
    private final JRadioButton jrdNam, jrdNu;
    private final ButtonGroup bt;

    public ControlLab5Bai2(ViewLab5Bai2 viewLab5Bai2) {
        this.viewLab5Bai2 = viewLab5Bai2;
        this.array = new ArrayList<>();
        this.btnAdd = viewLab5Bai2.getBtnAdd();
        this.btnDelete = viewLab5Bai2.getBtnDelete();
        this.btnSave = viewLab5Bai2.getBtnSave();
        this.btnFirst = viewLab5Bai2.getBtnFirst();
        this.btnNext = viewLab5Bai2.getBtnNext();
        this.btnPrevious = viewLab5Bai2.getBtnPrevious();
        this.btnLast = viewLab5Bai2.getBtnLast();
        this.btnTimKiem = viewLab5Bai2.getBtnTimKiem();
        this.btnUpdate = viewLab5Bai2.getBtnUpdate();

        this.txtDiaChi = viewLab5Bai2.getTxtDiaChi();
        this.txtHoTen = viewLab5Bai2.getTxtHoTen();
        this.txtEmail = viewLab5Bai2.getTxtEmail();
        this.txtMaSV = viewLab5Bai2.getTxtMaSV();
        this.txtSoDT = viewLab5Bai2.getTxtSoDT();
        this.txtTimKiem = viewLab5Bai2.getTxtTimKiem();
        this.jrdNam = viewLab5Bai2.getJrdNam();
        this.jrdNu = viewLab5Bai2.getJrdNu();
        this.bt = viewLab5Bai2.getBt();
    }

    public void kk() {
        btnFirst.addActionListener(ac);
        btnLast.addActionListener(ac);
        btnNext.addActionListener(ac);
        btnPrevious.addActionListener(ac);
        btnAdd.addActionListener(ac);
        btnDelete.addActionListener(ac);
        btnUpdate.addActionListener(ac);
        btnSave.addActionListener(ac);
        btnTimKiem.addActionListener(ac);
    }

    public void Display(int i) {
        ModelBai2 st = array.get(i);
        txtDiaChi.setText(st.diaChi);
        txtEmail.setText(st.Email);
        txtHoTen.setText(st.hoTen);
        txtMaSV.setText(st.maSV);
        txtSoDT.setText(st.soDT);
        boolean gt = st.gioiTinh;
        if (gt == true) {
            jrdNam.setSelected(true);
        } else {
            jrdNu.setSelected(true);
        }
    }

    public void LoadDataArray() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement sta = con.createStatement();
            String sql = "select * from STUDENTS";
            ResultSet rs = sta.executeQuery(sql);
            array.clear();
            while (rs.next()) {
                String masv = rs.getString(1);
                String hoten = rs.getString(2);
                String email = rs.getString(3);
                String sodt = rs.getString(4);
                boolean gt = rs.getBoolean(5);
                String diachi = rs.getString(6);
                ModelBai2 sv = new ModelBai2(masv, hoten, email, sodt, diachi, gt);
                array.add(sv);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    ActionListener ac = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnLast) {
                System.out.println("aaaaa");
                current = array.size() - 1;
                Display(current);
                JOptionPane.showMessageDialog(null, "Bạn đang ở cuối danh sách!");
            }
            if (ae.getSource() == btnFirst) {
                current = 0;
                Display(current);
                JOptionPane.showMessageDialog(null, "Bạn đang ở đầu danh sách!");
            }
            if (ae.getSource() == btnNext) {
                current++;
                if (current >= array.size()) {
                    JOptionPane.showMessageDialog(null, "Bạn đang ở cuối danh sách!");
                    return;
                }
                Display(current);
            }
            if (ae.getSource() == btnPrevious) {
                current--;
                if (current < 0) {
                    JOptionPane.showMessageDialog(null, "Bạn đang ở đầu danh sách!");
                    return;
                }
                Display(current);
            }
            if (ae.getSource() == btnAdd) {
                txtMaSV.setText("");
                txtHoTen.setText("");
                txtEmail.setText("");
                txtSoDT.setText("");
                bt.clearSelection();
                txtDiaChi.setText("");
            }
            if (ae.getSource() == btnDelete) {
                if (txtMaSV.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nhập Mã SV");
                    txtMaSV.requestFocus();
                    return;
                } else {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, user, password);
                        String sql = "delete from STUDENTS where MaSV = ?";
                        PreparedStatement pre = con.prepareStatement(sql);
                        pre.setString(1, txtMaSV.getText());
                        pre.execute();

                        con.close();
                        Display(current--);
                        JOptionPane.showMessageDialog(null, "Delete thành công!");
                        txtMaSV.setText("");
                        txtHoTen.setText("");
                        txtEmail.setText("");
                        txtSoDT.setText("");
                        bt.clearSelection();
                        txtDiaChi.setText("");
                    } catch (Exception e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(null, "Lỗi delete!");
                    }
                }
            }
            if (ae.getSource() == btnUpdate) {
                if (txtMaSV.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nhập Mã SV!");
                    txtMaSV.requestFocus();
                    return;
                } else {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, user, password);
                        String sql = "update STUDENTS set HoTen =? , Email =? , SoDT = ?,DiaChi = ?,"
                                +"GioiTinh =? where MaSV =?";
                        PreparedStatement presta = con.prepareStatement(sql);
                        presta.setString(1, txtHoTen.getText());
                        presta.setString(2, txtEmail.getText());
                        presta.setString(3, txtSoDT.getText());
                        presta.setString(4, txtDiaChi.getText());
                        boolean gt;
                        if (jrdNam.isSelected()) {
                            gt = true;
                        } else {
                            gt = false;
                        }
                        presta.setBoolean(5, gt);
                        presta.setString(6, txtMaSV.getText());
                        presta.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Update thành công!");
                        con.close();
                        LoadDataArray();
                    } catch (Exception e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(null, "Lỗi update!");
                    }
                }
            }
            if (ae.getSource() == btnSave) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql = "insert into STUDENTS values(?,?,?,?,?,?)";
                    PreparedStatement presta = con.prepareStatement(sql);
                    presta.setString(1, txtMaSV.getText());
                    presta.setString(2, txtHoTen.getText());
                    presta.setString(3, txtEmail.getText());
                    presta.setString(4, txtSoDT.getText());
                    boolean gt;
                    if (jrdNam.isSelected()) {
                        gt = true;
                    } else {
                        gt = false;
                    }
                    presta.setBoolean(5, gt);
                    presta.setString(6, txtDiaChi.getText());
                    presta.executeUpdate();
                    con.close();
                    LoadDataArray();
                    JOptionPane.showMessageDialog(null, "Save thành công!");
                    txtMaSV.setText("");
                    txtHoTen.setText("");
                    txtEmail.setText("");
                    txtSoDT.setText("");
                    bt.clearSelection();
                    txtDiaChi.setText("");
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Mã Sinh Viên này đã tồn tại!");
                }
            }
            if (ae.getSource() == btnTimKiem) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql1 = "select * from STUDENTS where MaSV = ?";
                    PreparedStatement st = con.prepareStatement(sql1);
                    st.setString(1, txtTimKiem.getText().trim());
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        String masv = rs.getString("MaSV");
                        String hoten = rs.getString("Hoten");
                        String email = rs.getString("Email");
                        String sodt = rs.getString("SoDT");
                        boolean gt = rs.getBoolean("Gioitinh");
                        String diachi = rs.getString("Diachi");
                        txtMaSV.setText(masv);
                        txtHoTen.setText(hoten);
                        txtEmail.setText(email);
                        txtSoDT.setText(sodt);
                        txtDiaChi.setText(diachi);
                        if (gt == true) {
                            jrdNam.setSelected(true);
                        } else {
                            jrdNu.setSelected(true);
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Không có mã sinh viên này!");
                    con.close();
                } catch (Exception e) {
                }
            }
        }
    };
}
