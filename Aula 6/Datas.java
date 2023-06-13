import java.util.ArrayList;
import java.util.HashMap;

public class Datas {
    public HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
    public ArrayList<String> nomes = new ArrayList<String>();

    public void inserir(String d,String n) {
        nomes.add(n);
        data.put(d, nomes);
    }

    public HashMap<String, ArrayList<String>> getData() {
        return data;
    }

    public ArrayList<String> getNomes() {
        return nomes;
    }
}
