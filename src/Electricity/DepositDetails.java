package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DepositDetails extends JFrame implements ActionListener {
    JTable t,t1;
    JButton search, print;
    JLabel l1, l2;
    Choice c1, c2;
    String x[] = {"Meter Number", "Month", "Units", "Total Bill", "Status"};
    String y[][] = new String[40][8];
    int i = 0, j =0;
    DepositDetails(){
        super("Deposit Details");
        setSize(700, 650);
        setLocation(200, 50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        l1 = new JLabel("Sort by Meter Number");
        l1.setBounds(20, 20, 150, 20);
        add(l1);

        c1 = new Choice();

        l2 = new JLabel("Sort by Month");
        l2.setBounds(400, 20, 100, 20);
        add(l2);

        c2 = new Choice();

        try{
            Conn c = new Conn();
            String q1 = "Select * from bill";
            ResultSet rs = c.stmt.executeQuery(q1);
            while (rs.next()){
                y[i][j++] = rs.getString("meter");
                y[i][j++] = rs.getString("month");
                y[i][j++] = rs.getString("unit");
                y[i][j++] = rs.getString("amount");
                y[i][j++] = rs.getString("status");
                i++;
                j=0;
            }
            t = new JTable(y, x);

            String q2 = "Select * from customer";
            rs = c.stmt.executeQuery(q2);
            while (rs.next()){
                c1.add(rs.getString("meter"));
            }
        }catch (Exception e){e.printStackTrace();}

        c1.setBounds(180, 20, 150, 20);
        add(c1);

        c2.setBounds(520, 20, 150, 20);
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        add(c2);

        search = new JButton("Submit");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        JScrollPane sp = new JScrollPane(t);
        sp.setBounds(0, 100, 700, 650);
        add(sp);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String q = "select * from bill where meter='"+c1.getSelectedItem()+"' and month='"+c2.getSelectedItem()+"'";
//            System.out.println(q);
            try{
                Conn c = new Conn();
                ResultSet rs = c.stmt.executeQuery(q);
                String x[] = {"Meter Number", "Month", "Units", "Total Bill", "Status"};
                String y[][] = new String[5][8];
                int i = 0, j =0;
                while (rs.next()){
                    y[i][j++] = rs.getString("meter");
                    y[i][j++] = rs.getString("month");
                    y[i][j++] = rs.getString("unit");
                    y[i][j++] = rs.getString("amount");
                    y[i][j++] = rs.getString("status");
                    i++;
                    j=0;
                }
                t = new JTable(y, x);
                JOptionPane.showMessageDialog(null, t);
//                t.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "No records found");
            }
        }else if (ae.getSource() == print){
            try {
                t.print();
            }catch (Exception e){e.printStackTrace();}
        }
    }

    public static void main(String[] args) {
        new DepositDetails().setVisible(true);
    }
}
