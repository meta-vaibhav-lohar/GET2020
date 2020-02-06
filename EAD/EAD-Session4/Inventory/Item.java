import java.util.ArrayList;

import org.json.simple.JSONObject;


public class Item {
	static ArrayList<JSONObject> Items ;
    private static Item instance;

	private Item(){}

	public static Item getInstance() {
        if(instance == null){
        	Items = new ArrayList<JSONObject>();
            instance = new Item();
        }
        return instance;
	}
	
	
	public boolean addItem(String name, int quantity){
		JSONObject item = new JSONObject();
		item.put("name", name);
		item.put("quantity", quantity);
		
		return (Items.add(item));
		
	}
	public ArrayList<JSONObject> getItems(){
		return (ArrayList<JSONObject>) Items.clone();
		
	}
}
