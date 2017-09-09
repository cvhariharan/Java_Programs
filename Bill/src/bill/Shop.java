/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;
import java.util.*;
/**
 *
 * @author thero
 */
public class Shop {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop();
        while(true){
        System.out.println("1.Customer 2.Owner");
        int choice = sc.nextInt();
        boolean isOwner = false;
        switch(choice)
        {
            case 1: shop.caterToCustomer();
            break;
            
            case 2: isOwner = shop.auth();
            break;
            
            default: System.out.println("Invalid Input!");
        }
       if(isOwner)
       {
           Categories catelog = new Categories();
           int todo = 1;
           while(todo!=0)
           {
               System.out.println("0.Exit 1.Add items 2.Generate Bill: ");
               todo = sc.nextInt();
           switch(todo)
           {
               case 1: 
               System.out.println("Item name: ");
               String item_name = sc.next();
               System.out.println("Cost per unit: ");
               double rate = sc.nextDouble();
               System.out.println("Category: ");
               String category = sc.next();
               Items item = new Items(item_name,category,rate);
               Categories.printAllCategories();
               System.out.println("Category ID: ");
               int cat_id = sc.nextInt();
               catelog.add(item, cat_id-1);
               break;
               
               case 2: Bill bill = new Bill();
               bill.generate();
           }
           }           
       }
     }
    }
    
    public boolean auth()
    {
        String username = "Owner";
        String password = "Password";
        Scanner sc = new Scanner(System.in);
        System.out.println("Username: ");
        String user = sc.next();
        System.out.println("Password: ");
        String pass = sc.next();
        return username.equals(user)&&password.equals(pass);
    }
    public void caterToCustomer()
    {
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Hello! Customer Id: "+customer.cust_id);
        System.out.println();
            Categories.printAllCategories();
            int in=0;
            do
            {
                in = sc.nextInt();
                ArrayList<Items> items = Categories.categories.get(in-1);
                    int i=1;
                    for(Items item: items)
                    {
                        System.out.println(i+"."+item.name);
                        i++;
                    }
                    customer.addToBasket(in-1);
                
            }while(in!=666);
    }
}
