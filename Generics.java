/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Generics {
public static <T> void displayArray(T[] anArray) {
    for (int i = 0; i < anArray.length; i++) {
        System.out.println(anArray[i]);
    }
}
public static void main(String[] args) {
String[] stringArray = { "apple", "banana", "carrot", "orange" };
System.out.print("stringArray contains: \n");
displayArray(stringArray);
Integer[] intArray = {2, 4, 6, 8, 10, 12};
System.out.print("\nintArray contains: \n");
displayArray(intArray);
}
}