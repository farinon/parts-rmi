package client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import server.PartRepositoryInterface;

public class RMIClient {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] argv) throws RemoteException, MalformedURLException, NotBoundException {
		try {
			// bind server object to object in client
			PartRepositoryInterface myServerObject = (PartRepositoryInterface) Naming.lookup("PartRepository");

			// menu repositório
			while (true) {
				getRepositoryOptions();
				int o = scanner.nextInt();
				chooseRepositoryOption(o, myServerObject);
			}

		} catch (RemoteException e) {
			System.out.println("RemoteException occured: " + e);
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Conexão RMI realizada com sucesso");
	}

	static String getRepositoryOptions() throws RemoteException {
		String menu = "***************************************************\n"
				+ "*  Sistemas Distribuidos                           *\n"
				+ "*  Tiago da Costa Farinon                          *\n"
				+ "*  Cristian da Rosa Nunes                          *\n"
				+ "*  Jonathan Forlin                                 *\n"
				+ "*                                                  *\n"
				+ "***************************************************\n"
				+ "* 1 - Criar Repositorio                            *\n"
				+ "* 2 - Adicionar peça ao Repositório                *\n"
				+ "* 3 - Listar peças do Repositório                  *\n"
				+ "* 4 - Busca peça no Repositório                    *\n"
				+ "* 5 - Encerra                                      *\n"
				+ "***************************************************\n"
				+ "Escolha o padrão que quer testar:";
		System.out.println(menu);
		return menu;
	}

	/**
	 * @param o
	 * @throws RemoteException
	 */
	static void chooseRepositoryOption(int o, PartRepositoryInterface repository ) throws RemoteException {
		Part part;

		switch (o) {
			case 1:
				System.out.println("Nome do Repositório: ");
				String name = scanner.nextLine();
				repository.setName(name);
				System.out.println("Nome: " + repository.getName());

				break;
			case 2:
				part = new Part();
				part.setCode(repository.getNextCode());

				System.out.println("Nome da Peça: ");
				String partName = scanner.nextLine();
				part.setName(partName);

				System.out.println("Descrição da Peça: ");
				String partDescription = scanner.nextLine();
				part.setDescription(partDescription);

				System.out.println(part.show());
				// repository.addPart(part);

				break;
			case 3:
				System.out.println(repository.getList());

				break;
			case 4:
				System.out.println("Código da Peça: ");
				int partCode = scanner.nextInt();
				//part = new Part();
				part = repository.getPart(partCode);
				System.out.println(part.show());
				break;
			case 5:

				break;
			case 99:
				repository.setName("Repositorio de teste");

				repository.addPart(repository.getNextCode(), "parte de teste", "descrição da parte de teste");

				break;

			default:
				getRepositoryOptions();
		}
	}

}