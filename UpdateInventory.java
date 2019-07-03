package inventory;

import java.sql.*;
import java.util.Scanner;
public class UpdateInventory 
{
    Scanner scn= new Scanner(System.in);
    SetConnection connection= new SetConnection();
    int sno;
    private int choice;
    //Edit Exisiting
    @SuppressWarnings("empty-statement")
    void EditInventory() throws SQLException
    {
        int continuee = 0;
        do
        {
        connection.SetConnectionn();
        Connection con= connection.con;
        System.out.println("Edit Inventory: ");
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
        //give the user choices to change the data
        System.out.println("Press 1 to change the Number of Products.");
        System.out.println("Press 2 to change the Cost.");
        System.out.println("Press 3 to change the MRP.");
        //no other input is accepted other than the above 
        
        do
        {
         choice= scn.nextInt();
        }while(choice != 1 && choice !=2 && choice !=3);
        
                
        switch(choice)
        {
            //updating the number of products
            case 1: 
                int number;
                System.out.println("Enter Updated Number of Products: ");
                number= scn.nextInt();
                String querynum= "update stdd set number = ? where sno= "+sno"";
                System.out.println("Serial Number: " + sno);
                System.out.println("Product Name: " + pname);
                System.out.println("Updated Number of Products: " + number);
                System.out.println("Enter 1 to Update.");
                int update= scn.nextInt();
                //Asking for confirmation before updating to the server 
                if(update==1)
                {
                PreparedStatement st;
                st = con.prepareStatement(querynum);
                st.setInt(1, number);
                int count;
                count = st.executeUpdate();
                st.close();
                }
                else
                {
                    break;
                }
                break;
            //Update the cost of the product
            case 2: 
                double cost;
                System.out.println("Enter Updated Cost of Products: ");
                cost= scn.nextDouble();
                String querycost;
                int sno1= sno;
                querycost = "update stdd set cost = ? where sno= "+sno1"";
                System.out.println("Serial Number: " + sno);
                System.out.println("Product Name: " + pname);
                System.out.println("Updated Cost of Products: " + cost);
                System.out.println("Enter 1 to Update.");
                int updatee= scn.nextInt();
            //Confirmation to update
                if(updatee==1)
                {
                PreparedStatement st;
                st = con.prepareStatement(querycost);
                st.setDouble(1, cost);
                int count;
                count = st.executeUpdate();
                st.close();
                }
                else
                {
                    break;
                }
                break;
            //Update the MRP
            case 3: 
                double mrp;
                System.out.println("Enter Updated MRP of Products: ");
                mrp= scn.nextDouble();
                String querymrp= "update stdd set mrp = ? where sno= "+sno"";
                System.out.println("Serial Number: " + sno);
                System.out.println("Product Name: " + pname);
                System.out.println("Updated MRP of Products: " + mrp);
                System.out.println("Enter 1 to Update.");
                int updateee= scn.nextInt();
            //Confirmation to update
                if(updateee==1)
                {
                PreparedStatement st;
                st = con.prepareStatement(querymrp);
                st.setInt(1, (int) mrp);
                int count;
                count = st.executeUpdate();
                st.close();
                }
                else
                {
                    break;
                }
                break;
            default:
                break;
        }
        if(choice== 2 || choice ==3)
        {
            //edit the profit data as per changed mrp and cost
            double profit;
            String queryprofita= "select cost from stdd where sno= "+sno"";
            String queryprofitb= "select mrp from stdd where sno= "+sno"";
            
            Statement st3 = con.createStatement();
            ResultSet rs1;
            rs1=st3.executeQuery(queryprofita);
            rs1.next();
            Double cost= rs1.getDouble("cost"); 
            ResultSet rs2;
            rs2= st3.executeQuery(queryprofitb);
            rs2.next();
            Double mrp= rs2.getDouble("mrp");
            profit= mrp-cost;
            String queryprofitu= "update stdd set profit = ? where sno= "+sno"";
            PreparedStatement st4;
            st4 = con.prepareStatement(queryprofitu);
            st4.setInt(1, (int) profit); 
            int count;
            count = st4.executeUpdate();
            st4.close();
        }
        System.out.println("Press 1 to Update further.");
       
        continuee= scn.nextInt();
        }while(continuee==1);
    }
}
