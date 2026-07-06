import java.util.*;
import java.io.*;

public class Set3
{
	Set<Integer> set1 = new TreeSet<>();
	Set<Integer> set2 = new TreeSet<>();
	Set<Integer> set3 = new TreeSet<>();
	
	public void main (String[] args) {
	    Set3 setC = new Set3();
	    Scanner input = new Scanner (System.in);
	    System.out.println("How big do you want each set to be?");
	    int size = input.nextInt();
	    input.nextLine();
	    
	    for (int i = 0; i < size; i++) {
	        System.out.println("Enter set A element " + (i + 1));
	        int element = input.nextInt();
	        input.nextLine();
	        setC.set1.add(element);
	    }
	    
	     for (int i = 0; i < size; i++) {
	        System.out.println("Enter set B element " + (i + 1));
	        int element = input.nextInt();
	        input.nextLine();
	        setC.set2.add(element);
	    }

	    System.out.println("What operation do you want to use and determine set C?");
	    System.out.println("1 - Intersection");
	    System.out.println("2 - Union");
	    System.out.println("3 - Difference");
	    int userChoice = input.nextInt();
        input.nextLine();
        
        if (userChoice == 1) { // only elements present in both sets get added to set C.
            
            setC.set3.clear(); 
            for (Integer element : setC.set1) {
                if (setC.set2.contains(element)) {
                    setC.set3.add(element);
                }
            }
            System.out.println("Intersection of sets: " + setC.set3);
        }
        
        if (userChoice == 2) { // elements present in either or both sets get added to set C.
            setC.set3.clear();
            setC.set3.addAll(setC.set1); // Add all elements from set1 and set2
            setC.set3.addAll(setC.set2); 
            System.out.println("Union of sets: " + setC.set3);

        }
        
        if (userChoice == 3) { // elements present in set A but not set B get added to set C.
            setC.set3.clear(); // Clear set3 before starting
            for (Integer element : setC.set1) {
                if (!setC.set2.contains(element)) {
                    setC.set3.add(element);
                }
            }
            System.out.println("Difference (set1 - set2): " + setC.set3);
        
        }
        
        input.close();
	}


}