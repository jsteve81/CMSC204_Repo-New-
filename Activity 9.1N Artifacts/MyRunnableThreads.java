import java.util.*;
import java.io.*;

public class MyRunnableThreads implements Runnable {
	private static final int repeats = 100; // how many times will the thread run
	private static final int delay = 100; // in ms
	private String task;
	
	// Constructor with args
	public MyRunnableThreads(String newTask) {
		task = newTask;
	}
	
	// from interface
	
	// all threads will run in inconsistent patterns, not completely perfect unless other functions are added.
	public void run() { // no arg function.
		try { // try-catch must have clauses for each type of task, implemented individually.
			if (task.equalsIgnoreCase("Displaying the character 'a' 100x...")) {
				// in larger project a specific string may not work.
				for (int i = 0; i < repeats; i++) {
                    System.out.print("a ");
                    Thread.sleep(delay); // delay between thread runs.
                }
			} else if (task.equalsIgnoreCase("Displaying the character 'b' 100x...")) {
				for (int i = 0; i < repeats; i++) {
                    System.out.print("b ");
                    Thread.sleep(delay);
                }
			} else if (task.equalsIgnoreCase("Counting down from 100 to 1...")){
				for (int i = 100; i >= 1; i--) {
                    System.out.println(i + " ");
                    Thread.sleep(delay);
                }
			}
		} catch (IllegalThreadStateException exception) { // another kind of exception I learned from Eclipse, not used here
			System.out.println(exception.getMessage());
		} catch (InterruptedException exception) { // exception handling
			System.out.println(exception.getMessage());
		} catch (Exception exception) { // general exception handling
			System.out.println(exception.getMessage());
		}
	}
	
} 