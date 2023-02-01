package myRmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService extends UnicastRemoteObject implements IOrderService{
    private static final long serialVersionUID = 1L;

    Map<Integer, List<Order>> orders;



    public OrderService() throws RemoteException {
        super();
        this.orders = new HashMap<>();
    }

    @Override
    public String placeOrder(int userId, Order order) throws RemoteException {
        if(!orders.containsKey(userId)) orders.put(userId, new ArrayList<>());

        orders.get(userId).add((order));

        return String.format("Thank you for placing the order user: %s", userId);
    }

    @Override
    public double getTotal(int userId) throws RemoteException {
        double res = 0;

        if(orders.containsKey(userId)) {
            for(Order o: orders.get(userId)) {
                res += o.orderPrice;
            }
        }

        return res;
    }
}
