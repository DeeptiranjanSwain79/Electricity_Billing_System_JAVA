package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class CalculateBill extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5;
    JTextField t;
    Choice c1, month;
    JButton submit, cancel;
    JPanel p;

    CalculateBill(){
        super("Bill Calculation");
//        p = new JPanel();
//        p.setLayout(null);
        setBackground(new Color(240, 10, 150));
//        add(p, "Center");

        l1 = new JLabel("Calculate Electricity Bill");
        l1.setBounds(30, 10, 670, 30);
        l1.setFont(new Font("Arial", Font.PLAIN, 25));
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBorder(BorderFactory.createLoweredBevelBorder());
        add(l1);

        l2 = new JLabel("Meter No");
        l2.setBounds(60, 70, 100, 30);
        add(l2);

        JLabel l6 = new JLabel("Name");
        l6.setBounds(60, 120, 100, 30);
        add(l6);

        JLabel l7 = new JLabel("Address");
        l7.setBounds(60, 170, 100, 30);
        add(l7);

        l3 = new JLabel("Units Consumed");
        l3.setBounds(60, 220, 100, 30);
        add(l3);

        l4 = new JLabel("Month");
        l4.setBounds(60, 270, 100, 30);
        add(l4);

        c1 = new Choice();
        c1.setBounds(200, 70, 180, 20);
        add(c1);

        try {
            Conn c= new Conn();
            ResultSet rs = c.stmt.executeQuery("Select * from customer");
            while (rs.next()){
                c1.add(rs.getString("meter"));
            }
        }catch (Exception e){e.printStackTrace();}

        JLabel name = new JLabel();
        name.setBounds(200, 120, 180, 20);
        add(name);

        JLabel address = new JLabel();
        address.setBounds(200, 170, 180, 20);
        add(address);

        c1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ae) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.stmt.executeQuery("select * from customer where meter='"+c1.getSelectedItem()+"'");
                    while (rs.next()){
                        name.setText(rs.getString("name"));
                        address.setText(rs.getString("address"));
                    }
                }catch (Exception e){e.printStackTrace();}
            }
        });

        t = new JTextField();
        t.setBounds(200, 220, 180, 20);
        add(t);

        month = new Choice();
        month.setBounds(200, 270, 180, 20);
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        add(month);

        submit = new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.BLUE);
        submit.setBounds(100, 350, 100, 25);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.RED);
        cancel.setBounds(230, 350, 100, 25);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 270, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l5 = new JLabel(i3);
        l5.setBounds(500, 70, 180, 270);
        add(l5);

        getContentPane().setBackground(new Color(240, 10, 150));
        setSize(750, 500);
        setLocation(100, 100);

        setLayout(new BorderLayout(30, 30));


    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String meter_no = c1.getSelectedItem();
            int units = Integer.parseInt(t.getText());
            String month_ = month.getSelectedItem();

            int total_bill = 0;

            try{
                Conn c = new Conn();
                ResultSet rs = c.stmt.executeQuery("select * from tax");
                while(rs.next()){
                    total_bill = units * Integer.parseInt(rs.getString("cost_per_unit"));
                    total_bill += Integer.parseInt(rs.getString("meter_rent"));
                    total_bill += Integer.parseInt(rs.getString("service_charge"));
                    total_bill += Integer.parseInt(rs.getString("service_tax"));
                    total_bill += Integer.parseInt(rs.getString("swachh_bharat_cess"));
                    total_bill += Integer.parseInt(rs.getString("fixed_tax"));


                }

                String q = "insert into bill (meter, month, unit, amount, status) values ('"+meter_no+"', '"+month_+"', '"+units+"', '"+total_bill+"', 'Not Paid')";

                try{
                    Conn c1 = new Conn();
                    c1.stmt.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Customer Bill Updated");
                    this.setVisible(false);

                }catch (Exception e){System.out.println(e);}
            }catch (Exception e){e.printStackTrace();}
        }if (ae.getSource() == cancel){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CalculateBill().setVisible(true);
    }
}
