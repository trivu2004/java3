package Thi1;

import Lab5.Student;
import exam.QuanLyThueXe;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Bai1 extends JFrame implements ActionListener, MouseListener {

    ArrayList<QuanLyThueXe> array = new ArrayList<QuanLyThueXe>();
    int current = 0;
    private JFrame frame;
    private JLabel lblHeader, lblBienSoXe, lblLoaiXe, lblNgayMuon, lblNgayTra, lblThanhTien;
    private JComboBox jcbLoaiXe;
    private JPanel p1;
    private JTextField txtBienSoxe, txtNgayMuon, txtNgayTra, txtThanhTien;
    private JButton btnNew, btnDelete, btnUpdate, btnSave, btnFirst, btnNext, btnPrevious, btnLast;
    String[] col = new String[]{"Biển Số Xe", "Loại Xe", "Ngày Mượn", "Ngày Trả", "Thành Tiền"};
    DefaultTableModel model = new DefaultTableModel(col, 0);
    JTable table;
    JScrollPane jsp;
    String url = "jdbc:mysql://localhost:3306/Thi1";
    String user = "root";
    String password = "123456";
    int rowIndex;

    Object[] ob = new Object[]{"Xe 4 chỗ", "Xe 7 chỗ"};

    public Bai1() {
        myGUI();
        fill();
        reset();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thay đổi trước khi thoát không?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    if (txtBienSoxe.getText().equals("") && txtNgayMuon.getText().equals("") && txtNgayTra.getText().equals("")
                            && txtThanhTien.getText().equals("")) {
                        System.exit(0);
                    }
                    save();
                } else if (confirmed == JOptionPane.NO_OPTION) {
                    setDefaultCloseOperation(0);
                } else {
                    setDefaultCloseOperation(0);
                }
            }
        }
        );
    }

    public void myGUI() {
        frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        lblHeader = new JLabel("Quản lý cho thuê xe");
        lblHeader.setBounds(250, 20, 400, 100);
        lblHeader.setFont(new Font("Roboto", Font.BOLD, 25));
        lblHeader.setForeground(Color.blue);
        frame.add(lblHeader);

        lblBienSoXe = new JLabel("Biển số xe");
        lblBienSoXe.setBounds(30, 130, 100, 50);
        lblBienSoXe.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblBienSoXe);

        txtBienSoxe = new JTextField();
        txtBienSoxe.setBounds(140, 135, 300, 40);
        frame.add(txtBienSoxe);

        lblLoaiXe = new JLabel("Loại xe");
        lblLoaiXe.setBounds(30, 180, 100, 50);
        lblLoaiXe.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblLoaiXe);

        jcbLoaiXe = new JComboBox(ob);
        jcbLoaiXe.setBounds(140, 180, 200, 50);
        frame.add(jcbLoaiXe);

        lblNgayMuon = new JLabel("Ngày Mượn");
        lblNgayMuon.setBounds(20, 230, 120, 50);
        lblNgayMuon.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblNgayMuon);

        txtNgayMuon = new JTextField();
        txtNgayMuon.setBounds(140, 235, 300, 40);
        frame.add(txtNgayMuon);

        lblNgayTra = new JLabel("Ngày Trả");
        lblNgayTra.setBounds(30, 280, 100, 50);
        lblNgayTra.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblNgayTra);

        txtNgayTra = new JTextField();
        txtNgayTra.setBounds(140, 285, 300, 40);
        frame.add(txtNgayTra);

        lblThanhTien = new JLabel("Thành Tiền");
        lblThanhTien.setBounds(30, 330, 100, 50);
        lblThanhTien.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblThanhTien);

        txtThanhTien = new JTextField();
        txtThanhTien.setBounds(140, 340, 300, 40);
        frame.add(txtThanhTien);
        txtThanhTien.setEnabled(false);

        table = new JTable(model);
        jsp = new JScrollPane(table);
        jsp.setBounds(30, 400, 700, 180);
        frame.add(jsp);

        btnNew = new JButton("New", new ImageIcon("E:\\PS31493\\src\\Icon\\Them1.png"));
        btnNew.setBounds(450, 120, 170, 55);
        btnNew.setFont(new Font("Roboto", Font.PLAIN, 22));
        btnNew.setBackground(new Color(204, 255, 255));
        btnNew.setForeground(Color.red);

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
        p1.setBounds(150, 650, 400, 60);
        p1.setLayout(new GridLayout(1, 4, 30, 30));
        p1.setBackground(new Color(224, 224, 224));

        btnFirst = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\dau.png"));
        btnFirst.setBackground(new Color(204, 255, 255));
        btnLast = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\cuoi.png"));
        btnLast.setBackground(new Color(204, 255, 255));
        btnPrevious = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\len.png"));
        btnPrevious.setBackground(new Color(204, 255, 255));
        btnNext = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\xuong.png"));
        btnNext.setBackground(new Color(204, 255, 255));

        frame.add(btnNew);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnSave);
        p1.add(btnPrevious);
        p1.add(btnFirst);
        p1.add(btnLast);
        p1.add(btnNext);
        frame.add(p1);
        frame.setVisible(true);
        btnDelete.addActionListener(this);
        btnFirst.addActionListener(this);
        btnLast.addActionListener(this);
        btnNew.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
        btnSave.addActionListener(this);
        btnUpdate.addActionListener(this);
        table.addMouseListener(this);
    }

    public void fill() {
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement sta = con.createStatement();
            String sql = "select * from Rentals";
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String biensoxe = rs.getString("BienSX");
                String loaixe = rs.getString("LoaiXe");
                String ngaymuon = rs.getString("NgayMuon");
                String ngaytra = rs.getString("NgayTra");
                String thanhtien = rs.getString("ThanhTien");
                Object[] newdata = {biensoxe, loaixe, ngaymuon, ngaytra, thanhtien};
                model.addRow(newdata);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void reset() {
        txtBienSoxe.setText("");
        txtNgayMuon.setText("");
        txtNgayTra.setText("");
        txtThanhTien.setText("");
        jcbLoaiXe.setSelectedIndex(-1);
    }

    public void Update() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "update Rentals set LoaiXe = ?, NgayMuon = ?, NgayTra = ?, ThanhTien = ? where BienSX = ? ";
            PreparedStatement presta = con.prepareStatement(sql);

            LocalDate ngayMuonDate = LocalDate.parse(txtNgayMuon.getText());
            LocalDate ngayTraDate = LocalDate.parse(txtNgayTra.getText());
            double thanhTien = calculateThanhTien(ngayMuonDate, ngayTraDate, String.valueOf(jcbLoaiXe.getSelectedItem()));

            presta.setString(1, String.valueOf(jcbLoaiXe.getSelectedItem()));
            presta.setString(2, txtNgayMuon.getText());
            presta.setString(3, txtNgayTra.getText());
            presta.setDouble(4, thanhTien);
            presta.setString(5, txtBienSoxe.getText());
            presta.executeUpdate();
            con.close();
            fill();
            JOptionPane.showMessageDialog(null, "Update thành công!");
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi update!");
        }
    }

    public void deleteRecord() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM Rentals WHERE BienSX = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, txtBienSoxe.getText());
            preparedStatement.executeUpdate();
            con.close();
            fill();
            JOptionPane.showMessageDialog(null, "Delete thành công!");
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi delete!");
        }
    }

    public boolean Check() {
        if (txtBienSoxe.getText().equals("")) {
            return false;
        }
        if (txtNgayMuon.getText().equals("")) {
            return false;
        }
        if (txtNgayTra.getText().equals("")) {
            return false;
        }
        if (txtThanhTien.getText().equals("")) {
            return false;
        }
        int indexx = jcbLoaiXe.getSelectedIndex();
        if (indexx == -1) {
            return false;
        }
        return true;
    }
    private static final double GIA_XE_4_CHO = 500000;
    private static final double GIA_XE_7_CHO = 700000;

    private int calculateDaysBetween(LocalDate startDate, LocalDate endDate) {
        return (int) java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
    }

    private double calculateThanhTien(LocalDate ngayMuon, LocalDate ngayTra, String loaiXe) {
        int soNgay = calculateDaysBetween(ngayMuon, ngayTra);
        double giaThue = 0;

        if ("Xe 4 chỗ".equals(loaiXe)) {
            giaThue = GIA_XE_4_CHO;
        } else if ("Xe 7 chỗ".equals(loaiXe)) {
            giaThue = GIA_XE_7_CHO;
        }

        return soNgay * giaThue;
    }

    public void save() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO Rentals (BienSX, LoaiXe, NgayMuon, NgayTra, ThanhTien) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement presta = con.prepareStatement(sql);
            String bienSoXe = txtBienSoxe.getText();
            String loaiXe = String.valueOf(jcbLoaiXe.getSelectedItem());
            String ngayMuon = txtNgayMuon.getText();
            String ngayTra = txtNgayTra.getText();
            LocalDate ngayMuonDate = LocalDate.parse(ngayMuon);
            LocalDate ngayTraDate = LocalDate.parse(ngayTra);
            double thanhTien = calculateThanhTien(ngayMuonDate, ngayTraDate, loaiXe);

            presta.setString(1, bienSoXe);
            presta.setString(2, loaiXe);
            presta.setString(3, ngayMuon);
            presta.setString(4, ngayTra);
            presta.setString(5, String.valueOf(thanhTien));
            presta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm mới thành công!");

            fill();
            reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Bai1();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnDelete) {
            deleteRecord();
        }
        if (ae.getSource() == btnUpdate) {
            Update();
        }
        if (ae.getSource() == btnNew) {
            reset();
        }

        if (ae.getSource() == btnSave) {
            save();
        }
        if (ae.getSource() == btnNext) {
            rowIndex = model.getRowCount() - 1;
            showRecordAtIndex(rowIndex);
            JOptionPane.showMessageDialog(null, "Bạn đang ở cuối danh sách!");
        }

        if (ae.getSource() == btnPrevious) {
            rowIndex = 0;
            showRecordAtIndex(rowIndex);
            JOptionPane.showMessageDialog(null, "Bạn đang ở đầu danh sách!");
        }

        if (ae.getSource() == btnLast) {
            if (rowIndex < model.getRowCount() - 1) {
                rowIndex++;
                showRecordAtIndex(rowIndex);
            }
        }

        if (ae.getSource() == btnFirst) {
            if (rowIndex > 0) {
                rowIndex--;
                showRecordAtIndex(rowIndex);
            }
        }
    }

    private void showRecordAtIndex(int index) {
        if (index >= 0 && index < model.getRowCount()) {
            txtBienSoxe.setText(model.getValueAt(index, 0).toString());
            jcbLoaiXe.setSelectedItem(model.getValueAt(index, 1));
            txtNgayMuon.setText(model.getValueAt(index, 2).toString());
            txtNgayTra.setText(model.getValueAt(index, 3).toString());
            txtThanhTien.setText(model.getValueAt(index, 4).toString());
            table.setRowSelectionInterval(index, index);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            rowIndex = table.rowAtPoint(me.getPoint()) + 1;
            String sql = "SELECT * FROM Rentals LIMIT ?, 1";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, rowIndex - 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String biensoxe = rs.getString("BienSX");
                String loaixe = rs.getString("LoaiXe");
                String ngaymuon = rs.getString("NgayMuon");
                String ngaytra = rs.getString("NgayTra");
                String thanhtien = rs.getString("ThanhTien");

                txtBienSoxe.setText(biensoxe);
                jcbLoaiXe.setSelectedItem(loaixe);
                txtNgayMuon.setText(ngaymuon);
                txtNgayTra.setText(ngaytra);
                txtThanhTien.setText(thanhtien);

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
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
