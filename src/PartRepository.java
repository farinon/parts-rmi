import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Cristian Nunes, Jonathan Forlin e Tiago Farinon
 */
public class PartRepository extends UnicastRemoteObject implements PartRepositoryInterface {

  private static ArrayList<Part> parts = new ArrayList<Part>();

  private int lastCode;

  private String name;

  private int selectedPart = 0;

  public PartRepository() throws RemoteException {
    // super();
    lastCode = 0;
  }

  @Override
  public String getList() throws RemoteException {
    // System.out.println(parts.toString());
    String ret = "";
    for (Part part : parts) {
      ret += part.show();
    }
    return ret;
  }

  @Override
  public String getPart(int index) throws RemoteException {
    // Part part = new Part();
    this.selectedPart = 0;
    Part p = select(PartRepository.parts, index);
    if(p.show()!=""){
      this.selectedPart = index;
    }
    /* for (Part p : PartRepository.parts) {
      if (p.getCode() == index) {
        this.selectedPart = index;
        // System.out.println("Esta peça existe!");
        return p.show();
      } else {
        this.selectedPart = 0;
      } 
    }*/
    return p.show();
  }

  @Override
  public void addPart(int code, String name, String description) throws RemoteException {

    Part part = new Part();
    part.setCode(code);
    part.setName(name);
    part.setDescription(description);
    System.out.println(part.show());
    parts.add(part);
    System.out.println(part.show());
    lastCode++;
  }

  @Override
  public int getNextCode() throws RemoteException {
    return lastCode + 1;
  }

  @Override
  public String getName() throws RemoteException {
    return name;
  }

  @Override
  public void setName(String name) throws RemoteException {
    System.out.println(name);
    this.name = name;
  }

  @Override
  public int countParts() throws RemoteException {
    return parts.size();
  }

  private Part select(ArrayList<Part> parts, int code) throws RemoteException {
    for (Part part : parts) {
      if (part.getCode() == code) {
        return part;
      } else if (part.countSubParts() > 0) {
        return select(part.getSubParts(), code);
      }
    }
    return null;
  }

  @Override
  public String choosePartOption(int o, String arg) throws RemoteException {
    String ret = "";
    switch (o) {      
      case 1:
        // 1 - Editar nome
        
        select(parts, selectedPart).setName(arg);

        System.out.println(select(parts, selectedPart).getName());

        return select(parts, selectedPart).getName();
      case 2:
        select(parts, selectedPart).setDescription(arg);
        System.out.println(select(parts, selectedPart).getDescription());
        // 2 - Editar Descrição
        return select(parts, selectedPart).getDescription();
      case 3:
        // 3 - Verificar se é peça primitiva ou agregada
        if(select(parts, selectedPart).isPrimitive()){
          return "A peça é Primitiva";
        } else{
          return "A peça é Agregada";
        }
        
      case 4:
        // 4 - Quantidade de Subcomponentes
        return Integer.toString(select(parts, selectedPart).countSubParts());
        //return "";
      case 5:
        // 5 - Listar Subcomponentes
        for (Part part : select(parts, selectedPart).getSubParts()) {
          ret += part.show();
        }
        return ret;
      case 6:
        // 6 - Esvazia a lista de Subcomponentes
        select(parts, selectedPart).getSubParts().clear();
        return "Lista de sub-componentes esvaziada";
      case 7:
        // 7 - Adicionar sub-componente
        String[] args = arg.split(";");
        System.out.println("args");
        
        select(parts, selectedPart).addSubPart(new Part(getNextCode(),args[0],args[1]));
        lastCode++;
        return select(parts, selectedPart).show();

      default:
        // getPartOptions();
    }
    return ret;
  }

  
}
