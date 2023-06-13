public class ExAtributosFinal {
    private final int codigo = 123;
    public static void main(String[] args) {
        final float pi = 3.14f;
        //pi = 2; //não pode
        System.out.println("pi vale " + pi);

        ExAtributosFinal ex = new ExAtributosFinal();
        System.out.println("codigo vale " 
            + ex.codigo);
    }
}