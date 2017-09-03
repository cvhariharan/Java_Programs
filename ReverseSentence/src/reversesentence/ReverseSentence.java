/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thero
 */
package reversesentence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ReverseSentence {
    
    public static void main(String[] args) throws IOException
    {
        ReverseSentence rs = new ReverseSentence();
        rs.getInput();
    }
    private void getInput() throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer s = new StringBuffer(in.readLine());
        reverse(s);
        
        
        
    }
    private void reverse(StringBuffer s)
    {
        //Using reverse method from StringBuffer
        s.reverse();
        String k = s.toString();
        String tokens[] = k.split(" ");
        for(int i=0;i<tokens.length;i++)
        {
            StringBuffer temp = new StringBuffer(tokens[i]);
            System.out.print(temp.reverse()+" ");
        }
        //Normal method
        /*String[] words = s.split(" ");
        int i = words.length-1;
        while(i>=0)
        {
            System.out.print(words[i]+" ");
            i--;
        }*/
    }
   
}
