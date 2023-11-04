/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide2;

import com.sun.prism.Image;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author USER
 */
public class Demo1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My frame"); 
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon usIcon = new ImageIcon("C:\\Users\\USER\\OneDrive\\Hình ảnh\\89.jpg");
        ImageIcon usIcon1 = new ImageIcon("C:\\Users\\USER\\OneDrive\\Hình ảnh\\89.jpg");
        ImageIcon usIcon2 = new ImageIcon("C:\\Users\\USER\\OneDrive\\Hình ảnh\\89.jpg");
        
        JPanel jp = new JPanel();
        JButton bt1 = new JButton("Click it",usIcon);
        JButton bt2 = new JButton("Click it",usIcon1);
        JButton bt3 = new JButton("Click it",usIcon2);
        bt1.setPressedIcon(usIcon);
        bt1.setPressedIcon(usIcon1);
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,"Ban chon viet nam");
            }
        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,"Ban chon My");
            }
        });
        jp.add(bt1);
        jp.add(bt2);
        jp.add(bt3);
        jp.setBorder(new TitledBorder(new LineBorder(Color.yellow),"Demo"));
        frame.add(jp);
        frame.setVisible(true);
    }
}
