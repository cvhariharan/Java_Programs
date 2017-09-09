/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variablecounter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 *
 * @author thero
 */
public class VariableCounter {

    /**
     * @param args the command line arguments
     */
    static int variables = 0;
    public static void main(String[] args) throws IOException, java.io.IOException {
        // TODO code application logic here
        VariableCounter vc = new VariableCounter();
        vc.input();
    }

    private void input() throws IOException, java.io.IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        StringBuffer forObjects = new StringBuffer(s);
        s = s.replace("{",";");
        s = s.replace("}",";");
        s = s.replace("(",";");
        s = s.replace(")",";");
        int variablesCount = CountVariables(s);
        System.out.println("Total Variables: "+variablesCount);
        int objectsCount = CountObjects(forObjects);
        System.out.println("Total Objects: "+objectsCount);
  
    }
    private int CountVariables(String s)
    {
        //Can count int, String, char variables declared within a codeblock.
        String lines[] = s.split(";");
        int i = 0;
        int variablesCount = 0;
        System.out.print("Variables: ");
        while(i<lines.length)
        {
            lines[i] = lines[i].trim();
            //String all_words[] = lines[i].split(" ");
            if(!lines[i].contains("int ") /*&& !lines[i].contains("String ")*/ && !lines[i].contains("float ") && !lines[i].contains("double ") && !lines[i].contains("char "))
            {
            } else {
                String variables[] = lines[i].split(",");
                variablesCount+=lines[i].split(",").length;
                
                for(int j=0;j<variables.length;j++)
                {
                    if(variables[j].contains("="))
                        variables[j] = variables[j].split("=")[0].trim();
                    variables[j] = variables[j].replace("new","");
                    //variables[j] = variables[j].replace("String","");
                    variables[j] = variables[j].replace("float","");
                    variables[j] = variables[j].replace("double","");
                    variables[j] = variables[j].replace("int","");
                    variables[j] = variables[j].replace("char","");
                    System.out.print(variables[j]+",");
                }
                
            }
            i++;
        }
        System.out.println();
        return variablesCount;
    }
    
    private int CountObjects(StringBuffer s)
    {
        int objects = 0;
        StringBuffer all_objects = new StringBuffer();
        String k = s.toString();
        k = k.replace("="," ");
        s = new StringBuffer(k);
        while(s.indexOf(" new ")>0)
        {
            k = k.trim().replaceAll(" +", " "); //Replaces more than one space with just a single one.
            String tokens[] = k.split(" ");
            int pos = Arrays.asList(tokens).indexOf("new");
            all_objects.append(tokens[pos-1].concat(","));
            s.replace(s.indexOf(" new "),s.indexOf(" new ")+3," ");
            objects++;
        }
        System.out.println("Objects: "+all_objects);
        return objects;
}
}
