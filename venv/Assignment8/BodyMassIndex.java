import java.util.*;

public class BodyMassIndex
{
  
  public static void main(String[] args)
  {
  
      Scanner in = new Scanner (System.in);
      double height = 0;                                                         //height entered by user must be greater than 0 
      double weight = 0;                                                         //weight entered by user must be greater than 0
      double bmi = 0;                                                            
      boolean heightError;                                               //variable used to end do loop
      boolean weightError;                                               //variable used to end do loop
      
      System.out.print("Enter the height in inches: ");

      do
      {    
         try
         {
           heightError = false;                                                  //heightError is set to false so that the do loop can end, but can become true if the catch starts
           height =in.nextDouble();
           
           do                                                                    //This loop will make sure the user enters a positive number greater then zero.
           {
               if(height <= 0)
               {
                  in.nextLine();
                  System.out.println("Invalid inches value. Must be a decimal number.");
                  System.out.print("Re-enter height in inches: ");
                  height = in.nextDouble();
               }
           }while(height<=0);
         }
        
         catch (InputMismatchException e)                                        // will start if anything other then a number is entered.
         {
            in.nextLine();
            System.out.println("Invalid inches value. Must be a positive.");
            System.out.print("Re-enter height in inches: ");
            heightError = true;                                                  //heightError will change from false to true forcing the loop to be run again.
         }
      }while(heightError);
       
      System.out.print("Enter the weight in pounds: ");

      do
      {    
         try
         {
            weightError = false;                                                 //weightError is set to false so that the do loop can end, but can become true if the catch starts
            weight = in.nextDouble();
            
            do                                                                    //This loop will make sure the user enters a positive number greater then zero.
            {
                 if(weight<=0)
                 {
                    in.nextLine();
                    System.out.println("Invalid pounds value. Must be a decimal number.");
                    System.out.print("Re-enter weight in pounds: ");
                    weight = in.nextDouble();
                 }
                 
            }while(weight <= 0);
         }
         
         catch (InputMismatchException e)                                        // will start if anything other then a number is entered.
         {
            in.nextLine();
            System.out.println("Invalid pounds value. Must be positive.");
            System.out.print("Re-enter weight in pounds: ");
            weightError = true;                                                  //weightError will change from false to true forcing the loop to be run again.
         }
       }while(weightError);
       
       bmi = 704*weight/(height*height);
       
       System.out.println("Height = " + height + "\"");
       System.out.println("Weight = " + weight + " pounds");
       System.out.println("Body mass index = " + bmi);
       
      
  }
} 