

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessUpdateUser
 */
@WebServlet("/ProcessUpdateUser")
public class ProcessUpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL="jdbc:mysql://localhost/META_PARKING";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessUpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String first_name = request.getParameter("first-name");
		String last_name = request.getParameter("last-name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String organisation = request.getParameter("organisation");
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
        	if(session==null){
        		out.println("<script>window.location=\"login.html\"</script>");
        	}
        	String originalEmail = session.getAttribute("user").toString();
        	
        	// Register JDBC driver
        	Class.forName(JDBC_DRIVER);
        	
        	// Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute SQL query
            Statement stmt = conn.createStatement();
            
            out.println("<html><body>");
          	out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
                     
            String sql = "UPDATE USERS SET first_name='"+first_name+"', last_name='"+last_name+"', gender='"+gender+"', email='"+email+"', contact='"+contact+"', organisation='"+organisation+"' WHERE email='"+originalEmail+"'";
            
            int rs = stmt.executeUpdate(sql);

            if(rs == 1) {
            	
				session.setAttribute("user", email);
            	
            	out.println("<script>swal('Update Successful', 'Your profile has been successfully updated', 'success')");
				out.println(".then(() => { window.location = '/EAD-2/home'; })</script>");
			} else {
				out.println("<script>swal('Update Unsuccessful', 'Something went wrong!', 'error')");
				out.println(".then(() => { window.location = '/EAD-2/home'; })</script>");
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
