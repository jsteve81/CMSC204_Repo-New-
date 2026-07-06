import java.util.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DictionaryBuilderTestStudent {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
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

	// Testing every method and constructors
	@Test
	void testConstructorWithArgs1() { // int estimatedEntries
	DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		assertEquals(0, testDictionary.getTotalWordCount());
        assertEquals(0, testDictionary.getUniqueWordCount());
	}
	
	@Test
	void testConstructorWithArgs2() throws Exception { 
		File testFile = new File("test.txt");
		PrintWriter testWriter = new PrintWriter(testFile);
        testWriter.println("All work and no play makes Fred a dull boy."); // no duplicates
        testWriter.println("All work and no play makes Fred a dull boy."); // all duplicates
        testWriter.close();

        // Call to String filename constructor
        DictionaryBuilder testDictionary = new DictionaryBuilder("test.txt");
        
        assertEquals(20, testDictionary.getTotalWordCount());
        assertEquals(10, testDictionary.getUniqueWordCount()); // 2nd line not counted as unique
	}
	
	@Test
	void testAddWord() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		assertEquals(0, testDictionary.getTotalWordCount()); 
	    assertEquals(0, testDictionary.getUniqueWordCount());
		testDictionary.addWord("March");
		testDictionary.addWord("April");
		testDictionary.addWord("april"); // duplicate
		testDictionary.addWord("ApRil!"); // duplicate
		testDictionary.addWord("May");
		testDictionary.addWord("June");


        assertEquals(6, testDictionary.getTotalWordCount()); // 4 unique + 2 duplicates = 6 total
        assertEquals(4, testDictionary.getUniqueWordCount());
	}
	
	@Test
	void testRemoveWord() throws Exception {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		testDictionary.addWord("lambda");
		   assertEquals(1, testDictionary.getTotalWordCount()); 
	       assertEquals(1, testDictionary.getUniqueWordCount());
	       assertEquals(1, testDictionary.getFrequency("lambda"));
		
		testDictionary.removeWord("lambda"); // adding and removing affects 3 methods

		   assertEquals(0, testDictionary.getTotalWordCount()); 
	       assertEquals(0, testDictionary.getUniqueWordCount());
	       assertEquals(0, testDictionary.getFrequency("lambda"));
	}
	
	@Test
	void testGetFrequency() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		testDictionary.addWord("red");
		testDictionary.addWord("blue");
		testDictionary.addWord("Blue");

        assertEquals(1, testDictionary.getFrequency("red"));
        assertEquals(2, testDictionary.getFrequency("blue"));
        assertEquals(2, testDictionary.getFrequency("Blue")); // case insensitive

	}
	
	@Test
	void testGetAllWords() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		testDictionary.addWord("future");
		testDictionary.addWord("constitution");
		testDictionary.addWord("python");


        List<String> testWords = testDictionary.getAllWords();

        // array placement is dependent on alphabetical order, so c -> f -> p

        assertEquals("constitution", testWords.get(0));
        assertEquals("future", testWords.get(1));
        assertNotEquals("future", testWords.get(2)); // wrong array index
        assertEquals("python", testWords.get(2));

	}
	
	// Testing all helper methods
	@Test
	void testCreateHashTable() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		// tested by constructors
        assertNotNull(testDictionary);
	}
	
	@Test
	void testSimplifyWord() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		testDictionary.addWord("supeR!@!#$&$^@#*8"); // full of special characters and numbers
		
        assertEquals(1, testDictionary.getFrequency("super"));
        assertEquals(1, testDictionary.getFrequency("supeR!@!#$&$^@#*8")); 
        // second line is NOT stored in the dictionary after it's simplified

	}
	
	@Test
	void testHasher() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		testDictionary.addWord("water");
        assertTrue(testDictionary.getFrequency("water") > 0); // hash code must be positive because of abs value (math)
	}
	
	@Test
	void testNext4KPlus3Prime() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		// tested by constructors
        assertNotNull(testDictionary);
	}
	
	@Test
	void testIsPrime() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		// tested by constructors
        assertNotNull(testDictionary);
        
        // in addition, this method was already given
	}
	
	@Test
	void testGetTotalWordCount() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		testDictionary.addWord("basketball");
        testDictionary.addWord("football");
        testDictionary.addWord("soccer");
        testDictionary.addWord("rugby");


        assertEquals(4, testDictionary.getTotalWordCount());
	}
	
	@Test
	void testGetUniqueWordCount() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		testDictionary.addWord("basketball");
        testDictionary.addWord("football");
        testDictionary.addWord("soccer");
        testDictionary.addWord("soccer");


        assertEquals(3, testDictionary.getUniqueWordCount());
        assertNotEquals(4, testDictionary.getUniqueWordCount()); // second instance of word "soccer" is omitted

	}
	
	@Test
	void testGetLoadFactor() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
	    assertTrue(testDictionary.getLoadFactor() == 0); // with no words, lambda = 0. 0 / 0.6 = 0.
		
		testDictionary.addWord("load");
	    assertTrue(testDictionary.getLoadFactor() > 0); // every word increases the load factor.
	}
	// Edge cases
	
	@Test
    void testAddEmptyString() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
		testDictionary.addWord("!!!");
        assertEquals(0, testDictionary.getTotalWordCount());
        testDictionary.addWord("");
        assertEquals(0, testDictionary.getTotalWordCount()); // these entries don't count.
    }

    @Test
    void testRemoveNonExistentWord() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
        assertThrows(DictionaryEntryNotFoundException.class, () -> {
        	testDictionary.removeWord("mansion"); // this word was never added 
        });
        assertNotEquals(-1, testDictionary.getTotalWordCount());
    }

    @Test
    void testCaseInsensitivity() {
		DictionaryBuilder testDictionary = new DictionaryBuilder(100); // calls int estimatedEntries constructor
        testDictionary.addWord("PRESSURE");
        assertEquals(1, testDictionary.getFrequency("pressure")); // already mostly covered in previous tests
    }
}
