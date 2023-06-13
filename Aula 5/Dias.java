import java.util.HashMap;

public class Dias {
    public static void main(String[] args) {
        HashMap<String, String> diasSemana = new HashMap<String, String>();
        diasSemana.put("SEG", "Segunda-feira");
        diasSemana.put("TER", "Terça-feira");
        diasSemana.put("QUA", "Quarta-feira");
        diasSemana.put("QUI", "Quinta-feira");
        diasSemana.put("SEX", "Sexta-feira");
        diasSemana.put("SAB", "Sábado");
        diasSemana.put("DOM", "Domingo");

        System.out.println("\nMostrando os pares armazenados: "+ diasSemana);

        System.out.println("\n"+ diasSemana.get("SEG"));

        System.out.println("\nVerificando se um item existe:\nQUA existe?" + diasSemana.containsKey("QUA"));
        System.out.println("XYZ existe?" + diasSemana.containsKey("XYZ"));

        System.out.println("\nPesquisando um item: "+ diasSemana.get("TER"));

        System.out.println("\nA quantidade de pares é: "+ diasSemana.size());

        System.out.println("\nRemovendo um item: "+ diasSemana.remove("TER"));
        System.out.println("A quantidade de pares é: "+ diasSemana.size());

        System.out.println("\nPercorrendo o conjunto de chaves:");

        for (String chave : diasSemana.keySet()) {
            System.out.println(chave);
        }

        System.out.println("\nPercorrendo o conjunto de valores:");

        for (String item : diasSemana.values()) {
            System.out.println(item);
        }

        System.out.println("\nRemovendo todos os pares...");
        
        diasSemana.clear();

        System.out.println("A quantidade de pares é: "+ diasSemana.size());
    }
}
