
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

/**
 * Servlet implementation class VehicleRegister
 */
@WebServlet("/VehicleRegister")
public class VehicleRegister extends HttpServlet {
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
    public VehicleRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("car-name");
		String vehicle_type = request.getParameter("vehicle-type");
		String vehicle_number = request.getParameter("vehicle-number");
		String employee_id = request.getParameter("employee-id");
		String identification = request.getParameter("identification");
		String registerId = request.getParameter("registerId");
		String pass_type = request.getParameter("pass-type");
		double price = Double.valueOf(request.getParameter("price"));
		
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
            sql = "SELECT vehicleId FROM USERS WHERE id='"+registerId+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            out.println("<html><body>");
        	out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        	
            if(rs.next()) {
				int vehicleId = rs.getInt("vehicleId");
				if(vehicleId==0){
					sql = "INSERT INTO VEHICLES(name,vehicle_type,vehicle_number,employee_id,identification,pass_type,price) ";
					sql += "VALUES ('"+name+"','"+vehicle_type+"','"+vehicle_number+"','"+employee_id+"','"+identification+"','"+pass_type+"',"+price+")";
					int rs2 = stmt.executeUpdate(sql);
					
					if(rs2==1){
						sql = "SELECT id FROM VEHICLES WHERE vehicle_type='"+vehicle_type+"' AND vehicle_number='"+vehicle_number+"' AND employee_id='"+employee_id+"'";
						ResultSet rs3 = stmt.executeQuery(sql);
						if(rs3.next()){
							vehicleId = rs3.getInt("id");
							sql = "UPDATE Users SET vehicleId="+vehicleId+" WHERE id="+registerId;
							stmt.executeUpdate(sql);
							out.println("<script>swal('Vehicle Registered Successfully', 'Price: $ "+price+" for parking "+pass_type+"', 'success')");
							out.println(".then(() => { window.location = '/EAD-2/home'; })</script>");
						}
					}
				} else {
					out.println("<script>swal('Registration Unsuccessful', 'Another vehicle is already registered with registration ID " + registerId
							+ "!', 'error')");
					out.println(".then(() => { window.location = '/EAD-2/signup.html?registrationId="+registerId+"'; })</script>");
				}
			} else {
				out.println("<script>swal('Registration Unsuccessful', 'Registration ID " + registerId
						+ " is invalid!', 'error')");
				out.println(".then(() => { window.location = '/EAD-2/signup.html'; })</script>");
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
