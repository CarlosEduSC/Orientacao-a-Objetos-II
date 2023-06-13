import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoClientes {
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

    public boolean inserir(Cliente c) {
        boolean resultado = false;

        try {
            conectar();
            String comando = "insert into tb_usuarios values (NULL, '"+ c.getNome() + "', '"+ c.getTelefone() +"', '"+ c.getEmail() +"');";

            st.executeUpdate(comando);
            resultado = true;


        } catch (SQLException e) {
            System.out.println("Erro ao inserir registro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return resultado;
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> resultados = new ArrayList<Cliente>();

        try {
            conectar();
            ResultSet rs = st.executeQuery("select * from tb_usuarios order by id");

            while (rs.next()) {
                Cliente c =new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));

                resultados.add(c);
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
            String comando = "delete from tb_usuarios where id = "+ cod + ";";
            st.executeUpdate(comando);
            quantidade = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return quantidade;
    }

    public Cliente consultar(int cod) {
        Cliente c = null;

        try {
            conectar();
            ResultSet rs = st.executeQuery("select * from tb_usuarios where id = "+ cod + ";");

            if (rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
            }
        
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return c;
    }

    public int alterar(Cliente c) {
        int quant = 0;

        try {
            conectar();
            st.executeUpdate("update tb_usuarios set nome = '"+ c.getNome() + "', telefone = '"+ c.getTelefone() + "', email = '"+ c.getEmail() + "' where id = "+ c.getId() + ";");
            quant = st.getUpdateCount();
        
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return quant;
    }
}
