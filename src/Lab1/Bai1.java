/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javafx.scene.control.CheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author USER
 */
public class Bai1 {

    JPanel controlPanel;
    JLabel headerLable, statusLable;
    JFrame mainJFrame;

    public Bai1() {
        mainJFrame = new JFrame("Lab1 bai 1");
        mainJFrame.setSize(600, 400);
        mainJFrame.setLocationRelativeTo(null);
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainJFrame.setLayout(new GridLayout(3, 1));

        controlPanel = new JPanel(new FlowLayout());

        final JCheckBox chkApple = new JCheckBox("Apple");
        final JCheckBox chkMango = new JCheckBox("Mango");
        final JCheckBox chkPeer = new JCheckBox("Peer");
        final ButtonGroup bt = new ButtonGroup();
        bt.add(chkApple);
        bt.add(chkMango);
        bt.add(chkPeer);
        chkApple.setMnemonic(KeyEvent.VK_A);
        chkMango.setMnemonic(KeyEvent.VK_M);
        chkPeer.setMnemonic(KeyEvent.VK_P);
        chkApple.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLable.setText("Apple Checkbox: "+(e.getStateChange() == 1 ? "checked" : "unchecked"));
                
                //neu ma trong truong hop chkApple duoc click vao thi no se thay doi bang apple checkbox
                //va no se kiem tra tinh trang checkbox
            }
        });
        chkMango.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLable.setText("Mango Checkbox: "+(e.getStateChange() == 1 ? "checked" : "unchecked"));
                
                //neu ma trong truong hop chkApple duoc click vao thi no se thay doi bang apple checkbox
                //va no se kiem tra tinh trang checkbox
            }
        });
        chkPeer.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLable.setText("Peer Checkbox: "+(e.getStateChange() == 1 ? "checked" : "unchecked"));
                
                //neu ma trong truong hop chkApple duoc click vao thi no se thay doi bang apple checkbox
                //va no se kiem tra tinh trang checkbox
            }
        });
        controlPanel.add(chkApple);
        controlPanel.add(chkMango);
        controlPanel.add(chkPeer);
        headerLable = new JLabel("Header", JLabel.CENTER);
        statusLable = new JLabel("Status", JLabel.CENTER);

        mainJFrame.add(headerLable);

        mainJFrame.add(controlPanel);
        mainJFrame.add(statusLable);
        mainJFrame.setVisible(true);

    }

    public static void main(String[] args) {
        Bai1 b1 = new Bai1();
    }
}
