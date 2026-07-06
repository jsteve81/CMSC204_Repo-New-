import java.util.*;
import java.io.*;

// Javadoc comments
/**
 * A singly linked list implementation used as a bucket in the hash table
 * for the DictionaryBuilder.
 * 
 * Each node stores a DictionaryEntry object containing a word and its frequency.
 * This class supports insertion, deletion, search, and traversal operations.
 */
public class MyLinkedList {

	/**
	 * A node in the linked list that stores a DictionaryEntry
	 * and a reference to the next node. This is a private, nested class.
	 */
	private class Node { // nested Node class
		DictionaryEntry data; // stores word and frequency
	    Node nextNode; // references next node in list
	    
	    /**
	     * Constructs a Node with the given DictionaryEntry.
	     *
	     * @param data the dictionary entry to store in the node
	     */
	    Node(DictionaryEntry data) {
	    	this.data = data;
	    }
	}

	private Node headNode; // head of the node

	/**
	 * Searches for a word in the linked list.
	 *
	 * @param word the word to find
	 * @return the DictionaryEntry containing the word, or null if word is not found
	 */
	public DictionaryEntry findNode(String word) {
		Node currentNode = headNode; // setup statement for linked list traversal
		while (currentNode != null) { // if current node is not null, traverse until the node data matches the word.
		if (currentNode.data.word.equals(word)) {
			return currentNode.data;
		}
			currentNode = currentNode.nextNode;
		}
		return null; // if the word is not found, return null
	}
	
	/**
	 * Inserts a new word into the linked list.
	 * The word is added at the beginning or head of the list.
	 *
	 * @param word the word to be inserted
	 */
	public void insertNode(String word) {
		// create new node and adjust the linked list accordingly
		Node newNode = new Node(new DictionaryEntry(word));
		newNode.nextNode = headNode;
		headNode = newNode;
	}
	
	/**
	 * Deletes a word from the linked list.
	 *
	 * @param word the word to be deleted
	 * @throws DictionaryEntryNotFoundException if the word is not found
	 */
	public void deleteNode(String word) throws DictionaryEntryNotFoundException {
		Node currentNode = headNode;
		Node previousNode = null; // keeps track of previous node for adjustment of the linked list
		
		while (currentNode != null) {
			// if the word is found
			if (currentNode.data.word.equals(word)) {
				if (previousNode == null) { // adjusting at the head node
					headNode = currentNode.nextNode;
				}
				else { // adjusting somewhere in the middle of the linked list
					previousNode.nextNode = currentNode.nextNode;
				}
				return; // end the method early if the word is found
			}
			// continue traversing through the linked list
			previousNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		// if the word is not found, we through the following exception
		throw new DictionaryEntryNotFoundException("The word " + word + " was not found in the dictionary.");
	}
	
	/**
	 * Returns a list of all words stored in this linked list.
	 *
	 * @return a list of words
	 */
	public List<String> getWords() {
		List<String> wordList = new ArrayList<>(); // List object must be returned according to project description
		Node currentNode = headNode;
		
		// traverse the list and add every word to the ArrayList for returning.
		while (currentNode != null) {
			wordList.add(currentNode.data.word);
			currentNode = currentNode.nextNode;
		}
		
		return wordList;
	}
	
	/**
	 * Adds all words in this linked list to the provided list.
	 * This method is used by DictionaryBuilder to gather words
	 * from all hash table buckets.
	 *
	 * @param wordList the list to which words will be added
	 */
	// Helper method for getAllWords() in DictionaryBuilder
	public void collectWords(List<String> wordList) {
		Node currentNode = headNode;
			
		while (currentNode != null) {
			wordList.add(currentNode.data.word);				
			currentNode = currentNode.nextNode;
		}
	}
	
}
