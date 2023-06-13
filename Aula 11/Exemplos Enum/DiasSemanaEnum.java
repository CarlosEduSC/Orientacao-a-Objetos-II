public enum DiasSemanaEnum {
    SEG("Segunda-feira"),
    TER("Terça-feira"),
    QUA("Quarta-feira"),
    QUI("Quinta-feira"),
    SEX("Sexta-feira"),
    SAB("Sábado"),
    DOM("Domingo");
    //qdo tem valor vai ; no último item

    String dia;

    //Para atribuir valor aos itens de um enum,
    //deve-se criar um construtor com o mesmo
    //numero de argumentos
    DiasSemanaEnum(String nomeDia){
        this.dia = nomeDia;
    }    

    public String getDia(){
        return this.dia;
    }
}