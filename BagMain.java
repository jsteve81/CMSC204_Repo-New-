import java.util.*;
import java.io.*;

public class BagMain
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    Bag<String> bag = new Bag<>();
	    int choice;
	    String item = null;
	    boolean loop = true;
	   
	while (loop == true) {
		System.out.println("Welcome to the Bag!");
		System.out.println("");
		System.out.println("Choose an operation: ");
		System.out.println("1 - Add an item to the bag");
		System.out.println("2 - Remove most recently added item from the bag");
		System.out.println("3 - Remove specific item from the bag");
		System.out.println("4 - Check if the bag is empty");
		System.out.println("5 - Empty the bag");
		System.out.println("6 - Check the frequency of an item in the bag");
		System.out.println("7 - View all of the items currently in the bag");
		System.out.println("8 - Quit");
		
		choice = input.nextInt();
		input.nextLine();
		
		while (choice < 1 || choice > 8) {
		    System.out.println("Invalid. Please choose a valid operation");
		    choice = input.nextInt();
		    input.nextLine();
		}
		
		if (choice == 1) {
		    System.out.println("Add an item.");
		    item = input.nextLine();
		    bag.add(item);
		}
		
		if (choice == 2) {
		    System.out.println("Removing most recently added item.");
		    bag.remove();
		}
		
		if (choice == 3) {
		    System.out.println("Choose the item to be removed.");
		    item = input.nextLine();
		    
		    if (bag.getFrequency(item) != 0) {
		        bag.remove(item);
		        System.out.println("Item removed successfully.");
		    } else {
		        System.out.println("This item is not in the bag.");
		    }
		}
		
		if (choice == 4) {
		    if (bag.isEmpty() == true) {
		        System.out.println("The bag is currently empty.");
		    } 
		    else { 
		        System.out.println("The bag is currently not empty.");
		    }
		}
		
		if (choice == 5) {
		    System.out.println("Emptying the bag...");
		    if (bag.isEmpty() == false) {
		        bag.clear();
		        System.out.println("Bag emptied successfully.");
		    } 
		    else { 
		        System.out.println("The bag is currently empty.");
		    }
		}
		
		if (choice == 6) {
		    System.out.println("Enter the item that you wish to check the frequency of. ");
		    item = input.nextLine();
		    System.out.println("The frequency of " + item + " is " + bag.getFrequency(item));
		}
		
		if (choice == 7) {
		    System.out.println("Items in the bag: ");
		    bag.display();
		}
		
		if (choice == 8) {
		    System.exit(0);
		}
	}
	}
}