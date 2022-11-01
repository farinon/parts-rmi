package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.Part;

/**
 *
 * @author Cristian Nunes, Jonathan Forlin e Tiago Farinon
 */
public interface PartRepositoryInterface extends Remote {
    public String getList() throws RemoteException;
    public Part getPart(long index) throws RemoteException;
    public void addPart(long code, String name, String description) throws RemoteException;
    public long getNextCode() throws RemoteException;
    public String getName() throws RemoteException;
    public void setName(String name) throws RemoteException;
    public long countParts() throws RemoteException;
}
