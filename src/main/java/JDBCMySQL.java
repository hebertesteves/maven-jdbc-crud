import java.sql.*;
import java.util.Properties;

public class JDBCMySQL {
    public static void main(String[] args) {

        try {
            // URL de conexão com o banco MySQL
            String url = "jdbc:mysql://localhost:3306/rocket_db";

            // Propriedades de autenticação
            Properties props = new Properties();
            props.setProperty("user", "root");     // usuário MySQL
            props.setProperty("password", ""); // senha MySQL

            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Conectado ao MySQL com sucesso!");

            String instrucaoSQL = "INSERT INTO `tab_cadastro` (`nome`, `idade`) VALUES (?, ?)";
            String nome = "Hebert";
            Integer idade = 19;

            PreparedStatement pst = conn.prepareStatement(instrucaoSQL);
            pst.setString(1, nome);
            pst.setInt(2, idade);

            pst.execute();
            System.out.println("Cadastro inserido com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
