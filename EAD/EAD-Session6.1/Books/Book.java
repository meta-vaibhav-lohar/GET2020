import java.util.ArrayList;

import org.json.simple.JSONObject;


/**
 * The Class Book.
 */
public class Book {
	
	/** The Items. */
	static ArrayList<JSONObject> Items ;
    
    /** The instance. */
    private static Book instance;

	/**
	 * Instantiates a new book.
	 */
	private Book(){}

	/**
	 * Gets the single instance of Book.
	 *
	 * @return single instance of Book
	 */
	public static Book getInstance() {
        if(instance == null){
        	Items = new ArrayList<JSONObject>();
            instance = new Book();
        }
        return instance;
	}
	
	
	/**
	 * Adds the item.
	 *
	 * @param title the title
	 * @param writer the writer
	 * @param publisher the publisher
	 * @param publisedYear the publised year
	 */
	public void addItem(String title, String writer, String publisher, int publisedYear){
		JSONObject item = new JSONObject();
		item.put("title", title);
		item.put("writer", writer);
		item.put("publisher", publisher);
		item.put("publisedYear", publisedYear);
		
	}
	
	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public ArrayList<JSONObject> getItems(){
		return (ArrayList<JSONObject>) Items.clone();		
	}
}
