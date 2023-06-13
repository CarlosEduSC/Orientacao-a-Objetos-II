import java.util.ArrayList;
import java.util.Iterator;

public class Cadclientes {
    public static void main(String[] args) {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        Cliente c1 = new Cliente();
        c1.setNome("Carlos");
        c1.setCpf("0133937398");
        c1.setEmail("carloeseduardodas.c@gmail.com");
        c1.setFone("988142045");

        lista.add(c1);

        Cliente c2 = new Cliente();
        c2.setNome("Vitor");
        c2.setCpf("12345678910");
        c2.setEmail("vitor@gmail.com");
        c2.setFone("1234567890");

        lista.add(c2);

        Cliente c3 = new Cliente();
        c3.setNome("Jackson");
        c3.setCpf("10987654321");
        c3.setEmail("irmã_do_jackson_é_gata@gmail.com");
        c3.setFone("0987654321");

        lista.add(c3);

        System.out.println("\n=====LISTA DE CLIENTES=====");
        Iterator<Cliente> it = lista.iterator();

        while(it.hasNext()) {

            Cliente cli = it.next();
            System.out.println("\nNome do Cliente: "+ cli.getNome());
            System.out.println("\nCPF do Cliente: "+ cli.getCpf());
            System.out.println("\nEmail do Cliente: "+ cli.getEmail());
            System.out.println("\nTelefone do Cliente: "+ cli.getFone());
            System.out.println("\n==========//==========");
        }

        Cliente cRemover = new Cliente();
        cRemover.setNome("Vitor");
        cRemover.setCpf("12345678910");
        cRemover.setEmail("vitor@gmail.com");
        cRemover.setFone("1234567890");
        
        if(lista.contains(cRemover)) {
            System.out.println("Encrotado!");
        }

        Cliente cRemover2 = new Cliente();
        cRemover2.setCpf("12345678910");

        Iterator<Cliente> itRemover = lista.iterator();
        
        while(itRemover.hasNext()) {
            if(itRemover.next().getCpf().equals(cRemover2.getCpf())) {
                System.out.println("\nRemovendo cliente:");
                itRemover.remove();
            }
        }

        Iterator<Cliente> it3 = lista.iterator();
        while(it3.hasNext()) {

            Cliente cli = it3.next();
            System.out.println("\nNome do Cliente: "+ cli.getNome());
            System.out.println("\nCPF do Cliente: "+ cli.getCpf());
            System.out.println("\nEmail do Cliente: "+ cli.getEmail());
            System.out.println("\nTelefone do Cliente: "+ cli.getFone());
            System.out.println("\n==========//==========");
        }
    }   
}
