package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class GenerateBill extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextArea ta;
    JButton btn;
    Choice c;
    String meter;

    GenerateBill(String meter){
        this.meter = meter;
        setSize(550, 750);
        setLayout(new BorderLayout());

        l1 = new JLabel("Generate Bill");
        l2 = new JLabel(meter);
        c = new Choice();

        c.add("January");
        c.add("February");
        c.add("March");
        c.add("April");
        c.add("May");
        c.add("June");
        c.add("July");
        c.add("August");
        c.add("September");
        c.add("October");
        c.add("November");
        c.add("December");

        ta = new JTextArea(50, 25);
        ta.setText("\n\n\s\s\s\s\s\s\s\s\sClick on the Generate Bill Button to\n\tto get the bill of the selected month");
        JScrollPane sp = new JScrollPane(ta);
        ta.setFont(new Font("Tahoma", Font.BOLD, 17));

        btn = new JButton("Generate Bill");

        add(l1);
        add(l2);
        add(c);
        add(sp, "Center");
        add(btn, "South");

        btn.addActionListener(this);
        setLocation(200, 10);
        
    }

    public void actionPerformed(ActionEvent ae){
        try {
            Conn con =  new Conn();
            String month = c.getSelectedItem();
            ta.setText("\n\n\s\s\s\s\s\s\s\s\sHAPPY.L Power  Limited\nELECTRICITY BILL FOR THE MONTH OF '"+month+"', 2021\n\n");

            ResultSet rs = con.stmt.executeQuery("Select * from customer where meter='"+meter+"'");

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

            rs = con.stmt.executeQuery("select * from meter_info where meter_no='"+meter+"'");
            if (rs.next()){
                ta.append("\n       Meter Location: "+rs.getString("meter_location"));
                ta.append("\n       Meter Type:     "+rs.getString("meter_type"));
                ta.append("\n       Phase Code:     "+rs.getString("phase_code"));
                ta.append("\n       Bill Type:      "+rs.getString("bill_type"));
                ta.append("\n       Days:           "+rs.getString("days"));
                ta.append("\n-------------------------------------------------------------------------------------------\n");

            }

            rs = con.stmt.executeQuery("select * from tax");
            if (rs.next()){
                ta.append("---------------------------------------------------------------------------------------------\n\n");
                ta.append("\n       Cost per Unit:      "+rs.getString("cost_per_unit"));
                ta.append("\n       Meter Rent:         "+rs.getString("meter_rent"));
                ta.append("\n       Service Charge:     "+rs.getString("service_charge"));
                ta.append("\n       Service Tax:        "+rs.getString("service_tax"));
                ta.append("\n       Swachh Bharat Cess: "+rs.getString("swachh_bharat_cess"));
                ta.append("\n       Fixed Tax:          "+rs.getString("fixed_tax"));
                ta.append("\n-------------------------------------------------------------------------------------------\n");
            }

            rs = con.stmt.executeQuery("select * from bill where meter='"+meter+"' and month='"+c.getSelectedItem()+"'");
            if (rs.next()){
                ta.append("---------------------------------------------------------------------------------------------\n\n");
                ta.append("\n       Current Month:  "+rs.getString("month"));
                ta.append("\n       Units Consumed: "+rs.getString("unit"));
                ta.append("\n       Total Charges:  "+rs.getString("amount"));
                ta.append("\n-------------------------------------------------------------------------------------------");
                ta.append("\n       TOTAL PAYABLE:  "+rs.getString("amount"));
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        new GenerateBill("").setVisible(true);
    }
}
