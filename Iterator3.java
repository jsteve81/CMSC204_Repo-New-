import java.util.*;
import java.io.*;

public class Iterator3
{
	
	public static void main(String[] args) {
	List<String> nameList = new ArrayList<>();
	Iterator<String> nameIterator = nameList.iterator();
		nameList.add("James");
		nameList.add("Bryan");
		nameList.add("Richard");
		
		for (int i = 0; i < nameList.size(); i++) {
		    if (i == nameList.size() - 1) {
		        System.out.println(nameList.get(i));
		    }
		}
	}
}