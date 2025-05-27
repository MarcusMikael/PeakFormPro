
package dao;
// Imports para fazer a conexão com o banco de dados
// Precisa baixar o .JAR do postgresql e adicionar em "Libraries"
// Só consegui fazer pelo NetBeans, não dava certo no eclipse.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    private static final String URL = "jdbc:postgresql://localhost:5432/PeakFormPro"; // Local no banco de dados
    private static final String USUARIO = "postgres"; // Usuario
    private static final String SENHA = "M@mikael22"; // Senha do pgAdmin4

    // Construtor privado para impedir instanciamento externo
    private ConnectionFactory() {}

    public static Connection getConnection() {
        try {
            // Verifica se a conexão não existe ou está fechada
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.out.println("Conexão sucedida!!");
            }
        } catch (SQLException s) {
            System.out.println("Erro ao conectar: " + s.getMessage());
            throw new RuntimeException("Erro ao obter conexão com o banco de dados", s);
        }
        return connection;
    }
}
