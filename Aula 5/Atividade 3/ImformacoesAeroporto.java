import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ImformacoesAeroporto {
    public BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
    public CadastroListagemConsulta cadastro = new CadastroListagemConsulta();
    public static void main(String[] args) throws Exception {
        ImformacoesAeroporto ia1 = new ImformacoesAeroporto(); 
        ia1.menu();
    }

    public void menu()throws Exception {
        String menu;
        do {
        System.out.println("\n1- Cadastrar aeroporto.\n2- Listar os aeroportos cadastrados.\n3- Remover aeroporto.\n4- Consultar detalhes de um aeroporto usando sua sigla.\n5- Sair;");
        
        System.out.println("\nEscolha uma das opções a cima: ");
        menu = reader.readLine();

        System.out.println("\n==========//==========");

        switch (menu) {
            case "1":
                Aeroporto a1 = new Aeroporto();
                
                cadastro.Cadastrar(a1);
                
                break;
            
            case "2":
                cadastro.Listar();

                break;
            
            case "3":
                cadastro.Remover();
                
                break;
            
            case "4":
                cadastro.Consulta();

                break;

            case "5":
                break;
            default:
                System.out.println("\nOpção invalida!");
                break;
        }

        } while (!menu.equals("5"));
    }
}
