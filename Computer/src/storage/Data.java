/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

/**
 *
 * @author thero
 */
public class Data {
    
    private String data = "Some data";
    
    Data(String d)
    {
        this.data = d;
    }
    Data()
    {
        
    }
    public void dataSet(String d)
    {
        data = d;
    
    }
    public String dataGet()
    {
        return data;
    }
}
