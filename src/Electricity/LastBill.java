package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LastBill extends JFrame implements ActionListener {
    JLabel l;
    JTextArea ta;
    JButton btn;
    Choice c;

    LastBill(){
        setSize(500, 750);
        setLayout(new BorderLayout());

        l = new JLabel("Generate Bill");
        c = new Choice();

        try {
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("select * from customer");
            while (rs.next()){
                c.add(rs.getString("meter"));
            }
        }catch (Exception e){e.printStackTrace();}

        ta = new JTextArea(50, 25);
        JScrollPane sp = new JScrollPane(ta);
        ta.setFont(new Font("Tahoma", Font.BOLD, 17));

        btn = new JButton("Generate Bill");
        add(l);
        add(c);
        add(sp, "Center");
        add(btn, "South");

        btn.addActionListener(this);
        setLocation(200, 10);
    }

    public void actionPerformed(ActionEvent ae){
        try {
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("select * from customer where meter='"+c.getSelectedItem()+"'");
            if (rs.next()){
                ta.append("\n       Customer Name: "+rs.getString("name"));
                ta.append("\n       Meter Number:  "+rs.getString("meter"));
                ta.append("\n       Address:       "+rs.getString("address"));
                ta.append("\n       City:          "+rs.getString("city"));
                ta.append("\n       State:         "+rs.getString("state"));
                ta.append("\n       Email:         "+rs.getString("email"));
                ta.append("\n       Phone:         "+rs.getString("phone"));
                ta.append("\n-------------------------------------------------------------------------------------------\n");

            }

            ta.append("Details of Last Bill\n\n");
            rs = con.stmt.executeQuery("select * from bill where meter='"+c.getSelectedItem()+"'");
            while (rs.next()){
                ta.append("         "+rs.getString("month")+"      "+rs.getString("amount")+"\n");
            }

        }catch (Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        new LastBill().setVisible(true);
    }
}
