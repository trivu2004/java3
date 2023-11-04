/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Bai2 extends JFrame implements ActionListener {

    private JLabel lblfirstnumber, lblsecondnumber, lblresult;
    private JTextField txtfirstnumber, txtsecondnumber, txtresult;
    private JPanel p1, p2, p3, p4;
    private JButton btncong, btntru, btnnhan, btnchia;

    public Bai2() {
        JFrame jp = new JFrame("Lab1 bai 2");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        p1 = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 0));
        p1.setBounds(0, 0, 500, 100);

        p2 = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        p2.setBounds(0, 100, 500, 100);

        p3 = new JPanel(new FlowLayout(FlowLayout.LEADING, 36, 0));
        p3.setBounds(0, 200, 500, 100);

        p4 = new JPanel();
        p4.setBounds(0, 300, 500, 100);
        

        lblfirstnumber = new JLabel("first number: ");
        lblfirstnumber.setBounds(5, 10, 500, 100);
        lblfirstnumber.setBackground(Color.yellow);
        lblfirstnumber.setFont(new Font("Roboto", 20, 20));

        lblsecondnumber = new JLabel("Secon number: ");
        lblsecondnumber.setBounds(50, 20, 400, 100);
        lblsecondnumber.setBackground(Color.yellow);
        lblsecondnumber.setFont(new Font("Roboto", 20, 20));

        lblresult = new JLabel("Result: ");
        lblresult.setBounds(0, 10, 100, 40);
        lblresult.setBackground(Color.yellow);
        lblresult.setFont(new Font("Roboto", 20, 20));

        txtfirstnumber = new JTextField();
        txtfirstnumber.setPreferredSize(new Dimension(250, 30));
        txtsecondnumber = new JTextField();
        txtsecondnumber.setPreferredSize(new Dimension(250, 30));
        txtresult = new JTextField();
        txtresult.setPreferredSize(new Dimension(250, 30));
        txtresult.setEnabled(false);
        btncong = new JButton("+");
        btncong.setBounds(0, 0, 10, 20);
        btntru = new JButton("-");
        btntru.setBounds(0, 0, 10, 20);
        btnnhan = new JButton("*");
        btnnhan.setBounds(0, 0, 10, 20);
        btnchia = new JButton("/");
        btnchia.setBounds(0, 0, 10, 20);
        p1.add(lblfirstnumber);
        p1.add(txtfirstnumber);
        p2.add(lblsecondnumber);
        p2.add(txtsecondnumber);
        p3.add(lblresult);
        p3.add(txtresult);
        p4.add(btncong);
        p4.add(btntru);
        p4.add(btnnhan);
        p4.add(btnchia);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        btncong.addActionListener(this);
        btntru.addActionListener(this);
        btnnhan.addActionListener(this);
        btnchia.addActionListener(this);
        setVisible(true);
    }

    public boolean CheckNull() {
        if (txtfirstnumber.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap gia tri! ");
            txtfirstnumber.requestFocus();
            return false;
        } else if (txtsecondnumber.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap gia tri! ");
            txtsecondnumber.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Bai2 b2 = new Bai2();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String click = ae.getActionCommand();
        System.out.println(click);
        if (click.equals("+")) {
            double so1, so2, ketqua = 0;
            if (CheckNull()) {
                try {
                    so1 = Double.valueOf(txtfirstnumber.getText());
                    so2 = Double.valueOf(txtsecondnumber.getText());
                    ketqua = so1 + so2;
                    txtresult.setText(ketqua + "");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Loi khong the nhap chu");
                }

            }
        } else if (click.equals("-")) {
            double so1, so2, ketqua = 0;
            if (CheckNull()) {
                try {
                    so1 = Double.valueOf(txtfirstnumber.getText());
                    so2 = Double.valueOf(txtsecondnumber.getText());
                    ketqua = so1 - so2;
                    txtresult.setText(ketqua + "");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Loi khong the nhap chu");
                }
            }
        } else if (click.equals("*")) {
            double so1, so2, ketqua = 0;
            if (CheckNull()) {
                try {
                    so1 = Double.valueOf(txtfirstnumber.getText());
                    so2 = Double.valueOf(txtsecondnumber.getText());
                    ketqua = so1 * so2;
                    txtresult.setText(ketqua + "");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Loi khong the nhap chu");
                }
            }
        }else{
        double so1, so2, ketqua = 0;
            if (CheckNull()) {
                try {
                    so1 = Double.valueOf(txtfirstnumber.getText());
                    so2 = Double.valueOf(txtsecondnumber.getText());
                    if(so2 == 0){
                        JOptionPane.showMessageDialog(this,"Loi nhap so");
                        return;
                    }else{
                    ketqua = so1/ so2;
                    txtresult.setText(ketqua + "");
                    }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Loi khong the nhap chu");
                }
    }
    }
}
}
