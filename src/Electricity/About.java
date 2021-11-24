package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {

    JButton btn;
    JLabel about;
    Font f1, f2, f3;
    TextArea t1;
    String s;

    public About(){
        setLayout(null);
        btn = new JButton("Exit");
        add(btn);
        btn.setBounds(180, 430, 120, 20);
        btn.addActionListener(this);

        //Font for Button
        Font f1 = new Font("Arial", Font.BOLD, 180);
        setFont(f1);

        //String to be displayed
        s = "\t\t\t\tAbout Project\n"+
                "Electricity billing is a software-based application developed in JAVA programming language.\n"+
                "The project aims in serving the department of electricity by computerizing the billing system.\n"+
                "It mainly focuses on the calculation of units consumed during the specified time and the money to be paid to the electricity offices.\n"+
                "This computerized system will make the overall billing system easy, accessible, comfortable and effective for consumers\n\n\n";
        
        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);
        
        add(t1);

        //Font for TextArea
        Font f2 = new Font("Arial", Font.BOLD, 16);
        t1.setFont(f2);
        
        Container contentPane = this.getContentPane();
        t1 = new TextArea();
        
        JLabel about = new JLabel("About Project");
        add(about);
        about.setBounds(170, 10, 180, 80);
        about.setForeground(Color.RED);

        //Font for Label
        Font f3 = new Font("Arial", Font.BOLD, 20);
        about.setFont(f3);
        
        setBounds(400, 150, 500, 550);

        //To show the project window in the middle
        setLayout(null);
        setVisible(true);
    }

    //Interface of ActionListener
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btn){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new About().setVisible(true);
    }
}
