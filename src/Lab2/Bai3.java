/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class Bai3 extends JFrame implements ActionListener{
    private JButton btn1,btn2,btn3,btn4;
    private JPanel p1,p2,p3,p4;
    public Bai3(){
        JFrame frame = new JFrame("Lab 3 Bai 3");
        frame.setSize(600, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        p1 = new JPanel();
        p1.setBounds(20, 0, 200, 100);
        p1.setLayout(new GridLayout(2, 2, 15, 15));
        
        btn1 = new JButton("Message Dialog");
        btn1.setFont(new Font("Roboto", Font.BOLD, 15));

        btn2 = new JButton("Input Dialog");
        btn2.setFont(new Font("Roboto", Font.BOLD, 15));

        btn3 = new JButton("Confign Dialog");
        btn3.setFont(new Font("Roboto", Font.BOLD, 15));

        btn4 = new JButton("Option Dialog");
        btn4.setFont(new Font("Roboto", Font.BOLD, 15));
        
        p1.add(btn1);
        p1.add(btn2);
        p1.add(btn3);
        p1.add(btn4);
        frame.add(p1);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Bai3 b3 = new Bai3();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String click = ae.getActionCommand();
        if(click.equals("Message Dialog")){
            JOptionPane.showMessageDialog(this,"Please input your name");
        }
        if(click.equals("Input Dialog")){
            JOptionPane.showInputDialog(this,"Your name is");
        }
        if(click.equals("Confign Dialog")){
            int ret = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(ret == JOptionPane.YES_OPTION){
                
            }else{
                
            }
        }
        if(click.equals("Option Dialog")){
            int mess = JOptionPane.QUESTION_MESSAGE;
            String[] option = {"Java","C++","VB","PHP","Perl"};
            int code = JOptionPane.showOptionDialog(this, "What language do you prefer?", "Option Dialog Box", 0, mess, null, option,"PHP");
            JOptionPane.showMessageDialog(this, "Answer"+code);
        }
    }
}
