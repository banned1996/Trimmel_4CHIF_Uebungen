import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Main {

	static String DATABASE = "shopdb", HOST = "127.0.0.1", USER = "root",
			PASSWORD = "";
	static int PORT = 3306;

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String conUrl = "jdbc:mysql://" + Main.HOST + ":" + Main.PORT + "/"
				+ Main.DATABASE;
		try {
			Connection connection = DriverManager.getConnection(conUrl,
					Main.USER, Main.PASSWORD);
			Statement statement = connection.createStatement();
			// SELECT-Statement
			ResultSet selCustomer = statement
					.executeQuery("SELECT * FROM c_customer");
			Main.print(selCustomer, 1);

			// INSERT-Statement
			statement = connection.createStatement();
			statement
					.executeUpdate("INSERT INTO c_customer VALUES (5, 'Nachname5', 'Vorname5', '1945-07-03', 'Ort5', 1100)");
			ResultSet selCust12 = statement
					.executeQuery("SELECT * FROM c_customer");
			Main.print(selCust12, 2);

			// INSERT with PreparedStatement
			String temp = "INSERT INTO `shopdb`.`c_customer` VALUES(?,?,?,?,?,?)";
			PreparedStatement ins = connection.prepareStatement(temp);

			ins.setInt(1, 6);
			ins.setString(2, "Nachname6");
			ins.setString(3, "Vorname6");
			ins.setDate(4, Date.valueOf("1960-03-03"));
			ins.setString(5, "Ort6");
			ins.setInt(6, 1100);
			ins.executeUpdate();

			selCustomer = statement.executeQuery("SELECT * FROM c_customer");
			Main.print(selCustomer, 4);

			// DELETE-Statement for Row 5 and 6
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM c_customer WHERE c_id=5");
			statement.executeUpdate("DELETE FROM c_customer WHERE c_id=6");
			ResultSet selCust2 = statement
					.executeQuery("SELECT * FROM c_customer");
			Main.print(selCust2, 3);

			// CLOSE CONNECTION
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void print(ResultSet s, int actIndex) {
		String resString = "";
		try {
			while (s.next()) {
				resString += "\nName: "
						+ s.getString("c_vorname")
						+ " "
						+ s.getString("c_nachname")
						+ "\nGebdat: "
						+ (s.getDate("c_gebdat",
								GregorianCalendar.getInstance())).toString()
						+ "\nOrt: " + s.getString("c_ort") + "\nPLZ: "
						+ s.getString("c_plz")
						+ "\n-----------------------------------------------";
			}

			// Just for JOptionPane Message!
			int erg = -2;
			while (erg == -2) {
				if (actIndex == 1) {
					erg = JOptionPane.showConfirmDialog(null, resString,
							"Alle Customer - SELECT", JOptionPane.OK_OPTION);
				} else if (actIndex == 2) {
					erg = JOptionPane.showConfirmDialog(null, resString,
							"Alle Customer - AFTER INSERT",
							JOptionPane.OK_OPTION);
				} else if (actIndex == 3) {
					erg = JOptionPane.showConfirmDialog(null, resString,
							"Alle Customer - AFTER DELETE",
							JOptionPane.OK_OPTION);
				} else if (actIndex == 4) {
					erg = JOptionPane
							.showConfirmDialog(
									null,
									resString,
									"Alle Customer - AFTER INSERT with PreparedStatement",
									JOptionPane.OK_OPTION);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
