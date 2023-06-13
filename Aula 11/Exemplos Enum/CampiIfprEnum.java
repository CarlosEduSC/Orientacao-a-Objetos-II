public enum CampiIfprEnum {
    FOZ("IFPR Campus Foz do Iguaçu", 2009, "(45)3422-5300"),
    CASCAVEL("IFPR Campus Cascavel", 2011, "(45)3422-8888"),
    CURITIBA("IFPR Campus Curitiba", 2008, "(45)3333-5300"),
    CAPANEMA("IFPR Campus Capanema", 2014, "(45)4567-6767");

    String nome, fone;
    int anoCricao;

    CampiIfprEnum(String nome, int ano, String fone){
        this.nome = nome;
        this.anoCricao = ano;
        this.fone = fone;
    }

    public String getNome() {
        return this.nome;
    }

    public String getFone() {
        return this.fone;
    }

    public int getAnoCricao() {
        return this.anoCricao;
    }    
}
