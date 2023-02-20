package dccnLab;

import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String args[]) {
        ServerSocket s = null;
        Socket c;

        String line;
        DataInputStream is = null, is1 = null;
        PrintStream os = null;

        try {
            s = new ServerSocket(2023);
            c = s.accept();

            is = new DataInputStream(c.getInputStream());
            is1 = new DataInputStream(System.in);
            os = new PrintStream(c.getOutputStream());

            do {
                line = is.readLine();
                System.out.println("Client: " + line);
                System.out.print("Server: ");

                line = is1.readLine();
                os.println(line);
            } while(line.equalsIgnoreCase("quit") == false);

            is.close();
            os.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
