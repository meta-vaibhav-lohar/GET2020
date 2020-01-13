import java.util.Scanner;

/*
 * Item Class represent the Detail of Items
 * itemName represent the name of item
 * price represent the price of item
 * 
 * getDetail methods takes input value for name and price
 * updatePrice change the price of the Item
 * 
 * */
public class Items{
	String itemName;
	double price;
	
	/*
	 * Item is constructor 
	 * @param name represent name of the item
	 * @param price represent price of the item
	 * 
	 * */
	public Items(String name, double price)
	{
		this.itemName=name;
		this.price=price;
	}
	
	//Methods
	
	/*
	 * getDetail method is used to take the input value for the data members
	 * 
	 * */
	public void getDetails(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Item Name");
		itemName=sc.nextLine();
		
		System.out.println("Enter the price of item");
		price=sc.nextDouble();	
		sc.close();
	}
	
	/*
	 * updatePrice method is used to update the price of the item
	 * 
	 * */
	
	public void updatePrice(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the updated price of item");
		price=sc.nextDouble();
		sc.close();
	}
}
