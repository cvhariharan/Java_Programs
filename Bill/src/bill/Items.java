package bill;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thero
 */
public class Items {
   public String name; //Name of the item
   public double cost; //This is the cost per unit
   public String category;
   int itemid;
   static int total_items = 0;
   Items(String name,String category,double cost)
   {
       this.name = name;
       this.cost = cost;
       this.category = category;
       total_items++;
       itemid += total_items+10;
   }
   
}
