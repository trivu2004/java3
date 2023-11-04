package Thi2;

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
public class Thi3 extends JFrame implements ActionListener, MouseListener {

    ArrayList<QuanLyHH> array = new ArrayList<QuanLyHH>();
    private JFrame frame;
    private JLabel lblHeader, lblMaSP, lblLoai, lblGia, lblSoLuong, lblTimKiem;
    private JComboBox jcbLoai;
    private JPanel p1;
    private JTextField txtMaSP, txtGia, txtSoLuong, txtTimKiem;
    private JButton btnNew, btnDelete, btnUpdate, btnSave, btnFirst, btnNext, btnPrevious, btnLast, btnTimKiem;
    String[] col = new String[]{"Mã Hàng", "Tên Hàng", "Giá"};
    DefaultTableModel model = new DefaultTableModel(col, 0);
    JTable table;
    JScrollPane jsp;
    String url = "jdbc:mysql://localhost:3306/Thi1";
    String user = "root";
    String password = "123456";
    int rowIndex;

    public Thi3() {
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

        lblHeader = new JLabel("Quản lý cho thuê xe");
        lblHeader.setBounds(250, 20, 400, 100);
        lblHeader.setFont(new Font("Roboto", Font.BOLD, 25));
        lblHeader.setForeground(Color.blue);
        frame.add(lblHeader);

        lblMaSP = new JLabel("Mã Sản Phẩm");
        lblMaSP.setBounds(10, 130, 130, 50);
        lblMaSP.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblMaSP);

        txtMaSP = new JTextField();
        txtMaSP.setBounds(140, 135, 300, 40);
        frame.add(txtMaSP);

        lblLoai = new JLabel("Tên Hàng");
        lblLoai.setBounds(20, 180, 120, 50);
        lblLoai.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblLoai);

        txtSoLuong = new JTextField();
        txtSoLuong.setBounds(140, 185, 300, 40);
        frame.add(txtSoLuong);

        lblGia = new JLabel("Giá");
        lblGia.setBounds(20, 230, 120, 50);
        lblGia.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblGia);

        txtGia = new JTextField();
        txtGia.setBounds(140, 235, 300, 40);
        frame.add(txtGia);

        lblTimKiem = new JLabel("Tìm Kiếm");
        lblTimKiem.setBounds(20, 300, 120, 50);
        lblTimKiem.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblTimKiem);

        txtTimKiem = new JTextField();
        txtTimKiem.setBounds(140, 305, 300, 40);
        frame.add(txtTimKiem);

        btnTimKiem = new JButton("Tìm Kiếm", new ImageIcon("E:\\PS31493\\src\\Icon\\b.png"));
        btnTimKiem.setBounds(140, 345, 300, 40);
        frame.add(btnTimKiem);
        table = new JTable(model);
        jsp = new JScrollPane(table);
        jsp.setBounds(0, 400, 800, 180);
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
        btnTimKiem.addActionListener(this);

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
            String sql = "select * from Rentals2";
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String tenhang = rs.getString("TenHang");
                String gia = rs.getString("Gia");
                Object[] newdata = {masp, tenhang, gia};
                model.addRow(newdata);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void reset() {
        txtMaSP.setText("");
        txtSoLuong.setText("");
        txtGia.setText("");
    }

    public void Update() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "update Rentals2 set TenHang = ?,Gia=? where MaSP =? ";
            PreparedStatement presta = con.prepareStatement(sql);
            presta.setString(1, txtSoLuong.getText());
            presta.setString(2, txtGia.getText());
            presta.setString(3, txtMaSP.getText());
            System.out.println(presta);
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
            String sql = "DELETE FROM Rentals2 WHERE MaSP = ?";
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
        return true;
    }

    public void save() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO Rentals2 (MaSP,TenHang, Gia) VALUES (?, ?, ?)";
            PreparedStatement presta = con.prepareStatement(sql);
            String masp = txtMaSP.getText();
            String tenhang = txtSoLuong.getText();
            double gia = Double.parseDouble(txtGia.getText());

            presta.setString(1, masp);
            presta.setString(2, tenhang);
            presta.setDouble(3, gia);
            presta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm mới thành công!");

            fill();
            reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thi3();
    }

    private void search(String keyword) {
        model.setRowCount(0);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM Rentals2 WHERE MaSP LIKE ? OR TenHang LIKE ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String tenhang = rs.getString("TenHang");
                String gia = rs.getString("Gia");
                Object[] newdata = {masp, tenhang, gia};
                model.addRow(newdata);
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if (ae.getSource() == btnTimKiem) {
            String keyword = txtTimKiem.getText();
            search(keyword);
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
            txtMaSP.setText(model.getValueAt(index, 0).toString());
            txtSoLuong.setText(model.getValueAt(index, 1).toString());
            txtGia.setText(model.getValueAt(index, 2).toString());
            table.setRowSelectionInterval(index, index);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            rowIndex = table.rowAtPoint(me.getPoint()) + 1;
            String sql = "SELECT * FROM Rentals2 LIMIT ?, 1";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, rowIndex - 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String tenhang = rs.getString("TenHang");
                String gia = rs.getString("Gia");

                txtMaSP.setText(masp);
                txtSoLuong.setText(tenhang);
                txtGia.setText(gia);

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
