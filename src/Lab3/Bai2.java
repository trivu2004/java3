/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author USER
 */
public class Bai2 extends JFrame implements ActionListener {

    JFrame frame;
    JPanel p1, p2, p3, p4, p5, p6;
    JLabel lblHo, lblTen, lblBidanh, lblMatMa, lblQueQuan, lblSothich, lblGhiChu;
    JTextField txtHo, txtTen, txtBidanh;
    JPasswordField txtPassword;
    JRadioButton rdbtnNam, rdbtnNu, rdbtnKXD;
    JComboBox jcbQueQuan;
    JCheckBox jcbAnchoi, jcbNhaymua, jcbNgunghi;
    JButton btnOK, btnReset, btnExit;
    JTextArea txtGhiChu;

    Object[] ob = new Object[]{"An Giang", "Bà Rịa-Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn",
        "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau",
        "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp",
        "Gia Lai", "Hà Giang", "Hà Nam", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình",
        "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai",
        "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam",
        "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa",
        "Thừa Thiên Huế", "Tiền Giang", "Tp Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"};

    public Bai2() {
        GUI();
        frame.setVisible(true);
    }

    public void GUI() {
        frame = new JFrame();
        frame.setSize(700, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        p1 = new JPanel();
        p1.setBounds(10, 10, 650, 150);
        p1.setBackground(Color.green);
        p1.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 3), "Ho ten", TitledBorder.CENTER, TitledBorder.TOP,
                new Font("Roboto", Font.BOLD, 18), Color.red));
        p1.setLayout(null);

        lblHo = new JLabel("Ho: ");
        lblHo.setBounds(20, 30, 100, 50);
        lblHo.setFont(new Font("Roboto", Font.BOLD, 18));
        txtHo = new JTextField();
        txtHo.setBounds(80, 40, 200, 30);
        txtHo.setFont(new Font("Roboto", Font.BOLD, 18));

        lblTen = new JLabel("Ten: ");
        lblTen.setBounds(320, 30, 100, 50);
        lblTen.setFont(new Font("Roboto", Font.BOLD, 18));
        txtTen = new JTextField();
        txtTen.setBounds(370, 40, 200, 30);
        txtTen.setFont(new Font("Roboto", Font.BOLD, 18));

        lblBidanh = new JLabel("Bi danh: ");
        lblBidanh.setBounds(10, 80, 100, 50);
        lblBidanh.setFont(new Font("Roboto", Font.BOLD, 18));
        txtBidanh = new JTextField();
        txtBidanh.setBounds(80, 90, 200, 30);
        txtBidanh.setFont(new Font("Roboto", Font.BOLD, 18));

        lblMatMa = new JLabel("Mat Ma: ");
        lblMatMa.setBounds(300, 80, 100, 50);
        lblMatMa.setFont(new Font("Roboto", Font.BOLD, 18));
        txtPassword = new JPasswordField();
        txtPassword.setBounds(370, 90, 200, 30);
        txtPassword.setFont(new Font("Roboto", Font.BOLD, 18));

        p2 = new JPanel();
        p2.setBounds(10, 200, 650, 100);
        p2.setBackground(Color.yellow);
        p2.setBorder(new TitledBorder(new LineBorder(Color.red, 3), "Gioi tinh", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Roboto", Font.BOLD, 18), Color.BLUE));
        p2.setLayout(null);

        rdbtnNam = new JRadioButton("Nam");
        rdbtnNam.setBounds(100, 30, 100, 50);

        rdbtnNu = new JRadioButton("Nu");
        rdbtnNu.setBounds(250, 30, 100, 50);

        rdbtnKXD = new JRadioButton("Khong Xac Dinh");
        rdbtnKXD.setBounds(400, 30, 130, 50);
        ButtonGroup bt = new ButtonGroup();
        bt.add(rdbtnNu);
        bt.add(rdbtnNam);
        bt.add(rdbtnKXD);

        p3 = new JPanel();
        p3.setBounds(10, 330, 650, 300);
        p3.setBackground(Color.red);
        p3.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 3), "Thong tin khac", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Roboto", Font.BOLD, 18), Color.green));
        p3.setLayout(null);

        lblQueQuan = new JLabel("Que Quan: ");
        lblQueQuan.setBounds(20, 20, 120, 70);
        lblQueQuan.setFont(new Font("Roboto", Font.BOLD, 22));
        lblQueQuan.setForeground(Color.yellow);
        jcbQueQuan = new JComboBox(ob);
        jcbQueQuan.setBounds(140, 37, 140, 40);
        jcbQueQuan.setFont(new Font("Roboto", Font.BOLD, 22));

        lblSothich = new JLabel("So Thich: ");
        lblSothich.setBounds(30, 100, 120, 50);
        lblSothich.setFont(new Font("Roboto", Font.BOLD, 22));
        lblSothich.setForeground(Color.yellow);
        jcbAnchoi = new JCheckBox("An choi");
        jcbAnchoi.setBounds(140, 105, 100, 40);

        jcbNhaymua = new JCheckBox("Nhay mua");
        jcbNhaymua.setBounds(280, 105, 100, 40);

        jcbNgunghi = new JCheckBox("Ngu nghi");
        jcbNgunghi.setBounds(420, 105, 100, 40);

        lblGhiChu = new JLabel("Ghi Chu: ");
        lblGhiChu.setBounds(40, 170, 120, 50);
        lblGhiChu.setFont(new Font("Roboto", Font.BOLD, 22));
        lblGhiChu.setForeground(Color.yellow);
        txtGhiChu = new JTextArea(50, 0);
        txtGhiChu.setLineWrap(true);
//        txtGhiChu.setBounds(140, 185, 450, 90);
        txtGhiChu.setFont(new Font("Roboto", Font.BOLD, 22));
        JScrollPane scrollPane = new JScrollPane(txtGhiChu);
        scrollPane.setBounds(140, 185, 450, 100);

        p4 = new JPanel();
        p4.setBounds(180, 650, 350, 50);
        p4.setLayout(new GridLayout(1, 3, 10, 10));

        btnOK = new JButton("OK");
        btnOK.setFont(new Font("Roboto", Font.BOLD, 20));

        btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Roboto", Font.BOLD, 20));

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Roboto", Font.BOLD, 20));

        p1.add(lblHo);
        p1.add(txtHo);
        p1.add(lblTen);
        p1.add(txtTen);
        p1.add(lblBidanh);
        p1.add(txtBidanh);
        p1.add(lblMatMa);
        p1.add(txtPassword);
        p2.add(rdbtnNam);
        p2.add(rdbtnNu);
        p2.add(rdbtnKXD);
        p3.add(lblQueQuan);
        p3.add(lblSothich);
        p3.add(lblGhiChu);
        p3.add(jcbQueQuan);
        p3.add(jcbAnchoi);
        p3.add(jcbNhaymua);
        p3.add(jcbNgunghi);
//        p3.add(txtGhiChu);
        p4.add(btnOK);
        p4.add(btnReset);
        p4.add(btnExit);
        p3.add(scrollPane);

        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int ret = JOptionPane.showConfirmDialog(null,"Ban co muon dong chuong trinh khong!","Confign",JOptionPane.YES_NO_OPTION);
                if(ret==JOptionPane.YES_OPTION){
                    System.exit(0);
                }else if(ret==JOptionPane.NO_OPTION){
                    setDefaultCloseOperation(0);
                }
                
            }
        });
        btnOK.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);

    }

    public String kk() {
        if (rdbtnNam.isSelected()) {
            return "Nam";
        } else if (rdbtnNu.isSelected()) {
            return "Nu";
        } else {
            return "KXD";
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnExit) {
            System.exit(0);
        }
        if (ae.getSource() == btnReset) {
            txtHo.setText("");
            txtTen.setText("");
            txtBidanh.setText("");
            txtPassword.setText("");

            rdbtnNam.setSelected(false);
            rdbtnNu.setSelected(false);
            rdbtnKXD.setSelected(false);

            jcbQueQuan.setSelectedIndex(-1);
            jcbAnchoi.setSelected(false);
            jcbNhaymua.setSelected(false);
            jcbNgunghi.setSelected(false);

            txtGhiChu.setText("");
        }
        if (ae.getSource() == btnOK) {
            JOptionPane.showMessageDialog(this, "Ho ten: " + txtHo.getText() + " " + txtTen.getText() + "\n" + "Que quan: "
                    + jcbQueQuan.getSelectedItem() + "\n" + "Gioi tinh: " + kk(),"Thong tin sinh vien",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Bai2();
    }

}
