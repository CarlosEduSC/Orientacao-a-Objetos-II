import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoVeiculo {
    private Connection con;
    private Statement st;

    private void conectar() {
        try {
            con = GerenciadorConexao.pegarConexao();
            st = con.createStatement();
        
        } catch (ClassNotFoundException e1) {
            System.out.println(e1.getMessage());
        
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    private void desconectar() {
        try {
            st.close();
            con.close();
        
        } catch (SQLException e2) {
            System.out.println("Erro ao encerrar a conexâo: "+ e2.getMessage());
        }
    }

    public boolean inserir(Veiculo v) {
        boolean resultado = false;

        try {
            conectar();
            String comando = "insert into tb_veiculos values (NULL, '"+ v.getMarca() + "', '"+ v.getModelo() +"', '"+ v.getChassi() +"', "+ v.getAno() +");";

            st.executeUpdate(comando);
            resultado = true;


        } catch (SQLException e) {
            System.out.println("Erro ao inserir registro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return resultado;
    }

    public ArrayList<Veiculo> listarVeiculos() {
        ArrayList<Veiculo> resultados = new ArrayList<Veiculo>();

        try {
            conectar();
            ResultSet rs = st.executeQuery("select * from tb_veiculos order by modelo");

            while (rs.next()) {
                Veiculo v =new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setChassi(rs.getString("chassi"));
                v.setAno(rs.getInt("ano"));

                resultados.add(v);
            }
        
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return resultados;
    }

    public int excluir(int cod) {
        int quantidade = 0;

        try {
            conectar();
            String comando = "delete from tb_veiculos where codigo = "+ cod + ";";
            st.executeUpdate(comando);
            quantidade = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return quantidade;
    }
}
