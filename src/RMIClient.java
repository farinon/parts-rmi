import java.rmi.Naming;

import java.rmi.RemoteException;
import java.util.Scanner;

public class RMIClient {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] argv) throws Exception {
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
	static void chooseRepositoryOption(int o, PartRepositoryInterface repository) throws RemoteException {
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
				String partInfo = repository.getPart(partCode);
				if (partInfo != "") {
					System.out.println(getPartOptions(partInfo));
					int option = scanner.nextInt();
					System.out.println(repository.choosePartOption(option,getPartArg(option)));
					
				}
				;
				// System.out.println(part.show());
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

	static String getPartOptions(String part) {
		String menu = "***************************************************\n"
				+ part + "\n"
				+ "***************************************************\n"
				+ "* 1 - Editar nome                           *\n"
				+ "* 2 - Editar descritivo                          *\n"
				+ "* 3 - Verificar se é peça primitiva ou agregada    *\n"
				+ "* 4 - Quantidade de Subcomponentes                 *\n"
				+ "* 5 - Listar Subcomponentes                       \n"
				+ "* 6 - Esvazia a lista de Subcomponentes            \n"
				+ "* 7 - Adicionar sub-componente                       \n"

				+ "***************************************************\n"
				+ "Escolha o padrão que quer testar:";
		System.out.println(menu);
		return menu;
	}

	static String getPartArg(int o) {
		String arg = "";
		switch (o) {
			case 1:
				// 1 - Editar nome
				System.out.println("Nome da peça:");
				arg = scanner.next();
				return arg;
			case 2:				
				// 2 - Editar Descrição
				System.out.println("Descrição da peça:");
				arg = scanner.next();
				return arg;
			case 3:
				// 3 - Verificar se é peça primitiva ou agregada
				return arg;
			case 4:
				// 4 - Quantidade de Subcomponentes
			 return arg;
			case 5:
				// 5 - Listar Subcomponentes
				return arg;
			case 6:
				// 6 - Esvazia a lista de Subcomponentes
				return arg;
			case 7:
				// 7 - Adicionar sub-componente
				System.out.println("Nome da peça:");
				arg = scanner.next() + ";";				
				System.out.println("Descrição da peça:");
				arg += scanner.next();
				return arg;
			default:
				return arg;
		}		
	}

}