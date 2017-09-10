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
    public static ArrayList<String> cate_names = new ArrayList<String>();
    
    //static String[] cate_names = {"Grains","Pulses","Snacks","Toiletries"}; //Maybe I will later convert the arrays into ArrayList
    //static double[] gst_rates = {12,15,10,6};
    public static ArrayList gst_rates = new ArrayList();
    public static ArrayList<ArrayList<Items>> categories = new ArrayList<ArrayList<Items>>(cate_names.size()); 
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
        cate_names.add("Grains");
        cate_names.add("Pulses");
        cate_names.add("Snacks");
        cate_names.add("Toiletries");
        gst_rates.add(12.0);
        gst_rates.add(14.0);
        gst_rates.add(6.0);
        gst_rates.add(8.0);
        int i = 0;
        initializeArrayList();
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
    
    public void adjustGST()
    {
        int in=1;
        Scanner sc = new Scanner(System.in);
        do
        {
            printAllCategories();
            System.out.println("Input Category Id to change its GST rate (Enter 0 to exit): ");
            in = sc.nextInt();
            if(in!=0)
            {
                in--;
                if(in>=0 && in < gst_rates.size())
                {
                    System.out.println("Old GST Rate: "+(double)gst_rates.get(in)+" Enter new GST Rate: ");
                    double new_gst = sc.nextDouble();
                    gst_rates.set(in, new_gst);
                }
            }
        }while(in != 0);
    }
    
    public static void addNewCategory()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the new Category: ");
        String name = in.next();
        System.out.println("Enter the GST rate for the Category: ");
        double gst = in.nextDouble();
        gst_rates.add(gst);
        cate_names.add(name);
        Categories cate = new Categories();
        cate.initializeArrayList();
    }
    
    public void initializeArrayList()
    {
        int i = 0;
        while(i<cate_names.size())
        {
            categories.add(new ArrayList<Items>());
            i++;
        }
    }
}
