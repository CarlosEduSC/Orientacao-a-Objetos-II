import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sistema {
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        Sistema s1 = new Sistema();
        s1.menu();
    }

    public void menu() throws Exception{
        String op = "";
        DatasAniversariantes da = new DatasAniversariantes();

        do {
            System.out.println("\n1- Adicionar aniversariante.\n2- Listar as datas que comtém aniversariantes.\n3- Consultar os aniversariantes de uma determinada data.\n4- Sair.");

            System.out.println("\nEscolha uma das opções acima: ");
            op = reader.readLine();

            System.out.println("\n==========//==========");

            switch (op) {
                case "1":
                    da.cadastrarAniversariante();
                    break;

                case "2":
                    da.listarDatas();
                    break;

                case "3":
                    da.listarAniversariantes();
                    break;

                case "4":
                    break;
                
                default:
                    System.out.println("\nOpção invalida!");
            }

        } while (!op.equals("4"));
    }
}
