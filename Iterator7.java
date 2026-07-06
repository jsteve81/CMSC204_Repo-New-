import java.util.*;
import java.io.*;

public class Iterator7
{
	
	public static void main(String[] args) {
	List<String> nameList = new ArrayList<>();
	List<String> newNameList = new ArrayList<>();
	Iterator<String> nameIterator = nameList.iterator();
		nameList.add("James");
		nameList.add("Bryan");
		nameList.add("Richard");
		nameList.add("Ruby");
		nameList.add("Bryan");
		nameList.add("Richard");
		
		
		for (String name : nameList) {
		   if (newNameList.contains(name) == false) {
		       newNameList.add(name);
		   }
		}
		
		    System.out.println(newNameList);
	}
}