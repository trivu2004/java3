/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Bai2 extends JFrame implements ActionListener {

    ArrayList<Student> array = new ArrayList<Student>();
    int current = 0;
    String url = "jdbc:mysql://localhost:3306/Lab5Bai1";
    String user = "root";
    String password = "123456";

    JFrame frame;
    JLabel lblHeader, lblMaSV, lblHoTen, lblEmail, lblSoDT, lblGioiTinh, lblDiaChi, lblTimKiem;
    JPanel p1, p2, p3, p4;
    JButton btnAdd, btnDelete, btnUpdate, btnSave, btnFirst, btnNext, btnPrevious, btnLast, btnTimKiem;
    JTextArea txtDiaChi;
    JTextField txtMaSV, txtHoTen, txtEmail, txtSoDT, txtTimKiem;
    JRadioButton jrdNam, jrdNu;
    ButtonGroup bt;

    public Bai2() {
        myGUI();
        frame.setVisible(true);
        LoadDataArray();
        Display(current);
    }

    public void myGUI() {
        frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(224, 224, 224));

        lblHeader = new JLabel("Quản Lý Users");
        lblHeader.setFont(new Font("Robot", Font.BOLD, 28));
        lblHeader.setBounds(130, 20, 300, 100);
        lblHeader.setForeground(Color.blue);

        lblTimKiem = new JLabel("Tìm Kiếm");
        lblTimKiem.setBounds(430, 20, 130, 100);
        lblTimKiem.setFont(new Font("Roboto", Font.PLAIN, 28));
        lblTimKiem.setForeground(Color.blue);

        btnTimKiem = new JButton("Search",new ImageIcon("E:\\PS31493\\src\\Icon\\b.png"));
        btnTimKiem.setBounds(730, 45, 130,50);
        frame.add(btnTimKiem);

        txtTimKiem = new JTextField();
        txtTimKiem.setBounds(560, 50, 150, 40);
        txtTimKiem.setBackground(new Color(204, 255, 255));
        txtTimKiem.setFont(new Font("Roboto", Font.PLAIN, 23));
        frame.add(lblTimKiem);
        frame.add(txtTimKiem);

        lblMaSV = new JLabel("Mã SV: ");
        lblMaSV.setBounds(40, 100, 100, 80);
        lblMaSV.setFont(new Font("Roboto", Font.PLAIN, 20));

        lblHoTen = new JLabel("Họ Tên: ");
        lblHoTen.setBounds(30, 155, 100, 80);
        lblHoTen.setFont(new Font("Roboto", Font.PLAIN, 20));

        lblEmail = new JLabel("Email: ");
        lblEmail.setBounds(45, 205, 100, 80);
        lblEmail.setFont(new Font("Roboto", Font.PLAIN, 20));

        lblSoDT = new JLabel("Số ĐT: ");
        lblSoDT.setBounds(40, 255, 100, 80);
        lblSoDT.setFont(new Font("Roboto", Font.PLAIN, 20));

        lblGioiTinh = new JLabel("Giới Tính: ");
        lblGioiTinh.setBounds(20, 310, 100, 80);
        lblGioiTinh.setFont(new Font("Roboto", Font.PLAIN, 20));

        lblDiaChi = new JLabel("Địa Chỉ: ");
        lblDiaChi.setBounds(35, 370, 100, 80);
        lblDiaChi.setFont(new Font("Roboto", Font.PLAIN, 20));

        txtMaSV = new JTextField();
        txtMaSV.setBounds(120, 120, 300, 40);
        txtMaSV.setFont(new Font("Roboto", Font.PLAIN, 20));

        txtHoTen = new JTextField();
        txtHoTen.setBounds(120, 175, 300, 40);
        txtHoTen.setFont(new Font("Roboto", Font.PLAIN, 20));

        txtEmail = new JTextField();
        txtEmail.setBounds(120, 225, 300, 40);
        txtEmail.setFont(new Font("Roboto", Font.PLAIN, 20));

        txtSoDT = new JTextField();
        txtSoDT.setBounds(120, 275, 300, 40);
        txtSoDT.setFont(new Font("Roboto", Font.PLAIN, 20));

        txtDiaChi = new JTextArea(50, 0);
        txtDiaChi.setLineWrap(true);
        txtDiaChi.setFont(new Font("Roboto", Font.PLAIN, 22));
        JScrollPane scrollPane = new JScrollPane(txtDiaChi);
        scrollPane.setBounds(120, 390, 500, 150);

        jrdNam = new JRadioButton("Nam");
        jrdNam.setBounds(120, 335, 100, 30);
        jrdNam.setFont(new Font("Roboto", Font.PLAIN, 22));
        jrdNam.setBackground(new Color(224, 224, 224));
        jrdNu = new JRadioButton("Nữ");
        jrdNu.setBounds(260, 335, 100, 30);
        jrdNu.setFont(new Font("Roboto", Font.PLAIN, 22));
        jrdNu.setBackground(new Color(224, 224, 224));
        bt = new ButtonGroup();
        bt.add(jrdNam);
        bt.add(jrdNu);

        btnAdd = new JButton("New", new ImageIcon("E:\\PS31493\\src\\Icon\\Them1.png"));
        btnAdd.setBounds(450, 120, 170, 55);
        btnAdd.setFont(new Font("Roboto", Font.PLAIN, 22));
        btnAdd.setBackground(new Color(204, 255, 255));
        btnAdd.setForeground(Color.red);

        btnDelete = new JButton("Delete", new ImageIcon("E:\\PS31493\\src\\Icon\\delete.png"));
        btnDelete.setBounds(450, 180, 170, 55);
        btnDelete.setFont(new Font("Roboto", Font.PLAIN, 22));
        btnDelete.setBackground(new Color(204, 255, 255));
        btnDelete.setForeground(Color.red);

        btnUpdate = new JButton("Update", new ImageIcon("E:\\PS31493\\src\\Icon\\update.png"));
        btnUpdate.setBounds(450, 240, 170, 55);
        btnUpdate.setFont(new Font("Roboto", Font.PLAIN, 22));
        btnUpdate.setBackground(new Color(204, 255, 255));
        btnUpdate.setForeground(Color.red);

        btnSave = new JButton("Save", new ImageIcon("E:\\PS31493\\src\\Icon\\luu1.png"));
        btnSave.setBounds(450, 300, 170, 55);
        btnSave.setFont(new Font("Roboto", Font.PLAIN, 22));
        btnSave.setBackground(new Color(204, 255, 255));
        btnSave.setForeground(Color.red);

        p1 = new JPanel();
        p1.setBounds(150, 600, 400, 60);
        p1.setLayout(new GridLayout(1, 4, 30, 30));
        p1.setBackground(new Color(224, 224, 224));

        btnNext = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\xuong.png"));
        btnNext.setBackground(new Color(204, 255, 255));

        btnFirst = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\dau.png"));
        btnFirst.setBackground(new Color(204, 255, 255));
        btnLast = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\cuoi.png"));
        btnLast.setBackground(new Color(204, 255, 255));
        btnPrevious = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\len.png"));
        btnPrevious.setBackground(new Color(204, 255, 255));

        p1.add(btnPrevious);
        p1.add(btnFirst);
        p1.add(btnLast);
        p1.add(btnNext);

        frame.add(lblHeader);
        frame.add(lblMaSV);
        frame.add(lblHoTen);
        frame.add(lblEmail);
        frame.add(lblSoDT);
        frame.add(lblGioiTinh);
        frame.add(lblDiaChi);
        frame.add(txtMaSV);
        frame.add(txtHoTen);
        frame.add(txtEmail);
        frame.add(txtSoDT);
        frame.add(scrollPane);
        frame.add(jrdNam);
        frame.add(jrdNu);
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnSave);
        frame.add(p1);
        btnFirst.addActionListener(this);
        btnLast.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnSave.addActionListener(this);
        btnTimKiem.addActionListener(this);
    }

    public void Display(int i) {
        Student st = array.get(i);
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
                Student sv = new Student(masv, hoten, email, sodt, diachi, gt);
                array.add(sv);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnLast) {
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
                JOptionPane.showMessageDialog(this, "Nhập Mã SV");
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
                    JOptionPane.showMessageDialog(this, "Delete thành công!");

                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi delete!");
                }
            }

        }
        if (ae.getSource() == btnUpdate) {
            if (txtMaSV.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Nhập Mã SV!");
                txtMaSV.requestFocus();
                return;

            } else {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql = "update STUDENTS set HoTen =? , Email =? , SoDT = ?,DiaChi = ?,"
                            + "GioiTinh =? where MaSV =?";
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
                    JOptionPane.showMessageDialog(this, "Update thành công!");
                    con.close();
                    LoadDataArray();
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi update!");
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
                JOptionPane.showMessageDialog(this, "Save thành công!");
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Mã Sinh Viên này đã tồn tại!");
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
                    if(gt==true){
                        jrdNam.setSelected(true);
                    }else
                        jrdNu.setSelected(true);
                    return;
                }
                
                JOptionPane.showMessageDialog(this,"Không có mã sinh viên này!");
                con.close();

            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        new Bai2();
    }

}
