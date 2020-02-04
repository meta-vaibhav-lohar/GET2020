import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;



public class SearchStudent extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
	    //Connecting Database
		
		BufferedReader bufferRead = req.getReader();
	    StringBuilder buffer = new StringBuilder();
	    String line;
	    
	    while ((line = bufferRead.readLine()) != null) {
	        buffer.append(line);
	    }
	    String jsonString = buffer.toString();
	    JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);  
	    String firstName = (String) jsonObject.get("firstName");
	    String lastName = (String) jsonObject.get("lastName");

	    try{
	    	Connection con = DataBaseConnect.connect();
	    	Statement stmt = con.createStatement();
			String sql = "select * from students where first_name = '"+ firstName+ "' or  last_name = '" + lastName + "' order by class";
			ResultSet result = stmt.executeQuery(sql);
			int count =0 ;
			JSONObject response = new JSONObject();
			while(result.next()){
				count++;
				JSONObject detail = new JSONObject();
				detail.put("firstName", result.getString(2));
				detail.put("lastName", result.getString(3));
				detail.put("fatherName", result.getString(4));
				detail.put("email", result.getString(5));
				detail.put("classname", result.getString(6));
				detail.put("age", result.getString(7));
				
				response.put(count, detail);
			}
			PrintWriter out = res.getWriter();
			out.write(response.toString());
			
	    }catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
