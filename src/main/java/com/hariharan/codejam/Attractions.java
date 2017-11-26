/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariharan.codejam;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
/**
 *
 * @author thero
 */
public class Attractions {
    
    public Attractions(String name,String attractions)
    {
        JFrame f = new JFrame("Attractions in "+name);
        f.setSize(500,200);
        JLabel lbl = new JLabel(name, SwingConstants.CENTER);
        lbl.setSize(50, 60);
        //lbl.setText(name);
        JLabel atr = new JLabel(attractions, SwingConstants.CENTER);
        //atr.setText(attractions);
        /*lbl.setLocation(150, 20);
        atr.setLocation(150,100);*/
        f.add(lbl);
        f.add(atr);
        f.setLayout(new GridLayout(2,1));
        f.setVisible(true);
    }
}
