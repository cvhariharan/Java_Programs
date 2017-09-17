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
    static ArrayList<Customer> customers_list = new ArrayList<Customer>();
    static int isDone = 1; //Has to be static to prevent further recursive calls in caterToCustomer
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
            System.out.println("1.Existing Customer 2.New Customer 3.Exit");
            int existing = sc.nextInt();
            if(existing == 1)
            {
                System.out.println("Enter Customer ID: ");
                String id = sc.next();
                int cust_id = Customer.parseCustId(id);
                if(cust_id >=0 && cust_id < shop.customers_list.size())
                {
                Customer customer = shop.customers_list.get(cust_id);
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
            else if(existing == 2)
            {
            System.out.println("Enter your name: ");
            String name = sc.next();
            System.out.println("Enter your phone number: ");
            long phone_no = sc.nextLong();
            Customer customer = new Customer(name,phone_no);
            shop.customers_list.add(customer); //customers_list stores data of all the customers
            shop.caterToCustomer(customer);
            }
            else
            break;
            break;
            case 2: isOwner = shop.auth();
            break;
            
            default: System.out.println("Invalid Input!");
        }
       if(isOwner)
       {
           Categories catelog = new Categories();
           int todo = 1;
           while(todo!=8)
           {
               System.out.println("0.Adjust GST rates \n1.Add Items \n2.Add new Category \n3.Customer Logs \n4.Delete Item \n5.Delete Category \n6.Edit Item details \n7.Print item details \n8.Exit");
               todo = sc.nextInt();
           switch(todo)
           {
               case 1: //Add items
               System.out.println("Item name: ");
               String item_name = sc.next();
               item_name += sc.nextLine();
               System.out.println("Cost per unit: ");
               double rate = sc.nextDouble();
               Categories.printAllCategories();
               System.out.println("Category ID: ");
               int category = sc.nextInt();
               System.out.println("Count (Enter 0 for default value of 50): ");
               int count = sc.nextInt();
               Items item = new Items(item_name,category-1,rate,count);
               catelog.add(item, category-1);
                   break;
               
               case 2: Categories.addNewCategory();
                   break;
              
               case 3: Customer.printCustomerLogs();
                   break;
               
               case 4: Categories.printAllCategories();  //Delete Item case
               System.out.println("Category ID: ");
               int cat_id = sc.nextInt();
               Categories.printAllItems(cat_id-1);
               System.out.println("Item ID: ");
               int item_id = sc.nextInt();
               Categories.deleteItem(cat_id-1, item_id-1);
                   break;
               
               case 5: Categories.printAllCategories();  //Delete category case
               System.out.println("Category ID: ");
               int cate_id = sc.nextInt();
               Categories.deleteCategory(cate_id-1);
                   break;
               
               case 6: Categories.printAllCategories();
               System.out.println("Category ID: ");
               int catid = sc.nextInt();
               Categories.printAllItems(catid-1);
               System.out.println("Item id: ");
               int itemid = sc.nextInt();
               Categories.editItem(catid-1, itemid-1);
                   break;
                   
               case 7: Categories.printAllCategories();
               System.out.println("Category ID: ");
               int cateid = sc.nextInt();
               Categories.printAllItems(cateid-1);
               System.out.println("Item id: ");
               int id = sc.nextInt();
               Items.printDetails(Categories.categories.get(cateid-1).get(id-1));
               System.out.println();
                   break;
               case 8:
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
        System.out.println();
        System.out.println("Hello! "+customer.name+ " "+"Customer ID: "+customer.fancyCustId());
            //Categories.printAllCategories();
            int in=0;
            do
            {
                Categories.printAllCategories();
                System.out.println("Select (Type 666 to exit and return to the previous option): ");
                in = sc.nextInt(); //This is the category Id
                if(in != 666)
                {
                    Categories.printAllItems(in-1);
                    customer.addToBasket(in-1);
                }
            }while(in!=666);
            System.out.println("Estimated cost: ");
            customer.showBasket();
            //int isDone = 1;
            while(true)
            {
            System.out.println("1.Delete item from basket\n2.Add more items\n3.Checkout");
            isDone = sc.nextInt();
            
            switch(isDone)
            {
                case 1: customer.showBasket();
                System.out.println("Enter the item id to delete that item: ");
                int item_id = sc.nextInt();
                customer.deleteFromBasket(item_id-1);
                System.out.println("Modified basket: ");
                customer.showBasket();
                break;
                
                case 2: caterToCustomer(customer);
                break;
                
                case 3: customer.checkout();
                break;
                    
            }
            
            if(isDone == 3)
            {
                
                break;
            }
            }
    
    }
}
