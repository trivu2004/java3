/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide7;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bai2Client extends JFrame implements ActionListener {

    JFrame frame;
    JLabel lblPortNo, lblClientsay;
    JTextField txtPortNo, txtSend;
    JTextArea txtClientsay;
    JButton btnConnect, btnSend;
    int port;
    Socket client;
    OutputStream out;
    PrintStream ps;

    public Bai2Client() {
        myGUI();
        btnSend.setEnabled(false);
    }

    public void myGUI() {
        frame = new JFrame();
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setTitle("Client");

        lblPortNo = new JLabel("Port No.");
        lblPortNo.setBounds(30, 30, 100, 50);
        lblPortNo.setFont(new Font("Roboto", Font.PLAIN, 24));
        frame.add(lblPortNo);

        txtPortNo = new JTextField();
        txtPortNo.setBounds(130, 35, 250, 40);
        frame.add(txtPortNo);

        btnConnect = new JButton("Connect");
        btnConnect.setBounds(400, 35, 130, 40);
        btnConnect.setFont(new Font("Roboto", Font.PLAIN, 20));
        frame.add(btnConnect);

        txtSend = new JTextField();
        txtSend.setBounds(30, 130, 400, 40);
        frame.add(txtSend);

        btnSend = new JButton("Send");
        btnSend.setBounds(450, 130, 100, 40);
        btnSend.setFont(new Font("Roboto", Font.PLAIN, 22));
        frame.add(btnSend);

        lblClientsay = new JLabel("Server: ");
        lblClientsay.setFont(new Font("Roboto", Font.BOLD, 20));
        lblClientsay.setBounds(30, 250, 100, 50);
        frame.add(lblClientsay);

        txtClientsay = new JTextArea(50, 0);
        txtClientsay.setLineWrap(true);
        txtClientsay.setFont(new Font("Roboto", Font.BOLD, 22));
        JScrollPane scrollPane = new JScrollPane(txtClientsay);
        scrollPane.setBounds(30, 290, 500, 130);
        frame.add(scrollPane);

        btnConnect.addActionListener(this);
        btnSend.addActionListener(this);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai2Client();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnConnect) {
            try {
                port = Integer.parseInt(txtPortNo.getText().trim());
                client = new Socket("127.0.0.1", port);
                out = client.getOutputStream();
                ps = new PrintStream(out);

                btnConnect.setEnabled(false);
                btnSend.setEnabled(true);
                Thread t = new Thread(new ClientThread(client, txtClientsay));
                t.start();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (ae.getSource() == btnSend) {
            Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                String formattedTime = dateFormat.format(calendar.getTime());
                ps.println(formattedTime + ": " + txtSend.getText().trim());
                txtSend.setText("");
        }
    }
}
