/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author USER
 */
public class Tr06b extends JFrame implements ActionListener {

    JPanel p;
    JButton btnYellow, btnRed;
    JLabel lblInfor;

    public Tr06b() {
        setSize(700, 500);
        setTitle("Chuyen doi mau");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new JPanel();

        btnYellow = new JButton("Yellow");
        btnRed = new JButton("Red");
        lblInfor = new JLabel("Nut chon");

        p.add(btnYellow);
        p.add(btnRed);
        
        p.setBorder(new LineBorder(Color.yellow,5));
        p.setBorder(new TitledBorder(new LineBorder(Color.yellow,2),"Test"));
                
        p.add(lblInfor);
        add(p);
        btnYellow.addActionListener(this);
        btnRed.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();
        if (s.equals("Yellow")) {
            p.setBackground(Color.yellow);
            lblInfor.setText("Ban chon nut mau vang");
        }
        if(s.equals("Red")){
            p.setBackground(Color.red);
            lblInfor.setText("Ban chon nut mau do");
        }
    }

}
