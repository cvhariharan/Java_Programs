
package atm;

import java.util.Scanner;

/**
 *
 * @author Hariharan
 */
public class ATM 
{
    int n1Val = 2000; //Values of notes
    int n2Val = 500;
    int n3Val = 100;
    int n1Ton2 = n1Val/n2Val; //Conversion rate
    int n1Ton3 = n1Val/n3Val;
    int n2Ton3 = n2Val/n3Val;
    int n1Total; //Total value for each note
    int n2Total;
    int n3Total;
    int Total;
    int notes[] = {2000,500,100};
    int unotes[];
    static int[] noteCount = new int[3]; //Array to hold number of notes. 0 for note1 and so on.
    int[] usedNoteCount = new int[3];
    int[] oldNotes = new int[3];
    double n1Re,n2Re,n3Re; //Each remaining note as a number between 0 and 1 with original number of notes
    public static void main(String[] args) 
    {
        Scanner read = new Scanner(System.in);
        ATM atm = new ATM();
        atm.Initialize(30,100,100); //Initialize the atm object with number of notes
        System.out.println("Enter the amount to be dispensed (Use atm.Initialize to enter the number of notes(Default 30x2000,100x500,100x100).): ");
        int money = read.nextInt();
        //atm.combos(money,0);
        atm.Dispense(money);
        
    }
    private void Initialize(int count1, int count2, int count3)
    {
        noteCount[0] = count1;
        noteCount[1] = count2;
        noteCount[2] = count3;
        oldNotes = noteCount;
        n1Total = noteCount[0]*n1Val;
        n2Total = noteCount[1]*n2Val;
        n3Total = noteCount[2]*n3Val;
        Total = n1Total+n2Total+n3Total;
    }
    private void Dispense(int money)
    {
        /*First check how many of each note remains on using it to pay the money*/
       if(money > Total || (money % 100) != 0) //Check if the last 2 digits are zero.
       {
           System.out.println("Sorry we don't have enough notes to meet your request!");
           System.exit(0);
       }
       if(money == 0)
       {
           System.out.println("Exiting.");
           System.exit(0);
       }
        System.out.println();
        n1Total = noteCount[0]*n1Val;
        n2Total = noteCount[1]*n2Val;
        n3Total = noteCount[2]*n3Val;
        n1Re = ((double)(noteCount[0] - (int)(money/n1Val))/(double)noteCount[0])*(n1Total); //Here n1Total is priority. This can be adjusted to get different combinations.
        n2Re = ((double)(noteCount[1] - (int)(money/n2Val))/(double)noteCount[1])*(n2Total);
        n3Re = ((double)(noteCount[2] - (int)(money/n3Val))/(double)noteCount[2])*(n3Total);
        if(n1Re == (n1Total))
            n1Re = 0;
        if(n2Re == (n2Total))
            n2Re = 0;
        if(n3Re == (n3Total))
            n3Re = 0;
        if(n1Re > n2Re && n1Re > n3Re)
        {
            Divide(n1Val,money,0);
        }
        else if(n2Re > n1Re && n2Re > n3Re)
        {
            Divide(n2Val,money,1);
        }
        else
        {
            Divide(n3Val,money,2);
        }
        
    }
    private void Divide(int note,int money,int noteIndex)
    {
        int i=0;
        while((money)>=note && noteCount[noteIndex] > 0)
        {
            money -= note; //Note has the value of the currency note used
            noteCount[noteIndex] -= 1;
            usedNoteCount[noteIndex] += 1;
            //System.out.println("Money: "+money+" Note: "+note+" NoteCount: "+noteCount[noteIndex]);
            System.out.print("Note: "+note+",");
            i++;
            if(i==2)
            {
                break;
            }
        }
        
        Dispense(money);
       
    }
    /*To print all combinations*/
    /*private void combos(int money,int i)
    {
        if(money == 0)
        {
            int k = 0;
            while(k<i)
                System.out.print(unotes[i]+",");
        }
        else if (money > 0)
        {
            int m=0;
            while(m<3)
            {
                unotes[i] = notes[m];
                combos(money-notes[m],++i);
                m++;
            }
        }
    }*/
}
