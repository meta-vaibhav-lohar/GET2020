package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import model.Cart;

/**
 * The Class View.
 */
public class View {

    /** The br. */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Menu.
     *
     * @return the int
     * @throws NumberFormatException the number format exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public int menu() throws NumberFormatException, IOException{
        System.out.print("Select Operation : \n 1) Add\n 2) Edit\n 3) Show \n 4) "
                + "Genrate bill\n 5) Exit\n Enter you choice : ");
        return Integer.parseInt(br.readLine());
    }
    
    /**
     * View item.
     *
     * @param itemList the item list
     * @return the int
     * @throws NumberFormatException the number format exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SQLException the SQL exception
     */
    //%5s and other  are for formating the output
    public int viewItem(ResultSet itemList) throws NumberFormatException, IOException, SQLException {
        int count = 0;
        System.out.println(String.format("%5s%20s%20s%20s%20s","SNo.","Code","Name","type","Price"));
        while(itemList.next()){
            count++;
            System.out.println(String.format("%5s%20s%20s%20s%20s",count,itemList.getString("code"),
                    itemList.getString("name"),itemList.getString("type"),itemList.getString("price")));
            }
        System.out.print("Enter Serial Number to add item in cart : ");
        return Integer.parseInt(br.readLine());
    }

    /**
     * Show cart.
     *
     * @param cart the cart
     * @return the double
     */
    public double showCart(Cart cart){
        int count = 0;
        List<Integer> code = cart.getProduct_code();
        List<String> name = cart.getName();
        List<String> type = cart.getType();
        List<Double> price = cart.getPrice();
        List<Integer> quantity = cart.getQuantity();
        int numberOfItem = type.size();
        System.out.println(numberOfItem);
        double amount, total = 0.0;
        
        System.out.println(String.format("%5s%20s%20s%20s%20s%20s","SNo.","Code","Name","type","quantity","Price"));
        while(count < numberOfItem ){
            amount = quantity.get(count)*price.get(count);
            System.out.println(String.format("%5s%20s%20s%20s%20s%20s",count+1,code.get(count),name.get(count),
                    type.get(count),quantity.get(count),amount));
            total += amount;
            count++;
        }
        return total;
    }
    
    /**
     * Update cart.
     *
     * @param cart the cart
     * @return the hash map
     * @throws NumberFormatException the number format exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public HashMap<Integer, Integer> updateCart(Cart cart) throws NumberFormatException, IOException {
        HashMap<Integer,Integer> serialNumberAndQuantity = new HashMap<Integer,Integer>(); 
        int serialNumber;
        
        showCart(cart);
        System.out.println("Enter Serial Number to edit item in cart : ");
        serialNumber = Integer.parseInt(br.readLine());
        System.out.println("Enter Quantity : ");
        serialNumberAndQuantity.put(serialNumber, Integer.parseInt(br.readLine()));
        
        return serialNumberAndQuantity;
    }
    
    /**
     * Successful.
     *
     * @param number the number
     */
    public void sccessful(int number) {
        if(number == 0){
            System.out.println("Successfully Add Item");
        }
        else{
            System.out.println("Successfully Edit Card");
        }
        
    }

    /**
     * Bill.
     *
     * @param cart the cart
     */
    public void bill(Cart cart) {
        double totalAmount;
        System.out.println();
        System.out.println(String.format("%45s","Shoping"));
        totalAmount = showCart(cart);
        System.out.println();
        System.out.println(String.format("%85s%20s","TOTAL",totalAmount));
        System.exit(0);
    }
    
}
