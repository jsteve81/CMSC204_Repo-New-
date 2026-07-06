import java.util.*;
import java.io.*;
import java.net.*;

public class SimpleSocketClient {
public static void main(String[] args) {

// user gives port and host name
Scanner userInput = new Scanner(System.in);
System.out.println("Enter a port: ");
int port = userInput.nextInt();
userInput.nextLine();
System.out.println("Enter a the host name: ");
String host = userInput.nextLine();
userInput.nextLine();

    try (Socket mySocket = new Socket(host, port)) {
        BufferedReader consoleReader = new BufferedReader(
                new InputStreamReader(System.in));
        BufferedReader buff = new BufferedReader(
                new InputStreamReader(mySocket.getInputStream()));
        PrintWriter print = new PrintWriter(mySocket.getOutputStream(), true);

        System.out.println(host + " has successfully connected to server. Type messages:");
        String input;
        while ((input = consoleReader.readLine()) != null) {
            System.out.println(input);
            String response = buff.readLine();
            System.out.println("Server: " + response);

            if (input.equalsIgnoreCase("bye")) {
                break;
            }
    }
            userInput.close(); // closing resources to prevent leaks
    } catch (IOException exception) {
        exception.printStackTrace();
    } catch (Exception exception) { // exception handling, specific and general
        exception.printStackTrace();
    }
    
    
}

}
