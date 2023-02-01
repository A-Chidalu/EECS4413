package xmlrpc;

import org.apache.xmlrpc.XmlRpcClient;

import java.util.Arrays;
import java.util.Vector;

public class XMLClient {
    public static void main(String[] args) {
        try {
            XmlRpcClient client = new XmlRpcClient("http://localhost/RPC2");
            Vector<Vector<Integer>> vec = new Vector<>();
            Vector<Integer> arr = new Vector<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

            vec.add(arr);

            Object result = client.execute("summer.maxint", vec);

            int maxInt = ((Integer) result).intValue();
            System.out.println("The Max int is: " + maxInt);

        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception);
        }
    }
}
