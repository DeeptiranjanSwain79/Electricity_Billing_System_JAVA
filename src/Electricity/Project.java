package Electricity;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Project extends JFrame implements ActionListener {
    String meter;
    Project(String meter, String person){
        super("Electricity Billing System");
        this.meter = meter;
        setSize(1600, 850);

//        Adding background image
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/elect2.jpg"));
        Image i = ic.getImage().getScaledInstance(1200, 900, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i);
        JLabel img = new JLabel(ic2);
        add(img);

        //First Column
        JMenuBar mb = new JMenuBar();
        JMenu admin = new JMenu("Admin");
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        JMenuItem m3 = new JMenuItem("Deposit Details");
        JMenuItem m4 = new JMenuItem("Calculate Bill");
        admin.setForeground(Color.BLUE);

        //*****Customer Details*****
        m1.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('C');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
        m1.setBackground(Color.WHITE);

        //Meter Details
        m2.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic('M');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.SHIFT_MASK));
        m2.setBackground(Color.WHITE);

        //Deposit Details
        m3.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        m3.setIcon(new ImageIcon(image3));
        m3.setMnemonic('D');
        m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
        m3.setBackground(Color.WHITE);

        //Calculate Bill
        m4.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        m4.setIcon(new ImageIcon(image5));
        m4.setMnemonic('B');
        m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.SHIFT_MASK));
        m4.setBackground(Color.WHITE);

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);

        //*****************************************************************************************************************
        JMenu info = new JMenu("Information");
        JMenuItem info1 = new JMenuItem("Update Information");
        JMenuItem info2 = new JMenuItem("View Information");
        info.setForeground(Color.BLUE);

        //Pay Bill
        info1.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        info1.setIcon(new ImageIcon(image4));
        m4.setMnemonic('P');
        m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
        info1.setBackground(Color.WHITE);

        //Last Bill
        info2.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon42 = new ImageIcon(ClassLoader.getSystemResource("icon/icon42.png"));
        Image image42 = icon42.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        info2.setIcon(new ImageIcon(image42));
        info2.setMnemonic('L');
        info2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.SHIFT_MASK));
        info2.setBackground(Color.WHITE);

        info1.addActionListener(this);
        info2.addActionListener(this);

        //*****************************************************************************************************************
        JMenu user = new JMenu("User");
        JMenuItem u1 = new JMenuItem("Pay Bill");
        JMenuItem u2 = new JMenuItem("Last Bill");
        user.setForeground(Color.BLUE);

        //Pay Bill
        u1.setFont(new Font("monospaced", Font.PLAIN, 15));
        Image image43 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image43));
        u1.setMnemonic('P');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
        u1.setBackground(Color.WHITE);

        //Last Bill
        u2.setFont(new Font("monospaced", Font.PLAIN, 15));
        Image image44 = icon42.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(image44));
        u2.setMnemonic('L');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.SHIFT_MASK));
        u2.setBackground(Color.WHITE);

        u1.addActionListener(this);
        u2.addActionListener(this);

        //*****************************************************************************************************************
        //Third Column
        JMenu report = new JMenu("Report");
        JMenuItem r1 = new JMenuItem("Generate Bill");
        report.setForeground(Color.BLUE);

        //***Report***
        r1.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        r1.setIcon(new ImageIcon(image7));
        r1.setMnemonic('R');
        r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.SHIFT_MASK));
        r1.setBackground(Color.WHITE);

        r1.addActionListener(this);

        //*****************************************************************************************************************
        //Fourth Column
        JMenu utility = new JMenu("Utility");
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");
        utility.setForeground(Color.BLUE);

        //Notepad
        ut1.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ut1.setIcon(new ImageIcon(image8));
        ut1.setMnemonic('N');
        ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.SHIFT_MASK));
        ut1.setBackground(Color.WHITE);

        //Notepad
        ut2.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ut2.setIcon(new ImageIcon(image9));
        ut2.setMnemonic('C');
        ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
        ut2.setBackground(Color.WHITE);

        //Web Browser
        ut1.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon10.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ut3.setIcon(new ImageIcon(image10));
        ut3.setMnemonic('N');
        ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.SHIFT_MASK));
        ut3.setBackground(Color.WHITE);

        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);

        //*****************************************************************************************************************
        //Fifth Column
        JMenu exit = new JMenu("Log out");
        JMenuItem ex = new JMenuItem("Log out");
        exit.setForeground(Color.RED);

        //Exit
        ex.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('N');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.SHIFT_MASK));
        ex.setBackground(Color.WHITE);

        ex.addActionListener(this);

        //*****************************************************************************************************************

        JMenu about = new JMenu("About");
        JMenuItem ab = new JMenuItem("About");
        about.setForeground(new Color(20, 100, 10));

        ab.setFont(new Font("monospaced", Font.PLAIN, 15));
        ab.setMnemonic('A');
        ab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK));
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);

        //******************************************************************************************************************
        admin.add(m1);
        admin.add(m2);
        admin.add(m3);
        admin.add(m4);

        info.add(info1);
        info.add(info2);

        user.add(u1);
        user.add(u2);

        report.add(r1);

        utility.add(ut1);
        utility.add(ut2);
        utility.add(ut3);

        about.add(ab);

        exit.add(ex);

        if (person.equals("Admin")){
            mb.add(admin);
        }else {
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(about);
        mb.add(exit);

        setJMenuBar(mb);

        setFont(new Font("Sanserif", Font.BOLD, 27));
        setLayout(new FlowLayout());
        setVisible(false);

    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if (msg.equals("Customer Details")){
            new CustomerDetails().setVisible(true);
        }else if(msg.equals("New Customer")){
            new NewCustomer().setVisible(true);
        }else if (msg.equals("Calculate Bill")){
            new CalculateBill().setVisible(true);
        }else if (msg.equals("Pay Bill")){
            new PayBill(meter).setVisible(true);
        }else if (msg.equals("Last Bill")){
            new PayBill(meter).setVisible(true);
        }else if (msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){e.printStackTrace();}
        }else if (msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){e.printStackTrace();}
        }else if (msg.equals("Web Browser")){
            try{
                Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            }catch (Exception e){e.printStackTrace();}
        }else if (msg.equals("Log out")){
            this.setVisible(false);
            new Login().setVisible(true);
        }else if (msg.equals("Generate Bill")){
            new GenerateBill(meter).setVisible(true);
        }else if(msg.equals("Deposit Details")){
            new DepositDetails().setVisible(true);
        }else if(msg.equals("View Information")){
            new ViewInformation(meter).setVisible(true);
        }else if (msg.equals("Update Information")){
            new UpdateInformation(meter).setVisible(true);
        }else if (msg.equals("Bill Details")){
            new BillDetails(meter).setVisible(true);
        }else if(msg.equals("About")){
            new About().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Project("", "").setVisible(true);
    }
}
