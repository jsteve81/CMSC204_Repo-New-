import java.util.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTestStudent {

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

	// Testing every method, constructor + edge/special cases
	
	@Test
	void testNoArgConstructor() {
		MorseCodeTree testTree = new MorseCodeTree();
		assertNotNull(testTree); // new object is created and is recognized/valid
        assertNotNull(testTree.getRoot());
        assertEquals("", testTree.getRoot().getData());
	}
	
	@Test
	void testAddNode() {
		MorseCodeTree testTree = new MorseCodeTree();

	    // custom node
	    testTree.addNode(testTree.getRoot(), "--.-.-", "custom");
	    assertEquals("custom", testTree.fetch("--.-.-"));

	    // overwriting an existing node on the left side
	    testTree.addNode(testTree.getRoot(), ".", "x");
	    assertEquals("x", testTree.fetch("."));

	    // single-character insert on the right side
	    testTree.addNode(testTree.getRoot(), "-", "y");
	    assertEquals("y", testTree.fetch("-"));
	}
	
	@Test
	void testBuildTree() {
		MorseCodeTree testTree = new MorseCodeTree();
		assertEquals("e", testTree.fetch("."));
        assertEquals("t", testTree.fetch("-"));
        assertEquals("i", testTree.fetch(".."));
        assertEquals("a", testTree.fetch(".-"));
        assertEquals("n", testTree.fetch("-."));
        assertEquals("m", testTree.fetch("--")); // do the characters map correctly?
	}
	
	@Test
	void testDelete() throws Exception {
		MorseCodeTree testTree = new MorseCodeTree();
		assertThrows(UnsupportedOperationException.class, () -> { // operation is not possible
            testTree.delete("c");
        });
		assertThrows(UnsupportedOperationException.class, () -> {
            testTree.delete("y");
        });
		assertThrows(UnsupportedOperationException.class, () -> {
            testTree.delete("3");
        });
	}
	
	@Test
	void testFetch() {
		MorseCodeTree testTree = new MorseCodeTree();
		assertEquals("s", testTree.fetch("...")); // fetching returns the appropriate letter's morse code
	    assertEquals("o", testTree.fetch("---"));
	    assertEquals("l", testTree.fetch(".-.."));
	}
	
	@Test
	void testFetchNode() {
		MorseCodeTree testTree = new MorseCodeTree();
		assertEquals("h", testTree.fetchNode(testTree.getRoot(), "...."));
	    assertEquals("b", testTree.fetchNode(testTree.getRoot(), "-..."));
	}
	
	@Test
	void testGetRoot() {
		MorseCodeTree testTree = new MorseCodeTree();
		assertNotNull(testTree.getRoot());
	    assertEquals("", testTree.getRoot().getData()); // root is empty, not null
	}
	
	@Test
	void testInsert() {
		MorseCodeTree testTree = new MorseCodeTree();
		testTree.insert(".--.-", "test");
	    assertEquals("test", testTree.fetch(".--.-")); // can be fetched after insertion
	}
	
	@Test
	void testLNROutputTraversal​() {
		MorseCodeTree testTree = new MorseCodeTree();
		ArrayList<String> list = new ArrayList<>();
        testTree.LNRoutputTraversal(testTree.getRoot(), list);

        assertTrue(list.size() > 0);
        assertTrue(list.contains("e"));
        assertTrue(list.contains("t"));
	}
	
	@Test
	void testSetRoot() {
		MorseCodeTree testTree = new MorseCodeTree();
		TreeNode<String> newRoot = new TreeNode<>("root");
        testTree.setRoot(newRoot);
        assertEquals("root", testTree.getRoot().getData());
	}
	
	@Test
	void testToArrayList() {
		MorseCodeTree testTree = new MorseCodeTree();
		ArrayList<String> testList = testTree.toArrayList();

        assertTrue(testList.contains("a")); // test functionality of the arraylist after it's populated
        assertTrue(testList.contains("z"));
        assertTrue(testList.contains("s"));
        assertTrue(testList.size() > 0);
	}
	
	@Test
	void testUpdate() throws Exception {
		MorseCodeTree testTree = new MorseCodeTree();
		assertThrows(UnsupportedOperationException.class, () -> {
            testTree.update(); // update is not supported but could realistically be implemented 
        });
	}
	
	// Edge cases
	
	@Test
	void testFetchEmptyString() {
	    MorseCodeTree testTree = new MorseCodeTree();
		assertNotNull(testTree.getRoot());
	    assertEquals("", testTree.fetch("")); // root is empty but not null
	}
	
	@Test
	void testFetchInvalidMorse() {
	    MorseCodeTree testTree = new MorseCodeTree();
		assertNotNull(testTree.getRoot());
	    assertThrows(NullPointerException.class, () -> {
	        testTree.fetch("-...-"); // this morse code does not map to a letter, so it throws NullPointerException
	    });
	}

	@Test
	void testAddEmptyNotNullNode() {
	    MorseCodeTree testTree = new MorseCodeTree();
	    testTree.addNode(testTree.getRoot(), "", "x");
	    assertEquals("", testTree.getRoot().getData()); // node is empty so the data is also empty.
	}
	
	@Test
	void testInsertOverwriteExisting() {
	    MorseCodeTree testTree = new MorseCodeTree();
	    assertEquals("e", testTree.fetch(".")); 
	    testTree.insert(".", "z");
	    assertEquals("z", testTree.fetch(".")); // we can override existing nodes manually
	}
	
	@Test
	void testMorseCodeTreeNullRoot() {
	    MorseCodeTree testTree = new MorseCodeTree();
	    assertNotNull(testTree.getRoot());
	    testTree.setRoot(null);
		assertNull(testTree.getRoot()); // confirming root is null
	    ArrayList<String> testList = new ArrayList<>();
	    testTree.LNRoutputTraversal(testTree.getRoot(), testList);
	    assertEquals(0, testList.size()); // null root node can't populate the test list
	}
	
	@Test
	void testToArrayListWithOverwrittenRoot() {
	    MorseCodeTree testTree = new MorseCodeTree();
	    TreeNode<String> testRoot = new TreeNode<>("only");
	    testTree.setRoot(testRoot); // we manually set the root, this tests how it interacts with the tree traversal
	    ArrayList<String> testList = testTree.toArrayList();
	    assertEquals(1, testList.size()); // this populates the ArrayList
	    assertEquals("only", testList.get(0)); // the root is the first element in the ArrayList
	}
	
	@Test
	void testAddNodeCustomCreation() {
	    MorseCodeTree testTree = new MorseCodeTree();
	    testTree.addNode(testTree.getRoot(), "...---...", "sos");
	    assertEquals("sos", testTree.fetch("...---...")); // we can also just make our own nodes without overwriting
	}
	
	@Test
	void testFetchAndOverwriteWithSingleCharacter() {
	    MorseCodeTree testTree = new MorseCodeTree();
	    testTree.insert(".", "o");
	    testTree.insert("-", "f"); // we can insert single characters to represent the morse code.
	    assertEquals("o", testTree.fetch("."));
	    assertEquals("f", testTree.fetch("-"));
	}
}
