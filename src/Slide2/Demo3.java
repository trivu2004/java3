/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide2;

import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class Demo3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo Checkbox");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        JCheckBox jcb1 = new JCheckBox("C/C+");
        JCheckBox jcb2 = new JCheckBox("Python");
        JCheckBox jcb3 = new JCheckBox("C#");
        JCheckBox jcb4 = new JCheckBox("Java");
        panel.add(jcb1);
        panel.add(jcb2);
        panel.add(jcb3);
        panel.add(jcb4);
        frame.add(panel);
        frame.setVisible(true);
    }
}
