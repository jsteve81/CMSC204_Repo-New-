/* Name: Javaughn Stevens
 * Date: 4/18/26
 * Assignment: Project 5 Morse Code CMSC 204
 * Term: Spring 2026
 * Instructor: Professor Gary Thai
 * Integrity Acknowledgement: This code is my original work, and 
 * I have not included source code from the Internet, AI generated nor from another student for this project.
 */

import java.util.*;
import java.io.*;

// Javadoc comments
/**
 * The MorseCodeConverter class provides methods to convert between
 * English text and Morse code. It uses a MorseCodeTree to decode
 * Morse code into English text and a HashMap to encode English characters back into Morse code.
 */
public class MorseCodeConverter {
    private static MorseCodeTree codeTree = new MorseCodeTree();
    private static Map<String, String> englishToMorse;

    /**
     * No-arg constructor for the MorseCodeConverter class.
     */
    // No-arg constructor
    public MorseCodeConverter() {
    }

    /**
     * Returns a string representation of the Morse code tree
     * after the traversal
     *
     * @return a space-separated and trimmed string of the Morse code tree 
     */
    public static String printTree() {
        ArrayList<String> treeList = codeTree.toArrayList();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < treeList.size(); i++) {
            result.append(treeList.get(i));
            result.append(" ");
        }

        return result.toString().trim();
    }

    /**
     * Converts a given Morse code string into English text.
     * Words in Morse code are separated by slash characters "/" that represent spaces and English letters by spaces " ".
     *
     * @param code the Morse code string to convert
     * @return the English string that was translated
     * @throws NullPointerException if the input code is null
     */
    public static String convertToEnglish(String code) {
        if (code == null) {
            throw new NullPointerException();
        }

        StringBuilder result = new StringBuilder();
        String[] words = code.split(" / ");

        for (int a = 0; a < words.length; a++) {
            String[] letters = words[a].split(" ");
            for (int b = 0; b < letters.length; b++) {
                result.append(codeTree.fetch(letters[b]));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    /**
     * Converts the contents of a file containing Morse code into English text.
     * The words are separated by spaces " ".
     *
     * @param testFile the MorseCode file
     * @return the English string that was translated and trimmed
     * @throws FileNotFoundException if the file cannot be found
     */
    public static String convertToEnglish(File testFile) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        Scanner input = new Scanner(testFile);

        while (input.hasNextLine() == true) {
            String line = input.nextLine();
            result.append(convertToEnglish(line));
            result.append(" ");
        }

        input.close(); // to prevent resource leaks
        return result.toString().trim();
    }

    /**
     * Converts an English text string into Morse code.
     * Spaces in English are represented as slash characters "/" in Morse code.
     *
     * @param english the English string to convert
     * @return the Morse code that was translated and trimmed
     * @throws NullPointerException if the input string is null
     */
    public static String convertToMorseString(String english) {
        if (english == null) {
            throw new NullPointerException();
        }

        initializeMap(); // call private method that initializes the hashMap
        StringBuilder result = new StringBuilder();
        english = english.toLowerCase(); // map only contains lowercase letters

        for (int i = 0; i < english.length(); i++) {
            char character = english.charAt(i);

            if (character == ' ') {
                result.append(" / ");
            } else {
                String morse = englishToMorse.get(String.valueOf(character));
                if (morse != null) {
                    result.append(morse).append(" ");
                }
            }
        }

        return result.toString().trim();
    }

    /**
     * Converts the English text contents of a file into Morse code.
     *
     * @param englishFile the path to the file containing the English text
     * @return the Morse code representation of the file contents that has been trimmed
     * @throws FileNotFoundException if the file cannot be found
     */
    public static String convertToMorseFile(String englishFile) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        File morseFile = new File(englishFile);
        Scanner input = new Scanner(morseFile);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            result.append(convertToMorseString(line));
            result.append(" ");
        }

        input.close();
        return result.toString().trim();
    }

    /**
     * Initializes the HashMap used to convert English characters
     * to their corresponding Morse code representations.
     * This is a helper method that is used just for additional functionality.
     */
    private static void initializeMap() {
        if (englishToMorse == null) {
            englishToMorse = new HashMap<>();
            englishToMorse.put("a", ".-");
            englishToMorse.put("b", "-...");
            englishToMorse.put("c", "-.-.");
            englishToMorse.put("d", "-..");
            englishToMorse.put("e", ".");
            englishToMorse.put("f", "..-.");
            englishToMorse.put("g", "--.");
            englishToMorse.put("h", "....");
            englishToMorse.put("i", "..");
            englishToMorse.put("j", ".---");
            englishToMorse.put("k", "-.-");
            englishToMorse.put("l", ".-..");
            englishToMorse.put("m", "--");
            englishToMorse.put("n", "-.");
            englishToMorse.put("o", "---");
            englishToMorse.put("p", ".--.");
            englishToMorse.put("q", "--.-");
            englishToMorse.put("r", ".-.");
            englishToMorse.put("s", "...");
            englishToMorse.put("t", "-");
            englishToMorse.put("u", "..-");
            englishToMorse.put("v", "...-");
            englishToMorse.put("w", ".--");
            englishToMorse.put("x", "-..-");
            englishToMorse.put("y", "-.--");
            englishToMorse.put("z", "--..");
        }
    }
}