package inventory;



import java.util.Scanner;

/*  
import
load and register c
establish the connection 
create the statement
execute the query 
process the query
close
*/

public class Main{

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        Scanner scn= new Scanner(System.in);
        int choice;
        System.out.println("Press 1 to Create New Inventory.");
        System.out.println("Press 2 to Update Inventory.");
        System.out.println("Press 3 to Delete Inventory.");
        System.out.println("Press 4 to Display Single Inventory");
        System.out.println("Press 5 to Display Complete Inventory");
        choice= scn.nextInt();
        switch(choice)
        {
            //Create Inventory
            case 1:
                CreateInventory createinv= new CreateInventory();
                createinv.CreateInventoryy();
                break;
            //Update Inventory
            case 2:
                UpdateInventory updateinv= new UpdateInventory();
                updateinv.EditInventory();
                break;
            //Delete Inventory
            case 3:
                DeleteInventory del= new DeleteInventory();
                del.Delete();
                break;
            case 4: 
                DisplayInventory dis= new DisplayInventory();
                dis.DisplaySingle();
                break;
            case 5:
                DisplayInventory disp= new DisplayInventory();
                disp.Displaywhole();
                break;
            default:
                break;
        } 
    }
}       