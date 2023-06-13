import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DatasAniversariantes {
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public Datas datas = new Datas();

    public void cadastrarAniversariante() throws Exception{

        System.out.println("\nDigite o nome do usuário: ");
        String n = reader.readLine();

        System.out.println("\nDigite a data de aniversário do usuário (dia/mês/ano): ");
        String da = reader.readLine();

        datas.inserir(da, n);

        System.out.println("\n==========//==========");
    }

    public void listarDatas() {
        System.out.println("\n=====DATAS QUE CONTÉM ANIVERSÁRIANTES=====");

        for (String data : datas.getData().keySet()) {
            System.out.println("\n"+ data);
        }

        System.out.println("\n==========//==========");
    }

    public void listarAniversariantes() throws Exception{
        System.out.println("\nDigite a data que deseja consultar: ");
        String d = reader.readLine();

        for (String n : datas.getNomes()) {
            System.out.println("\n"+ n);
        }

        /*if (!datas.getData().containsKey(d)) {
            System.out.println("\nData não possui aniversariantes!");
        
        } else {
            for (String key : datas.getData().keySet()) {
                if (key.equals(d)) {
                    System.out.println("\n=====ANIVERSÁRIANTES NA DATA "+ key);
                    
                    for (String n : datas.getData().get(key)) {
                        System.out.println("\n"+ n);
                    }
                }
            }
        }*/

        System.out.println("\n==========//==========");
    }
}