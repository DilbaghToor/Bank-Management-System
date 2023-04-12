
import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try {
           // (Class.forName(com.mysql.c).jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","217030");
            s = c.createStatement();

        } catch (Exception e){
            System.out.println(e);
        }

    }
}
