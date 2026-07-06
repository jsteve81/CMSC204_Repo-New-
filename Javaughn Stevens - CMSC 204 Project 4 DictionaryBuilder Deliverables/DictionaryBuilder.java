import java.util.*;
import java.io.*;

// Javadoc comments
/**
 * The DictionaryBuilder class constructs and manages a dictionary of words
 * using a hash table with separate chaining via linked lists.
 * 
 * It supports adding, removing, and querying word frequencies, as well as
 * retrieving all stored words. Words are normalized by removing punctuation and other special characters
 * and converting to only lowercase letters.
 */
public class DictionaryBuilder {
	private int estimatedEntries;
	private String filename;
	private int totalWordCount; // total word count + duplicate words
	private int size; // # of words without duplicates in dictionary
	private MyLinkedList[] linkedHashTable; // linked list array (hash table)
	public static final double loadFactor = 0.6; // from Javadoc and project outline recommendation, used
	
	/* No-arg constructor is not useful here because a file needs to be given to the program in prder
	 for a hash table to be created as well as the appropriate load factor (in this case 0.6). */
	
	/**
	 * Constructs a DictionaryBuilder with an estimated number of entries (integer).
	 * Initializes the hash table based on this given estimate.
	 *
	 * @param estimatedEntries the estimated number of entries
	 */
	// Constructor with args
	public DictionaryBuilder(int estimatedEntries) {
		this.estimatedEntries = estimatedEntries;
		
		createHashTable(estimatedEntries); // calls method to create hash table 
	}
	
	/**
	 * Constructs a DictionaryBuilder from a computer file.
	 * Reads all words from the input file and inserts them into the dictionary.
	 *
	 * @param filename the name of the input file
	 * @throws FileNotFoundException if the file cannot be found by the program
	 */
	// Constructor with args (for text files)
	public DictionaryBuilder(String filename) throws FileNotFoundException {
		this.filename = filename;
		
		File myFile = new File (filename); 
		int estimatedEntries = (int)(myFile.length() / 100); // formula from project description
		
		createHashTable(estimatedEntries); // calls method to create hash table 
		
		Scanner dictionaryScanner = new Scanner (myFile);
		while (dictionaryScanner.hasNext()) { // if the scanner has more to traverse
			addWord(dictionaryScanner.next()); // add words to the dictionary
		}
		
		dictionaryScanner.close(); // to prevent resource leaking
	}
	
	/**
	 * Adds a word to the dictionary. If the word already exists in the dictionary,
	 * its frequency count is incremented.
	 *
	 * @param word the word to be added
	 */
	public void addWord(String word) {
		word = simplifyWord(word); // removes punctuation and simplifies capitalization
		if (word.length() == 0) {
			return; // ends method early without need for exception handling.
		}
		int wordIndex = hasher(word);
		MyLinkedList linkedBucket = linkedHashTable[wordIndex];
		
		DictionaryEntry userEntry = linkedBucket.findNode(word);
		
		if (userEntry == null) { // if the word doesn't already exist
			linkedBucket.insertNode(word);
			size++; // increase size due to the new unique word
		} else {
			userEntry.count++; // increase the count of the word
		}
		
		totalWordCount++;

	}
	
	/**
	 * Completely removes a word from the dictionary.
	 *
	 * @param word the word to be removed
	 * @throws DictionaryEntryNotFoundException if the word already does not exist
	 */
	public void removeWord(String word) throws DictionaryEntryNotFoundException {
		word = simplifyWord(word);

	    int wordIndex = hasher(word);
	    DictionaryEntry userEntry = linkedHashTable[wordIndex].findNode(word);

	    if (userEntry == null) {
	        throw new DictionaryEntryNotFoundException("The word " + word + " was not found.");
	    }

	    totalWordCount -= userEntry.count;
	    size--;

	    linkedHashTable[wordIndex].deleteNode(word);
	}
	
	/**
	 * Returns the frequency of a given word in the dictionary.
	 *
	 * @param word the word to search for
	 * @return the number of occurrences of the word, or 0 if the word is absent from the dictionary
	 */
	// getter method
	public int getFrequency(String word) {
		word = simplifyWord(word);
		if (word.length() == 0) {
			return 0; // ends method early without need for exception handling.
		}
		int wordIndex = hasher(word);
		DictionaryEntry userEntry = linkedHashTable[wordIndex].findNode(word);
		
		if (userEntry == null) {
			return 0; // if word is not found, frequency is 0;
		}
		
		return userEntry.count;
	}
	
	/**
	 * Returns a sorted list of all unique words in the dictionary.
	 *
	 * @return a sorted List of words
	 */
	public List <String> getAllWords() {
		List<String> wordList = new ArrayList<>(); // List object must be returned according to project description
		
		for (int i = 0; i < linkedHashTable.length; i++) {
			linkedHashTable[i].collectWords(wordList);
		}
		
		Collections.sort(wordList); // post process
		return wordList;
	}
	
	/**
	 * Initializes the hash table using the estimated number of entries
	 * and the defined load factor.
	 *
	 * @param estimatedEntries the estimated number of entries
	 */
	// Helper method to construct hash table for constructors
	private void createHashTable(int estimatedEntries) {
		// load factor is a decimal so we must cast back to int
		int tableSize = next4kPlus3Prime((int) (estimatedEntries / loadFactor));
		linkedHashTable = new MyLinkedList[tableSize];
		
		for (int i = 0; i < tableSize; i++) {
			linkedHashTable[i] = new MyLinkedList();
		}
	}
	
	/**
	 * Simplifies a word by converting it to all lowercase letters and removing
	 * all special characters.
	 *
	 * @param word the original word
	 * @return the simplified word stripped of punctuation, capitalization, and special characters
	 */
	// Helper method to remove punctuation and case sensitivity as required by project description
	private String simplifyWord(String word) {
		word = word.toLowerCase(); // sets word to lowercase
	    StringBuilder simplified = new StringBuilder();

	    // very similar to Activity 5.1N
	    for (int i = 0; i < word.length(); i++) {
	        char character = word.charAt(i);
	        // we don't need to check if the character is a letter because of ASCII values
	        if (character >= 'a' && character <= 'z') {
	        	simplified.append(character);
	        }
	    }

	    return simplified.toString();
	}
	
	/**
	 * Computes a hash index for a given word using a hash code formula
	 *
	 * @param word the word to hash
	 * @return the corresponding index in the hash table
	 */
	// Helper method to create hash code
	
	/* According to Eclipse, the hash code of a String object is computed as 
	 * ∑s[x sub n] * 31 ^(n - (x + 1)), therefore I can implement hasher as follows: 
	 */
	private int hasher(String word) {
		int hash = 0;

	    for (int i = 0; i < word.length(); i++) {
	        hash = 31 * hash + word.charAt(i);
	    }
	    
	    int finalHashCode = 0;
	    
	    // absolute value
	    if (hash < 0) {
	    	finalHashCode = hash * -1;
	    } else {
	    	finalHashCode = hash;
	    }

	    return finalHashCode % linkedHashTable.length;
	}
	
	/**
	 * Finds the next prime number of the form (4k + 3) greater than or equal to a given value.
	 *
	 * @param value the starting value
	 * @return the next 4k + 3 prime number
	 */
	// Helper method for choosing the next 4k + 3 prime
	private int next4kPlus3Prime(int value) {
		boolean continuous = true;
		
/* infinite loop for this special scenario where we don't know the number of iterations but
 the loop condition is independent of the updating value (namely value). */
		while (continuous == true) {
	        if (isPrime(value) && value % 4 == 3) {
	            return value;
	        } else {
	        	value++;
	        }
	    }
		return value; // this won't get called ever since the loop is essentially infinite, it exists so the method can compile.
	}
	
	/**
	 * Determines whether a number is prime.
	 *
	 * @param n the number to check
	 * @return true if the number is prime, false otherwise
	 */
	/* Helper method provided from project description to determine if the passed number is prime.
	For reference, a prime number is a positive integer greater than one that is only divisible by 1 and itself. */
	private boolean isPrime(int n) {
		 if (n <= 1) {
			 return false;
		 }
		 	if (n == 2 || n == 3) {
		 		return true;
		 	}
		    if (n % 2 == 0 || n % 3 == 0) {
		    	return false;
		    }

		    for (int i = 5; i <= Math.sqrt(n); i += 6) {
		        if (n % i == 0 || n % (i + 2) == 0)
		            return false;
		    }
		    return true;
	}
	/**
	 * Returns the total number of words added, including duplicates.
	 *
	 * @return total word count
	 */
	// Additional getter helpers
	public int getTotalWordCount() {
	    return totalWordCount;
	}

	/**
	 * Returns the unique number of words added, omitting duplicates.
	 *
	 * @return total unique word count
	 */
	public int getUniqueWordCount() {
	    return size;
	}
	
	/**
	 * Returns the current load factor of the hash table.
	 *
	 * @return load factor (size or estimated unique entries / table length)
	 */
	public double getLoadFactor() {
	    return (double) size / linkedHashTable.length; // formula from slides
	}

}
