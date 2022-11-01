package client;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 5220208
 */

public class PartMenu {
    Part p;
    PartMenu(Part p){
        this.p = p;
    }
    String getOptions(){
                String menu =           "***************************************************\n"					
				+ 	"*    Detalhes da Peça                              *\n"
				+ 	"***************************************************\n"
				+ 	"* 1 - Descrição da peça                           *\n"
				+       "* 2 - Nome do Repositório                          *\n"
				+       "* 3 - Verificar se é peça primitiva ou agregada    *\n"
				+       "* 4 - Quantidade de Subcomponentes                 *\n"
                                +       "* 5 - Listar Subcomponentes                       \n"
                                +       "* 6 - Esvazia a lista de Subcomponentes            \n"
			 	+       "* 7 - Volta ao menu anterior                       \n"
                        
				
				+ 	"***************************************************\n"
				+ 	"Escolha o padrão que quer testar:";
		System.out.println(menu);
                return menu;
    }
    
    void choose(int o) throws RemoteException {       

		switch(o){
			case 1:
                        
			p.setName("teste");
                        System.out.println("teste");
                                
	            break;	
	        case 2:
	        	
	            break;	        
	        case 3:
	        	
	            break;	        
	        case 4:
	        	
	            break;	        
	        case 5:
	        	
	            break;	            
	        case 6:
	        	
	            break;	       
	        case 7:
                    //showRepositoryMenu();
	            break;	        

	        default:
	        	getOptions();
	    }
    }
         
}
