package bill;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thero
 */
public class Categories {
    static String[] cate_names = {"Grains","Pulses","Snacks","Toiletries"}; //Maybe I will later convert the arrays into ArrayList
    static double[] gst_rates = {12,15,10,6};
    public static ArrayList<ArrayList<Items>> categories = new ArrayList<ArrayList<Items>>(4); 
    static int flag = 0;
    Categories()
    {
        if(flag==0) //Only do it once
        {
        /*Items default_item = new Items("Null","Null",0);
        ArrayList<Items> de_arr = new ArrayList<Items>();
        de_arr.add(default_item);
        categories.add(0,de_arr);
        categories.add(1,de_arr);
        categories.add(2,de_arr);
        categories.add(3,de_arr);*/
        int i = 0;
        while(i<4)
        {
            categories.add(new ArrayList<Items>());
            i++;
        }
        flag=1;
        }
    }
    public boolean add(Items item,int cat_id)
    {
       categories.get(cat_id).add(item);
        /*for(Items each_item: temp)
            System.out.println(each_item.name);*/
        
        //categories.add(cat_id,temp);
        return true;
    }
    public static void printAllCategories()
    {
        int i=1;
        for(String cate: cate_names)
        {
            System.out.println(i+"."+cate);
            i++;
        }
    }
   /* public static void printCatelogue()
    {
        int i=1;
        for(ArrayList<Items> items: categories)
        {
            System.out.println(i+"."+cate);
            i++;
        }
    }*/
}
