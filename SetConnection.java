package inventory;


import java.sql.Connection;
import java.sql.DriverManager;

public class SetConnection {

    Connection con;
    
    void SetConnectionn()
    {
         try {
            //load the driver
            String url = "jdbc:mysql://localhost:3306/inventory?autoReconnect=true&useSSL=false";
            String user= "root";
            String password= "1q2w3e4r";
            //register the driver
            Class.forName("com.mysql.jdbc.Driver");
          con= DriverManager.getConnection(url, user, password);
        } 
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}
