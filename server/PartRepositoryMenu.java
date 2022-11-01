package server;



import java.rmi.RemoteException;
import java.util.Scanner;

import client.Part;
import client.PartMenu;

/**
 *
 * @author 5220208
 */
public class PartRepositoryMenu {
    static Scanner scanner = new Scanner(System.in);
    PartRepositoryInterface p;

    PartMenu partMenu;
    Part part;

    public PartRepositoryMenu(PartRepositoryInterface p) {
        this.p = p;
    }
    

    String getOptions()throws RemoteException{
        String menu =           "***************************************************\n"
                            + 	"*  Sistemas Distribuidos                           *\n"
                            + 	"*  Tiago da Costa Farinon                          *\n"
                            + 	"*  Cristian da Rosa Nunes                          *\n"                        
                            + 	"*  Jonathan Forlin                                 *\n"
                            + 	"*                                                  *\n"
                            + 	"***************************************************\n"
                            + 	"* 1 - Criar Repositorio                            *\n"
                            +   "* 2 - Adicionar peça ao Repositório                *\n"
                            +   "* 3 - Listar peças do Repositório                  *\n"
                            +   "* 4 - Busca peça no Repositório                    *\n"
                            +   "* 5 - Encerra                                      *\n"				
                            + 	"***************************************************\n"
				            + 	"Escolha o padrão que quer testar:";
	System.out.println(menu);	
        return menu;
    }
    
    void choose(int o) throws RemoteException{       
                
		switch(o){
			case 1:
                        System.out.println("Nome do Repositório: ");
                        String name = scanner.nextLine();
			p.setName(name);
                        System.out.println("Nome: "+p.getName());
                                
	            break;	
	        case 2:
                        part = new Part();
                        part.setCode(p.getNextCode());
                        
                        System.out.println("Nome da Peça: ");
                        String partName = scanner.nextLine();
			part.setName(partName);
                        
                        System.out.println("Descrição da Peça: ");
                        String partDescription = scanner.nextLine();
			part.setDescription(partDescription);
                        
                        System.out.println(part.toString());
                        //p.addPart(part);
	        	
	            break;	        
	        case 3:
                        System.out.println(p.getList());
                        
	            break;	        
	        case 4:
                    System.out.println("Código da Peça: ");
                    int partCode = scanner.nextInt();
                    part = new Part();                    
                    part = p.getPart(partCode);
                    part.toString();
	            break;	        
	        case 5:
	        	
	            break;
                case 99:
	        	p.setName("Repositorio de teste");
                        
                                           
                        p.addPart(p.getNextCode(),"parte de teste","descrição da parte de teste");
                        
	            break;
	          

	        default:
	        	getOptions();
	    }
    }
         
}
