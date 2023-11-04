/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class MayTinh extends JFrame implements ActionListener{
    JFrame fmain;
    JTextField txtSo1,txtSo2,txtKQ;
    JButton btncong,btntru,btnNhan,btnChia;
    public MayTinh(){
        maytinhGUI();
    }
    public void maytinhGUI(){
        fmain = new JFrame("May Tinh Bo Tui");
        fmain.setSize(400, 400);
        fmain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fmain.setLocationRelativeTo(null);
        fmain.setResizable(false);
        
        fmain.setLayout(new GridLayout(4,1));
        
        JPanel so1panel = new JPanel();
        so1panel.setLayout(new GridLayout(1,2));
        JLabel lblSo1 = new JLabel("first number: ");
        txtSo1 = new JTextField(30);
        so1panel.add(lblSo1);
        so1panel.add(txtSo1);
        fmain.add(so1panel);
        
        JPanel so2panel = new JPanel();
        so2panel.setLayout(new GridLayout(1,2));
        JLabel lblSo2 = new JLabel("Second number: ");
        txtSo2 = new JTextField(30);
        so2panel.add(lblSo2);
        so2panel.add(txtSo2);
        fmain.add(so2panel);
        
        JPanel KQ = new JPanel();
        KQ.setLayout(new GridLayout(1,2));
        JLabel lblKQ = new JLabel("KQ: ");
        txtKQ = new JTextField(30);
        KQ.add(lblKQ);
        KQ.add(txtKQ);
        txtKQ.setEnabled(false);
        fmain.add(KQ);
        
        JPanel nutbamPanelp = new JPanel();
        nutbamPanelp.setLayout(new FlowLayout());
        btncong = new JButton("+");
        btntru = new JButton("-");
        btnNhan = new JButton("*");
        btnChia = new JButton("/");
        
        nutbamPanelp.add(btncong);
        nutbamPanelp.add(btntru);
        nutbamPanelp.add(btnNhan);
        nutbamPanelp.add(btnChia);
        
        btncong.addActionListener(this);
        btntru.addActionListener(this);
        btnNhan.addActionListener(this);
        btnChia.addActionListener(this);
        fmain.add(nutbamPanelp);
        fmain.setVisible(true);
    }
    public boolean CheckNull(){
        if(txtSo1.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Nhap so 1!");
            txtSo1.requestFocus();
            return false;
        }else if(txtSo2.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Nhap so 2!");
            txtSo2.requestFocus();
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        MayTinh mt = new MayTinh();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btncong){
            if(CheckNull()){
                float so1,so2,kq;
                so1 = Float.valueOf(txtSo1.getText());
                so2 = Float.valueOf(txtSo2.getText());
                kq = so1 + so2;
                 txtKQ.setText(String.valueOf(kq)) ;
            }
        }else if(ae.getSource() == btntru){
            if(CheckNull()){
                float so1,so2,kq;
                so1 = Float.valueOf(txtSo1.getText());
                so2 = Float.valueOf(txtSo2.getText());
                kq = so1 - so2;
                 txtKQ.setText(String.valueOf(kq)) ;
            }
        }else if(ae.getSource() == btnNhan){
            if(CheckNull()){
                float so1,so2,kq;
                so1 = Float.valueOf(txtSo1.getText());
                so2 = Float.valueOf(txtSo2.getText());
                kq = so1 * so2;
                 txtKQ.setText(String.valueOf(kq)) ;
            }
        }else if(ae.getSource() == btnChia){
            if(CheckNull()){
                float so1,so2,kq;
                so1 = Float.valueOf(txtSo1.getText());
                so2 = Float.valueOf(txtSo2.getText());
                if(so2!=0){
                kq = so1 / so2;
                 txtKQ.setText(String.valueOf(kq)) ;
                }
            }
        }
    }
}
