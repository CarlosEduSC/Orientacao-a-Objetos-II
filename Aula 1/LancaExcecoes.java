import java.io.*;

public class LancaExcecoes{
    public static void main(String[] args) throws Exception {
        LancaExcecoes le1 = new LancaExcecoes();
        le1.LerArquivos();
    }

    public void LerArquivos() throws Exception {
        String arqEntrada = "arquivo.txt";
        BufferedReader arq = new BufferedReader(new FileReader(arqEntrada));
        String linha;

        while((linha = arq.readLine()) != null) {
            System.out.println(linha +"\n");
        }
    }
}