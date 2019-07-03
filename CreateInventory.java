package inventory;

/*  
import
load and register c
establish the connection 
create the statement
execute the query 
process the query
close
*/
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateInventory {

//load the driver
 //defining the query code to be used in mysql
void CreateInventoryy(){
    Scanner scn= new Scanner(System.in);
    SetConnection connection= new SetConnection();
         int i, sno;
        String pname;
        int number; 
        double cost, mrp, profit;
    int restart;
        //code to enter data into the database
        do
        {
      
        //input for prodcut name
       
        System.out.println("Enter product serial number: ");
        sno=scn.nextInt();
        scn.nextLine();
        
        System.out.println("Enter the product name: ");
        pname= scn.nextLine();
       
        //input for amount of product available
        System.out.println("Amount of product in store: ");
        number= scn.nextInt();
        
        //input of cost 
        System.out.println("Cost of product: ");
        cost= scn.nextDouble();
        
         //input of mrp
        System.out.println("MRP of product: ");
        mrp= scn.nextDouble();
       
        //input of profit margin
        profit= mrp-cost;
        
        
        System.out.println("Entered data:");
        System.out.println("Product Name:" +pname);
        System.out.println("Amount:" +number);
        System.out.println("Cost:" +cost);
        System.out.println("MRP: " +mrp);
        System.out.println("Press 1 to add, any other number to discard");
        int choice;
        choice= scn.nextInt();
        if(choice==1)
        {
            try {
                connection.SetConnectionn();
                Connection con= connection.con;
                String query= "insert into stdd values (?,?,?,?,?,?)";
                PreparedStatement st;
                st = con.prepareStatement(query);
                st.setInt(1, sno);
                st.setString(2, pname);
                st.setInt(3, number);
                st.setDouble(4, cost);
                st.setDouble(5, mrp);
                st.setDouble(6, profit);
                int count;
                count = st.executeUpdate();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(CreateInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        System.out.println("To enter another product press 1, press any other number to exit");
      restart= scn.nextInt();
        if(restart==1)
        {
            String nextLine = scn.nextLine();
        }
        if(restart!=1)
        {
            break;
        } 
        }while(restart==1);
        }
}
       
   

