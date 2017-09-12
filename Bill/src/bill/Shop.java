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
        System.out.println("1.Customer 2.Owner (Default username: Owner and Password: Password) All choices are done using the number indicated before the choices.");
        int choice = sc.nextInt();
        boolean isOwner = false;
        switch(choice)
        {
            case 1: 
            System.out.println("1.Existing Customer 2.New Customer");
            int existing = sc.nextInt();
            if(existing == 1)
            {
                System.out.println("Enter Customer ID: ");
                int cust_id = sc.nextInt();
                if(cust_id >=0 && cust_id < Customer.customers_list.size())
                {
                Customer customer = Customer.customers_list.get(cust_id);
                System.out.println("1.Show Purchase History 2.Buy more items");
                int cust_choice = sc.nextInt();
                if(cust_choice == 1)
                    customer.showHistory();
                else
                    shop.caterToCustomer(customer);
                
                }
                else
                    System.out.println("Invalid Customer ID!");
            }
            else
            {
            System.out.println("Enter your name: ");
            String name = sc.next();
            System.out.println("Enter your phone number: ");
            long phone_no = sc.nextLong();
            Customer customer = new Customer(name,phone_no);
            Customer.customers_list.add(customer); //customers_list stores data of all the customers
            shop.caterToCustomer(customer);
            }
            break;
            
            case 2: isOwner = shop.auth();
            break;
            
            default: System.out.println("Invalid Input!");
        }
       if(isOwner)
       {
           Categories catelog = new Categories();
           int todo = 1;
           while(todo!=3)
           {
               System.out.println("0.Adjust GST rates 1.Add Items 2.Add new Category 3.Exit 4.Customer Logs");
               todo = sc.nextInt();
           switch(todo)
           {
               case 1:
               System.out.println("Item name: ");
               String item_name = sc.next(); //Use BufferedReader
               System.out.println("Cost per unit: ");
               double rate = sc.nextDouble();
               Categories.printAllCategories();
               System.out.println("Category ID: ");
               int category = sc.nextInt();
               Items item = new Items(item_name,category-1,rate);
               catelog.add(item, category-1);
               break;
               
               case 2: Categories.addNewCategory();
               break;
               
               case 3: break;
               
               case 4: Customer.printCustomerLogs();
               break;
               
               case 0: Categories cate = new Categories();
               cate.adjustGST();
               /*case 2: Bill bill = new Bill();
               bill.generate(customer.basket,customer.quantities);*/
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
    public void caterToCustomer(Customer customer)
    {
        Scanner sc = new Scanner(System.in);
        //Customer customer = new Customer();
        System.out.println("Hello! "+customer.name+ " "+"Customer ID: "+customer.cust_id);
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
                        System.out.println(i+"."+item.name+" "+"GST: "+(double)Categories.gst_rates.get(item.category_id)+"%");
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
