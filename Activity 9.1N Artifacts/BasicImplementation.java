import java.util.*;
import java.io.*;

/* We can actually partially implement the prompt very easy without using real threads, by just using simple for loops, methods, and 
 other basic programming functions. However the functions will not be called continuously. */ 
 
public class BasicImplementation {

	public static void main(String[] args) {
		// simple user input menu
		Scanner userInput = new Scanner(System.in);
		System.out.println("Which thread do you want to use? (1, 2, 3)");
		System.out.println("Thread 1 - Print 'a' 100x");
		System.out.println("Thread 2 - Print 'b' 100x");
		System.out.println("Thread 3 - Count down from 100 to 1");
		
		int thread = userInput.nextInt();
		
		// input verification
		while (thread < 1 || thread > 3) {
			System.out.println("Invalid, please choose a value between 1 and 3.");
			thread = userInput.nextInt();
		}
		
		// if-else for function calls
		if (thread == 1) {
			a100x();
		} else if (thread == 2) {
			b100x();
		} else {
			OneHundredtoOne();
		}
		
		userInput.close(); // to avoid resource leaks
	}
	
	
	// method definition
	public static void a100x() {
		for (int i = 0; i < 100; i++) {
			System.out.print("a ");
		}
	}
	
	public static void b100x() {
		for (int i = 0; i < 100; i++) {
			System.out.print("b ");
		}
	}
	
	public static void OneHundredtoOne() {
		for (int i = 100; i >= 1; i--) {
			System.out.print(i + " ");
		}
	}

}
