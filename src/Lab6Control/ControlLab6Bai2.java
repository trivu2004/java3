/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6Control;

import Lab5.Model.ModelBai2;
import Lab6.View.ViewLab6Bai2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ControlLab6Bai2 implements ActionListener, MouseListener {

    String url = "jdbc:mysql://localhost:3306/NhanVien";
    String user = "root";
    String password = "123456";
    ViewLab6Bai2 viewBai2;
    int rowIndex;
    String name;

    public ControlLab6Bai2(ViewLab6Bai2 viewBai2) {
        this.viewBai2 = viewBai2;
        Reset();
        fill();

    }

    public void Reset() {
        viewBai2.txtName.setText("");
        viewBai2.txtAdress.setText("");
        viewBai2.txtContactNo.setText("");
        viewBai2.txtParentName.setText("");
        viewBai2.cbkStandard.setSelectedIndex(-1);
        viewBai2.cbkFees.setSelectedIndex(-1);
        viewBai2.txtId.setText("");
    }

    public boolean Check() {
        if (viewBai2.txtName.getText().equals("")) {
            return false;
        }
        if (viewBai2.txtAdress.getText().equals("")) {
            return false;
        }
        if (viewBai2.txtParentName.getText().equals("")) {
            return false;
        }
        if (viewBai2.txtContactNo.getText().equals("")) {
            return false;
        }
        int indexx = viewBai2.cbkStandard.getSelectedIndex();
        if (indexx == -1) {
            return false;
        }
        int indexx1 = viewBai2.cbkFees.getSelectedIndex();
        if (indexx1 == -1) {
            return false;
        }
        return true;
    }

    public void fill() {
        viewBai2.model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement sta = con.createStatement();
            String sql = "select * from Students";
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String namee = rs.getString("Namee");
                String standard = rs.getString("Standard");
                Object[] newdata = {namee, standard};
                viewBai2.model.addRow(newdata);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Update() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "update Students set Namee = ?, Address = ?,ParentName=?,ContactNo=?,Standard=?,Fees=? where Id =? ";
            PreparedStatement presta = con.prepareStatement(sql);
            presta.setString(1, viewBai2.txtName.getText());
            presta.setString(2, viewBai2.txtAdress.getText());
            presta.setString(3, viewBai2.txtParentName.getText());
            presta.setString(4, viewBai2.txtContactNo.getText());
            presta.setString(5, String.valueOf(viewBai2.cbkStandard.getSelectedItem()));
            presta.setString(6, String.valueOf(viewBai2.cbkFees.getSelectedItem()));
            presta.setString(7, viewBai2.txtId.getText());
            System.out.println(presta);
            presta.executeUpdate();
            con.close();
            fill();
            JOptionPane.showMessageDialog(null, "Update thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi update!");
        }
    }

    public void showNextRecord() {
        rowIndex++;
        int rowCount = viewBai2.table.getRowCount();

        if (rowIndex < rowCount) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                String sql = "SELECT * FROM Students LIMIT ?, 1";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, rowIndex);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    // Retrieve data from the next record and update the fields in the view
                    String id = rs.getString("Id");
                    String namee = rs.getString("Namee");
                    String address = rs.getString("Address");
                    String parentName = rs.getString("ParentName");
                    String contactNo = rs.getString("ContactNo");
                    String stanDard = rs.getString("Standard");
                    String fees = rs.getString("Fees");

                    viewBai2.txtId.setText(id);
                    viewBai2.txtName.setText(namee);
                    viewBai2.txtAdress.setText(address);
                    viewBai2.txtParentName.setText(parentName);
                    viewBai2.txtContactNo.setText(contactNo);
                    viewBai2.cbkStandard.setSelectedItem(stanDard);
                    viewBai2.cbkFees.setSelectedItem(stanDard);
                }
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            rowIndex = rowCount - 1;
            JOptionPane.showMessageDialog(null, "Đây là dòng cuối cùng");
        }
    }

    public void showPreviousRecord() {
        rowIndex--;
        if (rowIndex >= 0) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);

                String sql = "SELECT * FROM Students LIMIT ?, 1";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, rowIndex);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("Id");
                    String namee = rs.getString("Namee");
                    String address = rs.getString("Address");
                    String parentName = rs.getString("ParentName");
                    String contactNo = rs.getString("ContactNo");
                    String stanDard = rs.getString("Standard");
                    String fees = rs.getString("Fees");

                    viewBai2.txtId.setText(id);
                    viewBai2.txtName.setText(namee);
                    viewBai2.txtAdress.setText(address);
                    viewBai2.txtParentName.setText(parentName);
                    viewBai2.txtContactNo.setText(contactNo);
                    viewBai2.cbkStandard.setSelectedItem(stanDard);
                    viewBai2.cbkFees.setSelectedItem(stanDard);
                }
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Đây là dòng đầu tiên!");
        }
    }

    public void deleteRecord() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM Students WHERE Id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, viewBai2.txtId.getText());
            preparedStatement.executeUpdate();
            con.close();
            fill();
            JOptionPane.showMessageDialog(null, "Delete thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi delete!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewBai2.btnNew) {
            Reset();
            viewBai2.cbkStandard.setSelectedItem(1);
        }
        if (ae.getSource() == viewBai2.btnInsert) {
            if (!Check() == true) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            } else {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql = "insert into Students(Namee,Address,ParentName,ContactNo,Standard,Fees) values (?,?,?,?,?,?)";
                    PreparedStatement presta = con.prepareStatement(sql);
                    presta.setString(1, viewBai2.txtName.getText());
                    presta.setString(2, viewBai2.txtAdress.getText());
                    presta.setString(3, viewBai2.txtParentName.getText());
                    presta.setString(4, viewBai2.txtContactNo.getText());
                    presta.setString(5, String.valueOf(viewBai2.cbkStandard.getSelectedItem()));
                    presta.setString(6, String.valueOf(viewBai2.cbkFees.getSelectedItem()));
                    presta.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Insert thành công!");
                    fill();
                } catch (Exception e) {
                }
            }

        }
        if (ae.getSource() == viewBai2.btnEdit) {
            viewBai2.btnUpdate.setEnabled(true);
        }
        if (ae.getSource() == viewBai2.btnUpdate) {
            Update();
            viewBai2.btnUpdate.setEnabled(false);
        }

        if (ae.getSource() == viewBai2.btnNext) {
            showPreviousRecord();
        }
        if (ae.getSource() == viewBai2.btnPre) {
            showNextRecord();
        }
        if (ae.getSource() == viewBai2.btnDelete) {
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                deleteRecord();
                fill();
            }
        }
        if (ae.getSource() == viewBai2.btnExit) {
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            rowIndex = viewBai2.table.rowAtPoint(me.getPoint()) + 1;
            String sql = "SELECT * FROM Students LIMIT ?, 1";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, rowIndex - 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String namee = rs.getString("Namee");
                String address = rs.getString("Address");
                String parentName = rs.getString("ParentName");
                String contactNo = rs.getString("ContactNo");
                String stanDard = rs.getString("Standard");
                String fees = rs.getString("Fees");

                viewBai2.txtId.setText(id);
                viewBai2.txtName.setText(namee);
                viewBai2.txtAdress.setText(address);
                viewBai2.txtParentName.setText(parentName);
                viewBai2.txtContactNo.setText(contactNo);
                viewBai2.cbkStandard.setSelectedItem(stanDard);
                viewBai2.cbkFees.setSelectedItem(stanDard);
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
