/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6.View;

import Lab6Control.ControlLab6Bai1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author USER
 */
public class ViewLab6Bai1 extends JFrame {

    JFrame frame;
    JPanel p1, p2, p3;
    JLabel lblTitle;
    JButton btnSearch, btnExit, btnDelete;
    JScrollPane jsp;

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getTxtTitle() {
        return txtTitle;
    }

    public DefaultTableModel getModel() {
        return model;
    }
    JTextField txtTitle;
    JTable table;
    String[] col = new String[]{"Id", "Title", "Price"};
    DefaultTableModel model = new DefaultTableModel(col, 0);

    public ViewLab6Bai1() {
        myGUI();
        ControlLab6Bai1 controlLab6Bai1 = new ControlLab6Bai1(this);
        frame.setVisible(true);
        controlLab6Bai1.kk();
    }

    public void myGUI() {
        frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Book information");

        p1 = new JPanel();
        p1.setBounds(30, 20, 600, 150);
        p1.setLayout(null);
        p1.setBorder(new TitledBorder(new LineBorder(Color.red, 3), "Filter", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Roboto", Font.BOLD, 18), Color.BLUE));

        lblTitle = new JLabel("Title: ");
        lblTitle.setBounds(40, 60, 100, 50);
        lblTitle.setFont(new Font("Roboto", Font.PLAIN, 22));

        txtTitle = new JTextField();
        txtTitle.setBounds(100, 65, 450, 40);
        txtTitle.setFont(new Font("Roboto", Font.PLAIN, 22));

        btnSearch = new JButton("Search", new ImageIcon("E:\\PS31493\\src\\Icon\\b.png"));
        btnSearch.setBounds(640, 80, 150, 50);
        btnSearch.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnSearch.setBackground(new Color(204, 255, 255));
        btnSearch.setForeground(Color.RED);

        btnExit = new JButton("Exit", new ImageIcon("E:\\PS31493\\src\\Icon\\tat.png"));
        btnExit.setBounds(800, 80, 150, 50);
        btnExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnExit.setBackground(new Color(204, 255, 255));
        btnExit.setForeground(Color.RED);

        table = new JTable(model);

        jsp = new JScrollPane(table);
        jsp.setBounds(30, 200, 920, 180);
        frame.add(jsp);

        btnDelete = new JButton("Delete", new ImageIcon("E:\\PS31493\\src\\Icon\\delete.png"));
        btnDelete.setBounds(800, 410, 150, 50);
        btnDelete.setFont(new Font("Serif", Font.BOLD, 20));

        p1.add(lblTitle);
        p1.add(txtTitle);
        frame.add(p1);
        frame.add(btnSearch);
        frame.add(btnExit);
        frame.add(btnDelete);
        
        

    }

    public static void main(String[] args) {
        new ViewLab6Bai1();
    }
}
