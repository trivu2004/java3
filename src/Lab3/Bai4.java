/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author USER
 */
public class Bai4 extends JFrame implements ActionListener{
    JFrame frame;
    JLabel lblheader,lblFirstname,lblLastname,lblContact,lblAddress   
            ,lblAcamDetails,lblQualification,lblSpecification,lblEnollFor,lblExDetails,lblHobbies,lblSport;
    JTextField txtFirstname,txtLastname,txtContact,txtQualification,txtSpecification,txtEnollFor,txtHobbies,txtSport;
    JTextArea txtAddress;
    JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    
    JButton btnSave,btnReset,btnExit;
    
            
    public Bai4(){
        GUI();
        frame.setVisible(true);
    }
    public void GUI(){
        frame = new JFrame();
        frame.setSize(800, 1000);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        p1 = new JPanel();
        p1.setBounds(100, 10, 300, 50);
        
        lblheader = new JLabel("STUDENT REGISTRATION");
        lblheader.setFont(new Font("Roboto", Font.BOLD, 22));
        
        p2 = new JPanel();
        p2.setBounds(20, 100, 630, 330);
        p2.setBorder(new TitledBorder(new LineBorder(Color.red, 3), "Person Details", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Roboto", Font.BOLD, 18), Color.BLUE));
        p2.setLayout(null);
        
        lblFirstname = new JLabel("First Name");
        lblFirstname.setBounds(30, 30, 100, 50);
        lblFirstname.setFont(new Font("Roboto", Font.BOLD, 18));
        
        txtFirstname = new JTextField();
        txtFirstname.setBounds(140, 40, 400, 30);
        txtFirstname.setFont(new Font("Roboto", Font.BOLD, 18));
        
        lblLastname = new JLabel("Last Name");
        lblLastname.setBounds(30, 80, 100, 50);
        lblLastname.setFont(new Font("Roboto", Font.BOLD, 18));
        
        txtLastname = new JTextField();
        txtLastname.setBounds(140, 90, 400, 30);
        txtLastname.setFont(new Font("Roboto", Font.BOLD, 18));
        
        lblContact = new JLabel("Contact");
        lblContact.setBounds(30, 130, 100, 50);
        lblContact.setFont(new Font("Roboto", Font.BOLD, 18));
        
        txtContact = new JTextField();
        txtContact.setBounds(140, 140, 400, 30);
        txtContact.setFont(new Font("Roboto", Font.BOLD, 18));
        
        lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 180, 100, 50);
        lblAddress.setFont(new Font("Roboto", Font.BOLD, 18));
        
        txtAddress = new JTextArea(50,0);
        txtAddress.setLineWrap(true);
        txtAddress.setFont(new Font("Roboto", Font.BOLD, 22));
        JScrollPane scrollPane = new JScrollPane(txtAddress);
        scrollPane.setBounds(140, 195, 400, 100);
        
        p3 = new JPanel();
        p3.setBounds(20, 440 , 630, 200);
        p3.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 3), "Acamedic Details", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Roboto", Font.BOLD, 18), Color.GRAY));
        p3.setLayout(null);
        
        lblQualification = new JLabel("Highest Qualificartion");
        lblQualification.setBounds(40, 30, 200, 50);
        lblQualification.setFont(new Font("Roboto", Font.BOLD, 18));
        
        txtQualification = new JTextField();
        txtQualification.setFont(new Font("Roboto", Font.BOLD, 18));
        txtQualification.setBounds(240, 40, 300 , 30);
        
        lblSpecification = new JLabel("Specification");
        lblSpecification.setBounds(40, 90, 200, 50);
        lblSpecification.setFont(new Font("Roboto", Font.BOLD, 18));
        
        txtSpecification = new JTextField();
        txtSpecification.setFont(new Font("Roboto", Font.BOLD, 18));
        txtSpecification.setBounds(240, 100, 300 , 30);
        
        lblEnollFor = new JLabel("EnollFor ");
        lblEnollFor.setBounds(40, 140, 200, 50);
        lblEnollFor.setFont(new Font("Roboto", Font.BOLD, 18));
        
        txtEnollFor = new JTextField();
        txtEnollFor.setFont(new Font("Roboto", Font.BOLD, 18));
        txtEnollFor.setBounds(240, 150, 300 , 30);
        
        p4 = new JPanel();
        p4.setBounds(20, 650, 630, 160);
        p4.setBorder(new TitledBorder(new LineBorder(Color.YELLOW, 3), "Extracurricular Details", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Roboto", Font.BOLD, 18), Color.RED));
        p4.setLayout(null);
        
        lblHobbies = new JLabel("Hobbies ");
        lblHobbies.setBounds(40, 30, 200, 50);
        lblHobbies.setFont(new Font("Roboto", Font.BOLD, 18));
        
        txtHobbies = new JTextField();
        txtHobbies.setFont(new Font("Roboto", Font.BOLD, 18));
        txtHobbies.setBounds(200, 40, 300 , 30);
        
        lblSport = new JLabel("Sport ");
        lblSport.setBounds(40, 90, 200, 50);
        lblSport.setFont(new Font("Roboto", Font.BOLD, 18));
        
        txtSport = new JTextField();
        txtSport.setFont(new Font("Roboto", Font.BOLD, 18));
        txtSport.setBounds(200, 100, 300 , 30);
        
        p5 = new JPanel();
        p5.setBounds(20, 830, 630, 100);
        p5.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        
        p5.setLayout(null);
        
        btnSave = new JButton("Save");
        btnSave.setBounds(100, 25, 100, 50);
        btnSave.setFont(new Font("Roboto", Font.BOLD, 20));
        
        btnReset = new JButton("Reset");
        btnReset.setBounds(250, 25, 100, 50);
        btnReset.setFont(new Font("Roboto", Font.BOLD, 20));
        
        btnExit = new JButton("Exit");
        btnExit.setBounds(400, 25, 100, 50);
        btnExit.setFont(new Font("Roboto", Font.BOLD, 20));
        
        
        
        p1.add(lblheader);
        p2.add(lblFirstname);
        p2.add(txtFirstname);
        p2.add(lblLastname);
        p2.add(txtLastname);
        p2.add(lblContact);
        p2.add(txtContact);
        p2.add(lblAddress);
        p2.add(scrollPane);
        p3.add(lblQualification);
        p3.add(txtQualification);
        p3.add(lblSpecification);
        p3.add(txtSpecification);
        p3.add(lblEnollFor);
        p3.add(txtEnollFor);
        p4.add(lblHobbies);
        p4.add(txtHobbies);
        p4.add(lblSport);
        p4.add(txtSport);
        p5.add(btnSave);
        p5.add(btnReset);
        p5.add(btnExit);
        
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.add(p5);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int ret = JOptionPane.showConfirmDialog(null,"Ban co muon dong chuong trinh khong!","Confign",JOptionPane.YES_NO_OPTION);
                if(ret==JOptionPane.YES_OPTION){
                    System.exit(0);
                }else if(ret==JOptionPane.NO_OPTION){
                    setDefaultCloseOperation(0);
                }
                
            }
        });
        
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);
        btnSave.addActionListener(this);
    }
    public static void main(String[] args) {
        new Bai4();
    }
    public boolean Check(){
        if(txtFirstname.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Chua nhap first name");
            txtFirstname.requestFocus();
            return false;
        }
        if(txtLastname.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Chua nhap Last name");
            txtLastname.requestFocus();
            return false;
        }
        if(txtContact.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Chua nhap Contact");
            txtContact.requestFocus();
            return false;
        }
        if(txtAddress.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Chua nhap Address");
            txtAddress.requestFocus();
            return false;
        }
        if(txtQualification.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Chua nhap Qualification");
            txtQualification.requestFocus();
            return false;
        }
        if(txtSpecification.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Chua nhap Specification");
            txtSpecification.requestFocus();
            return false;
        }
        if(txtEnollFor.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Chua nhap EnollFor");
            txtEnollFor.requestFocus();
            return false;
        }
        if(txtHobbies.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Chua nhap Hobbies");
            txtHobbies.requestFocus();
            return false;
        }
        if(txtSport.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Chua nhap Sport");
            txtSport.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btnExit){
            System.exit(0);
        }
        if(ae.getSource()==btnReset){
            txtFirstname.setText("");
            txtLastname.setText("");
            txtContact.setText("");
            txtAddress.setText("");
            txtQualification.setText("");
            txtSpecification.setText("");
            txtEnollFor.setText("");
            txtHobbies.setText("");
            txtSport.setText("");
        }
        if(ae.getSource()==btnSave){
            if(Check()){
                JOptionPane.showMessageDialog(this,"Ho Ten: " + txtFirstname.getText()+" "+txtLastname.getText()+"\n"+"Contact: "
                +txtContact.getText()+"\n"+"Address: "+txtAddress.getText()+"\n"+"Qualification: "+txtQualification.getText()
                +"\n"+"Specification: "+txtSpecification.getText()+"\n"+"Enroll For: "+txtEnollFor.getText()+"\n"+"Hobbies: "
                +txtHobbies.getText()+"\n"+"Sport: "+txtSport.getText(),"Thong tin sinh vien",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }
}
