/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariharan.codejam;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author thero
 */
public class Map {
    
    private ArrayList<Place> allPlaces;
    public static HashMap<String, Place> placeObjs;
    JFrame f;
    static JButton[] nodes;
    public int sourceId = 0;
    public int destId = 4;
    public String source;
    public String destination;
    Map()
    {
        
        try
        {
            allPlaces = new ArrayList<Place>();
            placeObjs = new HashMap<String, Place>();
            JSONParser parser = new JSONParser();
            //String jsonContent = FileUtils.readFileToString(new File("users.json"), "UTF-8");
            FileReader in = new FileReader("places.json");
            JSONObject json = (JSONObject)parser.parse(in);
            JSONArray places = (JSONArray)json.get("Places");
            for(Object e: places)
            {
                JSONObject temp = (JSONObject)e;
                String name = (String)temp.get("name");
                long id = (long)temp.get("id");
                String type = (String)temp.get("type");
                if(type.equals("s"))
                    source = name;
                else if(type.equals("d"))
                    destination = name;
                long dist = (long)temp.get("dist");
                String nextPlace = (String)temp.get("next");
                String attractions = (String)temp.get("attractions");
                String next[] = null;
                if(nextPlace.contains(","))
                {
                    next = nextPlace.split(",");
                }
                else
                {
                    next = new String[1];
                    next[0] = nextPlace;
                }
                Place place = new Place(name,id,dist,next,attractions);
                allPlaces.add(place);
                placeObjs.put(place.name,place);
                System.out.println(name+" "+id+" "+dist+" "+nextPlace);
            }
            in.close();
        
        }
        catch(ParseException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
            System.out.println("Source: "+source+" Destionation: "+destination);
            f=new JFrame("Map");  
        /*JButton b=new JButton("Click Here");  
        b.setBounds(50,100,95,30);  */
        //f.add(b);  
            nodes = new JButton[allPlaces.size()];
            drawButtons();
            f.setSize(1000,600);  
            f.setLayout(null);  
            f.setVisible(true); 
        
    }
    
    public void drawButtons()
    {
        Random rand = new Random();
        buttonAction ba = new buttonAction(this,this.destination);
        int i = 0;
        JButton addNode = new JButton("Add Node");
        addNode.setActionCommand("Node");
        addNode.setBounds(10,10,90,40);
        addNode.addActionListener(ba);
        f.add(addNode);
        for(Place place: allPlaces)
        {
            
            int posY = rand.nextInt(500)+10;
            int id = (int)place.id;
            nodes[id] = new JButton(place.name);
            int posX = (int)(150+i*120);
            nodes[id].setLocation(posX,posY);
            nodes[id].setSize(90,50);
            nodes[id].setActionCommand(place.name);
            if(!(place.name).equals(source))
                nodes[id].setEnabled(false);
            nodes[id].addActionListener(ba);
            f.add(nodes[id]);
            i++;
        }
    }
    
    public JFrame getFrame()
    {
        return f;
    }
    public static void main(String[] args)
    {
        Map g = new Map();
        
    }
}

class buttonAction implements ActionListener
{
    Map main;
    String dest;
    public buttonAction(Map t,String dest)
    {
        this.main = t;
        this.dest = dest;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        String name = e.getActionCommand();
        if(name.equals("Node"))
        {
            
            System.out.println("New node");
            //main.getFrame().setVisible(false);
            
            AddNode node = new AddNode();
            node.setMain(this.main);
            node.setVisible(true);
            
            
        }
        else
        {
            Place place = Map.placeObjs.get(name);
            if((place.name.trim()).equals(this.dest.trim()))
            {
                Attractions d = new Attractions("Destination Reached: "+place.name,place.attractions);
            }
            else
            {
            Attractions atr = new Attractions(place.name,place.attractions);
            int places = Map.placeObjs.size()-1;
            String[] next = place.next;
            if(next.length > 0)
            {
                for(String s: next)
                {
                    Place p = Map.placeObjs.get(s);
                    int id = (int)p.id;
                    Map.nodes[id].setEnabled(true);
                    //System.out.println(p.attractions);
                    
                    if(p.name.equals("Agra"))
                        System.out.println("Destination reached!");
                }
            }
        }
        }
        
    }
    
}