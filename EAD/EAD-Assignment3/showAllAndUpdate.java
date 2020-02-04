import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class showAllAndUpdate extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res){
	    try{
	    	Connection con = DataBaseConnect.connect();
	    	Statement stmt = con.createStatement();
			String sql = "select * from students order by class";
			ResultSet result = stmt.executeQuery(sql);
			int count =0 ;
			JSONObject response = new JSONObject();
			while(result.next()){
				count++;
				JSONObject detail = new JSONObject();
				detail.put("sid", result.getString(1));
				detail.put("firstName", result.getString(2));
				detail.put("lastName", result.getString(3));
				detail.put("fatherName", result.getString(4));
				detail.put("email", result.getString(5));
				detail.put("classname", result.getString(6));
				detail.put("age", result.getString(7));
				
				response.put(count, detail);
			}
			res.setContentType("application/json");
			PrintWriter out = res.getWriter();
//			System.out.println(response.toString());
			out.write(response.toString());
			
	    }catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	private boolean update(Statement stmt, JSONObject json) throws SQLException{
		String detailsString =  (json.get("details")).toString();
		JSONObject details = (JSONObject) JSONValue.parse(detailsString);
		String updatesString =  (json.get("updates")).toString();
		JSONObject updates = (JSONObject) JSONValue.parse(updatesString);
		
	    String firstName = (String) details.get("firstName");
	    String email = (String) details.get("email");

	    
	    String updateFirstName = (String) updates.get("firstName");
	    String updateLastName = (String) updates.get("lastName");
	    String updateFatherName = (String) updates.get("fatherName");
	    String updateEmail = (String) updates.get("email");
	    String updateClassId = (String) updates.get("classname");
	    String updateAge = (String) updates.get("age");
		String sql = "UPDATE students SET first_name='"+updateFirstName+"',"
				+ " last_name='"+updateLastName+"', father_name='"+updateFatherName+"', "
				+ "email ='"+updateEmail+"', class='"+updateClassId+"', age='"+updateAge+"'"
				+ " WHERE first_name='"+firstName+"' and email='"+email+"' ";   
		System.out.println(sql);
		int result = stmt.executeUpdate(sql);
		if(result != 0){
			return true;
		}
		return false;
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		BufferedReader json = req.getReader();
	    StringBuilder buffer = new StringBuilder();
	    String line;
	    
	    while ((line = json.readLine()) != null) {
	        buffer.append(line);
	    }
	    
	    String jsonS = buffer.toString();
	    
	    JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonS);
	    System.out.println(jsonObject);
	    Connection con = DataBaseConnect.connect();
		Statement stmt;
		try {
			stmt = con.createStatement();
			boolean flag = update(stmt, jsonObject);
			JSONObject response = new JSONObject();

			if(flag){
				response.put("code", 200 );
				response.put("msg", "Updated");
//				System.out.println(response.toString());
				
			}else{
				response.put("code", 406 );
				response.put("msg", "Failed");
			}
			PrintWriter out = res.getWriter();
			out.write(response.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    

	}
}
