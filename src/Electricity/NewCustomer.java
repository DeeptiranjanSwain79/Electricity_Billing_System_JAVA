package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField name, meter, address, city, state, email, phone;
    JButton next, cancel;
//    Random r = new Random();
//    long m = Math.abs(r.nextLong() % 10000000000L);

    NewCustomer(){
        super("New Customer");
        setLocation(200, 100);
        setSize(700, 500);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(20, 150, 200));

        JLabel title = new JLabel("New Customer");
        title.setBounds(180, 10, 200, 25);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);

        l1 = new JLabel("Customer Name");
        l1.setBounds(100, 80, 200, 20);
        name = new JTextField();
        name.setBounds(240, 80, 200, 20);
        p.add(l1);
        p.add(name);

        l2 = new JLabel("Meter Number");
        l2.setBounds(100, 120, 200, 20);
        meter = new JTextField();
        meter.setBounds(240, 120, 200, 20);
        p.add(l2);
        p.add(meter);

        l3 = new JLabel("Address");
        l3.setBounds(100, 160, 200, 20);
        address = new JTextField();
        address.setBounds(240, 160, 200, 20);
        p.add(l3);
        p.add(address);

        l4 = new JLabel("City");
        l4.setBounds(100, 200, 200, 20);
        city = new JTextField();
        city.setBounds(240, 200, 200, 20);
        p.add(l4);
        p.add(city);

        l5 = new JLabel("State");
        l5.setBounds(100, 240, 200, 20);
        state = new JTextField();
        state.setBounds(240, 240, 200, 20);
        p.add(l5);
        p.add(state);

        l6 = new JLabel("Email");
        l6.setBounds(100, 280, 200, 20);
        email = new JTextField();
        email.setBounds(240, 280, 200, 20);
        p.add(l6);
        p.add(email);

        l7 = new JLabel("Phone Number");
        l7.setBounds(100, 320, 200, 20);
        phone = new JTextField();
        phone.setBounds(240, 320, 200, 20);
        p.add(l7);
        p.add(phone);

        next = new JButton("Next");
        next.setBounds(120, 400, 100, 30);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 400, 100, 30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p, "Center");

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i = ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i);
        l8 = new JLabel(ic2);

        add(l8, "West");
        getContentPane().setBackground(Color.WHITE);

        next.addActionListener(this);
        cancel.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == next){
            String name_ = name.getText();
            String meter_ = meter.getText();
            String address_ = address.getText();
            String state_ = state.getText();
            String city_ = city.getText();
            String email_ = email.getText();
            String phone_ = phone.getText();

            String q1 = "insert into customer (name, meter, address, city, state, email, phone) values ('"+name_+"', '"+meter_+"', '"+address_+"'," +
                    " '"+city_+"', '"+state_+"', '"+email_+"', '"+phone_+"')";

            String q2 = "insert into login values ('"+meter_+"', '', '', '', '')";

            System.out.println(q1);
            System.out.println(q2);
            try{
                Conn c = new Conn();
                c.stmt.executeUpdate(q1);
                c.stmt.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                this.setVisible(false);
                new MeterInfo(meter_).setVisible(true);
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == cancel){
            this.setVisible(false);

        }
    }

    public static void main(String[] args) {
        new NewCustomer().setVisible(true);
    }
}
