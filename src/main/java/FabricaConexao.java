import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao {
    private static Connection conn;

    public static void conectar() {
        try {
            if (conn == null) {
                // URL de conexão com o banco MySQL
                String url = "jdbc:mysql://localhost:3306/rocket_db";

                // Propriedades de autenticação
                Properties props = new Properties();
                props.setProperty("user", "root");     // usuário MySQL
                props.setProperty("password", ""); // senha MySQL

                conn = DriverManager.getConnection(url, props);
                System.out.println("Conectado ao MySQL com sucesso!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static Connection getConn() {
        return conn;
    }
}
