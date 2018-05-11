package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection connection;

	private static String url = "jdbc:postgresql://localhost:5432/sisnpj";

	private static String user = "postgres";

	private static String pass = "";

	public static Connection getConnection() {

		try {

			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(url, user, pass);

		}

		catch (SQLException e) {

			System.out.println("Erro Conexão com Banco de Dados - Detalhes: " + e);

			throw new RuntimeException(e);

		}

		catch (ClassNotFoundException e) {

			System.out.println("Erro Carregamento Driver Conexão - Detalhes: " + e);

			throw new RuntimeException(e);

		}

		return connection;

	}
}
