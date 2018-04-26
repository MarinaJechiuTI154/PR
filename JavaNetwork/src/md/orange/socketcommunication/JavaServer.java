package md.orange.socketcommunication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServer {
    public static void main(String[] args) {
        int portNumber = 1234;
        ServerSocket server = null;


            try {
                 server = new ServerSocket(portNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }


        while (true) {
            try  {
                //Listent for a connection to be made to this socket
                //and accepts it. The method blocks until a connection is made
                System.out.println("Waiting for connect request...");
                Socket client = server.accept();

                System.out.println("Connection established...");
                String clientAddress = client.getInetAddress().getHostAddress();
                int port = client.getPort();
                System.out.println("Client addres: [" + clientAddress + "]\nCliet port: [" + port + "]");

                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                String clientMessage = br.readLine();
                System.out.println("Mesage received: " + clientMessage);
                if (clientMessage != null) {
                    OutputStream clientOut = client.getOutputStream();
                    PrintWriter pw = new PrintWriter(clientOut, true);
                    String serverMessage = "Hello, " + clientMessage;
                    pw.println(serverMessage);
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

    }
}


