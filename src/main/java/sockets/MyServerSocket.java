package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

    private ServerSocket serverSocket;

    public MyServerSocket(int portNum) {
        try {
            this.serverSocket = new ServerSocket(portNum);

            System.out.println(String.format("Waiting for connections on port %d", portNum));
            //Listening for clients connecting to our serverSocket - this method blocks
            Socket clientSocket = serverSocket.accept();


            System.out.println(String.format("Client with IP %s and port %d has now connected", clientSocket.getInetAddress(), clientSocket.getPort()));
            //create the outputStream to send data to client
            PrintWriter outputStream = new PrintWriter(clientSocket.getOutputStream(), true);

            //Create the input stream
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line = "";

            while(!clientSocket.isClosed()) {
                line = inputStream.readLine();
                if(line == null) continue;

                System.out.println(String.format("Clients says: %s", line));

                if(line.equals("Hey")) {
                    outputStream.println("Hey!");
                }
                else if(line.equals("Shake")) {
                    outputStream.println("That booty?");
                }
                else {
                    outputStream.println("Sorry I don't understand.");
                }
            }

            serverSocket.close();
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        MyServerSocket myServerSocket = new MyServerSocket(1513);
    }
}
