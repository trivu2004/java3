/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide8;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author USER
 */
public class Bai1 extends JFrame implements ActionListener {

    JFrame frame;
    JPanel p1, p2, p3, p4;
    JLabel lblUserName, lblPassword, lblTo, lblSubject, lblMessage, lblSend, lblRecive, lblSendMail;
    JTextField txtUsername, txtTo, txtSubject;
    JPasswordField txtPassword;
    JTextArea txtMessage;
    JButton btnSend;

    public Bai1() {
        myGUI();
    }

    public void myGUI() {
        frame = new JFrame();
        frame.setSize(800, 900);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        lblSendMail = new JLabel("Send Mail");
        lblSendMail.setBounds(300, 30, 150, 80);
        lblSendMail.setFont(new Font("Roboto", Font.BOLD, 28));
        lblSendMail.setForeground(Color.BLUE);

        frame.add(lblSendMail);

        lblSend = new JLabel("Send");
        lblSend.setBounds(30, 110, 100, 50);
        lblSend.setFont(new Font("Roboto", Font.BOLD, 20));
        frame.add(lblSend);

        p1 = new JPanel();
        p1.setBounds(25, 150, 600, 150);
        p1.setLayout(null);
        p1.setBorder(new LineBorder(new Color(202, 224, 255), 3));
        frame.add(p1);

        lblUserName = new JLabel("User name: ");
        lblUserName.setBounds(20, 20, 120, 50);
        lblUserName.setFont(new Font("Roboto", Font.BOLD, 20));
        p1.add(lblUserName);

        lblPassword = new JLabel("Password: ");
        lblPassword.setBounds(25, 90, 120, 50);
        lblPassword.setFont(new Font("Roboto", Font.BOLD, 20));
        p1.add(lblPassword);

        txtUsername = new JTextField();
        txtUsername.setBounds(140, 25, 350, 40);
        txtUsername.setFont(new Font("Roboto", Font.BOLD, 20));
        p1.add(txtUsername);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 95, 350, 40);
        txtPassword.setFont(new Font("Roboto", Font.BOLD, 20));
        p1.add(txtPassword);

        lblRecive = new JLabel("Recive");
        lblRecive.setBounds(30, 330, 100, 50);
        lblRecive.setFont(new Font("Roboto", Font.BOLD, 20));
        frame.add(lblRecive);

        p2 = new JPanel();
        p2.setBounds(20, 390, 600, 400);
        p2.setLayout(null);
        p2.setBorder(new LineBorder(new Color(202, 224, 255), 3));
        frame.add(p2);

        lblTo = new JLabel("To: ");
        lblTo.setBounds(80, 30, 100, 50);
        lblTo.setFont(new Font("Roboto", Font.BOLD, 20));
        p2.add(lblTo);

        lblSubject = new JLabel("Subject: ");
        lblSubject.setBounds(40, 90, 100, 50);
        lblSubject.setFont(new Font("Roboto", Font.BOLD, 20));
        p2.add(lblSubject);

        lblMessage = new JLabel("Message: ");
        lblMessage.setBounds(25, 150, 100, 50);
        lblMessage.setFont(new Font("Roboto", Font.BOLD, 20));
        p2.add(lblMessage);

        txtTo = new JTextField();
        txtTo.setBounds(140, 35, 350, 40);
        txtTo.setFont(new Font("Roboto", Font.BOLD, 20));
        p2.add(txtTo);

        txtSubject = new JTextField();
        txtSubject.setBounds(140, 85, 350, 40);
        txtSubject.setFont(new Font("Roboto", Font.BOLD, 20));
        p2.add(txtSubject);

        txtMessage = new JTextArea(40, 100);
        txtMessage.setFont(new Font("Roboto", Font.BOLD, 20));
        txtMessage.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(txtMessage);
        scrollPane.setBounds(140, 170, 350, 150);
        p2.add(scrollPane);

        btnSend = new JButton("Send");
        btnSend.setBounds(140, 340, 100, 40);
        btnSend.setFont(new Font("Roboto", Font.BOLD, 20));
        p2.add(btnSend);
        btnSend.addActionListener(this);
        
        
        

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai1();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSend) {
            final String username = txtUsername.getText();
            final String password = txtPassword.getText();

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(txtUsername.getText()));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(txtTo.getText())
                );
                message.setSubject(txtSubject.getText());
                message.setText(txtMessage.getText());

                Transport.send(message);
                JOptionPane.showMessageDialog(this, "Email send");
                System.out.println("Done");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
