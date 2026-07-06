import java.util.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterTestStudent {

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

	// Testing every method and constructors + edge/special cases
	
	// I am omitting testing methods that were already tested in the public tests to avoid redundancy
	
	@Test
	void testNoArgConstructor() {
		MorseCodeConverter testConverter = new MorseCodeConverter();
        assertNotNull(testConverter); // this creates a new converter object for use in the class
	}
	
	@Test
	void testConvertToMorseString() {
		String input = "sos"; // basic input
        String expected = "... --- ...";  // basic output
        // we can translate the string to morse code manually and see if program comes up with the same
        assertEquals(expected, MorseCodeConverter.convertToMorseString(input));
	}

	@Test
	void testConvertToMorseFile() throws FileNotFoundException {
		File testFile = new File("morseTest.txt");
        PrintWriter testWriter = new PrintWriter(testFile);
        testWriter.println("sos");
        testWriter.close();

        String expected = "... --- ...";
        String actual = MorseCodeConverter.convertToMorseFile("morseTest.txt");

        assertEquals(expected, actual);
	}

	// Edge cases
	
	@Test
	void testConvertToEnglishStringNullInput() {
		assertThrows(NullPointerException.class, () -> {
			MorseCodeConverter.convertToEnglish((String) null); // we can't enter a null string
        });
		// unfortunately to comply with the project description I could not use the try-catch block.
	}
	
	@Test
	void testConvertToEnglishFileNotFound() {
		assertThrows(FileNotFoundException.class, () -> {
            MorseCodeConverter.convertToEnglish(new File("imaginary.txt"));
        });
	}
	
	// e.g. the .txt file has integers or other data types instead of strings.
	@Test
	void testConvertToEnglishFileBadFileContents() throws FileNotFoundException {
		File testFile = new File("morseTest.txt");
        PrintWriter testWriter = new PrintWriter(testFile);
        testWriter.println("388593 !&%*(%#(*&#*%^($&^#*%^$");
        testWriter.close();

        String testResult = MorseCodeConverter.convertToEnglish(testFile);

        assertNotNull(testResult); // should not crash
	}
	
	@Test
	void testConvertToMorseStringNullInput() {
		assertThrows(NullPointerException.class, () -> {
            MorseCodeConverter.convertToMorseString(null);
        });
	}
	
	@Test
	void testConvertToMorseFileNotFound() {
		assertThrows(FileNotFoundException.class, () -> {
            MorseCodeConverter.convertToMorseFile("missingFile.txt");
        });
	}

	@Test
	void testConvertToStringInvalidMorse() {
		String testInput = "ehrukjbdmbmadbf "; // invalid words/input
        String testResult = MorseCodeConverter.convertToMorseString(testInput);

        assertNotNull(testResult); // unexpected result
	}
	
	// e.g. the .txt file has integers or other data types instead of strings.
	@Test
	void testConvertToMorseFileBadFileContents() throws FileNotFoundException {
		 File testFile = new File("morseTest.txt");
		 PrintWriter testWriter = new PrintWriter(testFile);
         testWriter.println("737495938849865985798578094");
         testWriter.close();

	     String testResult = MorseCodeConverter.convertToMorseFile("morseTest.txt"); // pass String directly
   	     assertEquals("", testResult.trim()); // since numbers can't be converted to morse code, the result is null.
	}

}
