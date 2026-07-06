import java.util.*;
import java.io.*;
import java.net.*;
// imports

public class SocketServerTutorial {
public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter a port: ");
    int port = userInput.nextInt();

    try (ServerSocket myServerSocket = new ServerSocket(port)) {
        System.out.println("Server started on port " + port);

        boolean alwaysTrue = true;
        while (alwaysTrue == true) {
            Socket mySocket = myServerSocket.accept();
            System.out.println("Client successfully connected!");

            BufferedReader buff = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            PrintWriter print = new PrintWriter(mySocket.getOutputStream(), true);

            String line;
            while ((line = buff.readLine()) != null) {
                System.out.println("Received: " + line);
                print.println("Echo: " + line);

                if (line.equalsIgnoreCase("bye") == true) {
                    break; // end conversation
                }
            }

            mySocket.close();
            userInput.close(); // closing resources to prevent leaks
            System.out.println("Client successfully disconnected!");
        }
    } catch (IOException exception) {
        exception.printStackTrace();
    } catch (Exception exception) { // exception handling, specific and general
        exception.printStackTrace();
    }
}

}
