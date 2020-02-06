

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class sendAllBook
 */

public class sendBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendBook() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DataBaseConnect.connect();
		try{
			Statement stmt = con.createStatement();
			String sql = "SELECT ID, TITLE, WRITER, PUBLISHER, PUBLISHEDYEAR FROM BOOK";
			ResultSet result = stmt.executeQuery(sql);
			int count =0 ;
			JSONObject books = new JSONObject();
			while(result.next()){
				count++;
				JSONObject book = new JSONObject();
				book.put("id", result.getString(1));
				book.put("title", result.getString(2));
				book.put("writer", result.getString(3));
				book.put("publisher", result.getString(4));
				book.put("publisedYear", result.getString(5));
				
				books.put(count, book);
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(books.toString());
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BufferedReader json = request.getReader();
		StringBuilder buffer = new StringBuilder();
		String line;

		while ((line = json.readLine()) != null) {
			buffer.append(line);
		}

		String jsonS = buffer.toString();

		JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonS);
	    String title = (String) jsonObject.get("title");
	    Connection con = DataBaseConnect.connect();
	    try{
	    	Statement stmt = con.createStatement();
	    	String sql = "SELECT ID, TITLE, WRITER, PUBLISHER, PUBLISHEDYEAR FROM BOOK WHERE TITLE = '"+ title +"' "; 
	    	System.out.println(sql);
	    	ResultSet result = stmt.executeQuery(sql);
			int count =0 ;
			JSONObject books = new JSONObject();
			while(result.next()){
				count++;
				JSONObject book = new JSONObject();
				book.put("id", result.getString(1));
				book.put("title", result.getString(2));
				book.put("writer", result.getString(3));
				book.put("publisher", result.getString(4));
				book.put("publisedYear", result.getString(5));
					
				books.put(count, book);
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(books.toString());
			con.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}

}
