

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class RMIServer {
    
	static Scanner reader = new Scanner(System.in);
	public static void main(String[] argv) {

// para executar de uma forma segura, pode-se utilizar um arquivo de configuração com polices ...(premissao.policy) 
// e para executar tem que colocar: java -Djava.security.policy=permissao.policy RMIServer 

		//System.setSecurityManager(new SecurityManager());
		//System.setProperty("java.rmi.server.hostname","10.200.3.109");


		try { 
// Iniciar a execução do registry na porta desejada
			LocateRegistry.createRegistry(1099);
			System.out.println("RMI registry está pronto.");
		
		} catch (Exception e) {
			System.out.println("Exception gerado pelo RMI registry:");
		}

		try {

// instanciar objeto remoto
			PartRepositoryInterface objRemoto = (PartRepositoryInterface) new PartRepository();
                        

//registar o objeto remoto no Registry
			Naming.rebind("PartRepository", objRemoto);
			System.out.println("servidor está pronto");
                        //showRepositoryMenu();
		} catch (MalformedURLException | RemoteException e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
	}
        
        

}