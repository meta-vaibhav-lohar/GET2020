
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
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
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
        	if(session==null){
        		out.println("<script>window.location=\"login.html\"</script>");
        	}
        	// Register JDBC driver
        	Class.forName(JDBC_DRIVER);
        	
        	// Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String email = session.getAttribute("user").toString();
            
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Users WHERE email=\""+email+"\"";
            ResultSet rs = stmt.executeQuery(sql);        	
            
            if(rs.next()) {
            	String first_name = rs.getString("first_name"), last_name=rs.getString("last_name");
            	String contact = rs.getString("contact"), organisation = rs.getString("organisation");
            	String gender = rs.getString("gender");	
	            
            	String doc = "<!DOCTYPE html><html lang=\"en\"><head> <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"/> <title>Update User Info</title></head><body> <nav> <h1> Meta-Parking </h1> <form action='./login.html'> <button> Logout </button> </form> </nav> <h1 class=\"central-heading\">Update Your Info</h1> <div class=\"form-container\"> <form method=\"post\" onsubmit=\"return validateRegisterForm()\" id=\"processUpdateUser\" action=\"processUpdateUser\"> <div id=\"customer-register-form\"> <div class=\"float-container\"> <label for=\"first-name\">First Name</label> <input value=\""+first_name+"\" type=\"text\" id=\"first-name\" name=\"first-name\" onkeyup=\"onFieldChange('first-name', /^[A-Za-z]+$/)\" data-placeholder=\"Enter First Name\" required/> </div><div class=\"float-container\"> <label for=\"last-name\">Last Name</label> <input type=\"text\" value=\""+last_name+"\" name=\"last-name\" id=\"last-name\" onkeyup=\"onFieldChange('last-name', /^[A-Za-z]+$/)\" data-placeholder=\"Enter Last Name\" required/> </div><div class=\"container\"> <span>Gender </span> <label class=\"radio-container\" style=\"margin-top: 10px;\"> <input type=\"radio\" name=\"gender\" onclick=\"validateRadioInputs(['male','female'])\" id=\"male\" "+("male".equals(gender)?"checked":"")+" value=\"male\" required/>Male <span class=\"checkmark\"></span> </label> <label class=\"radio-container\"> <input type=\"radio\" "+("female".equals(gender)?"checked":"")+" name=\"gender\" id=\"female\" onclick=\"validateRadioInputs(['male','female'])\" value=\"female\" required/>Female <span class=\"checkmark\"></span> </label> </div><div class=\"float-container\"> <label for=\"email\">Email ID</label> <input type=\"email\" value=\""+email+"\" name=\"email\" id=\"email\" onkeyup=\"onFieldChange('password', /^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/)\" data-placeholder=\"Enter Email ID\" required/> </div><input type=\"hidden\" value=\"dummy\" name=\"password\" id=\"password\"/><input type=\"hidden\" value=\"dummy\" name=\"confirm-password\" id=\"confirm-password\"/> <div class=\"float-container\"> <label for=\"contact\">Contact Number</label> <input type=\"tel\" name=\"contact\" value=\""+contact+"\" id=\"contact\" maxlength=\"10\" onkeyup=\"onFieldChange('contact',/^[0-9]{10}/)\" data-placeholder=\"Enter Contact No.\" required/> </div><div class=\"container\"> <label for=\"organisation\">Organisation</label><br/> <select name=\"organisation\" onchange=\"validateSelectInput('organisation')\" id=\"organisation\"> <option value=\"\" "+(organisation==""?"selected":"")+" disabled=\"disabled\">Select Option</option> <option value=\"M1\" "+("M1".equals(organisation)?"selected":"")+">M1</option> <option "+("M2".equals(organisation)?"selected":"")+" value=\"M2\">M2</option> <option "+("M3".equals(organisation)?"selected":"")+" value=\"M3\">M3</option> <option "+("M4".equals(organisation)?"selected":"")+" value=\"M4\">M4</option> </select> </div><button type=\"submit\">Submit</button> </div></form> </div><script src=\"scripts.js\"></script> <script src=\"signup.js\"></script></body></html>";
            	out.println(doc);
            }else{
            	out.println("Fail!");
            }
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
