
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessUpdateVehicle
 */
@WebServlet("/ProcessUpdateVehicle")
public class ProcessUpdateVehicle extends HttpServlet {
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
    public ProcessUpdateVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String name = request.getParameter("car-name");
		String vehicle_type = request.getParameter("vehicle-type");
		String vehicle_number = request.getParameter("vehicle-number");
		String employee_id = request.getParameter("employee-id");
		String identification = request.getParameter("identification");
		String pass_type = request.getParameter("pass-type");
		double price = Double.valueOf(request.getParameter("price"));
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
                  
          	String sqlForVehicleId = "SELECT vehicleId FROM USERS WHERE email='"+originalEmail+"'";
          	ResultSet rsForVehicleId = stmt.executeQuery(sqlForVehicleId);
          	
          	if(rsForVehicleId.next()){
          		int vehicleId = rsForVehicleId.getInt("vehicleId");
                String sql = "UPDATE VEHICLES SET name='"+name+"', vehicle_type='"+vehicle_type+"', vehicle_number='"+vehicle_number+"', employee_id='"+employee_id+"', identification='"+identification+"', pass_type='"+pass_type+"', price='"+price+"' WHERE id='"+vehicleId+"'";
                int rs = stmt.executeUpdate(sql);

                if(rs == 1) {
                	
                	out.println("<script>swal('Update Successful', 'Your vehicle has been successfully updated', 'success')");
    				out.println(".then(() => { window.location = '/Parking/home'; })</script>");
    			} else {
    				out.println("<script>swal('Update Unsuccessful', 'Something went wrong!', 'error')");
    				out.println(".then(() => { window.location = '/Parking/home'; })</script>");
    			}
            	
            	out.println("</body></html>");
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
