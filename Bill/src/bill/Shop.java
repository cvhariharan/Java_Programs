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
            case 1: Customer customer = new Customer();
            shop.caterToCustomer(customer);
            break;
            
            case 2: isOwner = shop.auth();
            break;
            
            default: System.out.println("Invalid Input!");
        }
       if(isOwner)
       {
           Categories catelog = new Categories();
           int todo = 1;
           while(todo!=2)
           {
               System.out.println("1.Add Items 2.Exit");
               todo = sc.nextInt();
           if(todo == 1)
           {
               System.out.println("Item name: ");
               String item_name = sc.next();
               System.out.println("Cost per unit: ");
               double rate = sc.nextDouble();
               Categories.printAllCategories();
               System.out.println("Category ID: ");
               int category = sc.nextInt();
               Items item = new Items(item_name,category-1,rate);
               catelog.add(item, category-1);
               
               /*case 2: Bill bill = new Bill();
               bill.generate(customer.basket,customer.quantities);*/
           }
           else if(todo == 2)
               break;
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
    public void caterToCustomer(Customer customer)
    {
        Scanner sc = new Scanner(System.in);
        //Customer customer = new Customer();
        System.out.println("Hello! Customer Id: "+customer.cust_id);
        System.out.println();
            //Categories.printAllCategories();
            int in=0;
            do
            {
                Categories.printAllCategories();
                System.out.println("Select (Type 666 to exit and return to the previous option): ");
                in = sc.nextInt();
                if(in != 666)
                {
                ArrayList<Items> items = Categories.categories.get(in-1);
                    int i=1;
                    for(Items item: items)
                    {
                        System.out.println(i+"."+item.name+" "+"GST: "+Categories.gst_rates[item.category_id]+"%");
                        i++;
                    }
                    customer.addToBasket(in-1);
                }
            }while(in!=666);
            System.out.println("Estimated cost: ");
            customer.showBasket();
            System.out.println("Do you want to checkout? Y/N");
            String isDone = sc.next().toLowerCase();
            if(isDone.equals("y"))
                customer.checkout();
            else
                caterToCustomer(customer);
    }
}
