import java.util.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeNodeTestStudent {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// Testing every method and constructor + edge/special cases
	
	@Test
	void testConstructorWithArgs1() {
		TreeNode<String> testOriginal = new TreeNode<>("Merry Christmas 2026!");
		testOriginal.leftChild = new TreeNode<>("Happy New Year 2026!");
		testOriginal.rightChild = new TreeNode<>("Happy Hanukkah 2026!");
	    TreeNode<String> testCopy = new TreeNode<>(testOriginal); // nodes have children
	    assertEquals("Merry Christmas 2026!", testCopy.getData());
	    assertEquals("Happy New Year 2026!", testCopy.getLeftChild().getData());
	    assertEquals("Happy Hanukkah 2026!", testCopy.getRightChild().getData());

	    assertSame(testOriginal.getLeftChild(), testCopy.getLeftChild()); // reference is copied
	    assertSame(testOriginal.getRightChild(), testCopy.getRightChild());
	}
	
	@Test
	void testConstructorWithArgs2() {
	    TreeNode<String> testNode = new TreeNode<>("Merry Christmas 2026!");
	    assertEquals("Merry Christmas 2026!", testNode.getData());
	    assertNull(testNode.getLeftChild());
	    assertNull(testNode.getRightChild()); 
	    /* if there's only one node, there are no children and it's not really a tree, even though for now it functions like one.
	    Constructor is similar to no-arg constructor */
	}
	
	@Test
	void testGetData() {  // works with any data type
		TreeNode<Integer> testNode1 = new TreeNode<>(42);
	    assertEquals(42, testNode1.getData());
	    TreeNode<String> testNode2 = new TreeNode<>("Maxwell");
	    assertEquals("Maxwell", testNode2.getData());
	    TreeNode<Boolean> testNode3 = new TreeNode<>(true);
	    assertEquals(true, testNode3.getData());
	}
	
	// testing additional helper methods
	@Test
	void testSetData() {
		TreeNode<String> testNode = new TreeNode<>("Ashley");
	    testNode.setData("Rebecca"); // we can override previous data
	    assertNotEquals("Ashley", testNode.getData()); 
	    assertEquals("Rebecca", testNode.getData()); 
	}
	
	@Test
	void testGetLeftChild() {
		TreeNode<String> testParentNode = new TreeNode<>("Mother");
	    TreeNode<String> testLeftChild = new TreeNode<>("Child");
	    testParentNode.leftChild = testLeftChild;
	    assertEquals(testLeftChild, testParentNode.getLeftChild());
	}
	
	@Test
	void testGetRightChild() {
		TreeNode<String> testParentNode = new TreeNode<>("Father");
	    TreeNode<String> testRightChild = new TreeNode<>("Child");
	    testParentNode.rightChild = testRightChild;
	    assertEquals(testRightChild, testParentNode.getRightChild());
	}
	
	// Edge cases
	
	@Test
	void testConstructorWithArgs1NullInput() {
	    TreeNode<String> testNode = new TreeNode<>(null);
	    assertNull(testNode.getData());
	    assertNull(testNode.getLeftChild()); // the node has no information whatsoever
	    assertNull(testNode.getRightChild());
	}
	
	@Test
	void testSetDataWithNullInput() {
	    TreeNode<String> testNode = new TreeNode<>("Palm Tree");
	    testNode.setData(null);
	    assertNotEquals("Palm Tree", testNode.getData());
	    assertNull(testNode.getData()); // overwritten, the node is now null
	}
	
	@Test
	void testNullChildrenData() {
	    TreeNode<String> testParentNode = new TreeNode<>("Robot");
	    TreeNode<String> testLeftChild = new TreeNode<>(null);
	    TreeNode<String> testRightChild = new TreeNode<>(null);
	    testParentNode.leftChild = testLeftChild;
	    testParentNode.rightChild = testRightChild;
	    assertNotNull(testParentNode.getLeftChild());
	    assertNotNull(testParentNode.getRightChild());
	    assertNull(testParentNode.getLeftChild().getData()); // the children themselves aren't null but their data is
	    assertNull(testParentNode.getRightChild().getData());
	}

}
