import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Cristian Nunes, Jonathan Forlin e Tiago Farinon
 */
public interface PartRepositoryInterface extends Remote {
    public String getList() throws RemoteException;
    public String getPart(int index) throws RemoteException;
    public void addPart(int code, String name, String description) throws RemoteException;
    public int getNextCode() throws RemoteException;
    public String getName() throws RemoteException;
    public void setName(String name) throws RemoteException;
    public int countParts() throws RemoteException;
    public String choosePartOption(int o, String arg) throws RemoteException;
}
