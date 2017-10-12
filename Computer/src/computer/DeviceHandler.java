/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;
import java.util.Scanner;
/**
 *
 * @author thero
 */
public class DeviceHandler {

    public static void main(String[] args)
    {
        String processor = "";
        int ram = 0;
        String motherboard = "";
        String device_name = "";
        String data;
        int device_type;
        Scanner in = new Scanner(System.in);
        System.out.println("Name: ");
        String name = in.next();
        User user = new User(name);
        int choice = 0;
        do
        {
        System.out.println("1.Add Device\n2.Access Device\n0.Exit");
        choice = in.nextInt();
        if(choice == 1)
        {
            System.out.println("Name of the processor: ");
            processor = in.next();
            System.out.println("Size of RAM: ");
            ram = in.nextInt();
            System.out.println("Name of the motherboard: ");
            motherboard = in.next();
            System.out.println("Device name: ");
            device_name = in.next();
        switch(choice)
        {
            
            case 1: 
                System.out.println("1.Laptop\n2.Tablet\n3.Mobile\n4.Desktop");
                device_type= in.nextInt();
                switch(device_type)
                {
                    case 1: 
                        Laptop laptop = new Laptop(processor,ram,motherboard,device_name);
                        laptop.device_type = --device_type;
                        laptop.category = "Laptop";
                        laptop.charge();
                        user.addDevice(laptop);
                        break;
                        
                    case 2: 
                        Tablet tablet = new Tablet(processor,ram,motherboard,device_name);
                        tablet.device_type = --device_type;
                        tablet.category = "Tablet";
                        tablet.charge();
                        user.addDevice(tablet);
                        break;
                     
                    case 3: 
                        Mobile mobile = new Mobile(processor,ram,motherboard,device_name);
                        mobile.device_type = --device_type;
                        mobile.category = "Mobile";
                        mobile.charge();
                        user.addDevice(mobile);
                        break;
                        
                    case 4:
                        Desktop desktop = new Desktop(processor,ram,motherboard,device_name);
                        desktop.device_type = --device_type;
                        desktop.category = "Desktop";
                        user.addDevice(desktop);
                        break;
                    default:
                        System.out.println("Invalid Input!");
                }
                break;
                
            case 2:
                user.listDevices();
                System.out.println("Enter the index of the device to be accessed: ");
                int index = in.nextInt();
                if(index >=0 && index <=3)
                {
                    Computer device = user.devices.get(index);
                    switch(device.device_type)
                    {
                    case 0:
                        device = (Laptop)device;
                        break;

                    case 1:
                        device = (Tablet)device;
                        break;

                    case 2:
                        device = (Mobile)device;
                        break;
                        
                    case 3:
                        device = (Desktop)device;
                        break;

                    default: System.out.println("Unknown Device!");
                    }
                    System.out.println("1.Write Data\n2.Read Data");
                    int action = in.nextInt();
                    if(action == 1)
                        device.writeData();
                    else if(action == 2)
                        device.readData();
                    else
                        System.out.println("Invalid selection!");
                }
        }
        }
        }while(choice != 0);
    }
    
}
