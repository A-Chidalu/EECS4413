package xmlrpc;

import org.apache.xmlrpc.WebServer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

public class XmlServer {


    //Available data types: https://ws.apache.org/xmlrpc/types.html
    public Integer maxint(Vector<Integer> vec) {
        int maxInt = Integer.MIN_VALUE;

        for(int i: vec) {
            maxInt = Math.max(maxInt, i);
        }

        return maxInt;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Attempting to start XML-RPC Server...");

        WebServer server = new WebServer(80);
        server.addHandler("summer", new XmlServer());
        server.start();

        System.out.println("Started successfully.");
        System.out.println("Accepting requests. (Halt program to stop.)");
    }
}
