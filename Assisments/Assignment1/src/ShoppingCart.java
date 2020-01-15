import java.util.Scanner;
/*
 * Shopping Cart program implements a Shopping cart program which add,
 * delete, modify Items and their quantity and Generate the bill 
 * */

public class ShoppingCart {
	
	private static Scanner sc = new Scanner(System.in);
	
	/*
	 * This method is used to scan Integer value
	 * @return the scanned Integer value
	 * */
	public static int getChoice(){
		while (true) {
			try {			
					return sc.nextInt();
				}
			catch (Exception ex) {
					System.out.println("Enter integer value only :");
					sc.next();
			}
		}
	}
	
	/*
	 * This method is used to scan String value
	 * @return the scanned String value
	 * */
	public static String getString(){
		sc.nextLine();
		while (true) {
			try {
					return sc.nextLine();
				}
			catch (Exception ex) {
					System.out.println("Enter string value only :");
					sc.next();
				}
			}
	}
	
	/*
	 * This method is used to scan Double value
	 * @return the scanned Double value
	 * */
	public static double getDouble(){
		while(true){
			try{
					return sc.nextDouble();
			} 
			catch (Exception ex){
					System.out.println("Enter decimal value only :");
					sc.next();
			}
		}
	}
	
	/*
	 * This Method provide the functionalities for the Cart
	 * @param cartItem This is the first parameter to cartFunc method, It is object of class Cart
	 * @param stockItem This is the second parameter to cartFunc method, It is object of class Stock
	 * 
	 * */
	public static void cartFunc(Cart cartItem, Stock stockItem){
		
		boolean flag = true;
		while(flag){
				System.out.println("1) Add Item to cart\n"
					+ "2) Remove Item from Cart\n"
					+ "3) Reduce Quantity of Item\n"
					+ "4) Display Items in Cart\n"
					+ "5) Display Items from Stock\n"
					+ "6) Print Bill\n"
					+ "7) Menu\n"
					+ "Enter your Choice .....");
				int opt = ShoppingCart.getChoice();
			
				switch(opt){
					case 1:
							if(stockItem.stockItems.size()==0){
								System.out.println("Stock Empty");
								flag=false;
								break;
							}
							else{
								stockItem.printItems();
							}
							System.out.println("Enter the Item Name");
							String itemName=ShoppingCart.getString();
							
							System.out.println("Enter the Quantity");
							int quant = ShoppingCart.getChoice();
				
							cartItem.addItem(itemName, quant, stockItem);
							System.out.println("Items in Cart: \n");
							cartItem.printItems();
							break;
					case 2:
							cartItem.printItems();
							System.out.println("Enter the name Of item to delete");
							String deleteName = ShoppingCart.getString();
							cartItem.deleteItem(deleteName,stockItem);
							break;
					case 3: 
							System.out.println("Enter the element name for reduce the quantity");
							String name = ShoppingCart.getString();
							System.out.println("Enter the quantity to reduce");
							Integer quantity = getChoice();
							cartItem.reduceQuantity(name, quantity,stockItem);
							break;
					case 4:
							cartItem.printItems();
							break;
					case 5:
							stockItem.printItems();
							break;
				
					case 6:
							cartItem.calculateBill();
							break;
			
					case 7:
							flag=false;
							break;	
					default : 
							System.out.println("Invalid Option");
							break;
				}
			}	 
	}
	
	/*
	 * This Method provide the functionalities for the Stock
	 * @param stockItem This is the second parameter to stockItem method, It is object of class Stock
	 * 
	 * */
	public static void stockFunc(Stock stockItem){
		boolean flag =true;
		while(flag){
				System.out.println("Stock Menu :-\n1) Add Item\n"
						+ "2) List all Items\n"
						+ "3) Delete Item from Stock\n"
						+ "4) Menu\n"
						+ "Enter your Choice .....");
				int opt = ShoppingCart.getChoice();
				switch(opt){
					case 1:
							System.out.println("Enter the name Item");
							String name = ShoppingCart.getString();
					
							System.out.println("Enter the Price");
							double price = ShoppingCart.getDouble();
					
							Items item = new Items(name, price);
							System.out.println("Enter the Quantity");
							int quant = ShoppingCart.getChoice();
					
							stockItem.addItems(item, quant);
							stockItem.printItems(); 
							break;
					case 2:
							stockItem.printItems();
							break;
					case 3:
							stockItem.printItems();
							System.out.println("Enter the name of Item to remove");
							String deleteName  = ShoppingCart.getString();
							stockItem.deleteItem(deleteName, stockItem);
					case 4:
							flag =false;
							break;
					}
				}	
		}
	
	/*
	 * This method is main function which Initiate the functionalities
	 * */
	public static void main(String[] args) {
		
		Cart cartItems = new Cart();
		Stock stockItems = new Stock();
		while (true){
				System.out.println("Menu :- \n1)Cart"
						+ "\n2)Stock"
						+ "\n3)Exit"
						+ "\nEnter the Choice.... ");
				int choice=ShoppingCart.getChoice();
				
				switch (choice) {
					case 1:			
							ShoppingCart.cartFunc(cartItems,stockItems);
							break;
					case 2:
							ShoppingCart.stockFunc(stockItems);
							break;
					case 3:
							System.out.println("Exiting.....");
							System.exit(0);
							break;
					default:
							System.out.println("Invalid Option ....");
							break;
					}	
				}
		}
}
