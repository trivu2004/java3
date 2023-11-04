package Lab2;

import Lab2.Data;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class BT extends JFrame implements ActionListener {

    private JTextField txtName, txtLastname;
    private JTextArea txtaddress;
    private JComboBox cbkYear, cbkMonth, cbkDay;
    private JLabel lblName, lblDangKy, lblLastname, lblYear, lblMonth, lblDay, lblBirthday, lblbd;
    private JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19;
    private JCheckBox jcb1, jcb2, jcb3, jcb4, jcb5, jcb6, jcb7, jcb8;
    private JRadioButton jdbtSex1, jdbtSex2, jdbtSex3;
    private JButton btn1, btn2, btn3;
    private JTable tblDangKi;
    private DefaultTableModel model;
    private int index = 2;
    ButtonGroup bt = new ButtonGroup();

    public BT() {
        Object[] ob = new Object[]{"2000", "2001", "2002", "2003", "2004"};
        Object[] cb = new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        Object[] db = new Object[]{"0"};
        JFrame frame = new JFrame();
        frame.setSize(1100, 1200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        p1 = new JPanel();
        p1.setBounds(300, 0, 100, 100);
        lblDangKy = new JLabel("Dang Ky");
        lblDangKy.setBounds(0, 0, 200, 100);
        lblDangKy.setFont(new Font("Roboto", Font.BOLD, 20));
        p2 = new JPanel();
        p2.setBounds(0, 40, 200, 100);
        lblName = new JLabel("First Name:");
        lblName.setBounds(0, 0, 500, 100);
        lblName.setFont(new Font("Roboto", Font.BOLD, 20));
        p3 = new JPanel();
        p3.setBounds(450, 40, 200, 100);
        lblLastname = new JLabel("Last Name:");
        lblLastname.setBounds(0, 0, 500, 100);
        lblLastname.setFont(new Font("Roboto", Font.BOLD, 20));

        p4 = new JPanel();
        p4.setBounds(7, 80, 300, 100);
        txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(220, 30));

        p5 = new JPanel();
        p5.setBounds(460, 80, 300, 100);
        txtLastname = new JTextField();
        txtLastname.setPreferredSize(new Dimension(220, 30));

        p6 = new JPanel();
        p6.setBounds(7, 200, 100, 50);
        lblYear = new JLabel("Year");
        lblYear.setBounds(0, 0, 500, 100);
        lblYear.setFont(new Font("Roboto", Font.BOLD, 20));
        p7 = new JPanel();
        p7.setBounds(120, 200, 100, 50);
        lblMonth = new JLabel("Month");
        lblMonth.setBounds(0, 0, 500, 100);
        lblMonth.setFont(new Font("Roboto", Font.BOLD, 20));

        p8 = new JPanel();
        p8.setBounds(230, 200, 100, 50);
        lblDay = new JLabel("Day");
        lblDay.setBounds(0, 0, 500, 100);
        lblDay.setFont(new Font("Roboto", Font.BOLD, 20));

        p9 = new JPanel();
        p9.setBounds(500, 200, 100, 50);
        lblBirthday = new JLabel("BirthDay");
        lblBirthday.setFont(new Font("Roboto", Font.BOLD, 20));

        p10 = new JPanel();
        p10.setBounds(7, 250, 100, 100);
        cbkYear = new JComboBox<>(ob);
        cbkYear.setFont(new Font("Roboto", Font.BOLD, 20));

        p11 = new JPanel();
        p11.setBounds(120, 250, 100, 100);
        cbkMonth = new JComboBox<>(cb);
        cbkMonth.setFont(new Font("Roboto", Font.BOLD, 20));

        p12 = new JPanel();
        p12.setBounds(230, 250, 100, 100);
        cbkDay = new JComboBox<>(db);
        cbkDay.setFont(new Font("Roboto", Font.BOLD, 20));

        p13 = new JPanel();
        p13.setBounds(7, 350, 150, 150);
        p13.setLayout(new GridLayout(3, 1));
        p13.setBorder(new TitledBorder(new LineBorder(Color.black), "Gender", 1, 2, new Font("Roboto", Font.BOLD, 22)));
        jdbtSex1 = new JRadioButton("Male");
        jdbtSex2 = new JRadioButton("Female");
        jdbtSex3 = new JRadioButton("Other");
        jdbtSex1.setFont(new Font("Roboto", Font.BOLD, 20));
        jdbtSex2.setFont(new Font("Roboto", Font.BOLD, 20));
        jdbtSex3.setFont(new Font("Roboto", Font.BOLD, 20));

        p14 = new JPanel();
        p14.setBounds(500, 250, 100, 100);
        lblbd = new JLabel("...");
        lblbd.setFont(new Font("Roboto", Font.BOLD, 20));

        p15 = new JPanel();
        p15.setBounds(100, 550, 80, 50);
        btn1 = new JButton("Reset");
        btn1.setFont(new Font("Roboto", Font.BOLD, 20));

        p17 = new JPanel();
        p17.setBounds(200, 550, 80, 50);
        btn2 = new JButton("Save");
        btn2.setFont(new Font("Roboto", Font.BOLD, 20));

        p18 = new JPanel();
        p18.setBounds(300, 550, 80, 50);
        btn3 = new JButton("Close");
        btn3.setFont(new Font("Roboto", Font.BOLD, 20));

        String[] cot = {"STT", "FullName", "Birthday", "Gender", "Hobbies"};
        Object[][] data = {{"1", "tri", "08/05/2004", "Male", "soccer"}};
        model = new DefaultTableModel(data, cot);
        tblDangKi = new JTable(model);
        tblDangKi.setFont(new Font("Serif", Font.BOLD, 17));
        JTableHeader header = tblDangKi.getTableHeader();
        Font font = new Font("Serif", Font.BOLD, 20);
        header.setFont(font);
        header.setForeground(Color.red);
        tblDangKi.setPreferredScrollableViewportSize(new Dimension(800, 120));
        JScrollPane scrollPane = new JScrollPane(tblDangKi);
        p19 = new JPanel();
        p19.setBounds(50, 700, 900, 205);
        p19.add(scrollPane);

        p16 = new JPanel();
        p16.setBounds(200, 350, 500, 150);
        p16.setLayout(new GridLayout(3, 3));
        p16.setBorder(new TitledBorder(new LineBorder(Color.black), "hobbies", 0, 0, new Font("Roboto", Font.BOLD, 22)));
        jcb1 = new JCheckBox("Football");
        jcb1.setFont(new Font("Roboto", Font.BOLD, 20));
        jcb2 = new JCheckBox("Shopping");
        jcb2.setFont(new Font("Roboto", Font.BOLD, 20));
        jcb3 = new JCheckBox("Music");
        jcb3.setFont(new Font("Roboto", Font.BOLD, 20));
        jcb4 = new JCheckBox("Dancing");
        jcb4.setFont(new Font("Roboto", Font.BOLD, 20));
        jcb5 = new JCheckBox("Travelling");
        jcb5.setFont(new Font("Roboto", Font.BOLD, 20));
        jcb6 = new JCheckBox("Gymnas");
        jcb6.setFont(new Font("Roboto", Font.BOLD, 20));
        jcb7 = new JCheckBox("Photo");
        jcb7.setFont(new Font("Roboto", Font.BOLD, 20));
        jcb8 = new JCheckBox("Watching");
        jcb8.setFont(new Font("Roboto", Font.BOLD, 20));

        bt.add(jdbtSex1);
        bt.add(jdbtSex2);
        bt.add(jdbtSex3);

        p1.add(lblDangKy);
        p2.add(lblName);
        p3.add(lblLastname);
        p4.add(txtName);
        p5.add(txtLastname);
        p6.add(lblYear);
        p7.add(lblMonth);
        p8.add(lblDay);
        p9.add(lblBirthday);
        p10.add(cbkYear);
        p11.add(cbkMonth);
        p12.add(cbkDay);
        p13.add(jdbtSex1);
        p13.add(jdbtSex2);
        p13.add(jdbtSex3);
        p14.add(lblbd);
        p15.add(btn1);
        p16.add(jcb1);
        p16.add(jcb2);
        p16.add(jcb3);
        p16.add(jcb4);
        p16.add(jcb5);
        p16.add(jcb6);
        p16.add(jcb7);
        p16.add(jcb8);
        p17.add(btn2);
        p18.add(btn3);

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
        frame.add(p12);
        frame.add(p13);
        frame.add(p14);
        frame.add(p16);
        frame.add(p15);
        frame.add(p17);
        frame.add(p18);
        frame.add(p19);
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
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        cbkDay.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                birthDay();
            }
        });
        cbkMonth.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                birthDay();
                ChinhNgay();
            }
        });
        cbkYear.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                birthDay();
                ChinhNgay();
            }
        });
        frame.setVisible(true);
        ChinhNgay();
    }

    public void ChinhNgay() {
        int year = Integer.valueOf((String) cbkYear.getSelectedItem());
        int month = Integer.valueOf((String) cbkMonth.getSelectedItem());
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 9 || month == 11) {
            DefaultComboBoxModel<String> row = new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
            cbkDay.setModel(row);
        }
        if (month == 4 || month == 6 || month == 8 || month == 10 || month == 12) {
            DefaultComboBoxModel<String> row = new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"});
            cbkDay.setModel(row);
        }
        if (year % 4 == 0 && year % 400 == 0) {
            if (month == 2) {
                DefaultComboBoxModel<String> row = new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6",
                    "7", "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"});
                cbkDay.setModel(row);
            } else {
                DefaultComboBoxModel<String> row = new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6",
                    "7", "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"});
                cbkDay.setModel(row);
            }
        }
    }

    public void birthDay() {
        lblbd.setText(cbkDay.getSelectedItem() + "/" + cbkMonth.getSelectedItem() + "/" + cbkYear.getSelectedItem());
    }

    public static void main(String[] args) {
        BT bt = new BT();
    }

    public boolean Check() {
        if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ban chua nhap Name");
            txtName.requestFocus();
            return false;
        }
        if (txtLastname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ban chua nhap Lastname");
            txtLastname.requestFocus();
            return false;
        }
        return true;
    }

    public String kk() {
        if (jdbtSex1.isSelected()) {
            return "Male";
        } else if (jdbtSex2.isSelected()) {
            return "Famale";
        } else {
            return "Other";
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String click = ae.getActionCommand();

        if (click.equals("Reset")) {
            txtName.setText("");
            txtLastname.setText("");
            cbkDay.setSelectedIndex(0);
            cbkMonth.setSelectedIndex(0);
            cbkYear.setSelectedIndex(0);
            birthDay();
            jdbtSex1.setSelected(false);
            jdbtSex2.setSelected(false);
            jdbtSex3.setSelected(false);
            jcb1.setSelected(false);
            jcb2.setSelected(false);
            jcb3.setSelected(false);
            jcb4.setSelected(false);
            jcb5.setSelected(false);
            jcb6.setSelected(false);
            jcb7.setSelected(false);
            jcb8.setSelected(false);
            bt.clearSelection();

        } else if (click.equals("Close")) {
            System.exit(0);
        }
        if (click.equals("Save")) {
            String str = "";
            if (jcb1.isSelected()) {
                str = str + jcb1.getText() + " ,";
            }
            if (jcb2.isSelected()) {
                str = str + jcb2.getText() + " ,";
            }
            if (jcb3.isSelected()) {
                str = str + jcb3.getText() + " ,";
            }
            if (jcb4.isSelected()) {
                str = str + jcb4.getText() + " ,";
            }
            if (jcb5.isSelected()) {
                str = str + jcb5.getText() + " ,";
            }
            if (jcb6.isSelected()) {
                str = str + jcb6.getText() + " ,";
            }
            if (jcb7.isSelected()) {
                str = str + jcb7.getText() + " ,";
            }
            if (jcb8.isSelected()) {
                str = str + jcb8.getText() + " ,";
            }
            Object[] newdata = {index++, txtName.getText() + txtLastname.getText(), lblbd.getText(),
                kk(), str};
            model.addRow(newdata);

        }
    }

}
