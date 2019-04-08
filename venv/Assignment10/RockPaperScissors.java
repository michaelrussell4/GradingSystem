import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors
{
  
  //This method will ask user to enter rock, paper, and make sure nothing else is entered, then return the choice as a string.
  public String getUserChoice()
  {    
      Scanner in = new Scanner(System.in);
      String userChooses = " ";
      System.out.print("Rock, Paper, Or Scissors?: ");
      userChooses=in.nextLine();

      //This loop will make sure the user enters either rock, paper, or scissors not case sensitive
      while(!userChooses.equalsIgnoreCase("rock") && !userChooses.equalsIgnoreCase("paper") && !userChooses.equalsIgnoreCase("scissors"))    
      {
         System.out.println("Sorry \"" + userChooses + "\" is not a valid word.");
         System.out.print("Rock, Paper, Or Scissors?: ");
         userChooses=in.nextLine();
      }
      return userChooses;
  }
  
  //This method will randomly choose between rock paper or scissors, and return the choice as a string.
  public String getCPUChoice()
  {  
      Random r = new Random();
      int cpuRandomNumber;
      String cpuChoice =" ";
      
      cpuRandomNumber = r.nextInt(3);        //randomly generates number
      
      if(cpuRandomNumber==0)                 //this will coordinate a number with rock, paper, or scissors
      {
         cpuChoice = "rock";
      }
      else if(cpuRandomNumber==1)
      {
         cpuChoice="paper";
      }
      else
      {
         cpuChoice="scissors";  
      }
      
      return cpuChoice;                     //return choice as a string
   }
   
   //This method will declare the winner or a tie, after two variables are entered
   public String pickWinner(String user, String computer)
   {
        String winnerIs = " ";
         
        if(user.equalsIgnoreCase(computer))                                                   
        {
            winnerIs= "Tie";
        }  
        else if(user.equalsIgnoreCase("rock"))
        {     
           if (computer.equalsIgnoreCase("scissors"))
           {      
              winnerIs = "User";
           }    
           else if(computer.equalsIgnoreCase("paper"))
           {
              winnerIs = "Computer";
           }  
        }     
        else if(user.equalsIgnoreCase("scissors"))
        {   
           if (computer.equalsIgnoreCase("paper"))
           {
               winnerIs = "User";
           }
           else if(computer.equalsIgnoreCase("rock"))
           {
               winnerIs = "Computer";
           }
        }
        else if(user.equalsIgnoreCase("paper"))
        {     
           if (computer.equalsIgnoreCase("rock"))
           {      
               winnerIs = "User";
           }
           else if(computer.equalsIgnoreCase("scissors"))
           {       
               winnerIs = "Computer";
           }
        } 
        
        return winnerIs;     //returns the winner or a tie as a string
   } 
}