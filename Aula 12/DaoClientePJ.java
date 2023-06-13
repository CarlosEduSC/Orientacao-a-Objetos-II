import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoClientePJ {
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

    public boolean inserir(ClientePJ c) {
        boolean resultado = false;

        try {
            conectar();

            PreparedStatement pst = con.prepareStatement("insert into tb_clientes_pj (cod_cli_pj,nome, cnpj) values (null, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, c.getNome());
            pst.setString(2, c.getCnpj());
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            int idCliente = 0;

            if (rs.next()) {
                idCliente = rs.getInt(1);

                PreparedStatement pstEnd = con.prepareStatement("insert into tb_enderecos_pj (cod_end,cod_cli_pj,rua, numero, bairro, cep) values (null, ?, ?, ?, ?, ?);");

                pstEnd.setInt(1, idCliente);
                pstEnd.setString(2, c.getEnderecoPJ().getRua());
                pstEnd.setInt(3, c.getEnderecoPJ().getNumero());
                pstEnd.setString(4, c.getEnderecoPJ().getBairro());
                pstEnd.setString(5, c.getEnderecoPJ().getCep());
                pstEnd.executeUpdate();

                resultado = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir registro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return resultado;
    }

    public ArrayList<ClientePJ> listarClientePJ() {
        ArrayList<ClientePJ> resultados = new ArrayList<ClientePJ>();

        try {
            conectar();
            ResultSet rs = st.executeQuery("select * from tb_clientes_pj,tb_enderecos_pj where tb_clientes_pj.cod_cli_pj = tb_enderecos_pj.cod_cli_pj order by tb_clientes_pj.nome;");

            while (rs.next()) {
                ClientePJ c =new ClientePJ();
                c.setCodigoClientePJ(rs.getInt("cod_cli_pj"));
                c.setNome(rs.getString("nome"));
                c.setCnpj(rs.getString("cnpj"));

                EnderecoPJ e = new EnderecoPJ();
                e.setCodigo(rs.getInt("cod_end"));
                e.setRua(rs.getString("rua"));
                e.setNumero(rs.getInt("numero"));
                e.setBairro(rs.getString("bairro"));
                e.setCep(rs.getString("cep"));

                c.setEnderecoPJ(e);

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
            String comandoEnd = "delete from tb_enderecos_pj where cod_cli_pj = "+ cod + ";";
            st.executeUpdate(comandoEnd);
            
            String comandoCli = "delete from tb_clientes_pj where cod_cli_pj = "+ cod + ";";
            st.executeUpdate(comandoCli);
            
            quantidade = st.getUpdateCount();


        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return quantidade;
    }

    public Veiculo consultar(int cod) {
        Veiculo v = null;

        try {
            conectar();
            ResultSet rs = st.executeQuery("select * from tb_veiculos where codigo = "+ cod + ";");

            if (rs.next()) {
                v = new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setChassi(rs.getString("chassi"));
                v.setAno(rs.getInt("ano"));
            }
        
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return v;
    }

    public int alterar(Veiculo v) {
        int quant = 0;

        try {
            conectar();
            st.executeUpdate("update tb_veiculos set marca = '"+ v.getMarca() + "', modelo = '"+ v.getModelo() + "', chassi = '"+ v.getChassi() + "', ano = "+ v.getAno() + " where codigo = "+ v.getCodigo() + ";");
            quant = st.getUpdateCount();
        
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        
        } finally {
            desconectar();
        }

        return quant;
    }
}
