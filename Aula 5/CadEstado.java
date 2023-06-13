import java.util.HashMap;

public class CadEstado {
    public static void main(String[] args) {
        HashMap<String, Estado> estados = new HashMap<String, Estado>();

        Estado e1 = new Estado();
        e1.setNome("Paraná");
        e1.setRegiao("Sul");
        estados.put("PJ", e1);

        Estado e2 = new Estado();
        e2.setNome("Rio de Janeiro");
        e2.setRegiao("Sudeste");
        estados.put("RJ", e2);

        Estado e3 = new Estado();
        e3.setNome("São Paulo");
        e3.setRegiao("Sudeste");
        estados.put("SP", e3);

        System.out.println("\nEstados armazenados: "+ estados);
        
        System.out.println("\nVerificando se um estado existe:");
        if (estados.containsKey("SP")) {
            System.out.println("SP existe no HashMap");
            System.out.println("Buscando a região do estado e SP: "+ estados.get("SP").getRegiao());
        }


        System.out.println("\nPercorrendo o conjunto de chaves:");

        for (String chave : estados.keySet()) {
            System.out.println(chave);
        }

        System.out.println("\nPercorrendo o conjunto de valores:");

        for (Estado item : estados.values()) {
            System.out.println(item.getNome());
        }
    }
}
