public class UsaValoresEnum {
    public static void main(String[] args) {
        System.out.println("Dia: " 
            + DiasSemanaEnum.QUA);
        System.out.println("Dia: " 
            + DiasSemanaEnum.QUA.getDia());
        
        System.out.println("Campus: " 
            + CampiIfprEnum.FOZ.getNome()
            + " / inaugurado em " 
            + CampiIfprEnum.FOZ.getAnoCricao());
    }
}
