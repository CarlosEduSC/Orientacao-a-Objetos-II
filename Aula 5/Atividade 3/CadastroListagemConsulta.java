import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CadastroListagemConsulta {

    public HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>();
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void Cadastrar(Aeroporto a) throws Exception {
        System.out.println("\nDigite o nome do aeroporto: ");
        a.setNome(reader.readLine());

        System.out.println("\nDigite a cidade onde se encontra o aeroporto: ");
        a.setCidade(reader.readLine());

        System.out.println("\nDigite a altitude em que se encontra o aeroporto: ");
        a.setAltitude(Integer.parseInt(reader.readLine()));

        System.out.println("\nDigite a sigla de indentificação do aeroporto: ");
        String s = reader.readLine();

        aeroportos.put(s, a);
        System.out.println("\n==========//==========");
    }

    public void Listar() {
        System.out.println("\n=====LISTA DE AEROPORTOS CADASTRADOS=====");

        for (Aeroporto item : aeroportos.values()) {
            System.out.println("\nNome do aeroporto: "+ item.getNome());
            System.out.println("\nCidade onde se encontra o aeroporto: "+ item.getCidade());
            System.out.println("\nAltitude em que se encontra o aeroporto: "+ item.getAltitude());

            System.out.println("\n==========//==========");
        }

    }

    public void Consulta() throws Exception {
        String op;

        do {
            System.out.println("\nDigite a sigla do aeroporto que deseja consultar: ");
            String sigla = reader.readLine();

            if (aeroportos.containsKey(sigla)) {
                System.out.println("\nNome do aeroporto: "+ aeroportos.get(sigla).getNome());
                System.out.println("\nCidade do aeroporto: "+ aeroportos.get(sigla).getCidade());
                System.out.println("\nAltitude em que se encontra o aeroporto: "+ aeroportos.get(sigla).getNome());

            } else {
                System.out.println("\nAeroporto não encontrado!");
            }

            System.out.println("\nDeseja consultar outro aeroporto (S/N)?");
            op = reader.readLine();

            System.out.println("\n==========//==========");
        
        } while (op.equals("S") || op.equals("s"));
    }

    public void Remover() throws Exception {
        String op;

        do {
            System.out.println("\nDigite a sigla do aeroporto que deseja consultar: ");
            String sigla = reader.readLine();

            if (aeroportos.containsKey(sigla)) {
                aeroportos.remove(sigla);

                System.out.println("\nAeroporto removido!");
            
            } else {
                System.out.println("\nAeroporto não encontrado!");
            }
            
            System.out.println("\nDeseja remover outro aeroporto (S/N)?");
            op = reader.readLine();

            System.out.println("\n==========//==========");

        } while (op.equals("S") || op.equals("s"));
    }
}