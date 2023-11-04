/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide2;

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
public class Tr12 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Demo Trang 12");
        f.setLocationRelativeTo(null);
        f.setSize(500,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon vnIcon = new ImageIcon("src\\img2\\Vietnam_icon.png","Lock");
        ImageIcon vnIconOver = new ImageIcon("src\\img2\\Vietnam_icon_2.png","Lock");
        ImageIcon vnIconPress = new ImageIcon("src\\img2\\Vietnam_icon_3.png","Lock");
        
        ImageIcon jpIcon = new ImageIcon("img\\Japan_small.png","Lock");
        ImageIcon amIcon = new ImageIcon("img\\Americal_small.png","Lock");
        
        JPanel p = new JPanel();
        JButton btnVNFlag = new JButton("Viet Nam",vnIcon);
        btnVNFlag.setPressedIcon(vnIconPress);
        btnVNFlag.setRolloverIcon(vnIconOver);
        JButton btnJPFlag = new JButton("Nhat Ban",jpIcon);
        btnJPFlag.setToolTipText("Click here");
        
        JButton btnAMFlag = new JButton("Nước Mỹ",amIcon);
        
        p.add(btnVNFlag);
        p.add(btnJPFlag);
        p.add(btnAMFlag);
        p.setBorder(new TitledBorder(new LineBorder(Color.blue),"Demo"));
        f.add(p);
        f.pack();
        f.setLocationRelativeTo(null);
        
        btnAMFlag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bạn đã nhấn nút mước Mỹ");
            }
        }
        
        );
        f.setVisible(true);
    }
}
