/*
	* @author bacng
	* @ Date Jul 26, 2022
*/
package Training.Utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DBConnection {
	private static DBConnection instance;
	private Connection connection;

	private DBConnection() {
		Properties properties = new Properties();
		try {
			properties.load(DBConnection.class.getResourceAsStream("/DBConfig.properties"));
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String userName = properties.getProperty("userName");
			String password = properties.getProperty("password");

			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the connection from the instance
	 * 
	 * @return {@link Connection}
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Create new instance which connects with the database.
	 * 
	 * @return DBUtils
	 * @throws SQLException if connection false.
	 */
	public static DBConnection getInstance() throws SQLException {
		if (instance == null || instance.getConnection().isClosed()) {
			instance = new DBConnection();
		}
		return instance;
	}
}
