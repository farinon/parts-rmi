package client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Cristian Nunes, Jonathan Forlin e Tiago Farinon
 */
public class Part extends UnicastRemoteObject implements PartInterface {
    
    private long code;
    private String name;
    private String description;
    private ArrayList<Part> subParts = new ArrayList<Part>();

    public Part() throws RemoteException{}
    
    
    @Override
    public long getCode() throws RemoteException{
        return this.code;
    }

    
    @Override
    public String getName() throws RemoteException{
        return this.name;    
    }

    
    @Override
    public String getDescription() throws RemoteException{
        return this.description;
    }

    
    @Override
    public ArrayList<Part> getSubParts() throws RemoteException{
        return subParts;
    }

    
    @Override
    public boolean isPrimitive() throws RemoteException{
        return (subParts.size())<=0;
    }

    @Override
    public void setCode(long code) throws RemoteException{
        this.code = code;
    }

    @Override
    public void setName(String name) throws RemoteException{
        this.name = name;
    }

    @Override
    public void setDescription(String description) throws RemoteException{
        this.description = description;
    }

    @Override
    public void addSubPart(Part part)throws RemoteException{
        subParts.add(part);
    }
    
    @Override
    public void removeSubPart(int index)throws RemoteException{
        subParts.remove(index);
    }
    
    @Override
    public void removeAllSubPart() throws RemoteException{
        subParts.clear();
    }

    
    @Override
    public String show() throws RemoteException{
        return code + " - name=" + name + ", description=" + description + ", subParts=" + subParts + "\n";
    } 

    @Override
    public long countSubParts() throws RemoteException{
        return subParts.size();
    }
    
    
    
}
