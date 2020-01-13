import java.util.HashMap;
import java.util.Set;

/*
 *  This Class hold the data members and methods.
 *  stockItems is HashMap which stores the  object of Items class and the Quantity of Item
 *  
 * */
public class Stock{
	HashMap<Items,Integer> stockItems = new HashMap<Items,Integer>();
	
	public Stock(){}

	//Methods
	/*
	 * This method finds the Item by the item name
	 * @param Items is HashMap which stores all the Item in the stock 
	 * @param item is String which hold the item name to be searched
	 * @result returns the Item object or null if Item not found
	 * */
	public Items findItem(HashMap<Items, Integer> Items, String item){
		Set<Items> keys = Items.keySet();
		for(Items key: keys){
			if(key.itemName.equals(item)){
				return key;
			}
		}
		return null;
	}

	/*
	 * this method update the quantity of the item in stock
	 * @param item is object of class Item 
	 * @param quantity is the amount to update in stock
	 * */
	public void updateQuantity(Items item, Integer quantity){
		stockItems.replace(item, stockItems.get(item)-quantity);
	}
	/*
	 * this method add items in stock
	 * @param item is object of class Item
	 * @param quantity represent the amount of items 
	 * 
	 * */
	public void addItems(Items item, Integer quantity){
		stockItems.put(item, quantity);	
	}
	
	/*
	 * this method delete item form the stock
	 * @param item is name of item to be deleted
	 * @param stockItem represent the object of class stock to access the list of item
	 * */
	public void deleteItem(String item, Stock stockItem){
		Items element = findItem(stockItem.stockItems, item);
		if(element  != null) {
			stockItems.remove(element);
			System.out.println(element.itemName+" removed from cart");
		}
		else {
			System.out.println("Item not found");
		}

	}
	
	/*
	 * this method prints all the elements of the stock
	 * */
	public void printItems(){
		System.out.println("Items in Stock \nItems\t\t Price\t\t Quantity");
		Set<Items> keys = stockItems.keySet();
		for(Items key: keys){
			System.out.println(key.itemName+"\t\t "+key.price+"\t\t "+stockItems.get(key));
	}
		
	}
}
