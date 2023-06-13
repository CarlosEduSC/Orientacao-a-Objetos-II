import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorClientePJ {
    Scanner scanner;
    DaoClientePJ daoClientePJ;

    public GerenciadorClientePJ() {
        scanner = new Scanner(System.in);
        daoClientePJ = new DaoClientePJ();
    }

    public void menu() {
        String op;

        do {
            System.out.println("\n=====MENU DE VEICULOS=====");

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
                    excluirVeiculo();
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
        ClientePJ c1 = new ClientePJ();
        EnderecoPJ end = new EnderecoPJ();

        System.out.println("\n=====CADASTRO DE CLIENTE=====");

        System.out.println("\nDigite o nome do cliente: ");
        String nome = scanner.nextLine();
        c1.setNome(nome);

        System.out.println("\nDigite o CNPJ do cliente: ");
        String cnpj = scanner.nextLine();
        c1.setCnpj(cnpj);

        System.out.println("\nDigite o bairro em que o cliente mora: ");
        String bairro = scanner.nextLine();
        end.setBairro(bairro);

        System.out.println("\nDigite a rua em que o cliente mora: ");
        String rua = scanner.nextLine();
        end.setRua(rua);

        System.out.println("\nDigite o numero do local em que o cliente mora: ");
        int numero = Integer.parseInt(scanner.nextLine());
        end.setNumero(numero);

        System.out.println("\nDigite o CEP do cliente: ");
        String cep = scanner.nextLine();
        end.setCep(cep);

        c1.setEnderecoPJ(end);

        boolean inserido = daoClientePJ.inserir(c1);

        if (inserido){
            System.out.println("\nVeiculo cadastrado com sucesso!");
        }
    }

    public void listar() {
        ArrayList<ClientePJ> clientePJ;
        clientePJ = daoClientePJ.listarClientePJ();

        System.out.println("\n=====LISTA DE CLIENTES======");

        for (ClientePJ c : clientePJ) {
            System.out.println("\nCodigo: "+ c.getCodigoClientePJ());

            System.out.println("\nNome: "+ c.getNome());

            System.out.println("\nCNPJ: "+ c.getCnpj());

            System.out.println("\nEndereço: "+ c.getEnderecoPJ().getRua() + ", "+ c.getEnderecoPJ().getNumero() + ", "+ c.getEnderecoPJ().getBairro() +" - "+ c.getEnderecoPJ().getCep());

            System.out.println("\n==========//==========");
        }
    }

    public void excluirVeiculo() {
        System.out.println("\n=====EXCLUIR CLIENTE=====");

        System.out.println("\nDigite o codigo do cliente que deseja excluir: ");
        int cod = Integer.parseInt(scanner.nextLine());

        int quant = daoClientePJ.excluir(cod);

        if (quant > 0) {
            System.out.println("\nCliente excluido!");
        
        } else {
            System.out.println("\nCliente não encontrado!");
        }
    }

    public void consultar() {
        // System.out.println("\n=====CONSULTAR VEICULO=====");

        // System.out.println("\nDigite o codigo do veiculo que deseja consultar: ");
        // int codigo = Integer.parseInt(scanner.nextLine());

        // Veiculo e = daoVeiculo.consultar(codigo);

        // if (e != null) {
        //     System.out.println("\nModelo: "+ e.getModelo());

        //     System.out.println("\nMarca: "+ e.getMarca());

        //     System.out.println("\nNúmero do chassi: "+ e.getChassi());

        //     System.out.println("\nAno de fabricação: "+ e.getAno());
        
        // } else {
        //     System.out.println("\nVeiculo não encontrado!");
        // }
    }

    public void alterar() {
    //     System.out.println("\n=====ALTERAR DADOS DE UM VEICULO=====");

    //     System.out.println("\nDigite o codigo do veiculo que deseja alterar: ");
    //     int codigo = Integer.parseInt(scanner.nextLine());

    //     Veiculo e = daoVeiculo.consultar(codigo);

    //     if (e != null) {
    //         String op = "";

    //         do {
    //             System.out.println("\nModelo atual do veiculo: "+ e.getModelo());

    //             System.out.println("\nDeseja alterar o modelo do veiculo(S/N)?");
    //             op = scanner.nextLine();

    //             if (op.equals("S") || op.equals("s")) {
    //                 System.out.println("\nDigite o novo modelo do veiculo: ");
    //                 String mod = scanner.nextLine();

    //                 e.setModelo(mod);

    //                 System.out.println("\nModelo do veiculo alterado!");
                
    //             } else if (op.equals("N") || op.equals("n")) {
    //                 break;
    //             } else {
    //                 System.out.println("\nOpção digitada é invalida!");
    //             }

    //             System.out.println("\n==========//==========");
            
    //         } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));

    //         do {
    //             System.out.println("\nMarca atual do veiculo: "+ e.getMarca());

    //             System.out.println("\nDeseja alterar a marca do veiculo(S/N)?");
    //             op = scanner.nextLine();

    //             if (op.equals("S") || op.equals("s")) {
    //                 System.out.println("\nDigite a nova marca do veiculo: ");
    //                 String mar = scanner.nextLine();

    //                 e.setModelo(mar);

    //                 System.out.println("\nMarca do veiculo alterado!");
                
    //             } else if (op.equals("N") || op.equals("n")) {
    //                 break;
    //             } else {
    //                 System.out.println("\nOpção digitada é invalida!");
    //             }

    //             System.out.println("\n==========//==========");
            
    //         } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));

    //         do {
    //             System.out.println("\nNúmero do chassi atual: "+ e.getChassi());

    //             System.out.println("\nDeseja alterar o número do chassi do veiculo(S/N)?");
    //             op = scanner.nextLine();

    //             if (op.equals("S") || op.equals("s")) {
    //                 System.out.println("\nDigite o novo número do chassi: ");
    //                 String mar = scanner.nextLine();

    //                 e.setModelo(mar);

    //                 System.out.println("\nNúmero do chassi alterado!");
                
    //             } else if (op.equals("N") || op.equals("n")) {
    //                 break;
    //             } else {
    //                 System.out.println("\nOpção digitada é invalida!");
    //             }

    //             System.out.println("\n==========//==========");
            
    //         } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));

    //         do {
    //             System.out.println("\nAno de fabricação atual: "+ e.getAno());

    //             System.out.println("\nDeseja alterar o ano de fabricação do veiculo(S/N)?");
    //             op = scanner.nextLine();

    //             if (op.equals("S") || op.equals("s")) {
    //                 System.out.println("\nDigite o novo ano de fabricação: ");
    //                 String mar = scanner.nextLine();

    //                 e.setModelo(mar);

    //                 System.out.println("\nAno de fabricação alterado!");
                
    //             } else if (op.equals("N") || op.equals("n")) {
    //                 break;
    //             } else {
    //                 System.out.println("\nOpção digitada é invalida!");
    //             }

    //             System.out.println("\n==========//==========");
            
    //         } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));
        
    //     } else {
    //         System.out.println("\nVeiculo não encontrado!");
    //     }
    }
}
