

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL="jdbc:mysql://localhost:3306/parking";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
            System.out.println(email);
            
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT id,first_name,last_name,gender,email,password,contact,vehicleId,gender,organisation FROM Users WHERE email=\""+email+"\"";
            ResultSet rs = stmt.executeQuery(sql);
            
            String doc = "<!DOCTYPE html><html lang=\"en\"><head> <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"/> <title>Home</title></head><body> <nav> <h1> Meta-Parking </h1> <form action='logout' method='get'> <button> Logout </button> </form> </nav> <h1 class=\"central-heading\">Your Information <a href='./updateUser'>Edit >></a></h1> <table> <tr> <th>Registration Id: </th> <td>";
        	
            
            if(rs.next()) {
            	int id = rs.getInt("id");
            	String first_name = rs.getString("first_name"), last_name=rs.getString("last_name");
            	String contact = rs.getString("contact"), organisation = rs.getString("organisation");
            	String gender = rs.getString("gender");
            	String sql2 = "SELECT * FROM Vehicles WHERE id="+rs.getInt("vehicleId");
                ResultSet rs2 = stmt.executeQuery(sql2);
                if(rs2.next()){
	            	doc += "<input type=\"tel\" value=\""+id+"\" disabled=\"disabled\" /></td></tr><tr> <th>Name: </th> <td>"
	            	+ "<input type=\"text\" value=\""+first_name+" "+last_name+"\" disabled=\"disabled\"/> </td></tr><tr> <th>Email: </th> <td>"
	            	+ "<input type=\"email\" value=\""+email+"\" disabled=\"disabled\"/> </td></tr><tr> <th>Contact No.: </th> <td>"
	            	+ "<input type=\"tel\" value=\""+contact+"\" disabled=\"disabled\"/> </td></tr><tr> <th>Gender: </th> <td>"
	            	+ "<input type=\"text\" value=\""+gender+"\" disabled=\"disabled\"/> </td></tr><tr> <th>Organisation: </th> <td>"
	            	+ "<input type=\"text\" value=\""+organisation+"\" disabled=\"disabled\"/> </td></tr></table> <h1 class=\"central-heading\">Vehicle Information <a href='./updateVehicle'>Edit >></a></h1> <table> <tr> <th>Vehicle Name: </th>"
	            	+ "<td><input type=\"text\" value=\""+rs2.getString("name")+"\" disabled=\"disabled\"/></td></tr><tr> <th>Vehicle Type: </th> <td>"
	            	+ "<input type=\"text\" value=\""+rs2.getString("vehicle_type")+"\" disabled=\"disabled\"/> </td></tr><tr> <th>Vehicle Number: </th>"
	            	+ "<td><input type=\"text\" value=\""+rs2.getString("vehicle_number")+"\" disabled=\"disabled\"/></td></tr><tr> <th>Employee ID: </th> <td><input type=\"text\" value=\""+rs2.getString("employee_id")+"\" disabled=\"disabled\"/></td></tr><tr> <th>Description: </th> <td> <textarea disabled=\"disabled\" rows=\"4\">"+rs2.getString("identification")+"</textarea> </td></tr><tr> <th>Pass Type: </th> <td> <input type=\"text\" disabled=\"disabled\" value=\""+rs2.getString("pass_type")+"\" /> </td></tr><tr><th>Price: </th><td>$ "+rs2.getString("price")+"</td></tr></table>"
	            	+ "<div> <h1 class=\"central-heading\">Colleagues</h1> <table> <ul>";
	            	
	            	String sql3 = "SELECT * FROM USERS WHERE organisation=\""+organisation+"\" AND email!=\""+email+"\"";
	            	ResultSet rs3 = stmt.executeQuery(sql3);
	            	
	            	while(rs3.next()){
	            		String name = rs3.getString("first_name")+" "+rs3.getString("last_name");
	            		doc += "<tr> <td> <li><a href=\"./colleague?email="+rs3.getString("email")+"\">"+name+"</a></li></td></tr>";
	            	}
	            	
	            	doc += "</ul> </table> </div><script src=\"scripts.js\"></script></body></html>";
	            	out.println(doc);
                }
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
