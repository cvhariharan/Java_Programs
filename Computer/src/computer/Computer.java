/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;
import storage.*;
import java.util.*;
/**
 *
 * @author thero
 */
public class Computer {

    /**
     * @param args the command line arguments
     */
    private String processor;
    private int ram;
    private String motherboard;
    public String device_name;
    public int device_type; // 0-laptop,1-tablet,2-mobile,3-desktop
    public String category;
    Internal internal = new Internal();
    External external = new External();
    Removable removable = new Removable();
    Computer(String processor, int ram, String motherboard)
    {
        this.processor = processor;
        this.ram = ram;
        this.motherboard = motherboard;
        internal.writeData("Tablet internal");
    }
    Computer()
    {
        internal.writeData("Tablet internal");
    }
    
    public void printConfig()
    {
        System.out.println("Device Type: "+this.category);
        System.out.println("Processor: "+this.processor);
        System.out.println("RAM: "+this.ram);
        System.out.println("Motherboard: "+this.motherboard);
    }
    
    public void readData()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Internal\n2.External\n3.Removable");
        int choice = in.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Internal data: "+internal.readData());
                break;
            case 2:
                System.out.println("External data: "+external.readData());
                break;
            case 3:
                System.out.println("Removable data: "+removable.readData());
                break;
        }
        System.out.println(internal.readData());
    }
    
    public void writeData()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Internal\n2.External\n3.Removable");
        int choice = in.nextInt();
        System.out.println("Input data: ");
        String data = in.next();
        data = data + in.nextLine();
        switch(choice)
        {
            case 1:
                internal.writeData(data);
                System.out.println("Written to internal data.");
                break;
            case 2:
                external.writeData(data);
                System.out.println("Written to external data");
                break;
            case 3:
                removable.writeData(data);
                System.out.println("Written to removable data");
                break;
        }
        System.out.println("Successfully written.");
    }
    
}
