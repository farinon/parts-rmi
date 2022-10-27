


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Cristian Nunes, Jonathan Forlin e Tiago Farinon
 */
public class PartRepository extends UnicastRemoteObject implements PartRepositoryInterface{
    private ArrayList<Part> parts = new ArrayList<Part>();

    private long lastCode;

    private String name;

    private PartRepositoryMenu menu = new PartRepositoryMenu(this);
    
    

    public PartRepository() throws RemoteException{
        //super();
        lastCode = 0;        
    }
    
    

    @Override
    public String getList() throws RemoteException{
        //System.out.println(parts.toString());
        return parts.toString();
    }

    @Override
    public Part getPart(long index) throws RemoteException {
        Part part = new Part();
        for (Part p : this.parts) {
          if (p.getCode() == index) {
            System.out.println("Esta peça existe!");
            part = p;
          } else {
            System.out.println("Esta peça não existe!");
          }
        }
        return part;
      }

    @Override
    public void addPart(long code, String name, String description) throws RemoteException{
        
        Part part = new Part();
        part.setCode(code);                     
        part.setName(name);
        part.setDescription(description);
        System.out.println(part.toString());
        parts.add(part);
        System.out.println(part.toString());
        lastCode++;
     }

    @Override
    public long getNextCode() throws RemoteException{
        return lastCode+1;
    }

    @Override
    public String getName() throws RemoteException{
        return name;
    }

    @Override
    public void setName(String name) throws RemoteException{
        System.out.println(name);
        this.name = name;
    }

    @Override
    public long countParts() throws RemoteException{
        return parts.size();
    }



    
}
