package Electricity;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.*;

public class Signup extends JFrame implements ActionListener {
    JPanel p;
    JTextField username, name, password, meter;
    Choice user;
    JButton create, back;

    Signup(){
        super("Application form");
        setBounds(400, 200, 700, 400);

        p = new JPanel();
        p.setBounds(30, 30, 650, 300);
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        p.setForeground(new Color(20, 20, 150));
        p.setBorder(new TitledBorder(new LineBorder(Color.green, 2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
        add(p);

        JLabel l1 = new JLabel("Username");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 15));
        l1.setBounds(100, 50, 100, 20);
        p.add(l1);

        username = new JTextField();
        username.setBounds(260, 50, 150, 20);
        p.add(username);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma", Font.BOLD, 15));
        l2.setBounds(100, 90, 100, 20);
        p.add(l2);

        name = new JTextField();
        name.setBounds(260, 90, 150, 20);
        p.add(name);

        JLabel l3 = new JLabel("Password");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma", Font.BOLD, 15));
        l3.setBounds(100, 130, 100, 20);
        p.add(l3);

        password = new JTextField();
        password.setBounds(260, 130, 100, 20);
        p.add(password);

        JLabel l4 = new JLabel("Create Account as:");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma", Font.BOLD, 15));
        l4.setBounds(100, 170, 150, 20);
        p.add(l4);

        user = new Choice();
        user.add("Admin");
        user.add("Customer");
        user.setBounds(260, 170, 150, 20);
        p.add(user);

        JLabel l5 = new JLabel("Meter Number");
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma", Font.BOLD, 15));
        l5.setBounds(100, 210, 150, 20);
//        l5.setVisible(false);
        p.add(l5);

        meter = new JTextField();
        meter.setBounds(260, 210, 100, 20);
//        meter.setVisible(false);
        p.add(meter);

//        user.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                String user_ = user.getSelectedItem();
//                if(user_.equals("Customer")){
//                    l5.setVisible(true);
//                    meter.setVisible(true);
//                }else{
//                    l5.setVisible(false);
//                    meter.setVisible(false);
//                }
//            }
//        });

        create = new JButton("Create");
        create.setBackground(Color.BLUE);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 290, 120, 30);
        create.addActionListener(this);
        p.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 290, 120, 30);
        back.addActionListener(this);
        p.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(450, 30, 250, 250);
        p.add(img);
    }


    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create){
            String user_name = username.getText();
            String password_ = password.getText();
            String name_ = name.getText();
            String user_ = user.getSelectedItem();
            String meter_ = meter.getText();

            try {
                Conn c = new Conn();
                String str = null;
                if (user_.equals("Admin")){
                    str = "insert into login (meter_no, username, name, password, user) values ('"+meter_+"', '"+user_name+"', '"+name_+"', '"+password_+"', '"+user_+"')";
                }else if(user_.equals("Customer")){
                    str = "update login set username='"+user_name+"', name='"+name_+"', password='"+password_+"', user='"+user_+"' where meter_no='"+meter_+"'";
                }else{
                    JOptionPane.showMessageDialog(null, "Please Select User-type");
                }
                System.out.println(str);

                c.stmt.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new Login().setVisible(true);
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == back){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
