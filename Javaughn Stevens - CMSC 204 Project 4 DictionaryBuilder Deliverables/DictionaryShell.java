/* Name: Javaughn Stevens
 * Date: 3/28/26
 * Assignment: Project 4 DictionaryBuilder CMSC 204
 * Term: Spring 2026
 * Instructor: Professor Gary Thai
 * Integrity Acknowledgement: This code is my original work, and 
 * I have not included source code from the Internet, AI generated nor from another student for this project.
 */
import java.util.*;
import java.io.*;

// Javadoc comments
/**
 * The DictionaryShell class provides a command-line interface (CLI)
 * for interacting with the DictionaryBuilder, and it contains a main method.
 * 
 * The user can add, delete, search, and list words, as well as view
 * dictionary statistics. The dictionary can be initialized either
 * from a text file or with a default estimated size.
 * 
 */
public class DictionaryShell {
	
	/**
	 * Default constructor. Not directly used, as all functionality
	 * is handled in the main method.
	 */
	// No-arg constructor
	public DictionaryShell() {
		
	}

	/**
	 * The entry point of the program. Initializes the dictionary and
	 * processes user commands in a loop until the user exits.
	 *
	 * @param args optional command-line arguments; if provided,
	 * first argument is treated as a filename
	 * to initialize the dictionary
	 */
	public static void main (String[] args) {
		Scanner userInput = new Scanner(System.in); // for user to enter commands
		DictionaryBuilder userDictionary = null;
		// DictionaryBuilder object for hash-based dictionary
		
		// Initializing the dictionary
		try {
		// We can take advantage of this common method header in main
			if (args.length > 0) {
				userDictionary = new DictionaryBuilder(args[0]);
				// call to String filename constructor with args
			} else {
				userDictionary = new DictionaryBuilder(100);
				// call to int estimatedEntries constructor with args
			}
		} catch (FileNotFoundException exception) {
			System.out.println("File not found.");
            userInput.close(); // close the scanner object
            return; // end program
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			userInput.close(); // close the scanner object
            return; // end program
		}
		
		System.out.println("Welcome to the Dictionary Builder CLI.");
		System.out.println("Available commands: add <word>, delete <word>, search <word>, list, stats, exit >");
		
		boolean continuous = true;
		
		while (continuous == true) {
			System.out.print("> ");
		    String line = userInput.nextLine().trim();

		    if (line.length() == 0 ) {
		        continue; // ignore empty/null input from user.
		    }

		    // 2nd scanner object from 1st one closing
		    Scanner lineScanner = new Scanner(line);
		    String command = lineScanner.next().toLowerCase();
		    String word = null; // word not entered yet
		    
		    if (lineScanner.hasNext() == true) {
		        word = lineScanner.next(); // this is when the word is entered
		    }
		    
		    if (command.equals("add")) {
		        if (word == null) {
		            System.out.println("Usage: add <word>");
		            continue; // command not entered properly this reminds the user without ending program
		        }
		        userDictionary.addWord(word);
		        System.out.println("\"" + word.toLowerCase() + "\" added.");
		    }
		    else if (command.equals("delete")) {
		        if (word == null) {
		            System.out.println("Usage: delete <word>");
		            continue;
		        }
		        try {
		            userDictionary.removeWord(word);
		            System.out.println("\"" + word.toLowerCase() + "\" deleted."); // successful deletion
		        } catch (DictionaryEntryNotFoundException exception) {
		            System.out.println(exception.getMessage()); 
		            // unsuccessful deletion, exception thrown
		        }
		    }
		    else if (command.equals("search")) {
		        if (word == null) {
		            System.out.println("Usage: search <word>");
		            continue;
		        }
		        int frequency = userDictionary.getFrequency(word);
		        if (frequency > 0) {
		            System.out.println(frequency + " instance(s) of \"" + word.toLowerCase() + "\" found.");
		        } else {
		            System.out.println("\"" + word.toLowerCase() + "\" not found."); // word is not in the dictionary
		        }
		    }
		    else if (command.equals("list")) {
		        List<String> dictionaryWords = userDictionary.getAllWords();
		        for (int i = 0; i < dictionaryWords.size(); i++) {
		        	System.out.println(dictionaryWords.get(i)); // traverses through ArrayList
		        }
		    }
		    else if (command.equals("stats")) {
		    	// information about dictionary's current statistics
		        System.out.println("Total words: " + userDictionary.getTotalWordCount());
		        System.out.println("Total unique words: " + userDictionary.getUniqueWordCount());
		        System.out.printf("Estimated load factor: %.2f\n", userDictionary.getLoadFactor());
		        // output formatting from 203
		        // load factor changes constantly as more words are added
		    }
		    else if (command.equals("exit")) {
		        System.out.println("Quitting...");
		        lineScanner.close();
		        return; // ends program
		    }
		    else {
		        System.out.println("Command is invalid."); 
		    }

		    		lineScanner.close(); 
				}
			}
		}


