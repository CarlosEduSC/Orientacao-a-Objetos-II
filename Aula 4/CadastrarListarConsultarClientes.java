import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CadastrarListarConsultarClientes {
    public BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public void Cadastrar() throws Exception {
        Cliente c1 = new Cliente();
        
        System.out.println("\nDigite o nome do cliente: ");
        c1.setNome(reader.readLine());

        System.out.println("\nDigite o CPF do cliente: ");
        c1.setCpf(reader.readLine());

        System.out.println("\nDigite o telefone do cliente: ");
        c1.setTelefone(reader.readLine());

        System.out.println("\nDigite o endereço do cliente: ");
        c1.setEndereço(reader.readLine());

        clientes.add(c1);
        System.out.println("\n==========//==========");
    }

    public void Listar() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
        } else {
        
            System.out.println("\n=====LISTA DE CLIENTES=====");

            for (Cliente cli : clientes) {
                System.out.println("\nNome do cliente: "+ cli.getNome());

                System.out.println("\nCPF do cliente: "+ cli.getCpf());

                System.out.println("\nTelefone do cliente: "+ cli.getTelefone());

                System.out.println("\nEndereço do cliente: "+ cli.getEndereço());

                System.out.println("\n==========//==========");
            }
        }
    }

    public void Consultar() throws Exception {
        String op;

        do {
            System.out.println("\nDigite o CPF do cliente que deseja consultar: ");
            String cpf = reader.readLine();


            for (Cliente cli : clientes) {
                if (cli.getCpf() == cpf) {
                    System.out.println("\nNome do cliente: "+ cli.getNome());

                    System.out.println("\nCPF do cliente: "+ cli.getCpf());

                    System.out.println("\nTelefone do cliente: "+ cli.getTelefone());

                    System.out.println("\nEndereço do cliente: "+ cli.getEndereço());
                }
            }

            System.out.println("\nDeseja consultar outro cliente (S/N)?");
            op = reader.readLine();

            System.out.println("\n==========//==========");
        
        } while (op.equals("S") || op.equals("s"));
    }

    public ArrayList<Cliente> pegarLista() {
        return clientes;
    }
}
