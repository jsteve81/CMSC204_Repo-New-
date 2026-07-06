import java.util.*;
import java.io.*;

public class QuickSort // QuickSort uses a pivot to divide the array
{
    // Main QuickSort function
    // It sorts the portion of the array between index 'low' and 'high'
    public static void sort(int[] array, int low, int high) {

        // Base case: stop recursion when the subarray has 0 or 1 elements
        if (low < high) {

            // Partition the array and get the correct position of the pivot
            int pivotIndex = partition(array, low, high);

            // Recursively sort the left side of the pivot
            // (all values smaller than pivot)
            sort(array, low, pivotIndex - 1);

            // Recursively sort the right side of the pivot
            // (all values greater than pivot)
            sort(array, pivotIndex + 1, high);
        }
    }

    // Partition function:
    // Rearranges the array so that:
    // - all elements < pivot are on the left
    // - all elements > pivot are on the right
    // - pivot ends up in its final sorted position
    private static int partition(int[] array, int low, int high) {

        // Choose the last element as the pivot
        int pivot = array[high];

        // 'i' will track the position where the next smaller-than-pivot element goes
        // Start just before the subarray
        int i = low - 1;

        // Traverse the array from 'low' to 'high - 1'
        for (int b = low; b < high; b++) {

            // If current element is smaller than the pivot
            if (array[b] < pivot) {

                // Move the boundary of smaller elements forward
                i++;

                // Swap current element with element at index 'i'
                // This ensures all elements <= i are smaller than pivot
                int temp = array[i];
                array[i] = array[b];
                array[b] = temp;
            }
        }

        // After the loop:
        // - elements from low to i are < pivot
        // - elements from i+1 to high-1 are >= pivot

        // Place the pivot in its correct position (right after smaller elements)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Return the pivot's final index
        return i + 1;
    }
}
   
	public static void generateRandomArray(int[] array, int size) {
		for (int i = 0; i < size; i++) {
			array[i] = (int) (Math.random() * 1000) + 1;
		}
	}


	public static void main(String[] args) {
	    int pivot = 0, left = 0, right = 0, size;
		Scanner input = new Scanner (System.in);
		System.out.println("Enter array size: ");
		size = input.nextInt();
		right = size - 1;
	    input.nextLine();
		int[] array = new int[size];
		generateRandomArray(array, size);
		for (int i = 0; i < size; i++) {
		    System.out.print(array[i] + " ");
		}
		
		sort(array, left, right);
		System.out.println("");
		System.out.println("Sorted Array: ");

		
		for (int i = 0; i < size; i++) {
		    System.out.print(array[i] + " ");
		}
        
        input.close();
	}
}