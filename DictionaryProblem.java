import java.util.*;
import java.io.*;

public class DictionaryProblem // Contact Manager
{
    private String name;
    private String phoneNum;
    private HashMap<String, String> dictionaryDirectory;
    
    // No-arg constructor
    public DictionaryProblem() {
        dictionaryDirectory = new HashMap<>();
    }
    
    // constructor with args
    public DictionaryProblem(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public void addContact(String name, String phoneNum) {
     
        if (dictionaryDirectory.containsKey(name) == true) {
            dictionaryDirectory.put(name, phoneNum);
            System.out.println(name + " is already a contact. Updating their info....");
        } else {
            dictionaryDirectory.put(name, phoneNum);
            System.out.println(name + " has been added as a new contact.");
        }
    }
    
    public void displayContacts() {
        if (dictionaryDirectory.isEmpty() == true) {
            System.out.println("No contacts.");
        } else {
            for (String name : dictionaryDirectory.keySet()) {
                System.out.println("Name: " + name);
                System.out.println("Phone Number: " + dictionaryDirectory.get(name));
                System.out.println("");
            }
        }
    }
    public static void main (String[] args) {
	DictionaryProblem contactMan = new DictionaryProblem();
	
    contactMan.addContact("Alice", "123-4567");
	contactMan.addContact("Gary", "985-2645");
	contactMan.addContact("Alice", "894-2837");
	contactMan.displayContacts();
	
    }
    
    
}

