import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereço;
    private String telefone;
    private String cpf;
    public ArrayList<Orcamento> orcamentosCliente =  new ArrayList<Orcamento>();
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereço() {
        return endereço;
    }
    
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
