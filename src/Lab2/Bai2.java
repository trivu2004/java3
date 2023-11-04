/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author USER
 */
public class Bai2 extends JFrame implements ActionListener {

    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btncong, btntru, btnnhan, btnchia, btnsqrt, btnphantram, btnx, btnbang, btnC, btncongtru;
    private JPanel p1, p2, p3, p4, p5, p6;
    private JTextField txtSo, txt2;
    private JLabel lbl1;
    private long a = 0;
    private String pheptoan = "";

    public Bai2() {
        JFrame frame = new JFrame("Lab 2 Bai 2");
        frame.setSize(700, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        p1 = new JPanel();
        p1.setBounds(600, 0, 100, 100);
        lbl1 = new JLabel("CASIO");
        lbl1.setFont(new Font("Roboto", Font.BOLD, 20));

        p2 = new JPanel();
        p2.setBounds(0, 50, 690, 50);
        txtSo = new JTextField();
        txtSo.setFont(new Font("Roboto", Font.BOLD, 20));
        txtSo.setPreferredSize(new Dimension(700, 50));
        txtSo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        txtSo.setForeground(Color.BLUE);
        p3 = new JPanel();
        p3.setBounds(0, 150, 700, 90);
        p3.setLayout(new GridLayout(1, 5, 15, 15));
        btn1 = new JButton("1");
        btn1.setFont(new Font("Roboto", Font.BOLD, 20));
        btn1.setBackground(Color.red);
        btn1.setForeground(Color.white);
        btn2 = new JButton("2");
        btn2.setFont(new Font("Roboto", Font.BOLD, 20));
        btn2.setBackground(Color.red);
        btn2.setForeground(Color.white);
        btn3 = new JButton("3");
        btn3.setFont(new Font("Roboto", Font.BOLD, 20));
        btn3.setBackground(Color.red);
        btn3.setForeground(Color.white);
        btnchia = new JButton("/");
        btnchia.setFont(new Font("Roboto", Font.BOLD, 20));
        btnchia.setBackground(new Color(239, 188, 2));
        btnchia.setForeground(Color.white);
        btnsqrt = new JButton("sqrt");
        btnsqrt.setFont(new Font("Roboto", Font.BOLD, 20));
        btnsqrt.setBackground(new Color(239, 188, 2));
        btnsqrt.setForeground(Color.white);

        p4 = new JPanel();
        p4.setBounds(0, 250, 700, 90);
        p4.setLayout(new GridLayout(1, 5, 15, 15));
        btn4 = new JButton("4");
        btn4.setFont(new Font("Roboto", Font.BOLD, 20));
        btn4.setBackground(Color.red);
        btn4.setForeground(Color.white);
        btn5 = new JButton("5");
        btn5.setFont(new Font("Roboto", Font.BOLD, 20));
        btn5.setBackground(Color.red);
        btn5.setForeground(Color.white);
        btn6 = new JButton("6");
        btn6.setFont(new Font("Roboto", Font.BOLD, 20));
        btn6.setBackground(Color.red);
        btn6.setForeground(Color.white);
        btnnhan = new JButton("*");
        btnnhan.setFont(new Font("Roboto", Font.BOLD, 20));
        btnnhan.setBackground(new Color(239, 188, 2));
        btnnhan.setForeground(Color.white);
        btnphantram = new JButton("%");
        btnphantram.setFont(new Font("Roboto", Font.BOLD, 20));
        btnphantram.setBackground(new Color(239, 188, 2));
        btnphantram.setForeground(Color.white);

        p5 = new JPanel();
        p5.setBounds(0, 350, 700, 90);
        p5.setLayout(new GridLayout(1, 5, 15, 15));
        btn7 = new JButton("7");
        btn7.setFont(new Font("Roboto", Font.BOLD, 20));
        btn7.setBackground(Color.red);
        btn7.setForeground(Color.white);
        btn8 = new JButton("8");
        btn8.setFont(new Font("Roboto", Font.BOLD, 20));
        btn8.setBackground(Color.red);
        btn8.setForeground(Color.white);
        btn9 = new JButton("9");
        btn9.setFont(new Font("Roboto", Font.BOLD, 20));
        btn9.setBackground(Color.red);
        btn9.setForeground(Color.white);
        btntru = new JButton("-");
        btntru.setFont(new Font("Roboto", Font.BOLD, 20));
        btntru.setBackground(new Color(239, 188, 2));
        btntru.setForeground(Color.white);
        btnx = new JButton("1/x");
        btnx.setFont(new Font("Roboto", Font.BOLD, 20));
        btnx.setBackground(new Color(239, 188, 2));
        btnx.setForeground(Color.white);

        p6 = new JPanel();
        p6.setBounds(0, 450, 700, 90);
        p6.setLayout(new GridLayout(1, 5, 15, 15));
        btn0 = new JButton("0");
        btn0.setFont(new Font("Roboto", Font.BOLD, 20));
        btn0.setBackground(Color.red);
        btn0.setForeground(Color.white);
        btncongtru = new JButton("+/-");
        btncongtru.setFont(new Font("Roboto", Font.BOLD, 20));
        btncongtru.setBackground(Color.red);
        btncongtru.setForeground(Color.white);
        btnC = new JButton("C");
        btnC.setFont(new Font("Roboto", Font.BOLD, 20));
        btnC.setBackground(Color.red);
        btnC.setForeground(Color.white);
        btncong = new JButton("+");
        btncong.setFont(new Font("Roboto", Font.BOLD, 20));
        btncong.setBackground(new Color(239, 188, 2));
        btncong.setForeground(Color.white);
        btnbang = new JButton("=");
        btnbang.setFont(new Font("Roboto", Font.BOLD, 20));
        btnbang.setBackground(new Color(239, 188, 2));
        btnbang.setForeground(Color.white);

        p1.add(lbl1);
        p2.add(txtSo);
        p3.add(btn1);
        p3.add(btn2);
        p3.add(btn3);
        p3.add(btnchia);
        p3.add(btnsqrt);
        p4.add(btn4);
        p4.add(btn5);
        p4.add(btn6);
        p4.add(btnnhan);
        p4.add(btnphantram);
        p5.add(btn7);
        p5.add(btn8);
        p5.add(btn9);
        p5.add(btntru);
        p5.add(btnx);

        p6.add(btn0);
        p6.add(btncongtru);
        p6.add(btnC);
        p6.add(btncong);
        p6.add(btnbang);

        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.add(p5);
        frame.add(p6);

        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnC.addActionListener(this);
        btnbang.addActionListener(this);
        btnchia.addActionListener(this);
        btncong.addActionListener(this);
        btncongtru.addActionListener(this);
        btnnhan.addActionListener(this);
        btnx.addActionListener(this);
        btntru.addActionListener(this);
        btnphantram.addActionListener(this);
        btnsqrt.addActionListener(this);
        btnC.addActionListener(this);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Bai2 b2 = new Bai2();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String click = ae.getActionCommand();
        if (click.equals("1")) {
            String gt = txtSo.getText();
            if (gt.length() < 12) {
                long so = Long.parseLong(gt + "1");
                txtSo.setText(String.valueOf(so));
            }

        }
        if (click.equals("2")) {
            String gt = txtSo.getText();
            if (gt.length() < 12) {
                long so = Long.parseLong(gt + "2");
                txtSo.setText(String.valueOf(so));
            }

        }
        if (click.equals("3")) {
            String gt = txtSo.getText();
            if (gt.length() < 12) {
                long so = Long.parseLong(gt + "3");
                txtSo.setText(String.valueOf(so));
            }

        }

        if (click.equals("4")) {
            String gt = txtSo.getText();
            if (gt.length() < 12) {
                long so = Long.parseLong(gt + "4");
                txtSo.setText(String.valueOf(so));
            }

        }
        if (click.equals("5")) {
            String gt = txtSo.getText();
            if (gt.length() < 12) {
                long so = Long.parseLong(gt + "5");
                txtSo.setText(String.valueOf(so));
            }

        }
        if (click.equals("6")) {
            String gt = txtSo.getText();
            if (gt.length() < 12) {
                long so = Long.parseLong(gt + "6");
                txtSo.setText(String.valueOf(so));
            }

        }
        if (click.equals("7")) {
            String gt = txtSo.getText();
            if (gt.length() < 12) {
                long so = Long.parseLong(gt + "7");
                txtSo.setText(String.valueOf(so));
            }

        }
        if (click.equals("8")) {
            String gt = txtSo.getText();
            if (gt.length() < 12) {
                long so = Long.parseLong(gt + "8");
                txtSo.setText(String.valueOf(so));
            }

        }
        if (click.equals("9")) {
            String gt = txtSo.getText();
            if (gt.length() < 12) {
                long so = Long.parseLong(gt + "9");
                txtSo.setText(String.valueOf(so));
            }

        }
        if (click.equals("0")) {
            String gt = txtSo.getText();
            if (gt.length() < 12) {
                long so = Long.parseLong(gt + "0");
                txtSo.setText(String.valueOf(so));
            }

        }
        if (click.equals("+")) {
            a = Long.parseLong(txtSo.getText());
            pheptoan = "+";
            txtSo.setText("");
        }
        if (click.equals("-")) {
            a = Long.parseLong(txtSo.getText());
            pheptoan = "-";
            txtSo.setText("");
        }
        if (click.equals("*")) {
            a = Long.parseLong(txtSo.getText());
            pheptoan = "*";
            txtSo.setText("");
        }
        if (click.equals("")) {
            a = Long.parseLong(txtSo.getText());
            pheptoan = "/";
            txtSo.setText("");
        }
        if (click.equals("%")) {
            a = Long.parseLong(txtSo.getText());
            pheptoan = "%";
            txtSo.setText("");
        }
        if (click.equals("C")) {
            txtSo.setText("");

        }
        if (click.equals("sqrt")) {
            a = Long.parseLong(txtSo.getText());
            pheptoan = "sqrt";
        }
        if (click.equals("=")) {
            long kq = 0;
            long b = Long.parseLong(txtSo.getText());
            if (pheptoan.equals("+")) {
                kq = a + b;
                txtSo.setText(String.valueOf(kq));
            } else if (pheptoan.equals("-")) {
                kq = a - b;
                txtSo.setText(String.valueOf(kq));
            } else if (pheptoan.equals("*")) {
                kq = a * b;
                txtSo.setText(String.valueOf(kq));
            } else if (pheptoan.equals("/")) {
                kq = a / b;
                txtSo.setText(String.valueOf(kq));
            } else if (pheptoan.equals("%")) {
                kq = a % b;
                txtSo.setText(String.valueOf(kq));
            } else if (pheptoan.equals("sqrt")) {
                kq = (long) Math.sqrt(a);
                txtSo.setText(String.valueOf(kq));
            }
            if(a == 0 || b == 0){
            JOptionPane.showMessageDialog(this,"Loi");
        }
        }
        

    }
}
