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
    ArrayList basket = new ArrayList();
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
        ArrayList<Items> items = Categories.categories.get(cat_id);
        basket.add(items.get(choice));
        System.out.println("Quantities: ");
        int quantity = sc.nextInt();
        quantities.add(quantity);
    }
    public void showBasket()
    {
        String all_items = basket.toString();
        String quan = quantities.toString();
        System.out.println(all_items+"\n"+quan);
    }
    public void checkout()
    {
       
    }
}
