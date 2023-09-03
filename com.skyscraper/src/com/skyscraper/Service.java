package com.skyscraper;

import java.util.*;

public class Service {

	// Create a stack to store the floors.
	Stack<Integer> stack = new Stack<>();

	// This method sorts the stack of floors in ascending order.
	void sortStack(int array[]) {
		Stack<Integer> tempSt = new Stack<>();
		
		// If the array is empty, return.
		if (array.length == 0) {
			return;
		}

		// Push the first element of the array onto the stack.
		stack.push(array[0]);

		// Initialize a counter to iterate through the array.
		int i = 1;
		
		// Initialize a variable to store the element at the top of the stack.
		int el;
		
		// While the counter is less than the length of the array, do the following:
		while (i < array.length) {

				// Get the element at the top of the stack.
				el = (int) stack.peek();

				// If the current element is greater than or equal to the element at the top of the stack, push it onto the stack.
				
				if (array[i] >= el)
				stack.push(array[i]);
				
				else {
				
					el = (int) stack.peek();
					
					// Otherwise, keep popping elements from the stack until the current element is greater than or equal to the element at the top of the stack.
					while (array[i] < el && !stack.isEmpty()) {
					// Push the popped element onto a temporary stack.
					tempSt.push(stack.pop());
					
					// If the stack is empty, break out of the loop.
					if (stack.isEmpty())
						break;
					
					else
						// Set the element at the top of the stack to the current element.
						el = (int) stack.peek();
				}
					// Push the current element onto the stack.
					stack.push(array[i]);

				// Push all the elements from the temporary stack back onto the main stack.
				while (!tempSt.isEmpty())
					stack.push(tempSt.pop());
			}
			i++;
		}
	}
	// This method prints the order in which the floors should be built.
	public void printOrder(int[] floor) {

		// Sort the stack of floors.
		sortStack(floor);

		// Create a boolean array to keep track of which floors have been built.
		boolean floordone[] = new boolean[floor.length];
		
		// Iterate through the array of floors.
		for (int i = 0; i < floor.length; i++) {
			floordone[floor[i] - 1] = true;

			// Print the current day.
			System.out.println("Day: " + (i + 1));
			
			// If the current floor is not equal to the element at the top of the stack, print a blank line.
			if (floor[i] != (int) stack.peek())
				System.out.println();
			
			else {
				// Otherwise, print the elements from the stack until the stack is empty or the current floor is no longer at the top of the stack.
				while (!stack.isEmpty() && floordone[(int) stack.peek() - 1]) {
					int el = stack.pop();
					System.out.print(el + " ");
				}
				System.out.println();
			}
		}
	}
}
