import java.util.Scanner;
import java.util.Random;

public class RollSimulator
{
  
  public static void main(String[] args)
  {
  
      Scanner in = new Scanner (System.in);
      Random r = new Random();
      
      int[] storedTotal = new int[13];                     //Used thirteen elements for the array so that I would have elements 0-12 instead of 0-11
      int rolls;                                           //Number of rolls the user wants to throw
      int dice1;                                           
      int dice2;                                           //Will simulate rolling another dice
      int diceTotal = 0;                                   //Will simulate the number rolled with two dice
      int stars = 0;                                       //Percent of each roll (2-12) that occured
      
      System.out.println("Welcome to the dice throwing simulator!");
      System.out.print("How many rolls would you like to simulate? 1000 ");
      System.out.println("DICE ROLLING SIMULATION RESULTS ");
      System.out.println("Each \"*\" represents 1% of the total number of rolls. ");
      rolls = in.nextInt();
      
      
      for( int i=1; i <= rolls; i++)
      {   
         dice1 = r.nextInt(6) + 1;                        //This will simulate the numbered rolled for dice 1
         dice2 = r.nextInt(6) + 1;                        //This will simulate the numbered rolled for dice 2 
         diceTotal = dice1 + dice2;                       //The simulated number rolled with both dice
         storedTotal[diceTotal]++;                        //Array will keep count of each occurrence
      
      }
      
  
      for (int i=2; i<= 12; i++)                         //Loop will check the array in elements 2-12 and uses the counts to make calculations
      {
         stars = 100 * storedTotal[i] / rolls;           //Calculates the percent of each roll         
         System.out.print(i + ": ");
         
            for(int z =1; z<= stars; z++)                //This loop will keep printing stars until variable stars is reached
            {
               System.out.print("*");
            }
            System.out.println();                        //This will just move cursor to the next line
     }
      
     System.out.print("Thank you for using the dice throwing simulator. Goodbye!");
      
  } 
} 