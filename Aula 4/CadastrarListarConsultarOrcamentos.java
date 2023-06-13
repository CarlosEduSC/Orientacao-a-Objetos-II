import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CadastrarListarConsultarOrcamentos {
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();

    public void Cadastrar(ArrayList<Cliente> lista) throws Exception {
        Orcamento o = new Orcamento();

        System.out.println("\nDigite o número do orçamento: ");
        o.setNumeroOrcamento(Integer.parseInt(reader.readLine()));

        System.out.println("\nDigite o CPF do cliente: ");
        o.setCpfCliente(reader.readLine());

        System.out.println("\nDigite o nome do equipamento a ser avaliado/consertado: ");
        o.setEquipamento(reader.readLine());

        System.out.println("\nDigite a descrição do orçamento: ");
        o.setDescricao(reader.readLine());

        System.out.println("\nDigite o valor do orçamento: ");
        o.setValor(Float.parseFloat(reader.readLine()));

        for (Cliente cli : lista) {
            if (cli.getCpf() == o.getCpfCliente()) {
                cli.orcamentosCliente.add(o);
            }
        }

        orcamentos.add(o);
        System.out.println("\n==========//==========");
    }

    public void Listar(ArrayList<Cliente> lista) {
        if (orcamentos.isEmpty()) {
            System.out.println("\nNão há orçamentos cadastrados!");
        
        } else {
            System.out.println("\n=====LISTA DE ORÇAMENTOS=====");

            for (Orcamento orc : orcamentos) {
                for (Cliente cli : lista) {
                    if (cli.getCpf() == orc.getCpfCliente()) {
                        System.out.println("\nNúmero do orçamento: "+ orc.getNumeroOrcamento());

                        System.out.println("\nCPF do cliente: "+ orc.getCpfCliente());
                        
                        System.out.println("\nNome do equipamento a ser avaliado/consertado: "+ orc.getEquipamento());
                        
                        System.out.println("\nDescrição do orçamento: "+ orc.getDescricao());
                        
                        System.out.println("\nValor do orçamento: "+ orc.getValor());

                        System.out.println("\n==========//==========");
                    }
                }
            }
        }
    }

    public void Consultar() throws Exception {
        String op;
        
        do {
            System.out.println("\nDigite o número do orçamento que deseja consultar: ");
            String numero = reader.readLine();

            for (Orcamento orc : orcamentos) {
                if (orc.getNumeroOrcamento() == Integer.parseInt(numero)) {
                    System.out.println("\nNúmero do orçamento: "+ orc.getNumeroOrcamento());

                    System.out.println("\nCPF do cliente: "+ orc.getCpfCliente());
                    
                    System.out.println("\nNome do equipamento a ser avaliado/consertado: "+ orc.getEquipamento());
                    
                    System.out.println("\nDescrição do orçamento: "+ orc.getDescricao());
                    
                    System.out.println("\nValor do orçamento: "+ orc.getValor());
                }

                System.out.println("Deseja consultar outro orçamento (S/N)?");
                op = reader.readLine();

                System.out.println("\n==========//==========");
            }
        } while (op.equals("S") || op.equals("s"));
    }
}
