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
public abstract class Storage {
    
    private Data d = new Data();
    protected abstract void persistentSave();
    protected abstract void capacity();
    public void writeData(String data)
    {
        d.dataSet(data);
    }
    
    public String readData()
    {
        return d.dataGet();
    }
}
