public class TestarMenu {
    public static void main(String[] args) {
        executarAcao(OpcoesMenuEnum.EXCLUIR);
        executarAcao(OpcoesMenuEnum.SAIR);
    }

    public static void executarAcao(OpcoesMenuEnum opcao){
        //executa a ação relacionada à opção recebida
        if(opcao.equals(OpcoesMenuEnum.CADASTRAR)){
            System.out.println("Inserindo os dados...");
            //chama a ação de inserção
        }else if(opcao.equals(OpcoesMenuEnum.EXCLUIR)){
            System.out.println("Apagando o registro...");
        }

        switch (opcao) {
            case CONSULTAR:
                System.out.println("Consulta...");
                break;
            case SAIR:
                System.out.println("Encerrando...");
                break;
        }
    }
}