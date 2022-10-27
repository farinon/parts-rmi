

import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author Cristian Nunes, Jonathan Forlin e Tiago Farinon
 */
public interface PartInterface extends Remote{
    public long getCode() throws java.rmi.RemoteException;
    public String getName() throws java.rmi.RemoteException;
    public String getDescription() throws java.rmi.RemoteException;
    public ArrayList<Part> getSubParts() throws java.rmi.RemoteException;
    public boolean isPrimitive() throws java.rmi.RemoteException;
    public long countSubParts() throws java.rmi.RemoteException;
}
