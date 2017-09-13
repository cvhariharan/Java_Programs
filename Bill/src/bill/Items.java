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
   public int category_id;
   int itemid;
   public int count = 50; //Defualt count is 50 for all items
   static int total_items = 0;
   Items(String name,int cat_id,double cost,int count)
   {
       this.name = name;
       this.cost = cost;
       this.category_id = cat_id;
       this.category = Categories.cate_names.get(cat_id);
       if(count > 0)
        this.count = count;
       total_items++;
       itemid += total_items+10;
   }
   public static void printDetails(Items item)
   {
       System.out.println("Item name: "+item.name);
       System.out.println("Item cost: "+item.cost);
       System.out.println("Category: "+item.category);
       System.out.println("In stock: "+item.count);
   }
}
