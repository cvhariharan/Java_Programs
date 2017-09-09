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
   String[] cate_names = {"Grains","Pulses","Snacks","Toiletries"};
   public String name; //Name of the item
   public double cost; //This is the cost per unit
   public String category;
   public int category_id;
   int itemid;
   static int total_items = 0;
   Items(String name,int cat_id,double cost)
   {
       this.name = name;
       this.cost = cost;
       this.category_id = cat_id;
       this.category = cate_names[cat_id];
       total_items++;
       itemid += total_items+10;
   }
   
}
