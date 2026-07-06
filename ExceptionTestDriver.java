import java.util.*;
import java.io.*;

public class ExceptionTestDriver
{
	public static void main(String[] args) throws InsufficientFundException {
	    Scanner input = new Scanner (System.in);
	    System.out.println("Is this your first time?? 1 - Yes, 2 - No");
	    int choice = input.nextInt();
	    int money = 0;
	    input.nextLine(); // consume leftover newline
	    
	    while (choice != 1 && choice != 2) {
	        System.out.println("Invalid");
	        choice = input.nextInt();
	        input.nextLine(); // consume leftover newline
	    }
	    
	    if (choice == 1) {
	        BankAccount bank = new BankAccount();
	        // calls no-arg constructor.
	        money = 0;
	        System.out.println("You have just created a new account with $0");
	    }
	    
	    if (choice == 2) {
	        System.out.println("How much money did you have previously?");
	        money = input.nextInt();
	        input.nextLine(); // consume leftover newline;
	        BankAccount bank = new BankAccount(money);
	        // calls constructor with args.
	        System.out.println("Your account currently has $" + money);
	    }
	    
	    choice = 0; // reset this to be used again
	    System.out.println("What would you like to do?");
	    System.out.println("1 - Deposit Money");
	    System.out.println("2 - Withdraw Money");
	    System.out.println("3 - Quit");
	    choice = input.nextInt();
	    input.nextLine(); // consume leftover newline
	    
	    while (choice != 1 && choice != 2 && choice != 3) {
	        System.out.println("Invalid");
	        choice = input.nextInt();
	        input.nextLine(); // consume leftover newline
	    }
	    
	    if (choice == 1) {
	        depositMoney(money, input);
	    }
	    
	    if (choice == 2) {
	        try {
        withdrawMoney(money, input);
    } catch (InsufficientFundException exception) {
        System.out.println(exception.getMessage()); // eliminates stack traces
    }
	    }
	    
	    if (choice == 3) {
	        System.exit(0);
	    }
	    
	}
	
	public static void depositMoney(int money, Scanner input) {
	        int deposit;
	        System.out.println("Your account currently has $" + money);
	        System.out.println("How much would you like to deposit?");
	        deposit = input.nextInt();
	        input.nextLine();
	        
	        int newBalance = money + deposit;
	        System.out.println("Your new balance is $" + newBalance);
	    }
	    
	public static void withdrawMoney(int money, Scanner input) throws InsufficientFundException
	{
	     int withdrawal;
	     System.out.println("Your account currently has $" + money);
	     System.out.println("How much would you like to withdraw?");
	     withdrawal = input.nextInt();
	     input.nextLine();
	     
	     int newBalance = money - withdrawal;
	     
	     if (newBalance < 0) {
	         throw new InsufficientFundException("You cannot withdraw money you don't have.");
	     } else {
	         System.out.println("Your new balance is $" + newBalance);
	     }
	}
	
 }