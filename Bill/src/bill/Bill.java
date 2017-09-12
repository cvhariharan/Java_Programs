/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;
import java.util.*;
import java.math.*;
/**
 *
 * @author thero
 */
public class Bill {

    /**
     * @param basket
     * @param quantities
     * @param args the command line arguments
     */
    double total_bill=0;
    ArrayList<String> statements = new ArrayList<String>();
    public void Bill(ArrayList<Items> basket, ArrayList quantities)
    {
        
    }
    
    public Bill generate(ArrayList<Items> basket, ArrayList quantities,Customer customer)
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
            total_bill += temp_bill_gst;
            System.out.println(item.name+" "+"Rate: Rs."+item.cost+" X "+quantity+" "+"+"+" cgst: Rs."+cgst+" +"+" sgst: Rs."+sgst+" = "+temp_bill_gst);
            statements.add(item.name+" "+"Rate: Rs."+item.cost+" X "+quantity+" "+"+"+" cgst: Rs."+cgst+" +"+" sgst: Rs."+sgst+" = "+temp_bill_gst);
        }
        total_bill = Math.ceil(total_bill);
        System.out.println("Total Bill: "+total_bill);
        customer.total = total_bill;
        return this;
    }
    
}
