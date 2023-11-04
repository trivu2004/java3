/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide3;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ongmu
 */
public class DemoGridBagContraints3 extends JFrame implements ActionListener {
    JButton jButton;
    public DemoGridBagContraints3() {
//        JPanel jMain = new JPanel();
        setTitle("JTabbedPaneDemo");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        Container container = getContentPane();
        container.setLayout(gbl);
        
        JButton jbtn1 = new JButton("1: 0,1");
        JButton jbtn2 = new JButton("2: 1,1");
        JButton jbtn3 = new JButton("3: 1,2");
        JButton jbtn4 = new JButton("4: 0,3");
        JButton jbtn5 = new JButton("5: 2,2");
        JButton jbtn6 = new JButton("6: 4,1");
        JButton jbtn7 = new JButton("7: 0,5");
        JButton jbtn8 = new JButton("8: 1,6");
        JButton jbtn9 = new JButton("9: 2,8");

        gbc.insets = new Insets(5,5,5,5);
        
        gbc.weightx = 1; //Có 2 giá trị 0,1 cho hoặc không mở rộng theo x
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH; //mong muốn
        
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbl.setConstraints(jbtn1, gbc);
        container.add(jbtn1);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        
        gbl.setConstraints(jbtn2, gbc);
        container.add(jbtn2);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        
        gbl.setConstraints(jbtn3, gbc);
        container.add(jbtn3);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        
        gbl.setConstraints(jbtn4, gbc);
        container.add(jbtn4);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbl.setConstraints(jbtn5, gbc);
        container.add(jbtn5);
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        
        gbl.setConstraints(jbtn6, gbc);
        container.add(jbtn6);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        
        gbl.setConstraints(jbtn7, gbc);
        container.add(jbtn7);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        
        gbl.setConstraints(jbtn8, gbc);
        container.add(jbtn8);
        
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        
        gbl.setConstraints(jbtn9, gbc);
        container.add(jbtn9);
//        add(jMain);
    }
    
    public static void main(String[] args) {
        DemoGridBagContraints3 gbcd = new DemoGridBagContraints3();
        gbcd.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
