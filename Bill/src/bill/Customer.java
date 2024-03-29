package bill;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author thero
 */
public class Customer {
    static int all_customers;
    int cust_id;
    double total;
    String name;
    long phone_no;
    ArrayList<Items> basket = new ArrayList<Items>();
    ArrayList quantities = new ArrayList();
    //static ArrayList<Customer> customers_list = new ArrayList<Customer>();
    ArrayList<Bill> my_bills = new ArrayList<Bill>();
    /*ArrayList<Items> purchased = new ArrayList<Items>();
    ArrayList purchased_quantities = new ArrayList();*/
    Customer()
    {
        cust_id = all_customers;
        all_customers++;
    }
    Customer(String name, long phone_no)
    {
        this.name = name;
        this.phone_no = phone_no;
        cust_id = all_customers;
        all_customers++;
    }
    public ArrayList hasPurchased()
    {
       return basket;
    }
    
    public void addToBasket(int cat_id)
    {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        choice--;
        if(choice >= 0 && choice < Categories.categories.get(cat_id).size())
        {
        ArrayList<Items> items = Categories.categories.get(cat_id);
        Items item_to_add = items.get(choice);
        if(item_to_add.count > 0)
        {
        basket.add(item_to_add);
        System.out.println("Quantities: ");
        int quantity = sc.nextInt();
        if(quantity >= item_to_add.count && item_to_add.count != 0)
            quantity = item_to_add.count; //If quantity is more than available count, add all the available items to the basket
        quantities.add(quantity);
        item_to_add.count -= quantity;
        }
        else
            System.out.println("Sorry! "+item_to_add.name+" is out of stock!");
    }
    }
    public void deleteFromBasket(int item_id)
    {
            if(item_id >= 0 && item_id < basket.size())
            {
               basket.remove(item_id);
               quantities.remove(item_id);
            }
            else
                System.out.println("Invalid item id!");
     
    }
    public void showBasket()
    {
        int i=0;
        for(Items item: basket)
        {
            int quantity = (int)quantities.get(i);
            i++;
            double temp_bill = item.cost * quantity;
            double gst = temp_bill*((double)Categories.gst_rates.get(item.category_id))/100;
            double cgst = gst/2;
            double sgst = cgst;
            double temp_bill_gst = temp_bill+gst;
            System.out.println(i+". "+item.name+" "+"Rate: Rs."+item.cost+" X "+quantity+" "+"+"+" cgst: Rs."+cgst+" +"+" sgst: Rs."+sgst+" = "+temp_bill_gst);
        }
    }
    public void checkout()
    {
        
       Bill bill = new Bill();
       my_bills.add(bill.generate(basket,quantities,this));
       basket.clear();
       quantities.clear();
       
    }
    
    public static void printCustomerLogs()
    {
        System.out.println();
        for(Customer customer: Shop.customers_list)
        {
            /*System.out.println("Customer ID: "+customer.cust_id);
            customer.showBasket();
            System.out.println("Total: "+customer.total);*/
            System.out.println("Customer ID: "+customer.cust_id);
            customer.showHistory();
        }
    }
    
    public void showHistory()
    {
        int bill_id=1;
        for(Bill bill: my_bills)
        {
            int i = 0;
            System.out.println("Bill ID: "+bill_id);
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-15s %20s %20s","Name","Quantity","Cost");
            System.out.println();
            System.out.println("-----------------------------------------------------------");
            for(Items each_item : bill.basket)
            {
            System.out.println();
            System.out.printf("%-15s %20d %20f",each_item.name,bill.quantities.get(i),each_item.cost*(int)bill.quantities.get(i));
            i++;
            }
            System.out.println();
            System.out.print("Total: "+bill.total_bill);
            System.out.println();
            System.out.println("-----------------------------------------------------------");
            bill_id++;
        }
    }
    public String fancyCustId()
    {
        String fancyId = "C"+cust_id;
        return fancyId;
    }
    
    public static int parseCustId(String id)
    {
        String temp = id.replace("C","");
        int parsed_id = Integer.parseInt(temp);
        return parsed_id;
    }
}
