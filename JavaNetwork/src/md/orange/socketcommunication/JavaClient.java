package md.orange.socketcommunication;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class JavaClient {
    public static void main(String[] args) {
        int port = 1234;
        InetAddress localHost = null;
        Socket client = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                 client = new Socket("192.168.55.188", 1234);
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("Enter your name: ");
                String msg = consoleIn.readLine();

                //send the message read from console to the server
                pw.println(msg);

                System.out.println("Message returned from the server: " + br.readLine());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
