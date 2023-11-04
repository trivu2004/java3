package Lab5.View;

import Lab5.Control.ControlLab5Bai2;
import Lab5.Model.ModelBai2;
import Lab5.Student;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class ViewLab5Bai2 extends JFrame {

    JFrame frame;
    JLabel lblHeader, lblMaSV, lblHoTen, lblEmail, lblSoDT, lblGioiTinh, lblDiaChi, lblTimKiem;
    JPanel p1, p2, p3, p4;
    JButton btnAdd, btnDelete, btnUpdate, btnSave, btnFirst, btnNext, btnPrevious, btnLast, btnTimKiem;
    JTextArea txtDiaChi;
    JTextField txtMaSV, txtHoTen, txtEmail, txtSoDT, txtTimKiem;
    JRadioButton jrdNam, jrdNu;
    ButtonGroup bt;

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnFirst() {
        return btnFirst;
    }

    public JButton getBtnNext() {
        return btnNext;
    }

    public JButton getBtnPrevious() {
        return btnPrevious;
    }

    public JButton getBtnLast() {
        return btnLast;
    }

    public JButton getBtnTimKiem() {
        return btnTimKiem;
    }

    public JTextArea getTxtDiaChi() {
        return txtDiaChi;
    }

    public JTextField getTxtMaSV() {
        return txtMaSV;
    }

    public JTextField getTxtHoTen() {
        return txtHoTen;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtSoDT() {
        return txtSoDT;
    }

    public JTextField getTxtTimKiem() {
        return txtTimKiem;
    }

    public JRadioButton getJrdNam() {
        return jrdNam;
    }

    public JRadioButton getJrdNu() {
        return jrdNu;
    }

    public ButtonGroup getBt() {
        return bt;
    }

    public ViewLab5Bai2() {
        myGUI();
        frame.setVisible(true);
        ControlLab5Bai2 controlLab5Bai2 = new ControlLab5Bai2(this);
        controlLab5Bai2.LoadDataArray();
        controlLab5Bai2.Display(controlLab5Bai2.getCurrent());
        controlLab5Bai2.kk();
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

        btnTimKiem = new JButton("Search", new ImageIcon("E:\\PS31493\\src\\Icon\\b.png"));
        btnTimKiem.setBounds(730, 45, 130, 50);
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
        
        JLabel lblTongCong = new JLabel("Tổng Cộng");
        lblTongCong.setBounds(800, 300, 100, 50);
        
        JTextField txtTongCong = new JTextField();
        txtTongCong.setBounds(800, 400, 100, 50);

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
        frame.add(lblTongCong);
        frame.add(txtTongCong);

    }

    public static void main(String[] args) {
        new ViewLab5Bai2();
    }

}
