import java.util.*;
import java.io.*;

public class Queue<T> {
     private int size = 0;
     private T[] queueArray;
     private boolean empty = true;
     private final int capacity = 999999;
     
     public Queue() {
          queueArray = (T[]) new Object[capacity];
     }
     
     public void enqueue(T item) {
          if (size == capacity) {
            throw new IllegalStateException("Queue is full.");
        }
        queueArray[size++] = item;
        empty = false;
     }
     
     public T dequeue() {
           if (isEmpty() == true) {
            throw new NoSuchElementException("The queue is empty.");
        }

        T front = queueArray[0];

        // Shift elements left
        for (int i = 1; i < size; i++) {
            queueArray[i - 1] = queueArray[i];
        }

        queueArray[--size] = null;
        return front;
     }
     
     public T getFront() throws Exception {
            if (isEmpty() == true) {
            throw new NoSuchElementException("The queue is empty.");
        }
        else 
          return queueArray[0];
     }
     
     public boolean isEmpty() {
          if (size == 0) {
               empty = true;
          } else {
               empty = false;
          }
          return empty;
     }
     
     public void clear() {
          for (int i = 0; i < size; i++) {
               queueArray[i] = null;
          }
          size = 0;
     }
}