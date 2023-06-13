import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorVeiculo {
    Scanner scanner;
    DaoVeiculo daoVeiculo;

    public GerenciadorVeiculo(){
        scanner = new Scanner(System.in);
        daoVeiculo = new DaoVeiculo();
    }

    public void menu(){
        int opcao = -1;
        while(opcao != 0){
			System.out.println("\n------------------------------------------");
			System.out.println("GERENCIAMENTO DE VEICULOS");
			System.out.println("[1] Cadastrar");
			System.out.println("[2] Consultar");
			System.out.println("[3] Alterar");
			System.out.println("[4] Excluir");
			System.out.println("[5] Listar todos");
			System.out.println("[0] Voltar ao menu anterior");
			System.out.println("\n------------------------------------------");

            try{
                opcao = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                System.out.println("Erro... informe um numero inteiro. " 
                    + e.getMessage());
            }

            if(opcao == 1){
                this.cadastrar();
            }else if(opcao == 4){
                this.excluir();
            }else if(opcao == 5){
                this.listarTodos();
            }
        }
    }

    public void cadastrar(){
        Veiculo veiculo = new Veiculo();
		
		System.out.println("\n--------------------------------------------------------------");
		System.out.println("[Cadastro de Veiculos]");
		System.out.println("Marca: ");
		veiculo.setMarca(scanner.nextLine());
		System.out.println("Modelo: ");
		veiculo.setModelo(scanner.nextLine());
		System.out.println("Chassi: ");
		veiculo.setChassi(scanner.nextLine());
		System.out.println("Ano: ");
		veiculo.setAno(Integer.parseInt(scanner.nextLine()));       

        boolean inserido = daoVeiculo.inserir(veiculo);//passa o objeto para a camada model
        if(inserido){
            System.out.println("Inserido com sucesso.");
        }
    }

    private void listarTodos(){
        ArrayList<Veiculo> resultado = daoVeiculo.buscarTodos();
        System.out.println("---------------------------");
        System.out.println("Veiculos cadastrados:");
        for(Veiculo v : resultado){
            System.out.println("Modelo: " + v.getModelo()
                + ", Marca: " + v.getMarca()
                + ", Chassi: " + v.getChassi()
                + ", Ano: " + v.getAno()
                + ", Codigo: " + v.getCodigo());
        }
    }

    public void excluir(){
        System.out.println("---------------------------");
        System.out.println("[Exclusão de veiculos]");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine()); 
        int qtde = daoVeiculo.excluir(codigo);
        if(qtde > 0){
            System.out.println("Excluído com sucesso");
        }else{
            System.out.println("Não encontrado...");
        }
    }
}
