import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CadastrarListarClientes {
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
                System.out.println("\nNome  : "+ cli.getNome());

                System.out.println("\nCPF: "+ cli.getCpf());

                System.out.println("\nTelefone: "+ cli.getTelefone());

                System.out.println("\nEndereço: "+ cli.getEndereço());

                System.out.println("\n==========//==========");
            }
        }
    }
}
