/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Lab4;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Bai_1 extends javax.swing.JFrame {

    /**
     * Creates new form Bai_1
     */
    public Bai_1() {
        initComponents();
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thay đổi trước khi thoát không?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    if (txtA.getText().equals("")) {
                        System.exit(0);
                    }
                    save();
                } else if (confirmed == JOptionPane.NO_OPTION) {
                    System.exit(0);
                } else {
                    setDefaultCloseOperation(0);
                }
            }
        }
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void About() {
        String str = "Program Demo Menu";
        str += "\nAuthor: TuEch";
        str += "\nLast Update: 06-Oct-2015";
        str += "\nEducation: Fpoly";
        JOptionPane.showMessageDialog(this, str, "GioiThieu", JOptionPane.INFORMATION_MESSAGE);
    }

    public void textColor() {
        Color c = JColorChooser.showDialog(this, "Chon mau chu", Color.white);
        txt2.setForeground(c);
    }

    public void save() {
        JFileChooser fchoose = new JFileChooser();
        int result = fchoose.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fname = fchoose.getSelectedFile();
            try {
                PrintWriter pw = new PrintWriter(fname);
                pw.println(txtA.getText());
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Ban da luu thanh cong");
        }
    }

    public void open() {
        JFileChooser fchoose = new JFileChooser();
        int result = fchoose.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                txtA.setPage("file:///" + fchoose.getSelectedFile().getPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnAbout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txt2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtA = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmNew = new javax.swing.JMenuItem();
        jmOpen = new javax.swing.JMenuItem();
        jmSave = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        chcRed = new javax.swing.JCheckBoxMenuItem();
        chcGreen = new javax.swing.JCheckBoxMenuItem();
        chcBlue = new javax.swing.JCheckBoxMenuItem();
        jmTextColor = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmAbout = new javax.swing.JMenuItem();
        jmExit = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu7.setText("File");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar3.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lab4/New-file-icon.png"))); // NOI18N
        btnNew.setText("aaa");
        btnNew.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lab4/user-info-icon.png"))); // NOI18N
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lab4/Button-Close-icon.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(701, 701, 701))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew)
                    .addComponent(btnAbout))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txt2.setEditable(false);
        txt2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2.setText("Fpoly - Java3");
        txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt2ActionPerformed(evt);
            }
        });

        txtA.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jScrollPane2.setViewportView(txtA);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jmNew.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jmNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lab4/New-file-icon.png"))); // NOI18N
        jmNew.setText("New");
        jmNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNewActionPerformed(evt);
            }
        });
        jMenu1.add(jmNew);

        jmOpen.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jmOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lab4/open-file-icon.png"))); // NOI18N
        jmOpen.setText("Open");
        jmOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmOpenActionPerformed(evt);
            }
        });
        jMenu1.add(jmOpen);

        jmSave.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jmSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lab4/Save-icon.png"))); // NOI18N
        jmSave.setText("Save");
        jmSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSaveActionPerformed(evt);
            }
        });
        jMenu1.add(jmSave);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Color");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        buttonGroup1.add(chcRed);
        chcRed.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        chcRed.setSelected(true);
        chcRed.setText("Red");
        chcRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chcRedActionPerformed(evt);
            }
        });
        jMenu2.add(chcRed);

        buttonGroup1.add(chcGreen);
        chcGreen.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        chcGreen.setText("Green");
        chcGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chcGreenActionPerformed(evt);
            }
        });
        jMenu2.add(chcGreen);

        buttonGroup1.add(chcBlue);
        chcBlue.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        chcBlue.setText("Blue");
        chcBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chcBlueActionPerformed(evt);
            }
        });
        jMenu2.add(chcBlue);

        jmTextColor.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jmTextColor.setText("Text Color");
        jmTextColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTextColorActionPerformed(evt);
            }
        });
        jMenu2.add(jmTextColor);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("System");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jmAbout.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jmAbout.setText("About us");
        jmAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAboutActionPerformed(evt);
            }
        });
        jMenu6.add(jmAbout);

        jmExit.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jmExit.setText("Exit");
        jmExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExitActionPerformed(evt);
            }
        });
        jMenu6.add(jmExit);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(txt2))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNewActionPerformed
        txtA.setText("");
    }//GEN-LAST:event_jmNewActionPerformed

    private void chcGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chcGreenActionPerformed
        txt2.setBackground(Color.green);
    }//GEN-LAST:event_chcGreenActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtA.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        About();
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Bạn có muốn đóng chương trình không!", "warning", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(0);
        }

    }//GEN-LAST:event_btnExitActionPerformed

    private void jmAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAboutActionPerformed
        About();
    }//GEN-LAST:event_jmAboutActionPerformed

    private void jmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExitActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Bạn có muốn đóng chương trình không!", "warning", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(0);
        }
    }//GEN-LAST:event_jmExitActionPerformed

    private void chcRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chcRedActionPerformed
        txt2.setBackground(Color.red);
    }//GEN-LAST:event_chcRedActionPerformed

    private void chcBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chcBlueActionPerformed
        txt2.setBackground(Color.blue);
    }//GEN-LAST:event_chcBlueActionPerformed

    private void jmTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTextColorActionPerformed
        textColor();
    }//GEN-LAST:event_jmTextColorActionPerformed

    private void jmSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSaveActionPerformed
        save();
    }//GEN-LAST:event_jmSaveActionPerformed

    private void txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt2ActionPerformed

    private void jmOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmOpenActionPerformed
        open();
    }//GEN-LAST:event_jmOpenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bai_1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bai_1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bai_1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bai_1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBoxMenuItem chcBlue;
    private javax.swing.JCheckBoxMenuItem chcGreen;
    private javax.swing.JCheckBoxMenuItem chcRed;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem jmAbout;
    private javax.swing.JMenuItem jmExit;
    private javax.swing.JMenuItem jmNew;
    private javax.swing.JMenuItem jmOpen;
    private javax.swing.JMenuItem jmSave;
    private javax.swing.JMenuItem jmTextColor;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextPane txtA;
    // End of variables declaration//GEN-END:variables
}