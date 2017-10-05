/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;

/**
 *
 * @author thero
 */
public class Desktop extends Computer{
    private String processor;
    private int ram;
    private String motherboard;
    
    Desktop(String processor, int ram, String motherboard,String device_name)
    {
        super(processor,ram,motherboard);
        this.processor = processor;
        this.ram = ram;
        this.motherboard = motherboard;
        this.device_name = device_name;
        internal.d.data = "Desktop internal";
    }
    
}
