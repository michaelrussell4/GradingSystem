import java.util.Scanner;
import java.util.Random;

public class Roulette
{

   double bet = 0.0; //Bet that will returned 
   
   public double betOnce (Scanner console, double userBet)
   {     
         this.bet = userBet;
         Random r = new Random();
         
         int number = 0;   
         int userChoice = 0;
         number = r.nextInt(37); //Random number used to simulate rolling the ball on the table
         
         //Prompt user for what they would like to choose
         
         System.out.print("Do you want to bet on 1) low or 2) high or 3) a Number?");
         userChoice = console.nextInt();
        
        
         
         //If user bets low
        if (userChoice == 1)
        {
            if (number<=18)
            {
               System.out.println("The number was " + number + " You win!");
               bet = bet*2.0;
            }   
            else if (number>=19)
            {
               System.out.println("The number was " + number + " You lose!");
               bet = 0;
            }
                         
        }
        
        //If user bets high 
        else if (userChoice ==2)
        {
            if (number<=18 || number == 0)
            {
               System.out.println("The number was " +number + " You lose!");
               bet = 0;
            }
            else if(number>=19)
            {
               System.out.println("The number was " + number + " You win!");
               bet = bet*2.0;
            }
           
         }
         
         //If user gets brave and decides to guess a number
         else if (userChoice ==3)
         {
            System.out.print("Pick a number between 1 & 36: ");
            int luckyNumber = console.nextInt();
               
            if (luckyNumber == number)
            {
               System.out.println("The was " + number + ". You win big money!");
               bet = bet*34;
            }
            else if( luckyNumber != number || number == 0)
            {
               System.out.println("The number was " + number + ". You lose!");
               bet = 0;
            }   
           
          }
        return bet;  
    }
    
} 