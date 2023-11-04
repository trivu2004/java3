/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6.View;

import Lab6Control.ControlLab6Bai2;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ViewLab6Bai2 extends JFrame {

    JFrame frame;
    public JTable table;
    public JScrollPane jsp;
    public String[] col = {"Name", "Standard"};
    public DefaultTableModel model = new DefaultTableModel(null, col);
    public JLabel lblName, lblAdress, lblParentName, lblContactNo, lblStandard, lblFees,lblId;
    public JTextField txtName, txtParentName, txtContactNo,txtId;
    public JTextArea txtAdress;
    public JComboBox cbkStandard, cbkFees;
    public JButton btnNew, btnInsert, btnEdit, btnUpdate, btnNext, btnPre, btnDelete, btnExit;

    Object[] ob = new Object[]{"Java 1", "Java 2", "Java 3", "Java 4", "Java 5"};
    Object[] oc = new Object[]{"10.000", "20.000", "30.000", "40.000", "50.000"};

    public ViewLab6Bai2() {
        myGUI();
        
    }

    public void myGUI() {
        frame = new JFrame();
        frame.setSize(1050, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Lab6 Bài 2");
        frame.setLayout(null);

        table = new JTable(model);
        jsp = new JScrollPane(table);
        jsp.setBounds(20, 20, 400, 700);
        frame.add(jsp);

        lblName = new JLabel("Name: ");
        lblName.setBounds(508, 30, 120, 50);
        lblName.setFont(new Font("Roboto", Font.BOLD, 20));
        lblName.setForeground(Color.BLUE);
        frame.add(lblName);

        lblAdress = new JLabel("Address: ");
        lblAdress.setBounds(488, 90, 100, 50);
        lblAdress.setFont(new Font("Roboto", Font.BOLD, 20));
        lblAdress.setForeground(Color.BLUE);
        frame.add(lblAdress);

        lblParentName = new JLabel("ParentName: ");
        lblParentName.setBounds(450, 250, 130, 50);
        lblParentName.setFont(new Font("Roboto", Font.BOLD, 20));
        lblParentName.setForeground(Color.BLUE);
        frame.add(lblParentName);

        lblContactNo = new JLabel("ContactNo: ");
        lblContactNo.setBounds(468, 315, 120, 50);
        lblContactNo.setFont(new Font("Roboto", Font.BOLD, 20));
        lblContactNo.setForeground(Color.BLUE);
        frame.add(lblContactNo);

        lblStandard = new JLabel("Standard: ");
        lblStandard.setBounds(483, 375, 120, 50);
        lblStandard.setFont(new Font("Roboto", Font.BOLD, 20));
        lblStandard.setForeground(Color.BLUE);
        frame.add(lblStandard);
        
        lblId = new JLabel("Id: ");
        lblId.setBounds(540, 500, 120, 50);
        lblId.setFont(new Font("Roboto", Font.BOLD, 20));
        lblId.setForeground(Color.BLUE);
        frame.add(lblId);

        lblFees = new JLabel("Fees: ");
        lblFees.setBounds(520, 440, 120, 50);
        lblFees.setFont(new Font("Roboto", Font.BOLD, 20));
        lblFees.setForeground(Color.BLUE);
        frame.add(lblFees);

        txtName = new JTextField();
        txtName.setBounds(580, 35, 350, 40);
        txtName.setFont(new Font("Roboto", Font.BOLD, 20));
        txtName.setForeground(Color.RED);
        frame.add(txtName);

        txtAdress = new JTextArea();
        txtAdress.setBounds(580, 110, 350, 130);
        txtAdress.setFont(new Font("Roboto", Font.BOLD, 20));
        txtAdress.setForeground(Color.RED);
        frame.add(txtAdress);

        txtParentName = new JTextField();
        txtParentName.setBounds(580, 260, 350, 40);
        txtParentName.setFont(new Font("Roboto", Font.BOLD, 20));
        txtParentName.setForeground(Color.RED);
        frame.add(txtParentName);

        txtContactNo = new JTextField();
        txtContactNo.setBounds(580, 320, 350, 40);
        txtContactNo.setFont(new Font("Roboto", Font.BOLD, 20));
        txtContactNo.setForeground(Color.RED);
        frame.add(txtContactNo);
        
        cbkStandard = new JComboBox(ob);
        cbkStandard.setBounds(580, 380, 350, 40);
        cbkStandard.setFont(new Font("Roboto", Font.BOLD, 24));
        cbkStandard.setForeground(Color.red);
        frame.add(cbkStandard);
        
        cbkFees = new JComboBox(oc);
        cbkFees.setBounds(580, 445, 350, 40);
        cbkFees.setFont(new Font("Roboto", Font.BOLD, 24));
        cbkFees.setForeground(Color.red);
        frame.add(cbkFees);
        
        txtId = new JTextField();
        txtId.setBounds(580, 510, 350, 40);
        txtId.setFont(new Font("Roboto", Font.BOLD, 20));
        txtId.setForeground(Color.RED);
        frame.add(txtId);
        
        btnNew = new JButton("New");
        btnNew.setBounds(450, 600, 110, 40);
        btnNew.setFont(new Font("Roboto", Font.PLAIN, 22));
        frame.add(btnNew);
        
        btnInsert = new JButton("Insert");
        btnInsert.setBounds(580, 600, 110, 40);
        btnInsert.setFont(new Font("Roboto", Font.PLAIN, 22));
        frame.add(btnInsert);
              
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(710, 600, 110, 40);
        btnEdit.setFont(new Font("Roboto", Font.PLAIN, 22));
        
        frame.add(btnEdit);
        
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(840, 600, 110, 40);
        btnUpdate.setFont(new Font("Roboto", Font.PLAIN, 22));
         btnUpdate.setEnabled(false);
        frame.add(btnUpdate);
       
        
        btnNext = new JButton("Next");
        btnNext.setBounds(450, 670, 110, 40);
        btnNext.setFont(new Font("Roboto", Font.PLAIN, 22));
        frame.add(btnNext);
        
        btnPre = new JButton("Pre...");
        btnPre.setBounds(580, 670, 110, 40);
        btnPre.setFont(new Font("Roboto", Font.PLAIN, 22));
        frame.add(btnPre);
        
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(710, 670, 110, 40);
        btnDelete.setFont(new Font("Roboto", Font.PLAIN, 22));
        frame.add(btnDelete);
        
        btnExit = new JButton("Exit");
        btnExit.setBounds(840, 670, 110, 40);
        btnExit.setFont(new Font("Roboto", Font.PLAIN, 22));
        frame.add(btnExit);
        
        ActionListener ac = new ControlLab6Bai2(this);
        MouseListener lm = new ControlLab6Bai2(this);
        btnPre.addActionListener(ac);
        btnDelete.addActionListener(ac);
        btnEdit.addActionListener(ac);
        btnExit.addActionListener(ac);
        btnInsert.addActionListener(ac);
        btnNew.addActionListener(ac);
        btnNext.addActionListener(ac);
        btnUpdate.addActionListener(ac);
        table.addMouseListener(lm);
        

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ViewLab6Bai2();
    }
}
