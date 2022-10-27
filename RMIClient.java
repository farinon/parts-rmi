

import java.rmi.Naming;
import java.util.Scanner;


public class RMIClient {
	public static void main(String[] argv) throws Exception{
// para executar de uma forma segura, pode-se utilizar um arquivo de configuração com polices ...(premissao.policy) 
// e para executar tem que colocar: java -Djava.security.policy=permissao.policy RMIClient 
		
		//System.setSecurityManager(new SecurityManager());

		try {
//bind server object to object in client
			PartRepositoryInterface myServerObject = (PartRepositoryInterface) Naming.lookup("PartRepository");

//invoke method on server object
			// myServerObject.soma(1, 3);
			Scanner scanner = new Scanner(System.in);
			//myServerObject.setName("teste");
                        
                        
                        //myServerObject
			PartRepositoryMenu partRepositoryMenu = new PartRepositoryMenu(myServerObject);
                        while(true){
                            partRepositoryMenu.getOptions();
                            int o = scanner.nextInt();
                            partRepositoryMenu.choose(o);
                        }
 
		}
		catch(Exception e) {
			System.out.println("Exception occured: " + e);
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Conexão RMI realizada com sucesso");
	}


	
}