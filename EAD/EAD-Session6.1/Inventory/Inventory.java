import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class Inventory.
 */
@WebServlet("/Inventory")
public class Inventory extends HttpServlet {

	/**
	 * Instantiates a new inventory.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public Inventory() {
		super();
	}

	/**
	 * Do put.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BufferedReader json = request.getReader();
		StringBuilder buffer = new StringBuilder();
		String line;

		while ((line = json.readLine()) != null) {
			buffer.append(line);
		}

		String jsonS = buffer.toString();

		JSONArray jsonArray = (JSONArray) JSONValue.parse(jsonS);
		System.out.println(jsonArray);
		ArrayList<JSONObject> inventory = Item.getInstance().Items;
		for (int index = 0; index < inventory.size(); index++) {
			inventory.remove(index);
		}
		for (int index = 0; index < jsonArray.size(); index++) {
			inventory.add((JSONObject) jsonArray.get(index));
		}
		PrintWriter out = response.getWriter();
		out.write("{Items Added}");
		// for(int index = 0; index< inventory.size();index++){
		// System.out.println(inventory.get(index));
		// }
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BufferedReader json = request.getReader();
		StringBuilder buffer = new StringBuilder();
		String line;

		while ((line = json.readLine()) != null) {
			buffer.append(line);
		}

		String jsonS = buffer.toString();

		JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonS);
		ArrayList<JSONObject> inventory = Item.getInstance().Items;
		inventory.add((JSONObject) jsonObject);
		PrintWriter out = response.getWriter();
		out.write("{Items Added}");

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doDelete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JSONObject> inventory = Item.getInstance().Items;
		for (int index = 0; index < inventory.size(); index++) {
			inventory.remove(index);
		}
	}
}
