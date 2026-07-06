import java.util.*;
import java.io.*;

// Javadoc comments
/**
 * A generic TreeNode class used to represent nodes in a binary tree.
 * Each node stores data and references to left and right children nodes.
 * @param <T> the type of data stored in the node (generic)
 */
public class TreeNode <T> {
	private T data;
	public TreeNode<T> leftChild; // public is necessary for use in MorseCodeTree, contrasts how these vars are usually private
	public TreeNode<T> rightChild;
	
	// No arg constructor not represented in provided Javadoc
	
	// Constructors w/ args
	/**
     * Constructor that creates a new node by copying the data and child references from another node.
     * This does not create a deep copy.
     * @param node the TreeNode object to copy
     */
	public TreeNode (TreeNode<T> node) {
		// for copying node references.
		if (node != null) {
			this.data = node.data;
			this.leftChild = node.leftChild; 
			this.rightChild = node.rightChild;
		}
	}
	
    /**
     * Constructs a TreeNode with the specified data.
     * The left and right child references are initialized to null. Functionally similar to a no-arg constructor
     * @param dataNode the data to store in the node
     */
	public TreeNode(T dataNode) {
		/* creates a new TreeNode with left and right child set to null and data set to the dataNode
		 Functionally similar to no-arg constructor. */ 
		this.data = dataNode;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	// getter method
	/**
     * Simple getter method that returns the data stored in the TreeNode.
     * @return the TreeNode's data
     */
	public T getData() {
		return data;
	}
	
	// additional helper methods not in high-level pseudocode design
	/**
     * Simple getter method that returns the data stored in the left child of the TreeNode.
     * @return the child's data
     */
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	/**
     * Simple getter method that returns the data stored in the right child of the TreeNode.
     * @return the child's data
     */
	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	// helper setter method
	/**
     * Simple setter method that overwrites the data stored in this node.
     * @param data the new data value
     */
	public void setData(T data) {
	    this.data = data;
	}
}
