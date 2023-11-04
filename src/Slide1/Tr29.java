/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide1;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class Tr29 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        
        f.setSize(700, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Demo trang 29");
        JButton jbutton[] = new JButton[16];
        JPanel p = new JPanel(new GridLayout(4,4));
        for(int i = 0;i<16;i++){
            jbutton[i] = new JButton("Button: "+(i+1));
            p.add(jbutton[i]);
        }
        f.add(p);
        f.setVisible(true);
    }
}
