import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorCliente {
    Scanner scanner;
    DaoClientes daoCliente;

    public GerenciadorCliente() {
        scanner = new Scanner(System.in);
        daoCliente = new DaoClientes();
    }

    public void menu() {
        String op;

        do {
            System.out.println("\n=====MENU DE CLIENTES=====");

            System.out.println("\n1- Cadastrar um cliente.\n2- Consultar um cliente.\n3- Alterar dados de um cliente.\n4- Excluir um cliente.\n5- Listar todos os clientes.\n6- Sair.");

            System.out.println("\nEscolha uma das opções a cima: ");
            op = scanner.nextLine();

            switch (op) {
                case "1":
                    cadastrar();
                    break;

                case "2":
                    consultar();
                    break;

                case "3":
                    alterar();
                    break;

                case "4":
                    excluirCliente();
                    break;

                case "5":
                    listar();
                    break;

                case "6":
                    break;
            
                default:
                    System.out.println("\nOpção invalida!");
                    break;
            }
        
        } while(!op.equals("6"));
    }

    public void cadastrar() {
        DaoClientes daoCliente = new DaoClientes();
        Cliente c1 = new Cliente();

        System.out.println("\n=====CADASTRO DE CLIENTE=====");

        System.out.println("\nDigite o nome do clinte: ");
        String nome = scanner.nextLine();
        c1.setNome(nome);

        System.out.println("\nDigite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        c1.setTelefone(telefone);

        System.out.println("\nDigite o email do cliente: ");
        String email = scanner.nextLine();
        c1.setEmail(email);

        boolean inserido = daoCliente.inserir(c1);

        if (inserido){
            System.out.println("\nCliente cadastrado com sucesso!");
        }
    }

    public void listar() {
        ArrayList<Cliente> Clientes;
        Clientes = daoCliente.listarClientes();

        System.out.println("\n=====CLIENTES CADASTRADOS======");

        for (Cliente c : Clientes) {
            System.out.println("\nId: "+ c.getId());

            System.out.println("\nNome: "+ c.getNome());

            System.out.println("\nTelefone: "+ c.getTelefone());

            System.out.println("\nEmail: "+ c.getEmail());

            System.out.println("\n==========//==========");
        }
    }

    public void excluirCliente() {
        System.out.println("\n=====EXCLUIR CLIENTE=====");

        System.out.println("\nDigite o id do cliente que deseja excluir: ");
        int cod = Integer.parseInt(scanner.nextLine());

        int quant = daoCliente.excluir(cod);

        if (quant > 0) {
            System.out.println("\nCliente excluido!");
        
        } else {
            System.out.println("\nCliente não encontrado!");
        }
    }

    public void consultar() {
        System.out.println("\n=====CONSULTAR CLIENTE=====");

        System.out.println("\nDigite o codigo do cliente que deseja consultar: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        Cliente c = daoCliente.consultar(codigo);

        if (c != null) {
            System.out.println("\nId: "+ c.getId());

            System.out.println("\nNome: "+ c.getNome());

            System.out.println("\nTelefone: "+ c.getTelefone());

            System.out.println("\nEmail: "+ c.getEmail());
        
        } else {
            System.out.println("\nCliente não encontrado!");
        }
    }

    public void alterar() {
        System.out.println("\n=====ALTERAR DADOS DE UM CLIENTE=====");

        System.out.println("\nDigite o codigo do cliente que deseja alterar: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        Cliente c = daoCliente.consultar(codigo);

        if (c != null) {
            String op = "";

            do {
                System.out.println("\nNome atual do cliente: "+ c.getNome());

                System.out.println("\nDeseja alterar o nome do cliente(S/N)?");
                op = scanner.nextLine();

                if (op.equals("S") || op.equals("s")) {
                    System.out.println("\nDigite o novo nome do veiculo: ");
                    String nome = scanner.nextLine();

                    c.setNome(nome);

                    System.out.println("\nNome do cliente alterado!");
                
                } else if (op.equals("N") || op.equals("n")) {
                    break;
                } else {
                    System.out.println("\nOpção digitada é invalida!");
                }

                System.out.println("\n==========//==========");
            
            } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));

            do {
                System.out.println("\nTelefone atual do cliente: "+ c.getTelefone());

                System.out.println("\nDeseja alterar o telefone do cliente(S/N)?");
                op = scanner.nextLine();

                if (op.equals("S") || op.equals("s")) {
                    System.out.println("\nDigite o novo telefone do cliente: ");
                    String telefone = scanner.nextLine();

                    c.setTelefone(telefone);

                    System.out.println("\nTelefone do cliente alterado!");
                
                } else if (op.equals("N") || op.equals("n")) {
                    break;
                } else {
                    System.out.println("\nOpção digitada é invalida!");
                }

                System.out.println("\n==========//==========");
            
            } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));

            do {
                System.out.println("\nEmail atual do cliente: "+ c.getEmail());

                System.out.println("\nDeseja alterar o email do cliente(S/N)?");
                op = scanner.nextLine();

                if (op.equals("S") || op.equals("s")) {
                    System.out.println("\nDigite o novo email do cliente: ");
                    String email = scanner.nextLine();

                    c.setEmail(email);

                    System.out.println("\nEmail do cliente alterado!");
                
                } else if (op.equals("N") || op.equals("n")) {
                    break;
                } else {
                    System.out.println("\nOpção digitada é invalida!");
                }

                System.out.println("\n==========//==========");
            
            } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));
        
        } else {
            System.out.println("\nCliente não encontrado!");
        }
    }
}
