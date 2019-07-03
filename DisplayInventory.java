package inventory;


import java.sql.Connection;
import java.util.Scanner;
import java.sql.*;

public class DisplayInventory 
{
    SetConnection connection= new SetConnection();
    Scanner scn= new Scanner(System.in);
    void DisplaySingle() throws SQLException
    {
    connection.SetConnectionn();
    Connection con= connection.con;
        int choice;
    do{
    System.out.println("Display Single Inventory: ");
    System.out.println("Enter the serial number of the product: ");
    int sno;
    sno= scn.nextInt();
    String queryds;
    queryds="select * from stdd where sno="+sno"";
        try (Statement st1 = con.createStatement()) {
            ResultSet rs= st1.executeQuery(queryds);
            rs.next();
            System.out.println("Serial Number:" +rs.getString(1));
            System.out.println("Product Name: " +rs.getString(2));
            System.out.println("Amount: " +rs.getString(3));
            System.out.println("Cost: " +rs.getString(4));
            System.out.println("MRP: " +rs.getString(5));
        }
        System.out.println("Press 1 to display another product.");
        choice= scn.nextInt();
    }while(choice==1);
    break;
    }
    
    void Displaywhole() throws SQLException
    {
    connection.SetConnectionn();
    Connection con= connection.con;
        int choice;
    {
    System.out.println("Display Complete Inventory: ");
    String queryc;
    queryc="select * from stdd";
        try (Statement st1 = con.createStatement()) {
            ResultSet rs;
            rs = st1.executeQuery(queryc);
            if(rs.next())
            {
            do{
            System.out.println("Serial Number:" +rs.getString(1));
            System.out.println("Product Name: " +rs.getString(2));
            System.out.println("Amount: " +rs.getString(3));
            System.out.println("Cost: " +rs.getString(4));
            System.out.println("MRP: " +rs.getString(5));
            System.out.println("\n");
            }while(rs.next());
            }
        }
    }
    }
}
