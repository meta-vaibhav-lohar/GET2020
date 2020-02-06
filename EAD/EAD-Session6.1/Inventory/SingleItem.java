import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import sun.security.krb5.internal.PAEncTSEnc;

/**
 * Servlet implementation class SingleItem.
 */
@WebServlet("/SingleItem")
public class SingleItem extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new single item.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public SingleItem() {
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
		String pathInfo = request.getPathInfo(); // /{value}/test
		String[] pathParts = pathInfo.split("/");
		String key = pathParts[1]; // {value}
		System.out.println(key);

		ArrayList<JSONObject> inventory = Item.getInstance().Items;
		for (int index = 0; index < inventory.size(); index++) {
			if (inventory.get(index).get("name").equals(key)) {
				BufferedReader json = request.getReader();
				StringBuilder buffer = new StringBuilder();
				String line;

				while ((line = json.readLine()) != null) {
					buffer.append(line);
				}

				String jsonS = buffer.toString();

				JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonS);
				System.out.println(jsonObject);
				inventory.get(index).replace("name", jsonObject.get("name"));
				inventory.get(index).replace("quantity",
						jsonObject.get("quantity"));
			}

		}
		System.out.println(inventory);
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
	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo(); // /{value}/test
		String[] pathParts = pathInfo.split("/");
		String key = pathParts[1]; // {value}
		System.out.println(key);

		ArrayList<JSONObject> inventory = Item.getInstance().Items;
		for (int index = 0; index < inventory.size(); index++) {
			if (inventory.get(index).get("name").equals(key)) {
				inventory.remove(index);
			}

		}
		System.out.println(inventory);
	}

}
