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
        ArrayList<Items> items = Categories.categories.get(cat_id);
        basket.add(items.get(choice-1));
        System.out.println("Quantities: ");
        int quantity = sc.nextInt();
        quantities.add(quantity);
    }
    public void showBasket()
    {
        for(Items each_item: basket)
            System.out.println(each_item.name);     
    }
    public void checkout()
    {
       
    }
}
