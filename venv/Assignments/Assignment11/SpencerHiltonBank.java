import java.util.*;
public class SpencerHiltonBank
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      String accountName;                                               //User account name 
      String selection = " ";                                           //User selection 1-4
      double userDeposit;                                               //Used for amount to be deposited 
      double userWithdrawl;                                             //Used for amount to be withdrawn
      boolean toProceed = true;                                        
      boolean depositCheck = true;                                      
      boolean withdrawlCheck = true;                                    
      
      //Asks user for name and creates an instance "account"
      System.out.println("Welcome to the Bank of Spencer! \n");
      System.out.print("Please enter your name to create an account: ");
      accountName = in.nextLine();
      
      BankAccount account = new BankAccount(accountName, 35478265);
      
      //Ask user what they would like to do from selection
      do  
         {
         System.out.println("\nPress 1 to make a deposit");
         System.out.println("Press 2 to make a withdrawl");
         System.out.println("Press 3 to get account information");
         System.out.println("Press 4 to quit");
         selection = in.nextLine();
         //Check that user enters a 1, 2 ,3, or 4
         do
         {   
            if (!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4"))
            {
               System.out.print("Invalid choice, please try again\n");
               selection = in.nextLine();
            }
            
         }while(!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4"));
          
         //Used to make deposit to an account and warn user of invalid input 
         if(selection.equals("1"))
         {
            do
            { 
               try
               {
                  System.out.print("Please enter the amount to deposit: ");
                  userDeposit = in.nextDouble();
                  account.deposit(userDeposit);
                  in.nextLine();
                  depositCheck = false;
               }
               catch(InputMismatchException e)
               {
                  System.out.println("Invalid Input.");
                  in.nextLine();
                  depositCheck = true;
               }
            }while(depositCheck);
         }
        
         //Used to withdraw money from account and warn user of invalid input
         else if(selection.equals("2"))
         {
            do
            {
               try
               {
                  System.out.print("Please enter the amount to withdrawl: ");
                  userWithdrawl = in.nextDouble();
                  account.withdraw(userWithdrawl);
                  in.nextLine();
                  withdrawlCheck = false;
               }
               catch(InputMismatchException e)
               {
                  System.out.println("Invalid Input."); 
                  in.nextLine();
                  withdrawlCheck = true;
               }
            }while(withdrawlCheck);     
         }
        
         //Print account information
         else if(selection.equals("3"))
         {
            System.out.print("Name: " + account.getName() + "\nAccount #: " +account.getAccountNum() + "\nBalance: $" + account.getBalance() +"\n");
         }
         
         //Quit the program
         else if(selection.equals("4"))
         {
            System.out.print("Thank you for your business!");
            toProceed = false;
         }
      }while(toProceed);
           
   }
}