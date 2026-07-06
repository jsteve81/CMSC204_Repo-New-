import java.util.*;
import java.io.*;

// This is an implementation using threads to achieve the same result.
public class ThreadImplementation {

	// this is the driver as it has the main method.
	public static void main(String[] args) {
		MyRunnableThreads thread1 = new MyRunnableThreads("Displaying the character 'a' 100x...");
		MyRunnableThreads thread2 = new MyRunnableThreads("Displaying the character 'b' 100x...");
		MyRunnableThreads thread3 = new MyRunnableThreads("Counting down from 100 to 1...");
		
		// representation of the 3 threads.
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		Thread t3 = new Thread(thread3);
		
		// starting the threads
		t1.start();
		t2.start(); // each thread has a different function
		t3.start();
	}
	
	/* Some possible benefits of using this implementation over the basic one is that it can possibly track something
	 * in real time. Additionally, the classes are much more compact and if one were to write "cleaner" code than I did,
	 * it could be even more efficient.
	 */
}
