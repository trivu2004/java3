/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide2;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 *
 * @author USER
 */
public class Demo4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo4");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Ý kien cua ban"));
        panel.setLayout(new GridLayout(4,1));
        
        JRadioButton rd1 = new JRadioButton("Lap trinh java rat de");
        JRadioButton rd2 = new JRadioButton("Design GUI java rat de");
        JRadioButton rd3 = new JRadioButton("Viet web tren java rat de");
        JRadioButton rd4 = new JRadioButton("Tat ca deu kho");
        
        ButtonGroup group = new ButtonGroup();
        group.add(rd1);
        group.add(rd2);
        group.add(rd3);
        group.add(rd4);
        
        panel.add(rd1);
        panel.add(rd2);
        panel.add(rd3);
        panel.add(rd4);
        frame.add(panel);
        frame.setVisible(true);
    }
}
