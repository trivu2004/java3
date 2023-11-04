/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Bai1 extends JFrame implements ActionListener {

    JFrame frame;
    JPanel p1, p2, p3;
    JButton btnRed, btnGreen, btnYellow,btnNorth,btnWest,btnCenter,btnEast,btnSouth;
    JTextField txt1;

    public Bai1() {
        GUI();
        frame.setVisible(true);

    }

    public void GUI() {
        frame = new JFrame();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        p1 = new JPanel();
        p1.setBounds(10, 10, 660, 100);
        p1.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        btnRed = new JButton("Red");
        btnRed.setFont(new Font("Roboto", Font.BOLD, 18));

        btnGreen = new JButton("Green");
        btnGreen.setFont(new Font("Roboto", Font.BOLD, 18));

        btnYellow = new JButton("Yellow");
        btnYellow.setFont(new Font("Roboto", Font.BOLD, 18));
        
        p2 = new JPanel();
        p2.setBounds(10, 130, 660, 200);
        p2.setLayout(new BorderLayout());
        
        btnNorth = new JButton("North");
        btnNorth.setFont(new Font("Roboto", Font.BOLD, 18));
        
        btnCenter = new JButton("Center");
        btnCenter.setFont(new Font("Roboto", Font.BOLD, 18));
        
        btnWest = new JButton("West");
        btnWest.setFont(new Font("Roboto", Font.BOLD, 18));
        
        btnEast = new JButton("East");
        btnEast.setFont(new Font("Roboto", Font.BOLD, 18));
        
        btnSouth = new JButton("South");
        btnSouth.setFont(new Font("Roboto", Font.BOLD, 18));
        
        txt1 = new JTextField();
        txt1.setBounds(10, 350, 660, 50);
        txt1.setFont(new Font("Roboto", Font.BOLD, 18));
        txt1.setForeground(Color.green);
        
        p3 = new JPanel();
        p3.setBounds(10, 420, 660, 200);
        p3.setLayout(new GridLayout(2,5,15,15));
        p3.setBackground(Color.pink);
        
        JButton[] btn = new JButton[10];
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton("Button"+(i+1));
            btn[i].setText("");
            p3.add(btn[i]);
        }
        
        

        p1.add(btnRed);
        p1.add(btnGreen);
        p1.add(btnYellow);
        
        p2.add(btnNorth,BorderLayout.NORTH);
        p2.add(btnCenter,BorderLayout.CENTER);
        p2.add(btnEast,BorderLayout.EAST);
        p2.add(btnSouth,BorderLayout.SOUTH);
        p2.add(btnWest,BorderLayout.WEST);
        
        frame.add(p1);
        frame.add(p2);
        frame.add(txt1);
        frame.add(p3);
        btnRed.addActionListener(this);
        btnGreen.addActionListener(this);
        btnYellow.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== btnRed){
            p1.setBackground(Color.red);
        }else if(ae.getSource()== btnGreen){
            p1.setBackground(Color.GREEN);
        }else if(ae.getSource()== btnYellow){
            p1.setBackground(Color.yellow);
        }
    }

    public static void main(String[] args) {
        new Bai1();
    }

}
