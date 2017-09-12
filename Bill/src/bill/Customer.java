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
    static ArrayList<Customer> customers_list = new ArrayList<Customer>();
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
        basket.add(items.get(choice));
        System.out.println("Quantities: ");
        int quantity = sc.nextInt();
        quantities.add(quantity);
    }
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
            System.out.println(item.name+" "+"Rate: Rs."+item.cost+" X "+quantity+" "+"+"+" cgst: Rs."+cgst+" +"+" sgst: Rs."+sgst+" = "+temp_bill_gst);
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
        for(Customer customer: customers_list)
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
        for(Bill bill: my_bills)
        {
            for(String each_statement : bill.statements)
            {
            System.out.println(each_statement);
            
            }
            System.out.print("Total: "+bill.total_bill);
            System.out.println();
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
