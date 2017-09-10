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
    ArrayList<Items> basket = new ArrayList<Items>();
    ArrayList quantities = new ArrayList();
    Customer()
    {
        all_customers++;
        cust_id += all_customers+10;
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
       bill.generate(basket,quantities);
    }
}
