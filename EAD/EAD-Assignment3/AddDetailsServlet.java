import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import sun.nio.ch.IOUtil;


public class AddDetailsServlet extends HttpServlet{
//	private boolean validate(String firstName,String lastName, String fatherName, String email, String classId, Integer age){
//		
//		
//		return false;
//		
//	}
	
	private boolean checkMail(Statement stmt, String email) throws SQLException{
		String sql = "select sid from students where email = '"+ email+ "'";
		ResultSet result = stmt.executeQuery(sql);
		int count =0 ;
		while(result.next()){
			count++;
		}
		if(count == 0){
			return true;
		}
		return false;
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res ) throws IOException{
		BufferedReader json = req.getReader();
	    StringBuilder buffer = new StringBuilder();
	    String line;
	    
	    while ((line = json.readLine()) != null) {
	        buffer.append(line);
	    }
	    
	    String jsonS = buffer.toString();
	    JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonS);  
	    String firstName = (String) jsonObject.get("firstName");
	    String lastName = (String) jsonObject.get("lastName");
	    String fatherName = (String) jsonObject.get("fatherName");
	    String email = (String) jsonObject.get("email");
	    String classId = (String) jsonObject.get("classname");
	    String age = (String) jsonObject.get("age");
		JSONObject jsonObj = new JSONObject();
		
	    //	    boolean flag = validate(firstName, lastName, fatherName, email, classId, age);
	    //Getting database connection
	    Connection con = DataBaseConnect.connect();
	    try {
			Statement stmt =  con.createStatement();
			boolean flag = checkMail(stmt, email);
			if(flag){
			String sql = "INSERT INTO students(first_name, last_name, father_name, email, class, age) VALUES('" + firstName+"','"+ lastName+"','"+ fatherName+"','"+email+"' , '" + classId+"','"+ age+ "')";
			stmt.executeUpdate(sql);
			jsonObj.put("code", 200 );
			jsonObj.put("msg", "Added");
			PrintWriter out = res.getWriter();
			out.write(jsonObj.toString());
			}
			else{
				jsonObj.put("code", 406 );
				jsonObj.put("error", "duplicate email");
				PrintWriter out = res.getWriter();
				out.write(jsonObj.toString());
			}
		
	    } catch (Exception e) {
			e.printStackTrace();
		} 
	}
}	
