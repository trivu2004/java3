package Slide7;

/**
 *
 * @author Tu Ech
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class ServerDemo extends javax.swing.JFrame {

    ServerSocket server = null;
    Socket client = null;
    OutputStream out;
    PrintStream ps;
    int port;

    public ServerDemo() {
        initComponents();
        btnSend.setEnabled(false);
    }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    txtPort = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtClient = new javax.swing.JTextArea();
    jLabel2 = new javax.swing.JLabel();
    btnStart = new javax.swing.JButton();
    txtServer = new javax.swing.JTextField();
    btnSend = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Server");

    jLabel1.setText("Port No.");

    txtPort.setText("9998");

    txtClient.setColumns(20);
    txtClient.setEditable(false);
    txtClient.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    txtClient.setForeground(new java.awt.Color(0, 0, 153));
    txtClient.setRows(5);
    jScrollPane1.setViewportView(txtClient);

    jLabel2.setText("Client say :");

    btnStart.setText("Start");
    btnStart.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnStartActionPerformed(evt);
      }
    });

    txtServer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    btnSend.setText("Send");
    btnSend.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSendActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(33, 33, 33)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(38, 38, 38)
            .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnStart))
          .addGroup(layout.createSequentialGroup()
            .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnSend)))
        .addContainerGap(37, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnStart))
        .addGap(18, 18, 18)
        .addComponent(jLabel2)
        .addGap(2, 2, 2)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnSend))
        .addContainerGap(40, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        try {
            port = Integer.parseInt(txtPort.getText().trim());
            server = new ServerSocket(port);

            client = server.accept();
            btnStart.setEnabled(false);
            btnSend.setEnabled(true);

            out = client.getOutputStream();
            ps = new PrintStream(out);
            Thread t = new Thread(new ServerThread(client, txtClient));
            t.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        String s = txtServer.getText().trim();
        ps.println(s);
}//GEN-LAST:event_btnSendActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerDemo().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnSend;
  private javax.swing.JButton btnStart;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea txtClient;
  private javax.swing.JTextField txtPort;
  private javax.swing.JTextField txtServer;
  // End of variables declaration//GEN-END:variables

}

class ServerThread implements Runnable {

    Socket client;
    JTextArea txtClient;
    InputStream in;
    BufferedInputStream bi;
    DataInputStream dis;

    public ServerThread(Socket client, JTextArea txtClient) {
        this.client = client;
        this.txtClient = txtClient;
        
        try {
            in = client.getInputStream();
            bi = new BufferedInputStream(in);
            dis = new DataInputStream(bi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String s = "";
        while (true) {
            try {
                s = dis.readLine();
                txtClient.append(s + "\n\r");
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
