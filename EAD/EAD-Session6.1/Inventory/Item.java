import java.util.ArrayList;

import org.json.simple.JSONObject;


/**
 * The Class Item.
 */
public class Item {
	
	/** The Items. */
	static ArrayList<JSONObject> Items ;
    
    /** The instance. */
    private static Item instance;

	/**
	 * Instantiates a new item.
	 */
	private Item(){}

	/**
	 * Gets the single instance of Item.
	 *
	 * @return single instance of Item
	 */
	public static Item getInstance() {
        if(instance == null){
        	Items = new ArrayList<JSONObject>();
            instance = new Item();
        }
        return instance;
	}
	
	
	/**
	 * Adds the item.
	 *
	 * @param name the name
	 * @param quantity the quantity
	 * @return true, if successful
	 */
	public boolean addItem(String name, int quantity){
		JSONObject item = new JSONObject();
		item.put("name", name);
		item.put("quantity", quantity);
		
		return (Items.add(item));
		
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
