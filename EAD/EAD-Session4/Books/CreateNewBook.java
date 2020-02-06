	

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


/**
 * Servlet implementation class CreateNewBook
 */

public class CreateNewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewBook() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Parsing input
		BufferedReader json = request.getReader();
		StringBuilder buffer = new StringBuilder();
		String line;

		while ((line = json.readLine()) != null) {
			buffer.append(line);
		}

		String jsonS = buffer.toString();

		JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonS);
	    String title = (String) jsonObject.get("title");
	    String writer = (String) jsonObject.get("writer");
	    String publisher = (String) jsonObject.get("publisher");
	    String publishedYear = (String) jsonObject.get("publishedYear");
		JSONObject jsonObj = new JSONObject();

		System.out.println(jsonObject);	
		
		// Putting in database
		Connection con = DataBaseConnect.connect();
		
		try{
			Statement stmt = con.createStatement();
			boolean flag = true;
//					checkMail(stmt, email);
			if(flag){
			String sql = "INSERT INTO BOOK( TITLE, WRITER, PUBLISHER, PUBLISHEDYEAR) VALUES('" + title+"','"+ writer+"','"+ publisher+"','"+publishedYear+"')";
			stmt.executeUpdate(sql);
			jsonObj.put("code", 200 );
			jsonObj.put("msg", "Added");
			PrintWriter out = response.getWriter();
			out.write(jsonObj.toString());
			}
			else{
				//validations result
				PrintWriter out = response.getWriter();
				out.write(jsonObj.toString());
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}
