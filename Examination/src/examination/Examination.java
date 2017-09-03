/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examination;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 *
 * @author thero
 */
public class Examination {

    /**
     * @param args the command line arguments
     */
    ArrayList Questions = new ArrayList();
    ArrayList Choices = new ArrayList();
    ArrayList Answer = new ArrayList();
    ArrayList Subchoices = new ArrayList();
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Examination user = new Examination();
        while(true)
        {
        System.out.println("1. Teacher 2. Student. Choose 1 or 2: ");
        int choice = sc.nextInt();
        int auth = 0;
        boolean teacher;
        switch(choice)
        {
            case 1: teacher = true;
            System.out.println("Username: ");
            String username = sc.next();
            System.out.println("Password: ");
            String password = sc.next();
            auth = user.Authenticate(username,password);
            break;
            
            case 2: teacher = false;
            auth = 2;
            break;
            
            default: System.out.println("Invalid Selection!");
        }
        if(auth == 1)
        {
            user.takeQuestions();
        }
        else if(auth == 0)
        {
            System.out.println("Authentication Failed. Try again!");
            System.exit(0);
        }
        else if (auth==2)
        {
            int score = user.giveTest();
            System.out.println("Your Score is: "+score);
        }
        }
    }
        
        public int Authenticate(String username, String password)
        {
            String saved_username = "Teacher12";
            String saved_password = "SomePassword";
            if (saved_username.equals(username) && saved_password.equals(password))
                return 1;
            else
                return 0;
        }
        
        private void takeQuestions() throws IOException
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int i = 0;
            do
            {
            System.out.println("Press 1 to add a question, 2 to delete and 0 to exit: ");
            String input = in.readLine();
            i = Integer.parseInt(input);
            if(i==2)
            {
                System.out.println("Enter the index of the question to be removed (Indexing starts from 0): ");
                int index = Integer.parseInt(in.readLine());
                Questions.remove(index);
                Choices.remove(index);
                Answer.remove(index);
                Subchoices.remove(index);
                
            }
            if (i!=0)
            {
                System.out.println("Enter the Question: ");
                String question = in.readLine();
                Questions.add(question);
                
                StringBuffer subchoice = new StringBuffer();
                int j = 0;
                do
                {
                    System.out.println("Press 1 to add choice and 0 to exit: ");
                    input = in.readLine();
                    j = Integer.parseInt(input);
                    
                    if(j!=0)
                    {
                        System.out.println("Choice: ");
                        subchoice.append(in.readLine().concat(";;"));
                        Subchoices.add(subchoice);
                    }
                }while(j == 1);
                Choices.add(subchoice);
                Subchoices.clear();
                System.out.println("Correct Answer index (Index starts from 1): ");
                int answer = Integer.parseInt(in.readLine());
                //ArrayList temp =(ArrayList)Choices.get(i);
                Answer.add(answer);
            }
            }while(i == 1);
            /*for(i =0; i<Questions.size();i++)
            {
                System.out.println(Questions.get(i));
                System.out.println(Choices.get(i));
                System.out.println(Answer.get(i));
            }*/
        }
        
        private int giveTest()
        {
            ArrayList rnd_nos = new ArrayList();
            Scanner sc = new Scanner(System.in);
            int questions = sc.nextInt();
            int i = 0;
            Random rnd = new Random();
            int score=0;
            while (i<questions)
            {
                int j = rnd.nextInt(Questions.size());
                if(!rnd_nos.contains(j))
                {
                    rnd_nos.add(j);
                
                    System.out.println(Questions.get(j));
                    String choices[] = Choices.get(j).toString().split(";;");
                    System.out.println(Arrays.toString(choices));
                    //System.out.println(Choices.get(j));
                    int correctAnswer = (int)Answer.get(j);
                    System.out.println("Enter the correct answer: ");
                    int userAnswer = sc.nextInt();
                    if(userAnswer == correctAnswer)
                        score++;
                    i++;
                }
            }
            return score;
        }
    }
    


