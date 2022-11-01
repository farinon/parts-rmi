package client;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Cristian Nunes, Jonathan Forlin e Tiago Farinon
 */
public interface PartInterface extends Remote{
    public long getCode() throws RemoteException;
    public String getName() throws RemoteException;
    public String getDescription() throws RemoteException;
    public ArrayList<Part> getSubParts() throws RemoteException;
    public boolean isPrimitive() throws RemoteException;
    public long countSubParts() throws RemoteException;
    public String show() throws RemoteException;
    public void setCode(long code) throws RemoteException;
    public void setName(String name) throws RemoteException;
    public void setDescription(String description) throws RemoteException;
    public void addSubPart(Part part)throws RemoteException;
    public void removeSubPart(int index)throws RemoteException;
    public void removeAllSubPart() throws RemoteException;
}
