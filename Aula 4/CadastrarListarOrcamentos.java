import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CadastrarListarOrcamentos {
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();

    public void Cadastrar() throws Exception {
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

        orcamentos.add(o);
        System.out.println("\n==========//==========");
    }

    public void Listar() throws Exception{
        System.out.println("\nDigite o CPF do cliente que deseja consultar os orçamentos: ");
        String cpfCliente = reader.readLine();
        
        if (orcamentos.isEmpty()) {
            System.out.println("\nNão há orçamentos cadastrados!");
        
        } else {
            System.out.println("\n=====LISTA DE ORÇAMENTOS DO CLIENTE=====");

                for (Orcamento orc : orcamentos) {
                    
                    if (orc.getCpfCliente().equals(cpfCliente)) {
                        System.out.println("\nNúmero do orçamento: "+ orc.getNumeroOrcamento());

                        System.out.println("\nCPF do cliente: "+ orc.getCpfCliente());
                        
                        System.out.println("\nEquipamento a ser avaliado/consertado: "+ orc.getEquipamento());
                        
                        System.out.println("\nDescrição do orçamento: "+ orc.getDescricao());
                        
                        System.out.println("\nValor: "+ orc.getValor());

                        System.out.println("\n==========//==========");
                    }
                }
        }
    }
}
