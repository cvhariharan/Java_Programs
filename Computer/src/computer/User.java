/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;
import java.util.*;
/**
 *
 * @author thero
 */
public class User {
    ArrayList<Computer> devices = new ArrayList<Computer>();
    int id;
    static int all_id;
    String name;
    
    User(String name)
    {
        this.name = name;
        id = all_id+10;
        all_id+=5;
    }
    
    public void addDevice(Computer device)
    {
        devices.add(device);
    }
    
    public void listDevices()
    {
        int i=0;
        for(Computer device: devices)
        {
            System.out.println("Index: "+i);
            switch(device.device_type)
            {
                case 0:
                    Laptop laptop = (Laptop)device;
                    System.out.println(laptop.device_name);
                    laptop.printConfig();
                    break;
                    
                case 1:
                    Tablet tablet = (Tablet)device;
                    System.out.println(tablet.device_name);
                    tablet.printConfig();
                    break;
                    
                case 2:
                    Mobile mobile = (Mobile)device;
                    System.out.println(mobile.device_name);
                    mobile.printConfig();
                    break;
                    
                case 3:
                    Desktop desktop = (Desktop)device;
                    System.out.println(desktop.device_name);
                    desktop.printConfig();
                    break;
                    
                default: System.out.println("Unknown Device!");
            }
            i++;
        }
    }
    
   
}
