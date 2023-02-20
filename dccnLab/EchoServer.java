package dccnLab;

import java.io.*;
import java.net.*;
import java.lang.*;

public class EchoServer {
    public static void main(String args[]) {
        ServerSocket s = null;
        Socket c;

        String line;
        BufferedReader br;
        PrintStream ps;

        try {
            s = new ServerSocket(1234);
            c = s.accept();
            br = new BufferedReader(new InputStreamReader(c.getInputStream()));
            ps = new PrintStream(c.getOutputStream());

            while(true) {
                line = br.readLine();
                System.out.println("Message received and sent back to client");
                ps.println(line);
            }
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
