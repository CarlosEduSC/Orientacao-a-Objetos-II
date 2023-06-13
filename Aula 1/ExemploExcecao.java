public class ExemploExcecao {
    public static void main(String[] args) {
        ExemploExcecao ee1 =new ExemploExcecao();

        ee1.calcular();
        System.out.println("Fim...");
    }

    public void calcular() {
        try {
            float res;
            OperacoesMatematicas opMat = new OperacoesMatematicas();

            res = opMat.dividir(5, 2);
            System.out.println(res);
            res = opMat.dividir(4, 0);
            System.out.println(res);
        
        } catch (DivisaoPorZeroExeption e1) {
            System.out.println("Descrição do erro: " + e1.getMessage());
        }
    }
}
