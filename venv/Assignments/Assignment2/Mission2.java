package tests;

import java.util.Scanner;

/***********************************************
 * Assignment: 
 * Program:   
 * Author:
 * Description:     
 ***********************************************/
public class Mission2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the month you were born: ");
		String month = input.nextLine();
		
		System.out.print("Enter the day you were born: ");
		int day = input.nextInt();
		input.nextLine();
		
		System.out.print("Enter the year you were born: ");
		int year = input.nextInt();
		input.nextLine();
		
		System.out.println("\nYou will retire on " + month + " " + day + ", " + 
		(67 + year) + "");
	}
}
