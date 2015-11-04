import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String telNumber;
    String org;
    public ConnectDB(){
        try{
            Class.forName("org.h2.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:h2:phoneDataBase", "root", "root");
            statement = connection.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
