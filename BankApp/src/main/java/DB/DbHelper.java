package DB;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;

public class DbHelper {
	private String userName = "root";
	private String password = "emre";
	private String port = "jdbc:mysql://localhost:3306/bankappdb";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(port, userName, password);
	}

	public void showErrorMessage(SQLException ex) {
		System.out.println(ex.getMessage());
		System.out.println("Error code: " + ex.getErrorCode());
	}
}