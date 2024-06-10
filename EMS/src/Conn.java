package EMS.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;

    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root","ayushimeena33");
            statement = connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}