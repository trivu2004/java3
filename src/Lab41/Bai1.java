/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab41;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;

/**
 *
 * @author USER
 */
public class Bai1 extends JFrame {

    JButton btn1,btn2,btn3,btn4;

    public Bai1() {
        myGUI();
        this.setVisible(true);
    }

    public void myGUI() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.setFont(new Font("Roboto", Font.BOLD, 17));
        newItem.setFont(new Font("Roboto", Font.BOLD, 17));
        openItem.setFont(new Font("Roboto", Font.BOLD, 17));
        saveItem.setFont(new Font("Roboto", Font.BOLD, 17));

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(saveItem);

        JMenu colorMenu = new JMenu("Color");
        colorMenu.setFont(new Font("Roboto", Font.BOLD, 17));
        JRadioButtonMenuItem jrdRed = new JRadioButtonMenuItem("Red");
        JRadioButtonMenuItem jrdGreen = new JRadioButtonMenuItem("Green");
        JRadioButtonMenuItem jrdBlue = new JRadioButtonMenuItem("Blue");
        JCheckBoxMenuItem jcbTextColor = new JCheckBoxMenuItem("Text Color");
        jrdRed.setFont(new Font("Roboto", Font.BOLD, 17));
        jrdGreen.setFont(new Font("Roboto", Font.BOLD, 17));
        jrdBlue.setFont(new Font("Roboto", Font.BOLD, 17));
        jcbTextColor.setFont(new Font("Roboto", Font.BOLD, 17));
        ButtonGroup bt = new ButtonGroup();
        bt.add(jrdRed);
        bt.add(jrdGreen);
        bt.add(jrdBlue);

        JMenu systemMenu = new JMenu("System");
        systemMenu.setFont(new Font("Roboto", Font.BOLD, 17));
        JMenuItem aboutUs = new JMenuItem("About us");
        JMenuItem Exit = new JMenuItem("Exit");
        aboutUs.setFont(new Font("Roboto", Font.BOLD, 17));
        Exit.setFont(new Font("Roboto", Font.BOLD, 17));
        systemMenu.add(aboutUs);
        systemMenu.add(Exit);

        JToolBar toolBar = new JToolBar();
        toolBar.setSize(300, 30);

         btn1= new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\Luu1.png"));
         btn2= new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\nguoi.png"));
         btn3= new JButton(new ImageIcon("E:\\PS31493\\src\\Icon\\tat.png"));
         
         


        colorMenu.add(jrdRed);
        colorMenu.add(jrdGreen);
        colorMenu.add(jrdBlue);
        colorMenu.add(jcbTextColor);
        toolBar.add(btn1);
        toolBar.add(btn2);
        toolBar.add(btn3);
        toolBar.addSeparator();

        menuBar.add(fileMenu);
        menuBar.add(colorMenu);
        menuBar.add(systemMenu);
        setJMenuBar(menuBar);
        add(toolBar, BorderLayout.NORTH);

    }

    public static void main(String[] args) {
        new Bai1();
    }
}
