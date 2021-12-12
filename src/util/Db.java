/*
 * Singleton pattern
 * - Advantage is one object throughout the project
 * - Constructor has to be private.
 * - All properties need to be static.
 */

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Db {
	private Db() {

	}

	public static Connection getDbProperties() {
		Connection con = null;
		ResourceBundle rb = ResourceBundle.getBundle("db");
		try {
			Class.forName(rb.getString("driver"));
			con = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Exception occurred in Db.java " + e.getMessage());
		}
		return con;
	}
}
