/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

/**
 *
 * @author USER
 */
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Bai4 extends JFrame implements ActionListener {

    private JPanel p1, p2, p3, p4;
    private JLabel lblSo1, lblSo2, lblKetQua, lblCong, lblResult, lblScore;
    private JButton btn1, btn2, btn3, btnReset;
    Random rd = new Random();
    int score = 0;

    public Bai4() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);

        p1 = new JPanel(new FlowLayout(FlowLayout.LEADING, 30, 20));
        p1.setBounds(0, 0, 400, 100);

        p2 = new JPanel(new FlowLayout(FlowLayout.LEADING, 30, 0));
        p2.setBounds(0, 100, 400, 100);

        p3 = new JPanel(new FlowLayout(FlowLayout.LEADING, 30, 0));
        p3.setBounds(0, 200, 400, 100);

        p4 = new JPanel(new FlowLayout(FlowLayout.LEADING, 170, 0));
        p4.setBounds(0, 300, 400, 100);

        lblSo1 = new JLabel("0");
        lblSo1.setBounds(0, 0, 100, 30);

        lblCong = new JLabel("+");
        lblCong.setBounds(0, 0, 100, 30);

        lblSo2 = new JLabel("0");
        lblSo2.setBounds(0, 0, 100, 30);

        lblKetQua = new JLabel("0");
        lblKetQua.setBounds(0, 0, 100, 30);
        lblKetQua.setVisible(false);

        lblScore = new JLabel("Score: 0");
        lblScore.setBounds(0, 0, 100, 30);

        btn1 = new JButton("1");
        btn1.setBounds(0, 0, 100, 30);
        btn1.addActionListener(this);

        btn2 = new JButton("2");
        btn2.setBounds(0, 0, 100, 30);
        btn2.addActionListener(this);

        btn3 = new JButton("3");
        btn3.setBounds(0, 0, 100, 30);
        btn3.addActionListener(this);

        lblResult = new JLabel("Hay chon so dung");
        lblResult.setBounds(0, 0, 100, 30);

        btnReset = new JButton("Reset");
        btnReset.setBounds(0, 0, 100, 30);
        btnReset.addActionListener(this);

        p1.add(lblSo1);
        p1.add(lblCong);
        p1.add(lblSo2);
        p1.add(lblKetQua);
        p1.add(lblScore);

        p2.add(btn1);
        p2.add(btn2);
        p2.add(btn3);

        p3.add(lblResult);

        p4.add(btnReset);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        setVisible(true);
    }

    public int RandomNumber() {
        int Result = 0;
        Result = rd.nextInt(99) + 1;
        return Result;
    }

    public void ResetValues() {
        btn1.setText("1");
        btn2.setText("2");
        btn3.setText("3");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int so1 = RandomNumber();
        int so2 = RandomNumber();
        int ChosenButton = rd.nextInt(3) + 1;
        int ketQua = so1 + so2;
        int b1 = Integer.valueOf(btn1.getText());
        int b2 = Integer.valueOf(btn2.getText());
        int b3 = Integer.valueOf(btn3.getText());

        if (e.getSource() == btnReset) {
            lblSo1.setText(String.valueOf(so1));
            lblSo2.setText(String.valueOf(so2));
            lblKetQua.setText(String.valueOf(ketQua));

            if (b1 == ChosenButton) {
                btn1.setText(ketQua + "");
                System.out.println(ketQua);
            } else {
                int sclnhieu = rd.nextInt(9)+1;
                btn1.setText(String.valueOf(ketQua+sclnhieu));
            }
            if (b2 == ChosenButton) {
                btn2.setText(ketQua + "");
                System.out.println(ketQua);
            } else {
                int scl = rd.nextInt(11)+1;
                btn2.setText(String.valueOf(ketQua-scl));
            }
            if (b3 == ChosenButton) {
                btn3.setText(ketQua + "");
                System.out.println(ketQua);
            } else {
                int sclit = rd.nextInt(5)+1;
                btn3.setText(String.valueOf(ketQua+sclit));
            }
        }
        if (e.getSource() == btn1) {
            if (btn1.getText().equalsIgnoreCase(lblKetQua.getText())) {
                JOptionPane.showMessageDialog(this, "Ban da chon dung");
                ResetValues();
                score++;
            } else {
                JOptionPane.showMessageDialog(this, "Ban da chon sai");
                score = 0;
                lblScore.setText("Score: " + score);
            }
        }
        if (e.getSource() == btn2) {
            if (btn2.getText().equalsIgnoreCase(lblKetQua.getText())) {
                JOptionPane.showMessageDialog(this, "Ban da chon dung");
                ResetValues();
                score++;
            } else {
                JOptionPane.showMessageDialog(this, "Ban da chon sai");
                score = 0;
                lblScore.setText("Score: " + score);
            }
        }
        if (e.getSource() == btn3) {
            if (btn3.getText().equalsIgnoreCase(lblKetQua.getText())) {
                JOptionPane.showMessageDialog(this, "Ban da chon dung");
                ResetValues();
                score++;
            } else {
                JOptionPane.showMessageDialog(this, "Ban da chon sai");
                score = 0;
                lblScore.setText("Score: " + score);
            }
        }
        lblScore.setText("Score: " + score);
    }

    public static void main(String[] args) {
        new Bai4();
    }
}