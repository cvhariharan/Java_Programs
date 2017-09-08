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
    static int custId = 100;
    Customer()
    {
        custId++;
    }
    ArrayList basket = new ArrayList();
    ArrayList quantities = new ArrayList();
    public ArrayList hasPurchased()
    {
        
        return basket;
    }
    
    public void addToBasket(String item, int quantity)
    {
        basket.add(item);
        quantities.add(quantity);
    }
    
    public void checkout()
    {
        Bill bill = new Bill(basket,quantities);
    }
}
