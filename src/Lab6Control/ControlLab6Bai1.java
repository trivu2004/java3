package Lab6Control;

import Lab5.Model.ModelBai2;
import Lab5.View.ViewLab5Bai2;
import Lab6.View.ViewLab6Bai1;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ControlLab6Bai1 {

    public ControlLab6Bai1(ViewLab6Bai1 viewLab6Bai1) {
        this.viewLab6Bai1 = viewLab6Bai1;
        this.btnSearch = viewLab6Bai1.getBtnSearch();
        this.btnDelete = viewLab6Bai1.getBtnDelete();
        this.btnExit = viewLab6Bai1.getBtnExit();
        this.table = viewLab6Bai1.getTable();
        this.model = viewLab6Bai1.getModel();
        this.txtTitle = viewLab6Bai1.getTxtTitle();
    }

    String url = "jdbc:mysql://localhost:3306/Lab6Bai1";
    String user = "root";
    String password = "123456";

    private final ViewLab6Bai1 viewLab6Bai1;
    private final JButton btnSearch, btnExit, btnDelete;
    private final JTable table;
    private final DefaultTableModel model;
    private final JTextField txtTitle;

    public void kk() {
        btnSearch.addActionListener(ac);
        btnExit.addActionListener(ac);
        btnDelete.addActionListener(ac);
    }
    int i = -1;
    ActionListener ac = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnExit) {
                System.exit(0);
            }
            if (ae.getSource() == btnDelete) {
                    i = table.getSelectedRow();
                    int id = (int) table.getValueAt(i, 0);
                    if (i == -1) {
                        JOptionPane.showMessageDialog(null, "Moi chon dong can xoa");
                    } else {
                        int ret = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",JOptionPane.YES_NO_OPTION);
                        if (ret != JOptionPane.YES_OPTION) {
                            return;
                        }
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection(url, user, password);
                            String sql = "delete from book where Id=?";
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.setInt(1, id);
                            ps.executeUpdate();
                            search();
                        } catch (Exception ex) {
                        }
                    }
            }

            if (ae.getSource() == btnSearch) {
                search();
            }

        }
    };

    private void search() {
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            String sql = "select * from book";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (txtTitle.getText().equals("")) {
                    int id = rs.getInt("Id");
                    String title = rs.getString("Title");
                    double price = rs.getDouble("Price");
                    model.addRow(new Object[]{id, title, price});
                } else if (txtTitle.getText().equals(rs.getString("Title"))) {
                    int id = rs.getInt(1);
                    String title = rs.getString(2);
                    double price = rs.getDouble(3);
                    model.addRow(new Object[]{id, title, price});
                    return;
                }
            }
            if (!txtTitle.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Khong tim thay Title!");
            }
            rs.close();
        } catch (Exception ex) {
           
        }
    }
}
