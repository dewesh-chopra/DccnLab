package dccnLab;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String args[]) {
        Socket c = null;

        String line;
        BufferedReader br1, br2;
        PrintStream os;

        try {
            c = new Socket("localhost",1234);
            os = new PrintStream(c.getOutputStream());
            br1 = new BufferedReader(new InputStreamReader(System.in));
            br2 = new BufferedReader(new InputStreamReader(c.getInputStream()));

            do {
                System.out.print("Client message: ");
                line = br1.readLine();
                os.println(line);

                if(!line.equals("Exit successful")) {
                    System.out.println("Server reply: " + br2.readLine());
                }
            } while(!line.equals("exit"));
        } catch(IOException e) {
            System.out.println("Socket closed successfully");
        }
    }
}
