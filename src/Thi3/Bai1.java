package Thi3;

import static UI.FormDangNhap.ID_PATTEN;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private JFrame frame;
    private JLabel lblHeader, lblMaSP, lblLoai, lblGia, lblSoLuong, lblThanhTien,lblTimKiem;
    private JComboBox jcbLoai;
    private JPanel p1;
    private JTextField txtMaSP, txtGia, txtSoLuong, txtThanhTien, txtTennv,txtTimKiem;
    private JButton btnNew, btnDelete, btnUpdate, btnSave, btnFirst, btnNext, btnPrevious, btnLast,btnTimKiem;
    String[] col = new String[]{"Mã nhân viên", "Tên nhân viên", "Mức lương", "Số ngày công", "Thực lãnh"};
    DefaultTableModel model = new DefaultTableModel(col, 0);
    JTable table;
    JScrollPane jsp;
    String url = "jdbc:mysql://localhost:3306/Thi1";
    String user = "root";
    String password = "123456";
    int rowIndex;
    Object[] ob = new Object[]{"Mức 1", "Mức 2", "Mức 3"};

    public Bai1() {
        myGUI();
        fill();
        reset();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thay đổi trước khi thoát không?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    if (txtMaSP.getText().equals("")) {
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

        lblHeader = new JLabel("Quản lý nhân sự");
        lblHeader.setBounds(250, 10, 400, 100);
        lblHeader.setFont(new Font("Roboto", Font.BOLD, 25));
        lblHeader.setForeground(Color.blue);
        frame.add(lblHeader);

        lblMaSP = new JLabel("Mã nhân viên");
        lblMaSP.setBounds(10, 130, 130, 50);
        lblMaSP.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblMaSP);

        txtMaSP = new JTextField();
        txtMaSP.setBounds(140, 135, 300, 40);
        frame.add(txtMaSP);

        lblLoai = new JLabel("Tên nhân viên");
        lblLoai.setBounds(30, 180, 100, 50);
        lblLoai.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblLoai);

        txtTennv = new JTextField();
        txtTennv.setBounds(140, 180, 300, 40);
        frame.add(txtTennv);
        
        lblTimKiem = new JLabel("Tìm Kiếm");
        lblTimKiem.setBounds(30, 80, 120, 50);
        lblTimKiem.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblTimKiem);

        txtTimKiem = new JTextField();
        txtTimKiem.setBounds(140, 85, 300, 40);
        frame.add(txtTimKiem);

        btnTimKiem = new JButton("Tìm Kiếm", new ImageIcon("E:\\PS31493\\src\\Icon\\b.png"));
        btnTimKiem.setBounds(470, 70, 170, 55);
        frame.add(btnTimKiem);

        txtGia = new JTextField();
        txtGia.setBounds(140, 300, 300, 40);
        txtGia.setEnabled(false);
        txtGia.setFont(new Font("Roboto", Font.BOLD, 24));
        frame.add(txtGia);

        jcbLoai = new JComboBox(ob);
        jcbLoai.setBounds(140, 230, 200, 50);
        frame.add(jcbLoai);
        jcbLoai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLoai = (String) jcbLoai.getSelectedItem();
                if (selectedLoai != null) {
                    switch (selectedLoai) {
                        case "Mức 1":
                            txtGia.setText(String.valueOf(Muc_1));
                            break;
                        case "Mức 2":
                            txtGia.setText(String.valueOf(Muc_2));
                            break;
                        case "Mức 3":
                            txtGia.setText(String.valueOf(Muc_3));
                            break;
                        default:
                            txtGia.setText("");
                            break;
                    }
                }
            }
        });

        lblGia = new JLabel("Mức lương");
        lblGia.setBounds(20, 230, 120, 50);
        lblGia.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblGia);

        lblSoLuong = new JLabel("Số ngày công");
        lblSoLuong.setBounds(0, 350, 120, 50);
        lblSoLuong.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblSoLuong);

        txtSoLuong = new JTextField();
        txtSoLuong.setBounds(140, 355, 300, 40);
        frame.add(txtSoLuong);

        lblThanhTien = new JLabel("Thực lãnh");
        lblThanhTien.setBounds(30, 400, 100, 50);
        lblThanhTien.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblThanhTien);

        txtThanhTien = new JTextField();
        txtThanhTien.setBounds(140, 405, 300, 40);
        txtThanhTien.setEnabled(false);
        frame.add(txtThanhTien);

        table = new JTable(model);
        jsp = new JScrollPane(table);
        jsp.setBounds(30, 450, 800, 180);
        frame.add(jsp);

        btnNew = new JButton("New", new ImageIcon("E:\\PS31493\\src\\Icon\\Them1.png"));
        btnNew.setBounds(470, 135, 170, 55);
        btnNew.setFont(new Font("Roboto", Font.PLAIN, 22));
        btnNew.setBackground(new Color(204, 255, 255));
        btnNew.setForeground(Color.red);

        btnDelete = new JButton("Delete", new ImageIcon("E:\\PS31493\\src\\Icon\\delete.png"));
        btnDelete.setBounds(470, 215, 170, 55);
        btnDelete.setFont(new Font("Roboto", Font.PLAIN, 22));
        btnDelete.setBackground(new Color(204, 255, 255));
        btnDelete.setForeground(Color.red);

        btnUpdate = new JButton("Update", new ImageIcon("E:\\PS31493\\src\\Icon\\update.png"));
        btnUpdate.setBounds(470, 290, 170, 55);
        btnUpdate.setFont(new Font("Roboto", Font.PLAIN, 22));
        btnUpdate.setBackground(new Color(204, 255, 255));
        btnUpdate.setForeground(Color.red);

        btnSave = new JButton("Save", new ImageIcon("E:\\PS31493\\src\\Icon\\luu1.png"));
        btnSave.setBounds(470, 370, 170, 55);
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
        btnTimKiem.addActionListener(this);
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
            String sql = "select * from Rentals3";
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String masp = rs.getString("MaNV");
                String loai = rs.getString("TenNV");
                String gia = rs.getString("MucLuong");
                String soluong = rs.getString("SoNgayCong");
                String thanhtien = rs.getString("ThucLanh");
                Object[] newdata = {masp, loai, gia, soluong, thanhtien};
                model.addRow(newdata);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void reset() {
        txtMaSP.setText("");
        txtTennv.setText("");
        txtSoLuong.setText("");
        txtThanhTien.setText("");
        txtGia.setText("");
        jcbLoai.setSelectedIndex(-1);
    }
    private static final double Muc_1 = 500000;
    private static final double Muc_2 = 400000;
    private static final double Muc_3 = 300000;

    public void Update() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "update Rentals3 set TenNV = ?, MucLuong = ?,SoNgayCong=?,ThucLanh=? where MaNV =? ";
            PreparedStatement presta = con.prepareStatement(sql);
            presta.setString(1, txtTennv.getText());
            presta.setString(2, txtGia.getText());
            presta.setString(3, txtSoLuong.getText());
            double gia = Double.parseDouble(txtGia.getText());
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            double thanhTien = gia * soLuong;
            presta.setDouble(4, thanhTien);
            presta.setString(5, txtMaSP.getText());
            presta.executeUpdate();
            con.close();
            fill();
            JOptionPane.showMessageDialog(null, "Update thành công!");
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi update!");
        }
    }
     private void search(String keyword) {
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM Rentals3 WHERE MaNV LIKE ? OR TenNV LIKE ? OR MucLuong like ? ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");
            preparedStatement.setString(3, "%" + keyword + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("MaNV");
                String tenhang = rs.getString("TenNV");
                String gia = rs.getString("MucLuong");
                String songaycong = rs.getString("SoNgayCong");
                String thuclanh = rs.getString("ThucLanh");
                Object[] newdata = {masp, tenhang, gia,songaycong,thuclanh};
                model.addRow(newdata);
            }
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM Rentals3 WHERE MaNV = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, txtMaSP.getText());
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
        if (txtMaSP.getText().equals("")) {
            return false;
        }
        if (txtGia.getText().equals("")) {
            return false;
        }
        if (txtSoLuong.getText().equals("")) {
            return false;
        }
        int indexx = jcbLoai.getSelectedIndex();
        if (indexx == -1) {
            return false;
        }
        return true;
    }

    public void save() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO Rentals3 (MaNV, TenNV, MucLuong, SoNgayCong, ThucLanh) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement presta = con.prepareStatement(sql);
            String masp = txtMaSP.getText();
            String loai = txtTennv.getText();
            double mucluong = Double.parseDouble(txtGia.getText());
            int songaycong = Integer.parseInt(txtSoLuong.getText());
            double thuclanh = mucluong * songaycong;

            presta.setString(1, masp);
            presta.setString(2, loai);
            presta.setDouble(3, mucluong);
            presta.setInt(4, songaycong);
            presta.setDouble(5, thuclanh);
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
        if (ae.getSource() == btnTimKiem) {
            String keyword = txtTimKiem.getText();
            search(keyword);
        }
        if (ae.getSource() == btnUpdate) {
            Update();
        }
        if (ae.getSource() == btnNew) {
            reset();
        }

        if (ae.getSource() == btnSave) {
            if(Check()){
                save();
            }else{
                JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin!");
            }
            
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
            } else {
                rowIndex = 0;
            }
            showRecordAtIndex(rowIndex);
        }

        if (ae.getSource() == btnFirst) {
            if (rowIndex > 0) {
                rowIndex--;
            } else {
                rowIndex = model.getRowCount() - 1;
            }
            showRecordAtIndex(rowIndex);
        }
    }

    private void showRecordAtIndex(int index) {
        if (index >= 0 && index < model.getRowCount()) {
            txtMaSP.setText(model.getValueAt(index, 0).toString());
            txtTennv.setText(model.getValueAt(index, 1).toString());
            txtGia.setText(model.getValueAt(index, 2).toString());
            jcbLoai.setSelectedItem(model.getValueAt(index, 2).toString());
            txtSoLuong.setText(model.getValueAt(index, 3).toString());
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
            String sql = "SELECT * FROM Rentals3 LIMIT ?, 1";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, rowIndex - 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("MaNV");
                String loai = rs.getString("TenNV");
                String gia = rs.getString("MucLuong");
                String soluong = rs.getString("SoNgayCong");
//                String thanhtien = rs.getString("ThucLanh");

                txtMaSP.setText(masp);
                txtTennv.setText(loai);
//                jcbLoai.setSelectedItem(gia);
                txtGia.setText(gia);
                txtSoLuong.setText(soluong);
//                txtThanhTien.setText(thanhtien);

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
