import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Cristian Nunes, Jonathan Forlin e Tiago Farinon
 */
public class Part extends UnicastRemoteObject {
    
    private long code;
    private String name;
    private String description;
    private ArrayList<Part> subParts = new ArrayList<Part>();

    public Part() throws RemoteException{

    }
    
    
    public long getCode() throws RemoteException{
        return this.code;
    }

    
    public String getName() throws RemoteException{
        return this.name;    
    }

    
    public String getDescription() throws RemoteException{
        return this.description;
    }

    
    public ArrayList<Part> getSubParts() throws RemoteException{
        return subParts;
    }

    
    public boolean isPrimitive() throws RemoteException{
        return (subParts.size())<=0;
    }

    public void setCode(long code) throws RemoteException{
        this.code = code;
    }

    public void setName(String name) throws RemoteException{
        this.name = name;
    }

    public void setDescription(String description) throws RemoteException{
        this.description = description;
    }

    public void setSubParts(ArrayList<Part> subParts) throws RemoteException{
        this.subParts = subParts;
    }

    public void addSubPart(Part part)throws RemoteException{
        subParts.add(part);
    }
    
    public void removeSubPart(int index)throws RemoteException{
        subParts.remove(index);
    }
    
    public void removeAllSubPart()throws RemoteException{
        subParts.clear();
    }

    
    public String toString() {
        return "Part{" + "code=" + code + ", name=" + name + ", description=" + description + ", subParts=" + subParts + '}';
    }

    
    public long countSubParts() throws RemoteException{
        return subParts.size();
    }
    
    
    
}
