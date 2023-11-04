package Thi2;

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

    ArrayList<QuanLyHH> array = new ArrayList<QuanLyHH>();
    private JFrame frame;
    private JLabel lblHeader, lblMaSP, lblLoai, lblGia, lblSoLuong, lblThanhTien;
    private JComboBox jcbLoai;
    private JPanel p1;
    private JTextField txtMaSP, txtGia, txtSoLuong, txtThanhTien;
    private JButton btnNew, btnDelete, btnUpdate, btnSave, btnFirst, btnNext, btnPrevious, btnLast;
    String[] col = new String[]{"Mã Sản Phẩm", "Loại", "Giá", "Số Lượng", "Thành Tiền"};
    DefaultTableModel model = new DefaultTableModel(col, 0);
    JTable table;
    JScrollPane jsp;
    String url = "jdbc:mysql://localhost:3306/Thi1";
    String user = "root";
    String password = "123456";
    int rowIndex;
    Object[] ob = new Object[]{"Loại 1", "Loại 2", "Loại 3"};

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

        lblLoai = new JLabel("Loại");
        lblLoai.setBounds(30, 180, 100, 50);
        lblLoai.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblLoai);

        jcbLoai = new JComboBox(ob);
        jcbLoai.setBounds(140, 180, 200, 50);
        frame.add(jcbLoai);
        jcbLoai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLoai = (String) jcbLoai.getSelectedItem();
                if (selectedLoai != null) {
                    switch (selectedLoai) {
                        case "Loại 1":
                            txtGia.setText(String.valueOf(Loai_1));
                            break;
                        case "Loại 2":
                            txtGia.setText(String.valueOf(Loai_2));
                            break;
                        case "Loại 3":
                            txtGia.setText(String.valueOf(Loai_3));
                            break;
                        default:
                            txtGia.setText("");
                            break;
                    }
                }
            }
        });

        lblGia = new JLabel("Giá");
        lblGia.setBounds(20, 230, 120, 50);
        lblGia.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblGia);

        txtGia = new JTextField();
        txtGia.setBounds(140, 235, 300, 40);
        frame.add(txtGia);

        lblSoLuong = new JLabel("Số Lượng");
        lblSoLuong.setBounds(30, 280, 100, 50);
        lblSoLuong.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblSoLuong);

        txtSoLuong = new JTextField();
        txtSoLuong.setBounds(140, 285, 300, 40);
        frame.add(txtSoLuong);

        lblThanhTien = new JLabel("Thành Tiền");
        lblThanhTien.setBounds(30, 330, 100, 50);
        lblThanhTien.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(lblThanhTien);

        txtThanhTien = new JTextField();
        txtThanhTien.setBounds(140, 340, 300, 40);
        frame.add(txtThanhTien);

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
            String sql = "select * from Rentals1";
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String loai = rs.getString("Loai");
                String gia = rs.getString("Gia");
                String soluong = rs.getString("SoLuong");
                String thanhtien = rs.getString("ThanhTien");
                Object[] newdata = {masp, loai, gia, soluong, thanhtien};
                model.addRow(newdata);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void reset() {
        txtMaSP.setText("");
        txtGia.setText("");
        txtSoLuong.setText("");
        txtThanhTien.setText("");
        jcbLoai.setSelectedIndex(-1);
    }
    private static final double Loai_1 = 200000;
    private static final double Loai_2 = 150000;
    private static final double Loai_3 = 100000;

    public void Update() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "update Rentals1 set Loai = ?, Gia = ?,SoLuong=?,ThanhTien=? where MaSP =? ";
            PreparedStatement presta = con.prepareStatement(sql);
            presta.setString(1, String.valueOf(jcbLoai.getSelectedItem()));
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

    public void deleteRecord() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM Rentals1 WHERE MaSP = ?";
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
        if (txtThanhTien.getText().equals("")) {
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
            String sql = "INSERT INTO Rentals1 (MaSP, Loai, Gia, SoLuong, ThanhTien) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement presta = con.prepareStatement(sql);
            String masp = txtMaSP.getText();
            String loai = String.valueOf(jcbLoai.getSelectedItem());
            double gia = Double.parseDouble(txtGia.getText());
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            double thanhTien = gia * soLuong;

            presta.setString(1, masp);
            presta.setString(2, loai);
            presta.setDouble(3, gia);
            presta.setInt(4, soLuong);
            presta.setDouble(5, thanhTien);
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
            jcbLoai.setSelectedItem(model.getValueAt(index, 1));
            txtGia.setText(model.getValueAt(index, 2).toString());
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
            String sql = "SELECT * FROM Rentals1 LIMIT ?, 1";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, rowIndex - 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String loai = rs.getString("Loai");
                String gia = rs.getString("Gia");
                String soluong = rs.getString("SoLuong");
                String thanhtien = rs.getString("ThanhTien");

                txtMaSP.setText(masp);
                jcbLoai.setSelectedItem(loai);
                txtGia.setText(gia);
                txtSoLuong.setText(soluong);
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
