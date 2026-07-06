import java.util.*;
import java.io.*;

public class Bag<T> {
    private int size = 0;
    private boolean empty = true;
    private int frequency = 0; 
    private static final int capacity = 999999;
    private T[] bagArray = (T[]) new Object[capacity];
    private T item;
    
    public Bag() {
        size = 0;
        frequency = 0;
        bagArray = (T[]) new Object[capacity];
        empty = true;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getFrequency(T item) {
        frequency = 0;
        for (int i = 0; i < size; i++) {
            if (bagArray[i].equals(item)) {
                frequency++;
            }
        }
        
        return frequency;
    }
    
    public void add (T item) {
        if (size < bagArray.length) {
            bagArray[size] = item; // adds an item to the next empty array element.
            size++;
        } else {
            System.out.println("The bag is full.");
        }
    }
    
    public T remove() {
        if (isEmpty() == true) {
            return null;
        } 
        else 
        {
        T removedItem = bagArray[size - 1];
        bagArray[size - 1] = null; // frees up space in the array
        size--;
        return removedItem;
        }
    }
    
    public boolean remove(T item) {
        if (isEmpty() == true) {
            return false;
        } 
        
        for (int i = 0; i < size; i++) {
        if (bagArray[i].equals(item)) {
            bagArray[i] = bagArray[size - 1]; // replace with previous element
            bagArray[size - 1] = null;
            size--;
            return true;
        }
        }
        return false;
    }
    
    public boolean isEmpty() {
        if (size == 0) {
            empty = true;
            return empty;
        } else {
            empty = false;
            return empty;
        }
    }
    
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (bagArray[i].equals(item)) {
                return true;
            }
        }
        
        return false;
    }
    
    public void clear() {
        for (int i = 0; i < size; i++) {
            bagArray[i] = null;
        }
        size = 0;
    }
    
    public T[] toArray() {
        T[] arrayCopy = (T[]) new Object[size];
        
        for (int i = 0; i < size; i++) {
            arrayCopy[i] = bagArray[i];
        }
        
        return arrayCopy;
    }
    
    public void display() {
    if (isEmpty() == true) {
        System.out.println("The bag is empty.");
        return;
    }

    for (int i = 0; i < size; i++) {
        System.out.println(bagArray[i]);
    }
}
}