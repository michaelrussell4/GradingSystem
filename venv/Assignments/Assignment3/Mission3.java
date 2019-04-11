package tests;

import java.util.Random;
import java.util.Scanner;

/***********************************************
 * Assignment: 
 * Program: 
 * Author: 
 * Description:
 ***********************************************/
public class Mission3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Higher / Lower game! " + "Try to guess the number between 1 and 100.\n");
		int guess;
		int counter = 1;
		Random rand = new Random();
		int answer = rand.nextInt(100) + 1;
		System.out.print("Enter your guess: ");
		guess = input.nextInt();
		while (guess != answer) {
			if (guess > 100 || guess < 1) {
				System.out.print("Sorry, the guess needs to be a number between 1 and 100. "
						+ "Please try again: ");
			}else if(guess < answer){
				System.out.print("The number is higher.\nEnter your guess: ");
			}else if(guess > answer){
				System.out.print("The number is lower.\nEnter your guess: ");
			}
			guess = input.nextInt();
			counter++;
		}
		
		System.out.println("\nThe number was " + answer + "! You guessed correctly! It took you " + counter + " tries.");

	}
}