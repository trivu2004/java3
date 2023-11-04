/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Slider;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author USER
 */
public class Bai3 extends JFrame implements ActionListener, ChangeListener {

    JFrame frame;
    JSlider slider;
    JLabel lblvalue, lblFont;
    JTextField txtvalue;
    JButton btnvalue;

    public Bai3() {
        GUI();
        frame.setVisible(true);
        kk();
    }

    public void GUI() {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 45);
        slider.setBounds(10, 10, 550, 100);

        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(2);

        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(this);
        lblvalue = new JLabel("Gia tri hien tai: ");
        lblvalue.setBounds(20, 200, 100, 30);

        txtvalue = new JTextField();
        txtvalue.setBounds(120, 200, 100, 35);

        btnvalue = new JButton("Set Value");
        btnvalue.setBounds(230, 200, 100, 35);

        lblFont = new JLabel("Font");
        lblFont.setBounds(350, 300, 100, 35);

        frame.add(slider);
        frame.add(lblvalue);
        frame.add(txtvalue);
        frame.add(btnvalue);
        frame.add(lblFont);

        btnvalue.addActionListener(this);
    }

    public static void main(String[] args) {
        new Bai3();
    }

    public void kk() {
        int kh = slider.getValue();
        lblFont.setFont(new Font("Roboto", Font.BOLD, kh));
        txtvalue.setText(String.valueOf(kh));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnvalue) {
            int ko = Integer.valueOf(txtvalue.getText());
            lblFont.setFont(new Font("Roboto", Font.BOLD, ko));
            slider.setValue(ko);
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        if (ce.getSource() == slider) {
            kk();

        }
    }
}
