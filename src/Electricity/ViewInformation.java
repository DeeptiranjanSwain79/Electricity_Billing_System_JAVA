package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewInformation extends JFrame implements ActionListener {
    JButton back;
    ViewInformation(String meter){
        super("Customer Information");
        setBounds(100, 50, 850, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel title = new JLabel("VIEW CUSTOMER INFORMATION");
        title.setBounds(250, 10, 500, 40);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(70, 80, 200, 20);
        add(l1);

        JLabel l11 = new JLabel();
        l11.setBounds(250, 80, 200, 20);
        add(l11);

        JLabel l2 = new JLabel("Meter No.");
        l2.setBounds(70, 140, 200, 20);
        add(l2);

        JLabel l12 = new JLabel();
        l12.setBounds(250, 140, 200, 20);
        add(l12);

        JLabel l3 = new JLabel("Address");
        l3.setBounds(70, 200, 200, 20);
        add(l3);

        JLabel l13 = new JLabel();
        l13.setBounds(250, 200, 200, 20);
        add(l13);

        JLabel l4 = new JLabel("City");
        l4.setBounds(70, 260, 200, 20);
        add(l4);

        JLabel l14 = new JLabel();
        l14.setBounds(250, 260, 200, 20);
        add(l14);


        JLabel l5 = new JLabel("State");
        l5.setBounds(70, 320, 200, 20);
        add(l5);

        JLabel l15 = new JLabel();
        l15.setBounds(250, 320, 200, 20);
        add(l15);

        JLabel l6 = new JLabel("Email");
        l6.setBounds(70, 400, 200, 20);
        add(l6);

        JLabel l16 = new JLabel();
        l16.setBounds(250, 400, 200, 20);
        add(l16);

        JLabel l7 = new JLabel("Phone");
        l7.setBounds(70, 460, 200, 20);
        add(l7);

        JLabel l17 = new JLabel();
        l17.setBounds(250, 460, 200, 20);
        add(l17);

        try {
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("Select * from customer where meter='"+meter+"'");
            while (rs.next()){
                l11.setText(rs.getString("name"));
                l12.setText(rs.getString("meter"));
                l13.setText(rs.getString("address"));
                l14.setText(rs.getString("city"));
                l15.setText(rs.getString("state"));
                l16.setText(rs.getString("email"));
                l17.setText(rs.getString("phone"));
            }
        }catch (Exception e){e.printStackTrace();}

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 500, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(20, 350, 600, 300);
        add(img);

    }

    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new ViewInformation("").setVisible(true);
    }
}
