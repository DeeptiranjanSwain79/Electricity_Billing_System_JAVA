package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PayBill extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6,  l11, l12, l16, l14, l15;
    JTextField tf;
    Choice c1, c2;
    JButton pay, back;
    String meter;

    PayBill(String meter){
        this.meter = meter;
        setLayout(null);
        setBounds(50, 20, 900, 600);

        JLabel title = new JLabel("Electricity Bill");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(120, 5, 400, 30);
        add(title);

        l1 = new JLabel("Meter No.");
        l1.setBounds(35, 80, 200, 20);
        add(l1);

        l11 = new JLabel();
        l11.setBounds(300, 80, 200, 20);
        add(l11);

        l2 = new JLabel("Name");
        l2.setBounds(35, 140, 200, 20);
        add(l2);

        l12 = new JLabel();
        l12.setBounds(300, 140, 200, 20);
        add(l12);

        l3 = new JLabel("Month");
        l3.setBounds(35, 200, 200, 20);
        add(l3);

        c1 = new Choice();
        c1.setBounds(300, 200, 200, 30);
        c1.add("January");
        c1.add("February");
        c1.add("March");
        c1.add("April");
        c1.add("May");
        c1.add("June");
        c1.add("July");
        c1.add("August");
        c1.add("September");
        c1.add("October");
        c1.add("November");
        c1.add("December");
        add(c1);

        l4 = new JLabel("Units");
        l4.setBounds(35, 260, 200, 20);
        add(l4);

        l14 = new JLabel();
        l14.setBounds(300, 260, 200, 20);
        add(l14);

        l5 = new JLabel("Total Bill");
        l5.setBounds(35, 320, 200, 20);
        add(l5);

        l15 = new JLabel();
        l15.setBounds(300, 320, 200, 20);
        add(l15);

        l6 = new JLabel("Status");
        l6.setBounds(35, 380, 200, 20);
        add(l6);

        l16 = new JLabel();
        l16.setBounds(300, 380, 200, 20);
        add(l16);
        l16.setForeground(Color.red);

        try {
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from customer where meter='"+meter+"'");
            while (rs.next()){
                l11.setText(rs.getString("meter"));
                l12.setText(rs.getString("name"));
            }
            rs = c.stmt.executeQuery("select * from bill where meter='"+meter+"' and month='"+c1.getSelectedItem()+"'");
            while (rs.next()){
                l14.setText(rs.getString("unit"));
                l15.setText(rs.getString("amount"));
                l16.setText(rs.getString("status"));
            }
        }catch (Exception e){e.printStackTrace();}



        pay = new JButton("Pay");
        pay.setBounds(100, 460, 100, 25);
        pay.setBackground(Color.GREEN);
        add(pay);

        back = new JButton("Back");
        back.setBounds(230, 460, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500, 20, 400, 600);
        add(img);

        pay.addActionListener(this);
        back.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == pay){
            try{
                Conn c = new Conn();
                String q = "Update bill set status='Paid' where meter='"+meter+"' and month='"+c1.getSelectedItem()+"'";
                c.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Payment Successful");
                System.out.println(q);
            }catch (Exception e){
                e.printStackTrace();
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Something went wrong!");
            }
        }else if (ae.getSource()==back){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new PayBill("").setVisible(true);
    }
}
