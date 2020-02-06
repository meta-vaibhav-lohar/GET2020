import java.util.ArrayList;

import org.json.simple.JSONObject;


public class Book {
	static ArrayList<JSONObject> Items ;
    private static Book instance;

	private Book(){}

	public static Book getInstance() {
        if(instance == null){
        	Items = new ArrayList<JSONObject>();
            instance = new Book();
        }
        return instance;
	}
	
	
	public void addItem(String title, String writer, String publisher, int publisedYear){
		JSONObject item = new JSONObject();
		item.put("title", title);
		item.put("writer", writer);
		item.put("publisher", publisher);
		item.put("publisedYear", publisedYear);
		
	}
	public ArrayList<JSONObject> getItems(){
		return (ArrayList<JSONObject>) Items.clone();		
	}
}
