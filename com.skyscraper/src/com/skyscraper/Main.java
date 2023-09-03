package com.skyscraper;

import java.util.Scanner;
import java.util.Stack;
public class Main {
	// Create a Scanner object to read input from the user.
	static Scanner input = new Scanner(System.in);

	// This method is the main method of the program.
	public static void main(String args[]) {

		int floors;
		// Get the total number of floors from the user.
		System.out.println("Enter the total no of floors in the building");
		floors = input.nextInt();

		// Create an array to store the floor sizes.
		int[] floor = new int[floors];

		// Read the floor sizes from the user.	
		for (int i = 0; i < floors; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			floor[i] = input.nextInt();
			}
		// Create an object of the Service class.
		Service Object = new Service();

		// Print the order of construction of the floors.
		System.out.println("The order of construction is as follows \n");
		Object.printOrder(floor);
	}	
}


