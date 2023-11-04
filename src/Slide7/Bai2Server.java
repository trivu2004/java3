/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide7;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Bai2Server extends JFrame implements ActionListener {

    JFrame frame;
    JLabel lblPortNo, lblClientsay;
    JTextField txtPortNo, txtSend;
    JTextArea txtClientsay;
    JButton btnStart, btnSend;
    ServerSocket server = null;
    Socket client = null;
    OutputStream out;
    PrintStream ps;
    int port;

    public Bai2Server() {
        myGUI();
        btnSend.setEnabled(false);
    }

    public void myGUI() {
        frame = new JFrame();
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setTitle("Server");

        lblPortNo = new JLabel("Port No.");
        lblPortNo.setBounds(30, 30, 100, 50);
        lblPortNo.setFont(new Font("Roboto", Font.PLAIN, 24));
        frame.add(lblPortNo);

        txtPortNo = new JTextField();
        txtPortNo.setBounds(130, 35, 250, 40);
        frame.add(txtPortNo);

        btnStart = new JButton("Start");
        btnStart.setBounds(400, 35, 100, 40);
        btnStart.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(btnStart);

        lblClientsay = new JLabel("Client say: ");
        lblClientsay.setFont(new Font("Roboto", Font.BOLD, 20));
        lblClientsay.setBounds(30, 130, 100, 50);
        frame.add(lblClientsay);

        txtClientsay = new JTextArea(50, 0);
        txtClientsay.setLineWrap(true);
        txtClientsay.setFont(new Font("Roboto", Font.BOLD, 22));
        JScrollPane scrollPane = new JScrollPane(txtClientsay);
        scrollPane.setBounds(30, 180, 500, 130);
        frame.add(scrollPane);

        txtSend = new JTextField();
        txtSend.setBounds(30, 340, 400, 40);
        frame.add(txtSend);

        btnSend = new JButton("Send");
        btnSend.setBounds(450, 340, 100, 40);
        btnSend.setFont(new Font("Roboto", Font.PLAIN, 22));
        frame.add(btnSend);

        btnStart.addActionListener(this);
        btnSend.addActionListener(this);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai2Server();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnStart) {
            try {
                port = Integer.parseInt(txtPortNo.getText().trim());
                server = new ServerSocket(port);

                client = server.accept();
                btnStart.setEnabled(false);
                btnSend.setEnabled(true);

                out = client.getOutputStream();
                ps = new PrintStream(out);
                Thread t = new Thread(new ServerThread(client, txtClientsay));
                t.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (ae.getSource() == btnSend) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String formattedTime = dateFormat.format(calendar.getTime());

            String s = txtSend.getText().trim();
            ps.println(formattedTime + ": " + s);
            txtSend.setText("");
        }
    }

}
