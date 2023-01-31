package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClientSocket {
    public static void main(String[] args) {

        try(Socket serverSocket = new Socket("127.0.0.1", 1513);
            PrintWriter outputStream = new PrintWriter(serverSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            Scanner sc = new Scanner(System.in);
        ) {

            String response = "";
            String currLine = "";

            while(!currLine.equals("Finished.")) {
                currLine = sc.nextLine();
                //System.out.println("Client readLine: " + currLine);

                //write the line to the socket
                outputStream.println(currLine);

                //read the response from socket
                response = in.readLine();

                System.out.println("The Server says: " + response);
            }

        } catch (IOException ex) {

        }
    }
}
