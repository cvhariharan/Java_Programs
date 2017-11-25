/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariharan.codejam;

/**
 *
 * @author thero
 */
public class Place {
    
    public String name;
    public String[] next;
    public String fromNode;
    public long id;
    public long dist;
    public String attractions;
    public Place(String name,long id,long dist,String[] next,String attractions)
    {
        this.name = name;
        this.next = next;
        this.id = id;
        this.dist = dist;
        this.attractions = attractions;
    }
    
}
