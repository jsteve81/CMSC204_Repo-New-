import java.util.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DictionaryShellTestStudent {

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

	// Testing every operation in main + no arg constructor
	@Test
	void testNoArgConstructor() {
		 DictionaryShell testShell = new DictionaryShell();
	     assertNotNull(testShell); // creates new object
	}
	
	@Test
	void testMainMethodAdd() {
		// this is what the user enters during an actual program run
		String userInput = "add book \n exit \n"; // user has to create new lines in main 
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        DictionaryShell.main(new String[]{});
        // calling main method with empty string array
        
        /*.setIn and .main are commands for testing the main method in Java, articles will be included in writeup
         this is the 1st time I have ever done this in a project. */
         
	}
	
	@Test
	void testMainMethodDelete() {
		// user has to add and exit for every test
		String userInput = "add book \n delete book \n exit \n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        DictionaryShell.main(new String[]{});
	}
	
	@Test
	void testMainMethodSearch() {
		String userInput = "add book \n search book \n exit\n";
	    System.setIn(new ByteArrayInputStream(userInput.getBytes()));
	    DictionaryShell.main(new String[]{});
	}
	
	@Test
	void testMainMethodList() {
		String userInput = "add book \n list \n exit\n";
	    System.setIn(new ByteArrayInputStream(userInput.getBytes()));
	    DictionaryShell.main(new String[]{});
	}
	
	@Test
	void testMainMethodStats() {
		String userInput = "add book \n stats \n exit\n";
	    System.setIn(new ByteArrayInputStream(userInput.getBytes()));
	    DictionaryShell.main(new String[]{});
	}
	
	@Test
	void testMainMethodExit() {
		String userInput = "exit \n";
	    System.setIn(new ByteArrayInputStream(userInput.getBytes()));
	    DictionaryShell.main(new String[]{});
	}
	// Edge cases 
	
	// exception functionality
	@Test
	void testFileNotFoundException() {
        DictionaryShell.main(new String[]{"nonexistentTestFile.txt"});
        // file does not exist, so a FileNotFoundException will be thrown
	}
	
	@Test
	void testDictionaryEntryNotFoundException() {
		String userInput = "delete book \n exit \n"; // word was never added
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        DictionaryShell.main(new String[]{});
	}
	
	@Test
	void testNullUserInput() {
		String userInput = "\n exit \n"; // nothing
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        DictionaryShell.main(new String[]{});
	}
	
	@Test
	void testIncompleteUserInput() {
		String userInput = "add \n exit \n"; // missing the word after "add"
	    System.setIn(new ByteArrayInputStream(userInput.getBytes()));
	    DictionaryShell.main(new String[]{});
	}
	
	@Test
	void testInvalidUserInput() {
		String userInput = "xyz\n exit \n"; // missing the word after "add"
	    System.setIn(new ByteArrayInputStream(userInput.getBytes()));
	    DictionaryShell.main(new String[]{});
	}
	
	@Test
	void testMultipleCommands() { // repeated use of a command operation
		String userInput = "add shark \n add puppy \n add robot \n exit \n"; 
	    System.setIn(new ByteArrayInputStream(userInput.getBytes()));
	    DictionaryShell.main(new String[]{});
	}


}
