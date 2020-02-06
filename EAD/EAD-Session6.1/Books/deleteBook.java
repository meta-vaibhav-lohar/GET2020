

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteBook.
 */
@WebServlet("/deleteBook")
public class deleteBook extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new delete book.
     *
     * @see HttpServlet#HttpServlet()
     */
    public deleteBook() {
        super();
    }

	/**
	 * Do delete.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getHeader("book");
		if(operation.equals("all")){
			System.out.print("all");
			Connection con = DataBaseConnect.connect();
			try{
				Statement stmt = con.createStatement();
				String sql = "DELETE from book";
				stmt.execute(sql);
				PrintWriter out = response.getWriter();
				out.write("All books deleted");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(operation.equals("id")){
			System.out.print("id");
			Connection con = DataBaseConnect.connect();
			try{
				Statement stmt = con.createStatement();
				String sql = "DELETE from book WHERE ID = '"+operation+"'";
				stmt.execute(sql);
				PrintWriter out = response.getWriter();
				out.write("Book deleted");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
