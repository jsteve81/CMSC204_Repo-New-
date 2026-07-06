import java.util.*;
import java.io.*;

public class Iterator12
{
	public static void main(String[] args) {
	    Scanner input = new Scanner (System.in);
	    Random rand = new Random();
		List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        
        System.out.println("Enter size for alist and blist: ");
        int size = input.nextInt();
        input.nextLine();
        
        for (int i = 0; i < size; i++) {
            int random1 = (int) (Math.random() * 10000) + 1;
            aList.add(random1);
        }
        
        for (int i = 0; i < size; i++) {
            int random2 = (int) (Math.random() * 10000) + 1;
            bList.add(random2);
        }
        
        System.out.println(aList);
        System.out.println(bList);

        Iterator<Integer> aIterator = aList.iterator();
        Iterator<Integer> bIterator = bList.iterator();

       while (bIterator.hasNext() == true) {
           int value = bIterator.next();
           aList.add(value);
       }
       
       Collections.sort(aList);
       bList.clear(); // clears the bList.
      
        
        System.out.println("");
        System.out.println(aList);
        System.out.println(bList);

	}
}