/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author USER
 */
public class Bai1 extends JFrame implements ActionListener {

    private JTextField txtName;
    private JTextArea txtaddress;
    private JComboBox cbkQua;
    private JLabel lblName, lblAddress, lblSex, lblQua, lblHobby;
    private JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
    private JCheckBox jcb1, jcb2, jcb3;
    private JRadioButton jdbtSex1, jdbtSex2,jdbtSex3;
    private JButton btn1, btn2;
    ButtonGroup bt = new ButtonGroup();

    public Bai1() {
        Object[] ob = new Object[]{"Graduate", "Student"};
        JFrame frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1 = new JPanel();
        p1.setBounds(7, 10, 100, 100);
        lblName = new JLabel("Name:");
        lblName.setBounds(0, 0, 500, 100);
        lblName.setFont(new Font("Roboto", Font.BOLD, 20));

        p2 = new JPanel();
        p2.setBounds(10, 5, 400, 100);
        txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(220, 30));

        p3 = new JPanel();
        p3.setBounds(450, 10, 150, 100);
        lblQua = new JLabel("Qualification: ");
        lblQua.setFont(new Font("Roboto", Font.BOLD, 20));

        p4 = new JPanel();
        p4.setBounds(590, 5, 200, 50);
        cbkQua = new JComboBox(ob);
        cbkQua.setFont(new Font("Roboto", Font.BOLD, 20));

        p5 = new JPanel();
        p5.setBounds(0, 110, 100, 100);
        lblAddress = new JLabel("Address: ");
        lblAddress.setFont(new Font("Roboto", Font.BOLD, 20));

        p6 = new JPanel();
        p6.setBounds(50, 110, 400, 100);
        txtaddress = new JTextArea();
        txtaddress.setPreferredSize(new Dimension(300, 400));

        p7 = new JPanel();
        p7.setBounds(430, 110, 200, 100);
        lblHobby = new JLabel("Hobby:");
        lblHobby.setBounds(0, 0, 200, 150);
        lblHobby.setFont(new Font("Roboto", Font.BOLD, 20));

        p8 = new JPanel();
        p8.setLayout(new GridLayout(3, 1));
        p8.setBounds(630, 110, 150, 100);
        p8.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        jcb1 = new JCheckBox("Reading");
        jcb2 = new JCheckBox("Singing");
        jcb3 = new JCheckBox("Dancing");
        jcb1.setFont(new Font("Roboto", Font.BOLD, 20));
        jcb2.setFont(new Font("Roboto", Font.BOLD, 20));
        jcb3.setFont(new Font("Roboto", Font.BOLD, 20));

        p9 = new JPanel();
        p9.setBounds(0, 250, 100, 100);
        lblSex = new JLabel("Sex: ");
        lblSex.setFont(new Font("Roboto", Font.BOLD, 20));

        p10 = new JPanel();
        p10.setBounds(100, 255, 100, 100);
        p10.setLayout(new GridLayout(3, 1));
        p10.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        jdbtSex1 = new JRadioButton("Male");
        jdbtSex2 = new JRadioButton("Female");
        jdbtSex3 = new JRadioButton("Other");
        
        jdbtSex1.setFont(new Font("Roboto", Font.BOLD, 20));
        jdbtSex2.setFont(new Font("Roboto", Font.BOLD, 20));
        jdbtSex3.setFont(new Font("Roboto", Font.BOLD, 20));

        bt.add(jdbtSex1);
        bt.add(jdbtSex2);

        p11 = new JPanel();
        p11.setBounds(300, 450, 250, 50);
        p11.setLayout(new GridLayout(1, 1, 15, 15));
        btn1 = new JButton("Validate");
        btn1.setFont(new Font("Roboto", Font.BOLD, 20));
        btn2 = new JButton("Reset");
        btn2.setFont(new Font("Roboto", Font.BOLD, 20));

        p1.add(lblName);
        p2.add(txtName);
        p3.add(lblQua);
        p4.add(cbkQua);
        p5.add(lblAddress);
        p6.add(txtaddress);
        p7.add(lblHobby);
        p8.add(jcb1);
        p8.add(jcb2);
        p8.add(jcb3);
        p9.add(lblSex);
        p10.add(jdbtSex1);
        p10.add(jdbtSex2);
        p10.add(jdbtSex3);
        p11.add(btn1);
        p11.add(btn2);

        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.add(p5);
        frame.add(p6);
        frame.add(p7);
        frame.add(p8);
        frame.add(p9);
        frame.add(p10);
        frame.add(p11);

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Bai1 b1 = new Bai1();
    }

    public boolean Check() {
        if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ban chua nhap ten");
            txtName.requestFocus();
            return false;
        }
        if (txtaddress.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ban chua nhap address");
            txtaddress.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String click = ae.getActionCommand();
        if (click.equals("Validate")) {
            if (Check()) {
                String str = "";
                str = "Name" + txtName.getText() + "\n";
                str = "Address" + txtaddress.getText() + "\n";
                if (jdbtSex1.isSelected()) {
                    str = str + "Sex: Male\n";
                } else {
                    str = str + "Sex: Female\n";
                }
                str = str + "Qualification" + cbkQua.getSelectedItem();
                if (jcb1.isSelected()) {
                    str = str + "Hobby: Dancing\n";
                }
                if (jcb2.isSelected()) {
                    str = str + "Hobby: Reading\n";
                }
                if (jcb3.isSelected()) {
                    str = str + "Hobby: Singing\n";
                }
                JOptionPane.showMessageDialog(this, str);
            }
        }
        if (click.equals("Reset")) {
            txtName.setText("");
            txtaddress.setText("");
            cbkQua.setSelectedIndex(0);
            jcb1.setSelected(false);
            jcb2.setSelected(false);
            jcb3.setSelected(false);
            jdbtSex1.setSelected(false);
            jdbtSex2.setSelected(false);
            bt.clearSelection();
        }
    }

}
