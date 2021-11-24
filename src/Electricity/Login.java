package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JTextField tf;
    JPasswordField pf;
    JButton b1, b2, b3;
    Choice c1;

    Login(){
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        l1 = new JLabel("Username");
        l1.setBounds(300, 20, 100, 20);
        add(l1);
        l2 = new JLabel("Password");
        l2.setBounds(300, 60, 100, 20);
        add(l2);

        tf = new JTextField(15);
        tf.setBounds(400, 20, 150, 20);
        add(tf);
        pf = new JPasswordField(15);
        pf.setBounds(400, 60, 150, 20);;
        add(pf);

        l4 = new JLabel("Logging in as");
        l4.setBounds(300, 100, 100, 20);
        add(l4);

        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(400, 100, 150, 20);
        add(c1);

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));
        b1.setBounds(330, 160, 100, 20);
        add(b1);

        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel", new ImageIcon(i2));
        b2.setBounds(450, 160, 100, 20);
        add(b2);

        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i3 = ic3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b3 = new JButton("Sign Up", new ImageIcon(i3));
        b3.setBounds(380, 200, 130, 20);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i4 = ic4.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon icc = new ImageIcon(i4);
        l3 = new JLabel(icc);
        l3.setBounds(0, 0, 250, 250);
        add(l3);

        setLayout(new BorderLayout());

        setSize(640, 300);
        setLocation(200, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b1){
            try{
                Conn c = new Conn();
                String username = tf.getText();
                String password = pf.getText();
                String user = c1.getSelectedItem();
                String q = "select * from login where username=? and password=? and user=?";
                PreparedStatement ps = c.con.prepareStatement(q);

                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, user);

                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    String meter = rs.getString("meter_no");
                    new Project(meter, user).setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Credentials...");
                    tf.setText("");
                    pf.setText("");
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e);
            }
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
