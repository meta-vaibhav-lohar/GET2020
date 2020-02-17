
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL="jdbc:mysql://localhost:3306/parking";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
        	// Register JDBC driver
        	Class.forName(JDBC_DRIVER);
        	
        	// Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT first_name, email FROM Users WHERE email=\""+email.toLowerCase()+"\"";
            ResultSet rs = stmt.executeQuery(sql);
            
            out.println("<html><body>");
        	out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        	
            if(rs.next()) {
            	String name = rs.getString("first_name");
				sql += " AND password=\"" + password + "\"";
				ResultSet rs2 = stmt.executeQuery(sql);
				if (rs2.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("user", email);
					
					out.println("<script>swal('Login Successful', 'Welcome back "
							+ name + "', 'success')");
					out.println(".then(() => { window.location = '/Parking/home'; })</script>");
				} else {
					out.println("<script>swal('Login Unsuccessful', 'Check your password', 'error')");
					out.println(".then(() => { window.location = '/Parking/login.html'; })</script>");
				}
			} else {
				out.println("<script>swal('Login Unsuccessful', 'User " + email
						+ " not found!', 'error')");
				out.println(".then(() => { window.location = '/Parking/login.html'; })</script>");
			}
            
        	
        	out.println("</body></html>");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {            
            out.close();
        }
	}

}
