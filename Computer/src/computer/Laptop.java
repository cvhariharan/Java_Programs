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
public class Laptop extends Computer implements Charger{
    
    private String processor;
    private int ram;
    private String motherboard;
    boolean charging = false;
    
    Laptop(String processor, int ram, String motherboard,String device_name)
    {
        super(processor,ram,motherboard);
        this.processor = processor;
        this.ram = ram;
        this.motherboard = motherboard;
        this.device_name = device_name;
        internal.writeData("Tablet internal");
    }
    
    public void charge()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Is the device charging?Y/N: ");
        String c = in.next().toLowerCase();
        if(c.equals("y"))
            {
                this.charging = true;
                System.out.println("Charging...");
                System.out.println(this.charging);
            }
    }
    /*Laptop()
    {
        super();
        internal.d.data = "Laptop internal";
    }*/
}
