public class Orcamento {
    private int numeroOrcamento;
    private String cpfCliente;
    private String descricao;
    private String equipamento;
    private float valor;
    
    public String getCpfCliente() {
        return cpfCliente;
    }
    
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getNumeroOrcamento() {
        return numeroOrcamento;
    }
    
    public void setNumeroOrcamento(int numero) {
        this.numeroOrcamento = numero;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getEquipamento() {
        return equipamento;
    }
    
    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    
    public float getValor() {
        return valor;
    }
    
    public void setValor(float valor) {
        this.valor = valor;
    }

    
}
