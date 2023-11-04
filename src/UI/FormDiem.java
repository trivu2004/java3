/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author USER
 */
public class FormDiem extends JFrame implements ActionListener, MouseListener {

    ArrayList<Student> array = new ArrayList<>();
    JFrame frame;
    JPanel p1, p2, p3, p4, p5;
    JLabel lblHeader, lblTimKiem, lblmenu, lblHoTenSV, lblMaSV, lblTiengAnh, lblTinHoc, lblGiaoDucTC, lblDiemTrungBinh, lblDiem, lbl3SV;
    JTextField txtTimKiem, txtHoTenSV, txtMaSV, txtTiengAnh, txtTinHoc, txtGiaoDucTC;
    JButton btnTimKiem, btnLast, btnFirst, btnNext, btnPrevious, btnNew, btnSave, btnDelete, btnUpdate;
    DefaultTableModel model;
    JTable tblSinhVien;
    String url = "jdbc:mysql://localhost:3306/ASM";
    String user = "root";
    String password = "123456";
    int current = 0;
    int rowIndex;

    public FormDiem() {
        myGUI();
        frame.setVisible(true);
        LoadDataArray();
        fillTotable();
    }

    public void myGUI() {
        frame = new JFrame();
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setTitle("Quản Lý Điểm Sinh Viên");

        p1 = new JPanel();
        p1.setBounds(250, 20, 500, 100);

        lblHeader = new JLabel("Quản Lý Điểm Sinh Viên");
        lblHeader.setForeground(Color.blue);
        lblHeader.setFont(new Font("Roboto", Font.BOLD, 28));

        lblTimKiem = new JLabel("Tìm kiếm");
        lblTimKiem.setFont(new Font("Roboto", Font.BOLD, 18));
        lblTimKiem.setBounds(80, 100, 80, 30);

        p2 = new JPanel();
        p2.setBounds(70, 140, 700, 100);
        p2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        p2.setLayout(null);

        lblmenu = new JLabel("Mã SV: ");
        lblmenu.setFont(new Font("Roboto", Font.PLAIN, 25));
        lblmenu.setBounds(90, 30, 100, 50);

        txtTimKiem = new JTextField();
        txtTimKiem.setBounds(180, 30, 300, 50);
        txtTimKiem.setFont(new Font("Roboto", Font.PLAIN, 18));

        btnTimKiem = new JButton("Search", new ImageIcon("E:\\PS31493\\src\\Icon\\b.png"));
        btnTimKiem.setBounds(490, 30, 150, 50);
        btnTimKiem.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnTimKiem.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        btnTimKiem.setForeground(Color.blue);

        p3 = new JPanel();
        p3.setBounds(60, 250, 600, 280);
        p3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        p3.setLayout(null);

        lblHoTenSV = new JLabel("Họ Tên SV: ");
        lblHoTenSV.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblHoTenSV.setBounds(40, 10, 100, 50);

        lblMaSV = new JLabel("Mã SV: ");
        lblMaSV.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblMaSV.setBounds(70, 60, 100, 50);

        lblTiengAnh = new JLabel("Tiếng Anh: ");
        lblTiengAnh.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblTiengAnh.setBounds(45, 110, 100, 50);

        lblTinHoc = new JLabel("Tin Học: ");
        lblTinHoc.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblTinHoc.setBounds(60, 160, 100, 50);

        lblGiaoDucTC = new JLabel("Giáo Dục TC: ");
        lblGiaoDucTC.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblGiaoDucTC.setBounds(30, 210, 130, 50);

        lblDiemTrungBinh = new JLabel("Điểm TB: ");
        lblDiemTrungBinh.setBounds(470, 110, 100, 50);
        lblDiemTrungBinh.setFont(new Font("Roboto", Font.BOLD, 18));

        lblDiem = new JLabel();
        lblDiem.setBounds(470, 150, 100, 50);
        lblDiem.setFont(new Font("Roboto", Font.BOLD, 18));

        txtHoTenSV = new JTextField();
        txtHoTenSV.setBounds(140, 15, 300, 40);
        txtHoTenSV.setFont(new Font("Roboto", Font.PLAIN, 18));

        txtMaSV = new JTextField();
        txtMaSV.setBounds(140, 65, 300, 40);
        txtMaSV.setFont(new Font("Roboto", Font.PLAIN, 16));

        txtTiengAnh = new JTextField();
        txtTiengAnh.setBounds(140, 115, 300, 40);
        txtTiengAnh.setFont(new Font("Roboto", Font.PLAIN, 16));

        txtTinHoc = new JTextField();
        txtTinHoc.setBounds(140, 165, 300, 40);
        txtTinHoc.setFont(new Font("Roboto", Font.PLAIN, 16));

        txtGiaoDucTC = new JTextField();
        txtGiaoDucTC.setBounds(140, 215, 300, 40);
        txtGiaoDucTC.setFont(new Font("Roboto", Font.PLAIN, 16));

        p4 = new JPanel();
        p4.setBounds(100, 540, 480, 50);
        p4.setLayout(new GridLayout(1, 4, 30, 30));

        btnNext = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\xuong.png"));
        btnNext.setBackground(new Color(204, 255, 255));
        btnFirst = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\dau.png"));
        btnFirst.setBackground(new Color(204, 255, 255));
        btnLast = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\cuoi.png"));
        btnLast.setBackground(new Color(204, 255, 255));
        btnPrevious = new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\len.png"));
        btnPrevious.setBackground(new Color(204, 255, 255));

        lbl3SV = new JLabel("3 Sinh Viên có điểm cao nhất: ");
        lbl3SV.setBounds(10, 610, 300, 50);
        lbl3SV.setFont(new Font("Roboto", Font.PLAIN, 20));
        lbl3SV.setForeground(Color.blue);

        String[] cot = {"MaSV", "Ho Ten", "Tiếng Anh", "'Tin Học", "GDTC", "Điểm TB"};
        model = new DefaultTableModel(cot, 0);
        tblSinhVien = new JTable(model);
        tblSinhVien.setFont(new Font("Serif", Font.BOLD, 17));
        JTableHeader header = tblSinhVien.getTableHeader();
        Font font = new Font("Serif", Font.BOLD, 20);
        header.setFont(font);
        header.setForeground(Color.red);
        tblSinhVien.setPreferredScrollableViewportSize(new Dimension(800, 150));
        JScrollPane scrollPane1 = new JScrollPane(tblSinhVien);

        p5 = new JPanel();
        p5.setBounds(10, 660, 820, 200);
        p5.add(scrollPane1);

        btnNew = new JButton("New", new ImageIcon("E:\\PS31493\\src\\Icon\\Them1.png"));
        btnNew.setBounds(700, 250, 130, 50);
        btnSave = new JButton("Save", new ImageIcon("E:\\PS31493\\src\\Icon\\Luu1.png"));
        btnSave.setBounds(700, 325, 130, 50);
        btnDelete = new JButton("Delete", new ImageIcon("E:\\PS31493\\src\\Icon\\delete.png"));
        btnDelete.setBounds(700, 405, 130, 50);
        btnUpdate = new JButton("Update", new ImageIcon("E:\\PS31493\\src\\Icon\\update.png"));
        btnUpdate.setBounds(700, 480, 130, 50);

        p1.add(lblHeader);
        p2.add(lblmenu);
        p2.add(txtTimKiem);
        p2.add(btnTimKiem);
        p3.add(lblHoTenSV);
        p3.add(lblMaSV);
        p3.add(lblTiengAnh);
        p3.add(lblTinHoc);
        p3.add(lblGiaoDucTC);
        p3.add(lblDiemTrungBinh);
        p3.add(lblDiem);
        p3.add(txtHoTenSV);
        p3.add(txtMaSV);
        p3.add(txtTiengAnh);
        p3.add(txtTinHoc);
        p3.add(txtGiaoDucTC);
        p4.add(btnPrevious);
        p4.add(btnFirst);
        p4.add(btnLast);
        p4.add(btnNext);
        frame.add(p1);
        frame.add(lblTimKiem);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.add(lbl3SV);
        frame.add(p5);
        frame.add(btnNew);
        frame.add(btnSave);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        btnNew.addActionListener(this);
        btnSave.addActionListener(this);
        btnDelete.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnTimKiem.addActionListener(this);
        tblSinhVien.addMouseListener(this);
        btnFirst.addActionListener(this);
        btnLast.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);

    }

    public void Display(int i) {
        Student student = array.get(i);
        txtHoTenSV.setText(student.getHoTen());
        txtMaSV.setText(student.getMaSV());
        txtTiengAnh.setText(String.valueOf(student.getTiengAnh()));
        txtTinHoc.setText(String.valueOf(student.getTinHoc()));
        txtGiaoDucTC.setText(String.valueOf(student.getGiaoDucTC()));
    }

    public void fillTotable() {
        model.setRowCount(0);
        for (Student student : array) {
            Object[] row = new Object[]{student.maSV, student.hoTen, student.tiengAnh, student.tinHoc, student.giaoDucTC, student.diemTB};
            model.addRow(row);
        }
    }

    public void LoadDataArray() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement sta = con.createStatement();
            String sql = "select * from Diem1";
            ResultSet rs = sta.executeQuery(sql);
            array.clear();
            while (rs.next()) {
                String masv = rs.getString(1);
                String hoten = rs.getString(2);
                double tiengAnh = rs.getDouble(3);
                double tinHoc = rs.getDouble(4);
                double giaoDucTC = rs.getDouble(5);
                double diemTB = rs.getDouble(6);
                Student st = new Student(masv, hoten, tiengAnh, tinHoc, giaoDucTC, diemTB);
                array.add(st);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean Check() {
        if (txtHoTenSV.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nhập họ tên Sinh Viên!");
            txtHoTenSV.requestFocus();
            return false;
        }
        if (txtTiengAnh.equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập điểm Tiếng Anh");
            txtTiengAnh.requestFocus();
            return false;

        } else {
            try {
                double diem = Double.parseDouble(txtTiengAnh.getText());
                if (diem < 0 || diem > 10) {
                    JOptionPane.showMessageDialog(this, "Nhập điểm sai rồi!");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi định dạng điểm Tiếng Anh");
                return false;
            }
            if (txtTinHoc.equals("")) {
                JOptionPane.showMessageDialog(this, "Nhập điểm Tin Học");
                txtTinHoc.requestFocus();
                return false;
            } else {
                try {
                    double diem = Double.parseDouble(txtTinHoc.getText());
                    if (diem < 0 || diem > 10) {
                        JOptionPane.showMessageDialog(this, "Nhập điểm sai rồi!");
                        return false;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi định dạng điểm Tin Học");
                    return false;
                }
                if (txtGiaoDucTC.equals("")) {
                    JOptionPane.showMessageDialog(this, "Nhập điểm Giáo Dục Thể Chất");
                    txtGiaoDucTC.requestFocus();
                    return false;
                } else {
                    try {
                        double diem = Double.parseDouble(txtGiaoDucTC.getText());
                        if (diem < 0 || diem > 10) {
                            JOptionPane.showMessageDialog(this, "Nhập điểm sai rồi!");
                            return false;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Lỗi định dạng điểm Giáo Dục Thể Chất");
                        return false;
                    }
                }
                return true;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FormDiem();
    }

    public void reset() {
        txtMaSV.setText("");
        txtHoTenSV.setText("");
        txtTiengAnh.setText("");
        txtTinHoc.setText("");
        txtGiaoDucTC.setText("");
        lblDiem.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnLast) {
            current = array.size() - 1;
            Display(current);
            JOptionPane.showMessageDialog(null, "Bạn đang ở đầu danh sách!");
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
        if (ae.getSource() == btnNew) {
            reset();
        }
        if (ae.getSource() == btnSave) {
            if (Check()) {
                try {
                    String tiengAnhText = txtTiengAnh.getText().replace(",", ".");
                    String tinHocText = txtTinHoc.getText().replace(",", ".");
                    String giaoDucTCText = txtGiaoDucTC.getText().replace(",", ".");
                    double tiengAnh = Double.parseDouble(tiengAnhText);
                    double tinHoc = Double.parseDouble(tinHocText);
                    double giaoDucTC = Double.parseDouble(giaoDucTCText);
                    double diemTB = (tiengAnh + tinHoc + giaoDucTC) / 3;
                    DecimalFormat df = new DecimalFormat("#.##");
                    String roundedValue = df.format(diemTB);
                    lblDiem.setText(String.valueOf(roundedValue));

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql = "INSERT INTO Diem1 (HoTenSV, MaSV, TiengAnh, TinHoc, GiaoDucTC, diemTB) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, txtHoTenSV.getText());
                    preparedStatement.setString(2, txtMaSV.getText());
                    preparedStatement.setDouble(3, tiengAnh);
                    preparedStatement.setDouble(4, tinHoc);
                    preparedStatement.setDouble(5, giaoDucTC);
                    preparedStatement.setDouble(6, diemTB);
                    preparedStatement.executeUpdate();
                    con.close();
                    Student newStudent = new Student(txtMaSV.getText(), txtHoTenSV.getText(), tiengAnh, tinHoc, giaoDucTC, diemTB);
                    array.add(newStudent);
                    fillTotable();
                    JOptionPane.showMessageDialog(null, "Save thành công!");
                    reset();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi Save!");
                }

            }
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
                        String sql = "DELETE FROM Diem1 WHERE MaSV = ?";
                        PreparedStatement pre = con.prepareStatement(sql);
                        pre.setString(1, txtMaSV.getText());
                        pre.execute();
                        LoadDataArray();
                        fillTotable();
                        JOptionPane.showMessageDialog(this, "Delete thành công!");
                        reset();
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Lỗi delete!");
                    }
                }
            }

        }
        if (ae.getSource() == btnUpdate) {
            if (Check()) {
                try {
                    String tiengAnhText = txtTiengAnh.getText().replace(",", ".");
                    String tinHocText = txtTinHoc.getText().replace(",", ".");
                    String giaoDucTCText = txtGiaoDucTC.getText().replace(",", ".");
                    double tiengAnh = Double.parseDouble(tiengAnhText);
                    double tinHoc = Double.parseDouble(tinHocText);
                    double giaoDucTC = Double.parseDouble(giaoDucTCText);
                    double diemTB = (tiengAnh + tinHoc + giaoDucTC) / 3;

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql = "UPDATE Diem1 SET HoTenSV=?, TiengAnh=?, TinHoc=?, GiaoDucTC=?, diemTB=? WHERE MaSV=?";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, txtHoTenSV.getText());
                    preparedStatement.setDouble(2, tiengAnh);
                    preparedStatement.setDouble(3, tinHoc);
                    preparedStatement.setDouble(4, giaoDucTC);
                    preparedStatement.setDouble(5, diemTB);
                    preparedStatement.setString(6, txtMaSV.getText());
                    preparedStatement.executeUpdate();
                    LoadDataArray();
                    fillTotable();

                    JOptionPane.showMessageDialog(null, "Update thành công!");
                    reset();
                    con.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi Update!");
                }
            }
        }
        if (ae.getSource() == btnTimKiem) {
            String searchText = txtTimKiem.getText().trim();

            if (!searchText.isEmpty()) {
                DefaultTableModel tableModel = (DefaultTableModel) tblSinhVien.getModel();
                TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);
                tblSinhVien.setRowSorter(rowSorter);
                RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + searchText, 0, 1); 
                rowSorter.setRowFilter(filter);
            } else {
                tblSinhVien.setRowSorter(null);
            }
        }

    }
    @Override
    public void mouseClicked(MouseEvent me) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            rowIndex = tblSinhVien.rowAtPoint(me.getPoint()) + 1;
            String sql = "SELECT * FROM Diem1 LIMIT ?, 1";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, rowIndex - 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String masv = rs.getString("MaSV");
                String hoten = rs.getString("HoTenSV");
                double tiengAnh = rs.getDouble("TiengAnh");
                double tinHoc = rs.getDouble("TinHoc");
                double giaoDucTC = rs.getDouble("GiaoDucTC");
                double diemTB = rs.getDouble("diemTB");

                txtMaSV.setText(masv);
                txtHoTenSV.setText(hoten);
                txtTiengAnh.setText(String.valueOf(tiengAnh));
                txtTinHoc.setText(String.valueOf(tinHoc));
                txtGiaoDucTC.setText(String.valueOf(giaoDucTC));
                lblDiem.setText(String.valueOf(diemTB));
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
