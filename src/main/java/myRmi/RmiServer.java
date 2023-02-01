package myRmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {
    public static void main(String[] args) {

        try {

            LocateRegistry.createRegistry(6600);
            Naming.rebind("//localhost:6600/OS", new OrderService());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
