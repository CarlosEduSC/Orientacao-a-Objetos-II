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
            System.out.println("\n1- Cadastrar veiculo.\n2- Consultar veiculo.\n3- Alterar dados de um veiculo.\n4- Excluir veiculo.\n5- Listar todos os veiculos.\n6- Sair.");

            System.out.println("\nEscolha uma das opções a cima: ");
            op = scanner.nextLine();

            switch (op) {
                case "1":
                    cadastrar();
                    break;

                case "2":
                    break;

                case "3":
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

        System.out.println("\nDigite o ano de fabricação do veiculo: ");
        int ano = Integer.parseInt(scanner.nextLine());
        v1.setAno(ano);

        System.out.println("\nDigite o número do chassi do veiculo:");
        String chassi = scanner.nextLine();
        v1.setChassi(chassi);

        System.out.println("\nDigite a marca do veiculo:");
        String marca = scanner.nextLine();
        v1.setMarca(marca);

        System.out.println("\nDigite o modelo do veiculo:");
        String modelo = scanner.nextLine();
        v1.setModelo(modelo);

        boolean inserido = daoVeiculo.inserir(v1);

        if (inserido){
            System.out.println("\nVeiculo inserido com sucesso!");
        }
    }

    public void listar() {
        ArrayList<Veiculo> Veiculos;
        Veiculos = daoVeiculo.listarVeiculos();

        System.out.println("\n=====VEICULOS CADASTRADOS======");

        for (Veiculo e : Veiculos) {
            System.out.println("\n"+ e.getCodigo()+"° VEICULO");

            System.out.println("\nModelo do veiculo: "+ e.getModelo());

            System.out.println("\nMarca do veiculo : "+ e.getMarca());

            System.out.println("\nNúmero do chassi do veiculo: "+ e.getChassi());

            System.out.println("\nAno de fabricação do veiculo: "+ e.getAno());

            System.out.println("\n==========//==========");
        }
    }

    public void excluirVeiculo() {
        ArrayList<Veiculo> Veiculos;
        Veiculos = daoVeiculo.listarVeiculos();

        System.out.println("\n=====CODIGO DOS VEICULOS=====");
        for (Veiculo e : Veiculos) {
            System.out.println(e.getCodigo());
        }

        System.out.println("\nDigite o codigo do veiculo que deseja excluir: ");
        int cod = Integer.parseInt(scanner.nextLine());

        int quant = daoVeiculo.excluir(cod);

        if (quant > 0) {
            System.out.println("Veiculo excluido!");
        
        } else {
            System.out.println("Veiculo não encontrado!");
        }
    }
}
