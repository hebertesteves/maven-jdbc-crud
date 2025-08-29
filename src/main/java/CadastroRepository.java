import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
    private Connection conn;

    public CadastroRepository() {
        conn = FabricaConexao.getConn();
    }

    public void incluir(Cadastro cadastro){
        String instrucaoSQL = "INSERT INTO tab_cadastro (nome, idade) VALUES (?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(instrucaoSQL)) {
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());

            pst.execute();
            System.out.println("Cadastro inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Não foi possivel realziar o cadastro!");
            ex.printStackTrace();
        }
    }

    public void alterar(Cadastro cadastro){
        String instrucaoSQL = "UPDATE tab_cadastro SET nome = ?, idade = ? WHERE id = ?";

        try (PreparedStatement pst = conn.prepareStatement(instrucaoSQL)) {
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());

            pst.execute();
            System.out.println("Update realizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Não foi possivel realziar o update!");
            ex.printStackTrace();
        }
    }

    public void excluir(Integer id){
        String instrucaoSQL = "DELETE FROM tab_cadastro WHERE id = ?";

        try (PreparedStatement pst = conn.prepareStatement(instrucaoSQL)) {
            pst.setInt(1, id);

            pst.execute();
            System.out.println("Cadastro excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Não foi possivel realizar a exclusão do cadastro!");
            ex.printStackTrace();
        }
    }

    public List<Cadastro> listar(){
        String instrucaoSQL = "SELECT id, nome, idade FROM tab_cadastro";
        List<Cadastro> list = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement(instrucaoSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");
                list.add(new Cadastro(id, nome, idade));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public Cadastro buscar(Integer id){
        String instrucaoSQL = "SELECT id, nome, idade FROM tab_cadastro WHERE id = ?";
        Cadastro cadastro = null;

        try (PreparedStatement statement = conn.prepareStatement(instrucaoSQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");
                cadastro = new Cadastro(id, nome, idade);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cadastro;
    }
}
