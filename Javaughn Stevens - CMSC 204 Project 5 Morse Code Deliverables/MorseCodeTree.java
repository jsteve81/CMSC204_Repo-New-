import java.util.*;
import java.io.*;

// Javadoc comments
/**
 * The MorseCodeTree class represents a binary tree used to store Morse code mappings. Each node corresponds to a letter, where
 * traversing left represents a period (.) and right represents a hyphen (-).
 */
public class MorseCodeTree {
	private TreeNode<String> root;
	// I removed the additional Javadoc variables because they are not used in my implementation outside of parameters.

	/**
     * No-arg constructor that constructs a MorseCodeTree and initializes it with the standard Morse code mappings.
     */
	// No-arg constructor
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
     * Adds a node to the Morse code tree based on the given string.
     *
     * @param root the current root node
     * @param code the Morse code string
     * @param letter the letter to insert into the Morse code tree
     */
	public void addNode (TreeNode<String> root, String code, String letter) {
		if (code.length() == 0) {
			return; // base case #1
			/* I learned in a different class/programming language,
		We can use this statement in Java and other languages to forcefully end void methods without returning anything */
		}
		
		char character = code.charAt(0); // get the first character of the code, type casting doesn't work		
		if (code.length() == 1) {
	        if (character == '.') {
	            if (root.leftChild == null) {
	                root.leftChild = new TreeNode<String>(letter); // create a new node if it's null
	            } else {
	                root.leftChild.setData(letter); // overwrite this node
	            }
	        } else if (character == '-') {
	            if (root.rightChild == null) {
	                root.rightChild = new TreeNode<String>(letter);
	            } else {
	                root.rightChild.setData(letter);
	            }
	        }
	        return; // base case #2
	    }
		if (code.length() > 1) {
		    if (character == '.') { // we compare characters using ==
		        if (root.leftChild == null) {
		            root.leftChild = new TreeNode<String>(""); // create empty string that is not null
		        }
		        addNode(root.leftChild, code.substring(1), letter); // we use substring to gradually shrink the code
				// substring() is a part of Java string class
		    }
		    else if (character == '-') {
		        if (root.rightChild == null) {
		            root.rightChild = new TreeNode<String>("");
		        }
		        addNode(root.rightChild, code.substring(1), letter);
		    }
		}
		
	}
	
	/**
     * Builds the Morse code tree by inserting all standard letter mappings.
     * The 
     */

	public void buildTree() {
		// null/empty root
		root = new TreeNode<String>("");
		
		// Level 1 of the provided morse code tree
		insert (".", "e");
		insert ("-", "t");
		
		// Level 2
		insert ("..", "i");
		insert (".-", "a");
		insert ("-.", "n");
		insert ("--", "m");
		
		// Level 3
		insert ("...", "s");
		insert ("..-", "u");
		insert (".-.", "r");
		insert (".--", "w");
		insert ("-..", "d");
		insert ("-.-", "k");
		insert ("--.", "g");
		insert ("---", "o");
		
		// Level 4
		insert ("....", "h");
		insert ("...-", "v");
		insert ("..-.", "f");
		insert (".-..", "l");
		insert (".--.", "p");
		insert (".---", "j");
		insert ("-...", "b");
		insert ("-..-", "x");
		insert ("-.-.", "c");
		insert ("-.--", "y");
		insert ("--..", "z");
		insert ("--.-", "q");
	}
	
	/**
     * Getter method that returns the root of the Morse code tree.
     *
     * @return the root node
     */
	public TreeNode<String>	getRoot() {
		return root;
	}
	
	/**
     * Returns the English letter node that corresponds to the given Morse code.
     *
     * @param code the Morse code string
     * @return the corresponding English letter node
     */
	public String fetch (String code) {
		return fetchNode (root, code);
	}
	
	/**
     * Uses recursion to traverse the tree to find the letter corresponding to the given Morse code.
     *
     * @param root the current node
     * @param code the remaining Morse code string that gradually gets smaller
     * @return the corresponding English letter
     */
	public String fetchNode (TreeNode<String> root, String code) {
		if (code.length() == 0) {
			return root.getData();
		}
		
		char character = code.charAt(0);
		
		if (character == '.') {
			return fetchNode (root.leftChild, code.substring(1));
		}
		else if (character == '-') {
			return fetchNode (root.rightChild, code.substring(1)); // recursion happens here too.
		}
		
		return null; // necessary for compilation
	}
	
	/**
     * Inserts a letter into the Morse code tree using its Morse code.
     *
     * @param code the given Morse code string
     * @param letter the given English letter
     */
	public void insert (String code, String letter) {
		addNode (root, code, letter);
	}
	
    /**
     * Performs an traversal (left, root, right)
     * and stores the result in the provided list.
     *
     * @param root the current node
     * @param list the ArrayList to store traversal results
     */

	public void	LNRoutputTraversal (TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
			LNRoutputTraversal (root.leftChild, list); // recursion
			list.add(root.getData());
			LNRoutputTraversal (root.rightChild, list);
		}
	}
	
	/**
     * Sets/overwrites the root of the Morse code tree.
     *
     * @param newNode the new root node
     */
	public void	setRoot (TreeNode<String> newNode) {
		root = newNode;
	}
	
    /**
     * Returns an ArrayList containing the elements of the tree, and calls the previous method to do so.
     * @return an ArrayList of tree values
     */
	public ArrayList<String> toArrayList() {
		ArrayList<String> morseCodeList = new ArrayList<>();
		LNRoutputTraversal (root, morseCodeList); // method call, ArrayList is populated here
		return morseCodeList;
	}
	
	/**
     * update() is an unsupported operation for this project.
     * @throws UnsupportedOperationException always
     */
	public void update() {
		throw new UnsupportedOperationException(); 
	}
	
	/**
     * delete() is an unsupported operation for this project.
     * @throws UnsupportedOperationException always
     */
	// helper method from Javadoc
	public MorseCodeTree delete(String data) {
		throw new UnsupportedOperationException();
	}
	
}
