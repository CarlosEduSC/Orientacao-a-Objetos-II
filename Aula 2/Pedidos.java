import java.io.*;
import java.time.format.DateTimeParseException;

public class Pedidos {
    BufferedReader reader;

    public static void main(String[] args) {
        try {
        Pedidos p1 = new Pedidos();
        LeituraGravacao lg = new LeituraGravacao();
        p1.reader=  new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Digite o nome que deseja dar ao arquivo: ");
        String nome = p1.reader.readLine();
        nome = nome + ".csv";

        
            lg.gravarArq(nome);
            lg.lerArq(nome);
        
        } catch (arquivoVazioException e1){
            e1.getMessage();
        
        } catch (FileNotFoundException e2) {
            System.out.println("\nArquivo não encontrado!");
        
        } catch (DateTimeParseException e3) {
            System.out.println("\nO arquivo contem uma data invalida!");
        
        } catch (Exception e4) {
            System.out.println("\nErro inesperado incontrado.Por favor entrar em contato com o suporte!");
        }
    }

}
