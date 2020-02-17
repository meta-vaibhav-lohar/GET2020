package facade;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import model.Cart;
import view.View;
import dao.Database;

/**
 * The Class ShopingCardOperation.
 */
public class ShopingCardOperation {
    
    /** The database. */
    Database database = Database.getInstance();
    
    /** The cart. */
    Cart cart = Cart.getInstance();
    
    /**
     * Addition.
     *
     * @throws SQLException the SQL exception
     * @throws NumberFormatException the number format exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void addition() throws SQLException, NumberFormatException, IOException{
        int itemNumber, count = 0;
        ResultSet itemList;
        View view = new View();
        
        database.connection();
        itemList = database.showItems();
        itemNumber = view.viewItem(itemList);
        itemList.first();
        boolean flag = false;
        do{
            count++;
                      if(count == itemNumber){
                cart.setName(itemList.getString("name"));
                cart.setPrice(Double.parseDouble(itemList.getString("price")));
                cart.setProduct_code(Integer.parseInt(itemList.getString("code")));
                cart.setQuantity(1);
                cart.setType(itemList.getString("type"));
                flag = true;
                
            }
        }while(itemList.next());
        database.close();
        
        if(flag) view.sccessful(0);
        else{
        	System.out.println("Invalid option");
        }
    }
    
    /**
     * Edits the.
     *
     * @throws NumberFormatException the number format exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void edit() throws NumberFormatException, IOException{
        HashMap<Integer,Integer> itemNumberInCart;
        View view = new View();
        itemNumberInCart = view.updateCart(cart);
        for (HashMap.Entry<Integer, Integer> entry : itemNumberInCart.entrySet()) {
            cart.updateQuantity(entry.getKey()-1, entry.getValue());
            itemNumberInCart.clear();
        }
        view.sccessful(1);
    }
    
    /**
     * Show.
     */
    public void show(){
        View view = new View();
        view.showCart(cart);
        
    }
    
    /**
     * Genrate bill.
     */
    public void genrateBill() {
        View view = new View();
        view.bill(cart);
    }
}
