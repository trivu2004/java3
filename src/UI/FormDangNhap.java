/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import ENTITY.Users;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author USER
 */
public class FormDangNhap extends JFrame implements ActionListener, MouseListener {

    ArrayList<Users> array = new ArrayList<>();
    ArrayList<SinhVien> list = new ArrayList<>();

    JFrame frame, loginFrame;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnLogin, btnCancel;
    JPanel pan1, pan2, pan3, pan4, pan5;
    JLabel lblheader, lblMaSV, lblHoTen, lblEmail, lblSDT, lblGioiTinh, lblDiaChi, lblHinhAnh;
    JTextField txtMaSV, txtHoTen, txtEmail, txtSDT;
    JTextArea txtDiaChi;
    JRadioButton jrdNam, jrdNu;
    DefaultTableModel model;
    JTable tblSinhVien;
    JButton btnNew, btnSave, btnDelete, btnUpdate;
    String img;
    ButtonGroup bt;
    private int index = 3;
    String strhinhAnh = "";
    String url = "jdbc:mysql://localhost:3306/ASM";
    String user = "root";
    String password = "123456";
    int current = 0;
    int rowIndex;
    boolean gt;

    public FormDangNhap() {
        String[] cot = {"MaSV", "Ho Ten", "Email", "So DT", "Dia Chi", "Gioi Tinh", "Hinh"};
        model = new DefaultTableModel(cot, 0);
        myGUI();
        frame.setVisible(true);
        addData();
        LoadDataArray();
        fillTotable();
        kk();
    }

    public FormDangNhap(String user) {
        myGUI();
        frame.setVisible(true);
        kk();
        frame.setTitle("Quản Lý Sinh Viên");

    }

    public void myGUI() {
        frame = new JFrame();
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(10, 10, 100, 30);
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel p2 = new JPanel();
        p2.setBounds(20, 50, 500, 230);
        p2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        p2.setLayout(null);

        JLabel lblUsername = new JLabel("User Name: ");
        lblUsername.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblUsername.setBounds(10, 10, 100, 50);

        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblPassword.setBounds(10, 70, 100, 50);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Roboto", Font.PLAIN, 18));
        txtUsername.setBounds(120, 10, 300, 50);
        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Roboto", Font.PLAIN, 18));
        txtPassword.setBounds(120, 70, 300, 50);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 150, 100, 50);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(280, 150, 100, 50);

        loginFrame = new JFrame();
        loginFrame.setSize(1400, 1000);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setLayout(null);

        pan1 = new JPanel();
        pan1.setBounds(300, 20, 300, 50);
        lblheader = new JLabel("Quan Ly Sinh Vien");
        lblheader.setFont(new Font("Roboto", Font.BOLD, 30));
        lblheader.setForeground(Color.blue);

        pan2 = new JPanel();
        pan2.setBounds(100, 100, 500, 360);
        pan2.setLayout(null);

        lblMaSV = new JLabel("MaSV: ");
        lblMaSV.setBounds(17, 10, 100, 30);
        lblMaSV.setFont(new Font("Roboto", Font.PLAIN, 20));

        lblHoTen = new JLabel("Ho Ten: ");
        lblHoTen.setBounds(5, 50, 100, 30);
        lblHoTen.setFont(new Font("Roboto", Font.PLAIN, 20));

        lblEmail = new JLabel("Email: ");
        lblEmail.setBounds(20, 100, 100, 30);
        lblEmail.setFont(new Font("Roboto", Font.PLAIN, 20));

        lblSDT = new JLabel("So DT: ");
        lblSDT.setBounds(20, 150, 100, 30);
        lblSDT.setFont(new Font("Roboto", Font.PLAIN, 20));

        lblGioiTinh = new JLabel("Gioi Tinh: ");
        lblGioiTinh.setBounds(0, 200, 100, 30);
        lblGioiTinh.setFont(new Font("Roboto", Font.PLAIN, 20));

        lblDiaChi = new JLabel("Dia Chi: ");
        lblDiaChi.setBounds(15, 240, 100, 30);
        lblDiaChi.setFont(new Font("Roboto", Font.PLAIN, 20));

        txtMaSV = new JTextField();
        txtMaSV.setBounds(90, 10, 300, 30);
        txtMaSV.setFont(new Font("Roboto", Font.PLAIN, 20));

        txtHoTen = new JTextField();
        txtHoTen.setBounds(90, 50, 300, 30);
        txtHoTen.setFont(new Font("Roboto", Font.PLAIN, 20));

        txtEmail = new JTextField();
        txtEmail.setBounds(90, 100, 300, 30);
        txtEmail.setFont(new Font("Roboto", Font.PLAIN, 20));

        txtSDT = new JTextField();
        txtSDT.setBounds(90, 150, 300, 30);
        txtSDT.setFont(new Font("Roboto", Font.PLAIN, 20));

        txtDiaChi = new JTextArea(50, 50);
//        txtDiaChi.setLineWrap(true);
        txtDiaChi.setFont(new Font("Roboto", Font.BOLD, 22));
        JScrollPane scrollPane = new JScrollPane(txtDiaChi);
        scrollPane.setBounds(90, 245, 350, 100);

        jrdNam = new JRadioButton("Nam");
        jrdNam.setBounds(110, 200, 80, 30);
        jrdNam.setFont(new Font("Roboto", Font.PLAIN, 20));

        jrdNu = new JRadioButton("Nu");
        jrdNu.setBounds(190, 200, 100, 30);
        jrdNu.setFont(new Font("Roboto", Font.PLAIN, 20));

        bt = new ButtonGroup();
        bt.add(jrdNam);
        bt.add(jrdNu);

        tblSinhVien = new JTable(model);
        tblSinhVien.setFont(new Font("Serif", Font.BOLD, 17));
        JTableHeader header = tblSinhVien.getTableHeader();
        Font font = new Font("Serif", Font.BOLD, 20);
        header.setFont(font);
        header.setForeground(Color.red);
        tblSinhVien.setPreferredScrollableViewportSize(new Dimension(1200, 200));
        JScrollPane scrollPane1 = new JScrollPane(tblSinhVien);
        tblSinhVien.addMouseListener(this);
        pan3 = new JPanel();
        pan3.setBounds(0, 500, 1400, 400);
        pan3.add(scrollPane1);

        pan4 = new JPanel();
        pan4.setBounds(600, 100, 200, 200);
        pan4.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        pan4.setLayout(null);

        lblHinhAnh = new JLabel("Hinh anh");
        lblHinhAnh.setBounds(0, 0, 200, 200);
        lblHinhAnh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                try {
                    Image img = ImageIO.read(file);
                    strhinhAnh = file.getName();
                    int width = pan4.getWidth();
                    int height = pan4.getHeight();
                    lblHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
                    lblHinhAnh.setText(strhinhAnh);
                    System.out.println(img.getScaledInstance(width, height, 0));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        pan5 = new JPanel();
        pan5.setBounds(600, 350, 300, 150);
        pan5.setLayout(new GridLayout(2, 2, 30, 30));

        btnNew = new JButton("New", new ImageIcon("E:\\PS31493\\src\\Icon\\Them1.png"));
        btnSave = new JButton("Save", new ImageIcon("E:\\PS31493\\src\\Icon\\Luu1.png"));
        btnDelete = new JButton("Delete", new ImageIcon("E:\\PS31493\\src\\Icon\\delete.png"));
        btnUpdate = new JButton("Update", new ImageIcon("E:\\PS31493\\src\\Icon\\update.png"));

        p1.add(lblLogin);
        p2.add(lblUsername);
        p2.add(lblPassword);
        p2.add(txtUsername);
        p2.add(txtPassword);
        p2.add(btnLogin);
        p2.add(btnCancel);
        frame.add(p1);
        frame.add(p2);

        pan1.add(lblheader);
        pan2.add(lblMaSV);
        pan2.add(lblHoTen);
        pan2.add(lblEmail);
        pan2.add(lblSDT);
        pan2.add(lblGioiTinh);
        pan2.add(lblDiaChi);
        pan2.add(txtMaSV);
        pan2.add(txtHoTen);
        pan2.add(txtEmail);
        pan2.add(txtSDT);
        pan2.add(jrdNam);
        pan2.add(jrdNu);
        pan2.add(scrollPane);
        pan4.add(lblHinhAnh);
        pan5.add(btnNew);
        pan5.add(btnSave);
        pan5.add(btnDelete);
        pan5.add(btnUpdate);

        loginFrame.add(pan1);
        loginFrame.add(pan2);
        loginFrame.add(pan3);
        loginFrame.add(pan4);
        loginFrame.add(pan5);
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);

        btnNew.addActionListener(this);
        btnSave.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);

    }

    public void kk() {
        array.add(new Users("admin", "123456"));
        array.add(new Users("tri", "123"));
    }

    public static void main(String[] args) {
        new FormDangNhap();

    }

    public void addData() {
    }

    public void fillTotable() {
        model.setRowCount(0);
        for (SinhVien sinhVien : list) {
            Object[] row = new Object[]{sinhVien.maSV, sinhVien.hoTen, sinhVien.Email, sinhVien.soDT, sinhVien.diaChi, sinhVien.gioiTinh,strhinhAnh};
            model.addRow(row);
        }
    }

    public void Display(int i) {
        SinhVien sv = list.get(i);
        txtDiaChi.setText(sv.diaChi);
        txtEmail.setText(sv.Email);
        txtHoTen.setText(sv.hoTen);
        txtMaSV.setText(sv.maSV);
        txtSDT.setText(sv.soDT);
        boolean gt = sv.gioiTinh;
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
            String sql = "select * from Students";
            ResultSet rs = sta.executeQuery(sql);
            list.clear();
            while (rs.next()) {
                String masv = rs.getString("MaSV");
                String hoten = rs.getString("Hoten");
                String email = rs.getString("Email");
                String sodt = rs.getString("SoDT");
                String diachi = rs.getString("Diachi");
                gt = rs.getBoolean("Gioitinh");
                SinhVien sv = new SinhVien(masv, hoten, email, sodt, diachi, gt);
                list.add(sv);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean Check() {
        if (txtUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhap User name");
            txtUsername.requestFocus();
            return false;
        }
        if (txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhap Password");
            txtPassword.requestFocus();
            return false;
        }
        Matcher matcher = Pattern.compile(EMAIL_VERIFICATION).matcher(txtEmail.getText());
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Email sai định dạng");
            return false;
        }
        Matcher matcherId = Pattern.compile(ID_PATTEN).matcher(txtMaSV.getText());

        if (!matcherId.matches()) {
            JOptionPane.showMessageDialog(null, "Mã sinh viên không chính xác\nMã sinh viên gồm sv + 3 số phía sau\nVí dụ: sv001");
            return false;
        }
        Matcher matcherSDT = Pattern.compile(SDT_PATTEN).matcher(txtSDT.getText());

        if (!matcherSDT.matches()) {
            JOptionPane.showMessageDialog(null, "Số điện thoại sai định dạng");
            return false;
        }

        return true;
    }
    public static final String SDT_PATTEN = "0[0-9]{9}";
    public static final String EMAIL_VERIFICATION = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
    public static final String ID_PATTEN = "sv[0-9]{3}";

    public String gt() {
        if (jrdNam.isSelected()) {
            return "Nam";
        } else {
            return "Nu";
        }
    }

    public void Reset() {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        bt.clearSelection();
        txtDiaChi.setText("");
        lblHinhAnh.setIcon(null);
        strhinhAnh = "";
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnCancel) {
            System.exit(0);
        }
        if (ae.getSource() == btnLogin) {
            for (Users users : array) {
                if (users.getUserName().equals(txtUsername.getText()) & users.getPassWord().equals(txtPassword.getText())) {
                    if (txtUsername.getText().equals("tri") & txtPassword.getText().equals("123")) {
                        JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                        new FormDiem();
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Dang nhap thanh cong");
                        loginFrame.setVisible(true);
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "Sai Username hoac Password!");
        }
        if (ae.getSource() == btnDelete) {
            if (txtMaSV.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Nhập Mã SV");
                txtMaSV.requestFocus();
                return;
            } else {
                int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, user, password);
                        String sql = "DELETE FROM Students WHERE MaSV = ?";
                        PreparedStatement pre = con.prepareStatement(sql);
                        pre.setString(1, txtMaSV.getText());
                        pre.execute();
                        LoadDataArray();
                        fillTotable();
                        JOptionPane.showMessageDialog(this, "Delete thành công!");
                        Reset();
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Lỗi delete!");
                    }
                }
            }

        }

        if (ae.getSource() == btnNew) {
            Reset();
        }
        if (ae.getSource() == btnSave) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                String sql = "insert into Students values(?,?,?,?,?,?,?)";
                PreparedStatement presta = con.prepareStatement(sql);
                presta.setString(1, txtMaSV.getText());
                presta.setString(2, txtHoTen.getText());
                presta.setString(3, txtEmail.getText());
                presta.setString(4, txtSDT.getText());
                presta.setString(5, txtDiaChi.getText());
                boolean gt;
                if (jrdNam.isSelected()) {
                    gt = true;
                } else {
                    gt = false;
                }
                presta.setBoolean(6, gt);
                presta.setString(7, lblHinhAnh.getText()+"");
                presta.executeUpdate();
                LoadDataArray();
                fillTotable();
                JOptionPane.showMessageDialog(this, "Save thành công!");
                Reset();
                lblHinhAnh.setText("hình ảnh");
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Mã Sinh Viên này đã tồn tại!");
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
                    String sql = "update Students set Hoten =? , Email =? , SoDT = ?,DiaChi = ?,"
                            + "GioiTinh =? where MaSV =?";
                    PreparedStatement presta = con.prepareStatement(sql);
                    presta.setString(1, txtHoTen.getText());
                    presta.setString(2, txtEmail.getText());
                    presta.setString(3, txtSDT.getText());
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
                    LoadDataArray();
                    fillTotable();
                    JOptionPane.showMessageDialog(this, "Update thành công!");
                    Reset();
                    con.close();

                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi update!");
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            rowIndex = tblSinhVien.rowAtPoint(me.getPoint()) + 1;
            String sql = "SELECT * FROM Students LIMIT ?, 1";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, rowIndex - 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String masv = rs.getString("MaSV");
                String namee = rs.getString("Hoten");
                String email = rs.getString("Email");
                String sodt = rs.getString("SoDT");
                String diachi = rs.getString("Diachi");
                boolean gt = rs.getBoolean("Gioitinh");
                if (gt) {
                    jrdNam.setSelected(true);
                } else {
                    jrdNu.setSelected(true);
                }
                String hinhanh = rs.getString("hinhanh");
                txtMaSV.setText(masv);
                txtHoTen.setText(namee);
                txtEmail.setText(email);
                txtSDT.setText(sodt);
                txtDiaChi.setText(diachi);
                lblHinhAnh.setText(hinhanh);
            }
            rs.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
