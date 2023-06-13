import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LeituraGravacao {
    public BufferedReader ler;
    public BufferedWriter gravar;

    public void gravarArq(String nome)throws Exception {

        gravar = new BufferedWriter(new FileWriter(nome));

        String linha = "Carlos;20/12/2021";
        gravar.write(linha);
        gravar.newLine();
        linha = "Marcelo;12/03/2022";
        gravar.write(linha);
        gravar.newLine();
        linha = "Bianca;21/04/2022";
        gravar.write(linha);
        gravar.newLine();
        linha = "Pedro;25/04/2022";
        gravar.write(linha);
        gravar.newLine();
        linha = "Bruna;04/05/2022";
        gravar.write(linha);
        gravar.newLine();

        gravar.close();
    }

    public void lerArq(String nome)throws Exception {
        ler = new BufferedReader(new FileReader(nome));
        String linha;
        int quantidadeLinhas = 0;
        
        System.out.println("\n=====LISTA DE PEDIDOS=====");

        while ((linha = ler.readLine()) != null) {
            quantidadeLinhas++;
            String[] split = linha.split(";");

            System.out.println("\nNome do cliente: "+ split[0]);
            System.out.println("\nData do pedido: " + split[1]);
            System.out.println("\nData limite de entrega do pedido: "+ calcularDataLimite(split[1]));
            System.out.println("\n==========//==========");
        }

        ler.close();

        if (quantidadeLinhas == 0) {
            throw new arquivoVazioException();
        }
    }

    public String calcularDataLimite(String d) throws DateTimeParseException {

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(d, formatoData);
        data = data.plusDays(7);
        return (data.format(formatoData));
    }
}
