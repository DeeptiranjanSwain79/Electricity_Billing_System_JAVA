package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MeterInfo extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    Choice location, type, code, bType, c5;
    JButton submit, cancel;

    MeterInfo(String meter){
        setLocation(200, 100);
        setSize(700, 500);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(170, 20, 200));

        JLabel title = new JLabel("Meter Information");
        title.setBounds(180, 10, 200, 25);
        title.setFont(new Font("Tahoma", Font.PLAIN, 25));
        p.add(title);

        l1 = new JLabel("Meter Number");
        l1.setBounds(100, 80, 100, 20);
        l2 = new JLabel(meter);
        l2.setBounds(240, 80, 200, 20);
        p.add(l1);
        p.add(l2);

        l3 = new JLabel("Meter Location");
        l3.setBounds(100, 120, 100, 20);
        location = new Choice();
        location.add("Outside");
        location.add("Inside");
        location.setBounds(240, 120, 200, 20);
        p.add(l3);
        p.add(location);

        l4 = new JLabel("Meter Type");
        l4.setBounds(100, 160, 100, 20);
        type = new Choice();
        type.add("Electric Meter");
        type.add("Solar Meter");
        type.add("Smart Meter");
        type.setBounds(240, 160, 200, 20);
        p.add(l4);
        p.add(type);

        l5 = new JLabel("Phase Code");
        l5.setBounds(100, 200, 100, 20);
        code = new Choice();
        code.add("011");
        code.add("022");
        code.add("033");
        code.add("044");
        code.add("055");
        code.add("066");
        code.add("077");
        code.add("088");
        code.add("099");
        code.setBounds(240, 200, 200, 20);
        p.add(l5);
        p.add(code);

        l6 = new JLabel("Bill Type");
        l6.setBounds(100, 240, 100, 20);
        bType = new Choice();
        bType.add("Normal");
        bType.add("Industrial");
        bType.setBounds(240, 240, 200, 20);
        p.add(l6);
        p.add(bType);

        l7 = new JLabel("Days");
        l7.setBounds(100, 280, 100, 20);
        l8 = new JLabel("30 Days");
        l8.setBounds(240, 280, 200, 20);
        p.add(l7);
        p.add(l8);

        l9 = new JLabel("Note");
        l9.setBounds(100, 320, 100, 20);
        l10 = new JLabel("By default bill is calculated for 30 days only");
        l10.setBounds(240, 320, 300, 20);
        p.add(l9);
        p.add(l10);

        submit = new JButton("Submit");
        submit.setBounds(120, 390, 100, 25);
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        p.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 390, 100, 25);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        p.add(cancel);
        setLayout(new BorderLayout());

        add(p, "Center");

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image ic2 = ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        l11 = new JLabel(ic3);
        add(l11, "West");
        getContentPane().setBackground(Color.WHITE);

        submit.addActionListener(this);
        submit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String meter_no = l2.getText();
            String meter_location = location.getSelectedItem();
            String meter_type = type.getSelectedItem();
            String phase_code = code.getSelectedItem();
            String bill_type = bType.getSelectedItem();
            String days = "30";

            String q = "insert into meter_info(meter_no, meter_location, meter_type, phase_code, bill_type, days) values ('"+meter_no+"'," +
                    " '"+meter_location+"', '"+meter_type+"', '"+phase_code+"', '"+bill_type+"', '"+days+"')";
            try{
                Conn c = new Conn();
                c.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Meter Info Added Successfully");
                this.setVisible(false);
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == cancel){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MeterInfo("").setVisible(true);
    }
}
