import java.sql.Connection;
import java.sql.DriverManager;


/**
 * The Class DataBaseConnect.
 */
public class DataBaseConnect {
	
	/**
	 * Connect.
	 *
	 * @return the connection
	 */
	public static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentdetails", "root", "root");
			// here  is database name, root is username and password
			return(con);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}