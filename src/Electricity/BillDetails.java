package Electricity;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
//import net.*;

public class BillDetails extends JFrame {
    JTable t;
    String x[] = {"Meter Number", "Month", "Units", "Total Bill", "Status"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    BillDetails(String meter){
        super("Bill Details");
        setSize(700, 650);
        setLocation(200, 50);
        setLayout(null);
        getContentPane().setBackground(new Color(0, 128, 128));
        t = new JTable(y, x);
        t.setBorder(BorderFactory.createBevelBorder(2, Color.BLUE, Color.BLACK));
        try{
            Conn c = new Conn();
            String q = "select * from bill where meter = "+meter;
            ResultSet rs = c.stmt.executeQuery(q);
            while(rs.next()){
                y[i][j++] = rs.getString("meter");
                y[i][j++] = rs.getString("month");
                y[i][j++] = rs.getString("unit");
                y[i][j++] = rs.getString("amount");
                y[i][j++] = rs.getString("status");
                i++;
                j=0;
            }
            t = new JTable(y, x);
        }catch (Exception e){e.printStackTrace();}

        JScrollPane sp = new JScrollPane(t);
        sp.setBounds(0, 0, 750, 650);
        add(sp);

    }

    public static void main(String[] args) {
        new BillDetails("").setVisible(true);
    }
}
