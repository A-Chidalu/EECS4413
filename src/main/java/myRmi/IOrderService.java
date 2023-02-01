package myRmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOrderService extends Remote {
    public String placeOrder(int userId, Order order) throws RemoteException;
    public double getTotal(int userId) throws RemoteException;

}
