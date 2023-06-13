public enum OpcoesMenuEnum {
    CADASTRAR(1), CONSULTAR(2), 
    ATUALZIAR(3), EXCLUIR(4), SAIR(0);

    private int valor;

    OpcoesMenuEnum(int val){
        this.valor = val;
    }

    public int getValor(){
        return this.valor;
    }
}
