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
    static ArrayList<ArrayList<Items>> categories = new ArrayList<ArrayList<Items>>();
    public boolean add(Items item,int cat_id)
    {
        ArrayList<Items> temp = categories.get(cat_id);
        temp.add(item);
        categories.add(cat_id,temp);
        return true;
    }
    public void printAllCategories()
    {
        int i=0;
        for(String cate: cate_names)
        {
            System.out.println(i+"."+cate);
        }
    }
}
