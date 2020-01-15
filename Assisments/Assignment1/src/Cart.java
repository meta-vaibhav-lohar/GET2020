import java.util.HashMap;
import java.util.Set;

/*
 *  This Class hold the data members and methods.
 *  
 * */
public class Cart {
		/*
		 *  cartItems is HashMap which stores the  object of Items class and the Quantity of Item
		 *  bill is double type variable used to save the total bill
		 * */
	
		HashMap<Items, Integer> cartItems = new HashMap<Items, Integer>();
		double bill;
		
		/*
		 * Constructor to initialize the object
		 * */
		
		public Cart() {
			
			bill=0.0;
		}
		
		/*
		 * Constructor to initialize the object 
		 * @param item is Object of class items contain name and price of item
		 * @param quantity represents the quantity of item taken
		 * */
		
		public Cart(Items item, Integer quantity){
			cartItems.put(item, quantity);
			
		}
		
		/*
		 * This method finds the Item by the item name
		 * @param Items is HashMap which stores all the Item in the cart 
		 * @param item is String which hold the item name to be searched
		 * @result returns the Item object or null if Item not found
		 * */
		
		public Items findItem(HashMap<Items, Integer> Items, String itemName){
			Set<Items> keys = Items.keySet();
			for(Items key: keys) {
					if(key.itemName.equals(itemName)) {
						return key;
					}
			}
			return null;
		}

		/*
		 * This method add Items to the Cart
		 * @param item represent the name of the Item to add
		 * @param quantity represent the amount of items to add
		 * @param stockI represent the object of class Stock for getting the detail of the Item
		 * 
		 * */
		public void addItem(String itemName, Integer quantity, Stock stockI) {
			Items element = findItem(stockI.stockItems, itemName);
			
			if(element != null) {
						cartItems.put(element, quantity);
						stockI.updateQuantity(element, quantity);
			}
			else {
					System.out.println("Enter valid Item");
			}
			
		}
		
		/*
		 * this method id used to delete selected Item from the Cart
		 * @param item name of element to delete 
		 * @param stockItem object used to update the quantity in stock 
		 * 
		 * */
		
		public void deleteItem(String itemName, Stock stockItem) {
			Items element = findItem(stockItem.stockItems, itemName);
			
			if(element != null) {
				stockItem.stockItems.replace(element, stockItem.stockItems.get(element) + cartItems.get(element));
				cartItems.remove(element);
				System.out.println(element.itemName+" removed from cart");
			}
			else {
				System.out.println("Enter valid Item");
			}
		}
		
		/*
		 * this method is used to reduce the quantity of item in the cart
		 * @param item name of element to delete 
		 * @param quantity to reduce the
		 * @param stockItem object used to update the quantity in stock 
		 * 
		 * */
		public void reduceQuantity(String itemName, Integer quantity,Stock stockItem) {
			Items element = findItem(cartItems, itemName);
			
			if( element != null) {
				stockItem.stockItems.replace(element, stockItem.stockItems.get(element) + cartItems.get(element));
				cartItems.replace(element, cartItems.get(element)-quantity);
			}else {
				System.out.println("Enter valid Item");
			}
		}
		
		/*
		 * this method prints all the item in cart
		 * 
		 * */
		
		public void printItems(){
			System.out.println("Items in Stock \n Items\t\t Price\t\t Quantity");
			Set<Items> keys = cartItems.keySet();
			for(Items key: keys){
				System.out.println(key.itemName+"\t\t "+key.price+"\t\t "+cartItems.get(key));
			}
		}
		
		/*
		 * this method print the total bill 
		 * */
		public void calculateBill(){
			
			bill=0.0;
			Set<Items> keys = cartItems.keySet();
			for(Items key: keys){
				bill +=  key.price * cartItems.get(key));
			}
			System.out.println("Total Bill:- "+ bill);
		}
}
