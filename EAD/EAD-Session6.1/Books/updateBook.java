

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;

import javafx.scene.chart.PieChart.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class updateBook.
 */

public class updateBook extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new update book.
     *
     * @see HttpServlet#HttpServlet()
     */
    public updateBook() {
        super();
    }

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader json = request.getReader();
		StringBuilder buffer = new StringBuilder();
		String line;

		while ((line = json.readLine()) != null) {
			buffer.append(line);
		}

		String jsonS = buffer.toString();

		JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonS);
	    JSONObject flags = (JSONObject) jsonObject.get("keys");
	    JSONObject newValues = (JSONObject) jsonObject.get("values");
	    
	    String oldTitle = (String) flags.get("title");
	    String oldPublishedYear = (String) flags.get("publishedYear");
	    String title = (String) newValues.get("title");
	    String writer = (String) newValues.get("writer");
	    String publisher = (String) newValues.get("publisher");
	    String publishedYear = (String) newValues.get("publishedYear");
	    Connection con = DataBaseConnect.connect();
	    try{
	    	Statement stmt = con.createStatement();
	    	String sql = "UPDATE book SET TITLE='"+title+"',"
					+ " WRITER='"+writer+"', PUBLISHER='"+publisher+"', "
					+ "PUBLISHEDYEAR ='"+publishedYear+"'"
					+ " WHERE TITLE='"+oldTitle+"' and PUBLISHEDYEAR='"+oldPublishedYear+"' ";   
	    	System.out.println(sql);
			int result = stmt.executeUpdate(sql);

			if(result != 0){
				JSONObject jsonObj = new JSONObject();
				jsonObj .put("code", 200 );
				jsonObj.put("msg", "Added");
				System.out.println(jsonObj);
				PrintWriter out = response.getWriter();
				out.write(jsonObj.toString());
			}
	    	
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		

	}

}
