import java.io.*;

public class TrataExcecoes {
    public static void main(String[] args) {
        TrataExcecoes te1 = new TrataExcecoes();
        te1.LerArquivos();
    }

    public void LerArquivos(){
        try {
            String arqEntrada = "arquivo.txt";
            BufferedReader arq = new BufferedReader(new FileReader(arqEntrada));
            String linha;

            while((linha = arq.readLine()) != null) {
                System.out.println(linha +"\n");
            }

            arq.close();

        } catch (FileNotFoundException e1) {
            System.out.println("Arquivo não encontrado!");
        
        } catch (Exception ex2) { //captura exceções genericas
            System.out.println("Erro inesperado!");

        } finally { // executado sempre
            System.out.println("Encerrando...");
        }
    }
}
