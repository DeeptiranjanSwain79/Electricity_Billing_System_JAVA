package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateInformation extends JFrame implements ActionListener {
    JTextField address, city, state, email, phone;
    JLabel l11, l12;
    JButton update, back;
    String meter;
    UpdateInformation(String meter){
        this.meter = meter;

        setBounds(50, 100, 1050, 450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("UPDATE CUSTOMER INFORMATION");
        title.setBounds(110, 10, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 70, 200, 20);
        add(l1);

        l11 = new JLabel();
        l11.setBounds(230, 70, 200, 20);
        add(l11);

        JLabel l2 = new JLabel("Meter No.");
        l2.setBounds(30, 110, 200, 20);
        add(l2);

        l12 = new JLabel();
        l12.setBounds(230, 110, 200, 20);
        add(l12);

        try{
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from customer where meter='"+meter+"'");
            while (rs.next()){
                l11.setText(rs.getString("name"));
                l12.setText(rs.getString("meter"));
            }
        }catch (Exception e){e.printStackTrace();}

        JLabel l3 = new JLabel("Address");
        l3.setBounds(30, 150, 200, 20);
        add(l3);

        address = new JTextField();
        address.setBounds(230, 150, 200, 20);
        add(address);

        JLabel l4 = new JLabel("City");
        l4.setBounds(30, 190, 200, 20);
        add(l4);

        city = new JTextField();
        city.setBounds(230, 190, 200, 20);
        add(city);

        JLabel l5 = new JLabel("State");
        l5.setBounds(30, 230, 200, 20);
        add(l5);

        state = new JTextField();
        state.setBounds(230, 230, 200, 20);
        add(state);

        JLabel l6 = new JLabel("Email");
        l6.setBounds(30, 270, 200, 20);
        add(l6);

        email = new JTextField();
        email.setBounds(230, 270, 200, 20);
        add(email);

        JLabel l7 = new JLabel("Phone");
        l7.setBounds(30, 310, 200, 20);
        add(l7);

        phone = new JTextField();
        phone.setBounds(230, 310, 200, 20);
        add(phone);

        update = new JButton("Update");
        update.setBackground(Color.BLUE);
        update.setForeground(Color.WHITE);
        update.setBounds(70, 360, 100, 25);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 360, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(550, 50, 400, 300);
        add(img);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == update){
            String name_ = l11.getText();
            String meter_ = l12.getText();
            String address_ = address.getText();
            String city_ = city.getText();
            String state_ = state.getText();
            String email_ = email.getText();
            String phone_ = phone.getText();

            try {
                Conn c = new Conn();
                String q = "update customer set address='"+address_+"', city='"+city_+"', state='"+state_+"', email='"+email_+"', phone='"+phone_+"' where meter='"+meter_+"'";
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                this.setVisible(false);
                c.stmt.executeUpdate(q);
            }catch (Exception e){e.printStackTrace();}

        }else if (ae.getSource() == back){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateInformation("").setVisible(true);
    }
}
