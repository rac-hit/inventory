package inventory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DeleteInventory {
     Scanner scn= new Scanner(System.in);
        SetConnection connection= new SetConnection();
        void Delete()
    {
        int sno, updatee;           
         try {
             connection.SetConnectionn();
             Connection con= connection.con;
             System.out.println("Delete Inventory: ");
             System.out.println("Enter the serial number of the product: ");
             sno= scn.nextInt();
             //display the serial number entered by the user
             String queryshow;
             queryshow = "select pname from stdd where sno= "+sno"";
             //display the name of the product to be changed
             Statement st1 = con.createStatement();
             ResultSet rs= st1.executeQuery(queryshow);
             rs.next();
             String pname= rs.getString("pname");
             System.out.println("Serial Number: " +sno);
             System.out.println("Product Name: " +pname);
             System.out.println("To confirm deletion, press 1.");
             updatee= scn.nextInt();
             if(updatee==1)
                {
                String querydel="delete from stdd where sno="+sno"";
                PreparedStatement st;
                st = con.prepareStatement(querydel);
                st.executeUpdate();
                st.close();
                }
         } 
         catch (SQLException ex) 
         {
             Logger.getLogger(DeleteInventory.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
