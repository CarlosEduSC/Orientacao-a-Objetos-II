public class OperacoesMatematicas {
    public int dividir(int num1,int num2) throws DivisaoPorZeroExeption {
        if (num2 == 0) {
            throw new DivisaoPorZeroExeption();
        }

        return num1/num2;
    }    
}
