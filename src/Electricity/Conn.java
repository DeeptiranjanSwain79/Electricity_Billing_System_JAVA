package Electricity;

import java.sql.*;

public class Conn {
    Connection con;
    Statement stmt;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Electricity?characterEncoding=latin1", "root", "Happy");
            stmt = con.createStatement();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
