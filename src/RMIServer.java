
import java.rmi.Naming;
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
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
	}
        
	/* public static void main(String[] args) {
        try {
			// cria um objeto para se tornar acessível via rede
        	PartRepositoryInterface partRepository = new PartRepository();

            String objName = "PartRepository";
			
            System.out.println("Registrando o objeto no RMIRegistry...");

			LocateRegistry.createRegistry(1099);
            Naming.rebind(objName, partRepository);
			
            System.out.println("Aguardando Clientes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }     */

}