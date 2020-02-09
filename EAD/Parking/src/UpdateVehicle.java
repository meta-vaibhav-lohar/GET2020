

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
 * Servlet implementation class UpdateVehicle
 */
@WebServlet("/UpdateVehicle")
public class UpdateVehicle extends HttpServlet {
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
    public UpdateVehicle() {
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
            sql = "SELECT vehicleId FROM Users WHERE email=\""+email+"\"";
            ResultSet rs = stmt.executeQuery(sql); 
            
            if(rs.next()) {
            	sql = "SELECT * FROM VEHICLES WHERE id="+rs.getInt("vehicleId");
            	ResultSet rs2 = stmt.executeQuery(sql);
            	if(rs2.next()){
	            	String vehicle_name = rs2.getString("name"), vehicle_type=rs2.getString("vehicle_type");
	            	String vehicle_number = rs2.getString("vehicle_number"), employee_id = rs2.getString("employee_id");
	            	String description = rs2.getString("identification"), pass_type = rs2.getString("pass_type");
	            	double price = rs2.getDouble("price");
		            
	            	String doc = "<!DOCTYPE html><html lang=\"en\"><head> <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"/> <title>Update Vehicle Info</title></head><body> <nav> <h1> Meta-Parking </h1> <form action='./login.html'> <button> Logout </button> </form> </nav> <h1 class=\"central-heading\">Update Vehicle Info</h1> <div class=\"form-container\"><form method=\"post\" id=\"registration-form-2\" action=\"processUpdateVehicle\"> <div id=\"vehicle-register-form\" style=\"display: block;\"> <div class=\"container\"> <span>Registration Id is <span id=\"registrationId\" style=\"font-weight: bold;\"></span></span> </div> <div class=\"float-container\"> <label for=\"car-name\">Car Name</label> <input type=\"text\" id=\"car-name\" name=\"car-name\" value=\""+vehicle_name+"\" onkeyup=\"onFieldChange('car-name', /^[A-Z a-z]+$/)\" data-placeholder=\"Enter Car Name\" required/> </div><div class=\"container\"> <label for=\"vehicle-type\">Vehicle Type</label><br/> <select name=\"vehicle-type\" onchange=\"validateSelectInput('vehicle-type')\" id=\"vehicle-type\"> <option value=\"\" "+(vehicle_type==""?"selected":"")+" disabled=\"disabled\">Select Option</option> <option "+("cycle".equals(vehicle_type)?"selected":"")+" value=\"cycle\">Cycle</option> <option "+("two-wheeler".equals(vehicle_type)?"selected":"")+" value=\"two-wheeler\">Two Wheeler</option> <option "+("four-wheeler".equals(vehicle_type)?"selected":"")+" value=\"four-wheeler\">Four Wheeler</option> </select> </div><div class=\"float-container\"> <label for=\"vehicle-number\">Vehicle Number</label> <input type=\"text\" value=\""+vehicle_number+"\" id=\"vehicle-number\" name=\"vehicle-number\" onkeyup=\"onFieldChange('vehicle-number', /^(?=.*\\d)(?=.*[A-Z]).{9,10}/)\" data-placeholder=\"Ex: RJ17CAXXXX\" required/> </div><div class=\"float-container\"> <label for=\"employee-id\">Employee ID</label> <input type=\"text\" id=\"employee-id\" name=\"employee-id\"value=\""+employee_id+"\" onkeyup=\"onFieldChange('employee-id', /^[A-Z]*[a-z]*[0-9]{1,}/)\" data-placeholder=\"Your Employee ID\" required/> </div><div class=\"container\"> <label for=\"identification\">Description</label><br/> <textarea id=\"identification\" rows=\"4\" name=\"identification\" placeholder=\"Identification of your vehicle\">"+description+"</textarea> </div><button type=\"button\" class=\"next-button\" onclick=\"validateVehicleForm()\">Next >></button> </div><div id=\"pass-type-form\"> <div class=\"container\"> <label for=\"pass-type\">Pass Type</label><br/> <select name=\"pass-type\" id=\"pass-type\" onchange=\"validateSelectInput('pass-type'); calculate();\"> <option value=\"\" selected=\"selected\" "+(pass_type==""?"selected":"")+" disabled=\"disabled\">Select Option</option> <option "+("daily".equals(pass_type)?"selected":"")+" value=\"daily\">Daily</option> <option "+("monthly".equals(pass_type)?"selected":"")+" value=\"monthly\">Monthly</option> <option "+("yearly".equals(pass_type)?"selected":"")+" value=\"yearly\">Yearly</option> </select> </div><div class=\"container\"> <span>Currency </span> <label class=\"radio-container\" style=\"margin-top: 10px;\"> <input type=\"radio\" name=\"currency\" id=\"inr\" value=\"INR\" onclick=\"changeCurrency('INR'); calculate();\" required/>INR <span class=\"checkmark\"></span> </label> <label class=\"radio-container\"> <input type=\"radio\" name=\"currency\" id=\"usd\" value=\"USD\" checked onclick=\"changeCurrency('USD'); calculate();\" required/>USD <span class=\"checkmark\"></span> </label> <label class=\"radio-container\"> <input type=\"radio\" name=\"currency\" id=\"yen\" value=\"YEN\" onclick=\"changeCurrency('YEN'); calculate();\" required/>YEN <span class=\"checkmark\"></span> </label> </div><div class=\"container\"> <span>Total Amount(<span id=\"current-currency\">USD</span>): <span style=\"font-weight: bold;\" id=\"amount\">$ "+price+"</span></span> </div><input type=\"hidden\" name=\"price\" id=\"price\"/> <button type=\"submit\">Submit</button> </div></form> </div><script src=\"scripts.js\"></script> <script src=\"signup.js\"></script></body></html>";
	            	out.println(doc);
            	}
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
