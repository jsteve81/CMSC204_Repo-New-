import java.util.*;
import java.io.*;

// Javadoc comments
/**
 * The DictionaryEntry class represents a single entry in the dictionary.
 * 
 * Each entry stores a word and the number of times it appears
 * in the dictionary, also called the frequency of the word.
 * 
 */
public class DictionaryEntry { // class for storing words in the dictionary builder.
	public String word;
	public int count;
		
	/**
	 * Constructs a DictionaryEntry with the specified word.
	 * The initial count is set to 1.
	 *
	 * @param word the word to store in this entry
	 */
	// Constructor with args
	public DictionaryEntry(String word) {
       this.word = word;
       this.count = 1; // count isn't passed into the constructor parameters because it's constant.
   }
}
