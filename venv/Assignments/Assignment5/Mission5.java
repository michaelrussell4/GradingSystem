import java.util.Random;
import java.util.Scanner;

/***********************************************
 * Assignment: 
 * Program: 
 * Author: 
 * Description:
 ***********************************************/
public class Mission5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("Welcome to Rock, Paper, Scissors!");
		System.out.print("Please enter the number of rounds you would like to play: ");
		int numGames = input.nextInt();
		input.nextLine();
		
		while(numGames % 2 == 0){	
			System.out.print("Sorry, you need to enter an odd number. Please try again: ");
			numGames = input.nextInt();
			input.nextLine();
		}
		
		String userChoice, compChoice = "";
		String[] options = {"Rock", "Paper", "Scissors"};
		int userWins = 0, computerWins = 0;

		for(int i = 0; i < numGames; i++){
			System.out.print("Rock, Paper, or Scissors?: ");
			userChoice = input.nextLine();
			
			if(userChoice.equalsIgnoreCase("rock") || userChoice.equalsIgnoreCase("paper") ||
					userChoice.equalsIgnoreCase("scissors")){
				compChoice = options[rand.nextInt(3)];
				
				if(compChoice.equalsIgnoreCase(userChoice)){
					System.out.println("Computer chooses " + compChoice + ". It's a tie.");
					i--;
				}else if(compChoice.equalsIgnoreCase("Rock") && 
						userChoice.equalsIgnoreCase("Paper")){
					System.out.println("Computer chooses " + compChoice + ". You win!");
					userWins++;
				}else if(compChoice.equalsIgnoreCase("Paper") && 
						userChoice.equalsIgnoreCase("Scissors")){
					System.out.println("Computer chooses " + compChoice + ". You win!");
					userWins++;
				}else if(compChoice.equalsIgnoreCase("Scissors") && 
						userChoice.equalsIgnoreCase("Rock")){
					System.out.println("Computer chooses " + compChoice + ". You win!");
					userWins++;
				}else{
					System.out.println("Computer chooses " + compChoice + ". You lose.");
					computerWins++;
				}
			}else{
				System.out.println("Sorry, \""+ userChoice + "\" is not a valid entry.");
				i--;
			}
		}
		System.out.println("\nUser wins: " + userWins);
		System.out.println("Computer wins: " + computerWins + "\n");
		
		if(userWins > computerWins){
			System.out.println("User wins the game!");
		}else{
			System.out.println("Computer wins the game!");
		}
	}
}