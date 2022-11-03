import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Cristian Nunes, Jonathan Forlin e Tiago Farinon
 */
public class Part extends UnicastRemoteObject implements PartInterface {
    
    private int code;
    private String name;
    private String description;
    private ArrayList<Part> subParts = new ArrayList<Part>();

    public Part() throws RemoteException{}
    
    public Part(int code, String name, String description) throws RemoteException{
        this.code = code;
        this.name = name;
        this.description = description;
    }
    
    public int getCode() throws RemoteException{
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

    public void setCode(int code) throws RemoteException{
        this.code = code;
    }

    public void setName(String name) throws RemoteException{
        this.name = name;
    }

    public void setDescription(String description) throws RemoteException{
        this.description = description;
    }

    public void addSubPart(Part part)throws RemoteException{
        subParts.add(part);
    }
    
    public void removeSubPart(int index)throws RemoteException{
        subParts.remove(index);
    }
    
    public void removeAllSubPart() throws RemoteException{
        subParts.clear();
    }

    
    public String show() throws RemoteException{
        String ret = code + " - name=" + name + ", description=" + description+ "\n";
        if (subParts.size()>0){
            ret += "     subParts: ";
            for (Part part : subParts) {
                ret += part.show() + "\n";
            }
        }
        
        return  ret;
    } 

    public int countSubParts() throws RemoteException{
        return subParts.size();
    }
    
    
    
    
}
