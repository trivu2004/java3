/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide3;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import jdk.nashorn.internal.runtime.Debug;

/**
 *
 * @author USER
 */
public class Demo extends JFrame implements ActionListener{
    private JButton btn1,btn2,btn3;
    private JTextField txtName;
    private JLabel lblname;
    private JPanel p1,p2,p3,p4,p5,p6;
    public Demo(){
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        
        p1 = new JPanel();
        p1.setBounds(50, 0, 300, 100);
        p1.setLayout(new GridLayout(1, 2,15,15));
        
        btn1 = new JButton("Show card1");
        btn1.setFont(new Font("Roboto", Font.BOLD, 20));
        btn2 = new JButton("Show card2");
        btn2.setFont(new Font("Roboto", Font.BOLD, 20));
        
        p2 = new JPanel();
        p2.setBounds(10, 200, 70, 50);
        
        p3 = new JPanel();
        p3.setBounds(80, 200, 200, 100);
        
        
        txtName = new JTextField();
        txtName.setFont(new Font("Roboto", Font.BOLD, 20));
        txtName.setPreferredSize(new Dimension(220, 30));
        
        lblname = new JLabel("Name: ");
        lblname.setFont(new Font("Roboto", Font.BOLD, 20));
        
        p4 = new JPanel();
        p4.setBounds(300, 195, 100, 100);
        
        btn3 = new JButton("Action");
        btn3.setFont(new Font("Roboto", Font.BOLD, 20));
        
        p1.add(btn1);
        p1.add(btn2);
        p2.add(lblname);
        p3.add(txtName);
        p4.add(btn3);
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        
        frame.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    public static void main(String[] args) {
        Demo dm = new Demo();
    }
}
