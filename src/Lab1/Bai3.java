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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Bai3 extends JFrame implements ActionListener {

    private JLabel lblusername, lblpassword, lblconfirm;
    private JTextField txtusername;
    private JPasswordField txtpassword, txtconfirm;
    private JPanel p1, p2, p3, p4;
    private JButton btnSignup, btnCancel;

    public Bai3() {
        JFrame jp = new JFrame("Lab1 bai 3");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        p1 = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 0));
        p1.setBounds(0, 0, 500, 100);

        p2 = new JPanel(new FlowLayout(FlowLayout.LEADING, 12, 0));
        p2.setBounds(0, 100, 500, 100);

        p3 = new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 0));
        p3.setBounds(0, 200, 500, 100);

        p4 = new JPanel();
        p4.setBounds(0, 300, 500, 100);
        lblusername = new JLabel("User name: ");
        lblusername.setBounds(5, 10, 500, 100);
        lblusername.setBackground(Color.yellow);
        lblusername.setFont(new Font("Roboto", 20, 20));

        lblpassword = new JLabel("Password: ");
        lblpassword.setBounds(50, 20, 400, 100);
        lblpassword.setBackground(Color.yellow);
        lblpassword.setFont(new Font("Roboto", 20, 20));

        lblconfirm = new JLabel("Confirm: ");
        lblconfirm.setBounds(0, 10, 100, 40);
        lblconfirm.setBackground(Color.yellow);
        lblconfirm.setFont(new Font("Roboto", 20, 20));

        txtusername = new JTextField();
        txtusername.setPreferredSize(new Dimension(250, 30));
        txtpassword = new JPasswordField();
        txtpassword.setPreferredSize(new Dimension(250, 30));
        txtconfirm = new JPasswordField();
        txtconfirm.setPreferredSize(new Dimension(250, 30));
        btnSignup = new JButton("Signup");
        btnSignup.setBounds(0, 0, 10, 20);
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(0, 0, 10, 20);

        p1.add(lblusername);
        p1.add(txtusername);

        p2.add(lblpassword);
        p2.add(txtpassword);

        p3.add(lblconfirm);
        p3.add(txtconfirm);

        p4.add(btnSignup);
        p4.add(btnCancel);

        add(p1);
        add(p2);
        add(p3);
        add(p4);

        btnSignup.addActionListener(this);
        btnCancel.addActionListener(this);
        setVisible(true);

    }

    public static void main(String[] args) {
        Bai3 b3 = new Bai3();
    }

    public boolean Check() {
        char[] a = txtpassword.getPassword();
        char[] b = txtconfirm.getPassword();

        String c = String.valueOf(a);
        String d = String.valueOf(b);
        if (txtusername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Can nhap username");
            txtusername.requestFocus();
            return false;
        } else if (c.equals("")) {
            JOptionPane.showMessageDialog(this, "Can nhap password");
            txtpassword.requestFocus();
            return false;
        } else if (d.equals("")) {
            JOptionPane.showMessageDialog(this, "Can nhap confign");
            txtpassword.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String click = ae.getActionCommand();
        System.out.println(click);
        if (click.equals("Signup")) {
            if (Check()) {
                char[] a = txtpassword.getPassword();
                char[] b = txtconfirm.getPassword();

                String c = String.valueOf(a);
                String d = String.valueOf(b);

                if (c.equals(d)) {
                    JOptionPane.showMessageDialog(this, "Dang nhap thanh cong");
                } else {
                    JOptionPane.showMessageDialog(this, "Dang nhap khong thanh cong");
                }
            }
        }
        if (click.equals("Cancel")) {
            System.exit(0);
        }
    }
}
