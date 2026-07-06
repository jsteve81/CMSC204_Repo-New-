import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DictionaryEntryTestStudent {

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

	// Only one test needed, small class to implement and test
	@Test
	void testConstructorWithArgs() {
		DictionaryEntry testEntry = new DictionaryEntry("box");
        assertEquals("box", testEntry.word);
        assertEquals(1, testEntry.count);
	}

}
