import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorVeiculo {
    Scanner scanner;
    DaoVeiculo daoVeiculo;

    public GerenciadorVeiculo() {
        scanner = new Scanner(System.in);
        daoVeiculo = new DaoVeiculo();
    }

    public void menu() {
        String op;

        do {
            System.out.println("\n=====MENU DE VEICULOS=====");

            System.out.println("\n1- Cadastrar um veiculo.\n2- Consultar um veiculo.\n3- Alterar dados de um veiculo.\n4- Excluir um veiculo.\n5- Listar todos os veiculos.\n6- Sair.");

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
        DaoVeiculo daoVeiculo = new DaoVeiculo();
        Veiculo v1 = new Veiculo();

        System.out.println("\n=====CADASTRO DE VEICULO=====");

        System.out.println("\nDigite o ano de fabricação do veiculo: ");
        int ano = Integer.parseInt(scanner.nextLine());
        v1.setAno(ano);

        System.out.println("\nDigite o número do chassi do veiculo: ");
        String chassi = scanner.nextLine();
        v1.setChassi(chassi);

        System.out.println("\nDigite a marca do veiculo: ");
        String marca = scanner.nextLine();
        v1.setMarca(marca);

        System.out.println("\nDigite o modelo do veiculo: ");
        String modelo = scanner.nextLine();
        v1.setModelo(modelo);

        boolean inserido = daoVeiculo.inserir(v1);

        if (inserido){
            System.out.println("\nVeiculo cadastrado com sucesso!");
        }
    }

    public void listar() {
        ArrayList<Veiculo> Veiculos;
        Veiculos = daoVeiculo.listarVeiculos();

        System.out.println("\n=====VEICULOS CADASTRADOS======");

        for (Veiculo e : Veiculos) {
            System.out.println("\nCodigo: "+ e.getCodigo());

            System.out.println("\nModelo: "+ e.getModelo());

            System.out.println("\nMarca: "+ e.getMarca());

            System.out.println("\nNúmero do chassi: "+ e.getChassi());

            System.out.println("\nAno de fabricação: "+ e.getAno());

            System.out.println("\n==========//==========");
        }
    }

    public void excluirVeiculo() {
        System.out.println("\n=====EXCLUIR VEICULO=====");

        System.out.println("\nDigite o codigo do veiculo que deseja excluir: ");
        int cod = Integer.parseInt(scanner.nextLine());

        int quant = daoVeiculo.excluir(cod);

        if (quant > 0) {
            System.out.println("\nVeiculo excluido!");
        
        } else {
            System.out.println("\nVeiculo não encontrado!");
        }
    }

    public void consultar() {
        System.out.println("\n=====CONSULTAR VEICULO=====");

        System.out.println("\nDigite o codigo do veiculo que deseja consultar: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        Veiculo e = daoVeiculo.consultar(codigo);

        if (e != null) {
            System.out.println("\nModelo: "+ e.getModelo());

            System.out.println("\nMarca: "+ e.getMarca());

            System.out.println("\nNúmero do chassi: "+ e.getChassi());

            System.out.println("\nAno de fabricação: "+ e.getAno());
        
        } else {
            System.out.println("\nVeiculo não encontrado!");
        }
    }

    public void alterar() {
        System.out.println("\n=====ALTERAR DADOS DE UM VEICULO=====");

        System.out.println("\nDigite o codigo do veiculo que deseja alterar: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        Veiculo e = daoVeiculo.consultar(codigo);

        if (e != null) {
            String op = "";

            do {
                System.out.println("\nModelo atual do veiculo: "+ e.getModelo());

                System.out.println("\nDeseja alterar o modelo do veiculo(S/N)?");
                op = scanner.nextLine();

                if (op.equals("S") || op.equals("s")) {
                    System.out.println("\nDigite o novo modelo do veiculo: ");
                    String mod = scanner.nextLine();

                    e.setModelo(mod);

                    System.out.println("\nModelo do veiculo alterado!");
                
                } else if (op.equals("N") || op.equals("n")) {
                    break;
                } else {
                    System.out.println("\nOpção digitada é invalida!");
                }

                System.out.println("\n==========//==========");
            
            } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));

            do {
                System.out.println("\nMarca atual do veiculo: "+ e.getMarca());

                System.out.println("\nDeseja alterar a marca do veiculo(S/N)?");
                op = scanner.nextLine();

                if (op.equals("S") || op.equals("s")) {
                    System.out.println("\nDigite a nova marca do veiculo: ");
                    String mar = scanner.nextLine();

                    e.setModelo(mar);

                    System.out.println("\nMarca do veiculo alterado!");
                
                } else if (op.equals("N") || op.equals("n")) {
                    break;
                } else {
                    System.out.println("\nOpção digitada é invalida!");
                }

                System.out.println("\n==========//==========");
            
            } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));

            do {
                System.out.println("\nNúmero do chassi atual: "+ e.getChassi());

                System.out.println("\nDeseja alterar o número do chassi do veiculo(S/N)?");
                op = scanner.nextLine();

                if (op.equals("S") || op.equals("s")) {
                    System.out.println("\nDigite o novo número do chassi: ");
                    String mar = scanner.nextLine();

                    e.setModelo(mar);

                    System.out.println("\nNúmero do chassi alterado!");
                
                } else if (op.equals("N") || op.equals("n")) {
                    break;
                } else {
                    System.out.println("\nOpção digitada é invalida!");
                }

                System.out.println("\n==========//==========");
            
            } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));

            do {
                System.out.println("\nAno de fabricação atual: "+ e.getAno());

                System.out.println("\nDeseja alterar o ano de fabricação do veiculo(S/N)?");
                op = scanner.nextLine();

                if (op.equals("S") || op.equals("s")) {
                    System.out.println("\nDigite o novo ano de fabricação: ");
                    String mar = scanner.nextLine();

                    e.setModelo(mar);

                    System.out.println("\nAno de fabricação alterado!");
                
                } else if (op.equals("N") || op.equals("n")) {
                    break;
                } else {
                    System.out.println("\nOpção digitada é invalida!");
                }

                System.out.println("\n==========//==========");
            
            } while (!op.equals("S") && !op.equals("s") && !op.equals("N") && !op.equals("n"));
        
        } else {
            System.out.println("\nVeiculo não encontrado!");
        }
    }
}
