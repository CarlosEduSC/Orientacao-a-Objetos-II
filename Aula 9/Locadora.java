import java.util.Scanner;

public class Locadora {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Locadora l = new Locadora();
        l.menu();
    }

    public void menu() {
        String op;

        do {
            System.out.println("\n=====MENU PRINCIPAL=====");

            System.out.println("\n1- Gerenciar veiculos.\n2- Gerenciar clientes.\n3- Sair.");

            System.out.println("\nEscolha uma das opções a cima: ");
            op = scanner.nextLine();

            switch (op) {
                case "1":
                    GerenciadorVeiculo gv = new GerenciadorVeiculo();
                    gv.menu();
                    break;

                case "2":
                    GerenciadorCliente gc = new GerenciadorCliente();
                    gc.menu();
                    break;

                case "3":
                    break;
            
                default:
                    System.out.println("\nOpção invalida!");
                    break;
            }
        
        } while(!op.equals("3"));
    }
}
