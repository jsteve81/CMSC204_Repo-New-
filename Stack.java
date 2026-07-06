import java.util.*;
import java.io.*;

public class Stack<T> {
     private int size;
     private boolean empty = true;
     private T[] stackArray;
     private int capacity = 999999;
     
     // No-arg constructor
     public Stack() {
          size = 0;
          empty = true;
          stackArray = (T[]) new Object[capacity];
     }
     
     public void push(T newEntry) {
          if (size == stackArray.length) {
               resize();
          }
          stackArray[size++] = newEntry;
          empty = false;
     }
     
     public T pop() {
          if (isEmpty() == true) {
               throw new EmptyStackException();
          }
          T temp = stackArray[--size];
          stackArray[size] = null;
          size--;
          
          if (size == 0) {
               empty = true;
          }
          return temp;
     }
     
     public T peek() {
          if (isEmpty() == true) {
               throw new EmptyStackException();
          }
          return stackArray[size - 1];
     }
     
     public boolean isEmpty() {
          if (size == 0) {
               empty = true;
          } else {
               empty = false;
          }
          return empty;
     }
     
     public void toArray() {
          for (int i = 0; i < size; i++) {
               System.out.println(stackArray[i]);
          }
     }
     
     private void resize() {
          T[] newArray = (T[]) new Object[stackArray.length * 2];
          
          for (int i = 0; i < size; i++) {
               newArray[i] = stackArray[i];
          }
          
          stackArray = newArray;
     }
}