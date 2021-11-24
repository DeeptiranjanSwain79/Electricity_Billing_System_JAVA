package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerDetails extends JFrame implements ActionListener {
    JTable t;
    JButton print;
    String x[] = {"Customer Name", "Meter Number", "Address", "City", "State", "Email", "Phone"};
    String y[][] = new String[40][8];
    int i = 0, j = 0;

    CustomerDetails(){
        super("Customer Details");
        setSize(1200, 650);
        setLocation(50, 50);

        try{
            Conn c = new Conn();
            String q = "Select * from customer";
            ResultSet set = c.stmt.executeQuery(q);
            while (set.next()){
                y[i][j++] = set.getString("name");
                y[i][j++] = set.getString("meter");
                y[i][j++] = set.getString("address");
                y[i][j++] = set.getString("city");
                y[i][j++] = set.getString("state");
                y[i][j++] = set.getString("email");
                y[i][j++] = set.getString("phone");
                i++;
                j=0;
            }
            t = new JTable(y, x); //JTable table = new JTable(data, columnNames);
            t.setBorder(BorderFactory.createBevelBorder(2, Color.BLUE, Color.BLACK));
        }catch (Exception e){e.printStackTrace();}

        print = new JButton("Print");
        add(print, "South");
        JScrollPane sp = new JScrollPane(t);
        add(sp);
        print.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae){
        try {
            t.print();
        }catch (Exception e){System.out.println(e);}
    }

    public static void main(String[] args) {
        new CustomerDetails().setVisible(true);
    }
}
