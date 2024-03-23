package CollegeManagementSystem;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/collegemanagementsystem","root","5269");
            s=c.createStatement();

        }
        catch(Exception e){
            e.printStackTrace();

        }
    }



}
