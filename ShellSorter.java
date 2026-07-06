import java.util.*;   // Imports utility classes like Arrays and Scanner
import java.io.*;    // Imports input/output classes (not heavily used here)

public class ShellSorter {

    int[] theArray;  // Array to hold the integers to be sorted
    int size;        // Size of the array

    // Method to perform Shell Sort on the array
    public void sort() {
        int inner, outer, temp;
        int interval = 1; // Initial gap (interval)

        // Calculate initial interval using Knuth's formula: h = 3*h + 1
        while (interval <= size / 3)
            interval = interval * 3 + 1;

        // Start sorting with decreasing intervals
        while (interval > 0) {

            // Loop through the array with the current interval
            for (outer = interval; outer < size; outer++) {

                temp = theArray[outer]; // Store the current value
                inner = outer;

                // Perform a gapped insertion sort
                // Shift elements that are greater than temp to the right
                while (inner > interval - 1 && theArray[inner - interval] >= temp) {
                    theArray[inner] = theArray[inner - interval];
                    inner -= interval;
                }

                // Place temp in its correct location
                theArray[inner] = temp;
            }

            // Reduce the interval for the next pass
            interval = (interval - 1) / 3;
        }
    }

    // Constructor to initialize array and fill it with random values
    public ShellSorter(int size) {
        this.size = size;
        theArray = new int[size];
        generateRandomArray(); // Fill array with random numbers
    }

    // Generates random integers between 1 and 500
    public void generateRandomArray() {
        for (int i = 0; i < size; i++) {
            theArray[i] = (int) (Math.random() * 500) + 1;
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask user for array size
        System.out.println("Enter the array size:");
        int size = input.nextInt();

        // Create ShellSorter object
        ShellSorter shell = new ShellSorter(size);

        // Print array before sorting
        System.out.println("Before: " + Arrays.toString(shell.theArray));

        // Sort the array
        shell.sort();

        // Print array after sorting
        System.out.println("After:  " + Arrays.toString(shell.theArray));
    }
}