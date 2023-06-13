package ex3_enum_vs_final;

public class Cadastro {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.setEstadoCivil(EstadoCivil.CASADO);
        System.out.println("Estado civil da pessoa 1: " 
            +p1.getEstadoCivil());
        
        PessoaEnum p2 = new PessoaEnum();
        p2.setEstadoCivil(EstadoCivilEnum.SOLTEIRO);
        System.out.println("Estado civil da pessoa 1: " 
            +p2.getEstadoCivil());     
    }
}
