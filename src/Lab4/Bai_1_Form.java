/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class Bai_1_Form extends JFrame {

    JEditorPane edp;
    JTextField txt;

    public Bai_1_Form() {
        setTitle("Menu Java 3");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu File = new JMenu("File");

        JMenuItem menuNew = new JMenuItem("New");
        JMenuItem OpenMenu = new JMenuItem("Open");
        JMenuItem SaveMenu = new JMenuItem("Save");

        File.add(menuNew);
        File.add(OpenMenu);
        File.add(SaveMenu);

        menuBar.add(File);

        JMenu MenuColor = new JMenu("Color");
        JRadioButtonMenuItem rdRed = new JRadioButtonMenuItem("Red");
        JRadioButtonMenuItem rdGreen = new JRadioButtonMenuItem("Green");
        JRadioButtonMenuItem rdBlue = new JRadioButtonMenuItem("Blue");
        JCheckBoxMenuItem chkBoxMenu = new JCheckBoxMenuItem("TextBox");

        MenuColor.add(rdRed);
        MenuColor.add(rdGreen);
        MenuColor.add(rdBlue);
        MenuColor.addSeparator();//Đường ngang
        MenuColor.add(chkBoxMenu);
        menuBar.add(MenuColor);

        //Chọn 1 trong 3 màu
        ButtonGroup btnGroupCl = new ButtonGroup();
        btnGroupCl.add(rdRed);
        btnGroupCl.add(rdGreen);
        btnGroupCl.add(rdBlue);

        setJMenuBar(menuBar);

        edp = new JEditorPane();
        add(edp);

        txt = new JTextField("Fpoly", 50);
        Font f = new Font("Arial", Font.BOLD, 24);

        txt.setFont(f);
        add(txt, BorderLayout.SOUTH);
        setVisible(true);

        menuNew.getActionListeners();
        OpenMenu.getActionListeners();
        SaveMenu.getActionListeners();

        rdRed.getActionListeners();
        rdGreen.getActionListeners();
        rdBlue.getActionListeners();
        chkBoxMenu.getActionListeners();
    }

    ActionListener i = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e
        ) {
            switch (e.getActionCommand()) {
                case "New":
                    edp.setText("");
                    edp.requestFocus();
                    break;
                case "Open":
                    break;
                case "Save":
                    break;
                case "Red":
                    txt.setForeground(Color.red);
                    break;
                case "Green":
                    txt.setForeground(Color.green);
                    break;
                case "Blue":
                    txt.setForeground(Color.blue);
                    break;
            }

        }
    };

    public static void main(String[] args) {
        Bai_1_Form a = new Bai_1_Form();
    }

}
