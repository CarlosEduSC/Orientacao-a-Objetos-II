public class ExEstatico {
    private String nome;
    private static int x;
    private int y;

    public static void main(String[] args) {
        x = 5;
        //y = 6;

        ExEstatico ex1 = new ExEstatico();
        ex1.y = 8;
        ex1.nome = "A";
        ex1.testar();

        ExEstatico ex2 = new ExEstatico();
        ex2.y = 10;
        ex2.nome = "B";
        ex2.x = 2;
        ex2.testar();
        ex1.testar();

        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();
        System.out.println("qtde de clientes = " 
            + Cliente.qtdeClientes);
    }

    private void testar(){
        System.out.println("nome = " + this.nome);
        System.out.println("x = " + this.x);
        System.out.println("y = " + this.y);
    }
}
