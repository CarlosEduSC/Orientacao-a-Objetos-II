enum Nivel{
    BAIXO,
    MEDIO,
    ALTO
}

public class ExEnum2 {
    public static void main(String[] args) {
        Nivel nivelAtual = Nivel.MEDIO;

        switch (nivelAtual) {
            case BAIXO:
                System.out.println("Nível Baixo");
                break;
            case MEDIO:
                System.out.println("Nível Médio");
                break;
            case ALTO:
                System.out.println("Nível Alto");
                break;
        }

        //percorrer as opções
        System.out.println("As opções de nível são:");
        for(Nivel nivel : Nivel.values()){
            System.out.println(nivel);
        }
    }
}
