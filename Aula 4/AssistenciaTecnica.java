import java.io.*;

public class AssistenciaTecnica {
    public BufferedReader reader;
    public static void main(String[] args) throws Exception {
        AssistenciaTecnica at1 = new AssistenciaTecnica();
        at1.reader = new BufferedReader(new InputStreamReader(System.in));
        at1.menu();
    }

    public void menu() throws Exception{
        String menu;
        CadastrarListarClientes clcc = new CadastrarListarClientes();
        CadastrarListarOrcamentos clco = new CadastrarListarOrcamentos();
        
        do {

            System.out.println("\n1- Cadastrar cliente.\n2- Listar clientes.\n3- Cadastrar orçamento.\n4- Listar orçamentos de um cliente.\n5- Sair.");
            System.out.println("\nEscolha uma das opções a cima:");
            menu = this.reader.readLine();

            System.out.println("\n==========//==========");

            switch ((Integer.parseInt(menu))) {
                case 1:
                    clcc.Cadastrar();
                    break;

                case 2:
                    clcc.Listar();
                    break;
                
                case 3:
                    clco.Cadastrar();
                    break;

                case 4:
                    clco.Listar();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("\nOpção invalida!");
            }

        } while ((Integer.parseInt(menu)) != 5);
    }
}
