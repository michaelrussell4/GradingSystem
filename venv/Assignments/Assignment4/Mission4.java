package tests;

import java.util.Scanner;

/***********************************************
 * Assignment: 
 * Program: 
 * Author: 
 * Description:
 ***********************************************/
public class Mission4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the Pig Latin Translator!\n");
		System.out.print("Please enter a word: ");
		String word = input.nextLine();
		String temp = "", testWord = "" , translated= "";
		boolean found = false, done = false;
		do {
			temp = word.toLowerCase();
			if (temp.charAt(0) == 'a' || temp.charAt(0) == 'e' || temp.charAt(0) == 'i' || temp.charAt(0) == 'o'
					|| temp.charAt(0) == 'u') {
				translated = word + "way";
			} else {
				for (int i = 0; i < word.length(); i++) {
					
					if (!done && (temp.charAt(i) == 'a' || temp.charAt(i) == 'e' || temp.charAt(i) == 'i'
								|| temp.charAt(i) == 'o' || temp.charAt(i) == 'u')) {					
						if(!found)
							translated += temp.charAt(i);
						found = true;
						done = true;
					} else {
						if(found)
							translated += temp.charAt(i);
					}
					
					if (!found) {
						testWord += word.charAt(i);
					}		
				}
				translated += testWord + "ay";
			}
			System.out.println("The translation is: " + translated);
			System.out.println();
			System.out.print("Enter another word to be translated (or press Q to quit): ");
			word = input.nextLine();
			translated ="";
			testWord ="";
			found = false;
			done = false;
		}while(!word.equalsIgnoreCase("q"));
}}