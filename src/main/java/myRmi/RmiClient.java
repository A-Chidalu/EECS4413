package myRmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiClient {
    public static void main(String[] args) {
        try {
            OrderService orderService = (OrderService) Naming.lookup("rmi://localhost:6600/OS");

            Order o1 = new Order(1, 10.99);
            Order o2 = new Order(2, 30.99);

            orderService.placeOrder(1, o1);
            orderService.placeOrder(1, o2);

            System.out.println("The total is: " + orderService.getTotal(1));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
