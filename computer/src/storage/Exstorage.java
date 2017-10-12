/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;
import computer.*;
/**
 *
 * @author thero
 */
public class Exstorage {
    
   public boolean connected = false;
   Computer connectedTo;
   public boolean connect(Computer device)
   {
       if(!connected)
       {
           connected = true;
           connectedTo = device;
       }
       else
           System.out.println("Already connected to: "+device.device_name);
       return connected;
   }
   public boolean disconnect()
   {
       if(connected)
           connected = false;
       else
           System.out.println("Not connected to anything to be disconnected.");
       return connected;
   }
}
