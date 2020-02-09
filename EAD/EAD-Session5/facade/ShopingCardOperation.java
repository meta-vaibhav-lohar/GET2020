package facade;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import model.Cart;
import view.View;
import dao.Database;

public class ShopingCardOperation {
    Database database = Database.getInstance();
    Cart cart = Cart.getInstance();
    
    public void addition() throws SQLException, NumberFormatException, IOException{
        int itemNumber, count = 0;
        ResultSet itemList;
        View view = new View();
        
        database.connection();
        itemList = database.showItems();
        itemNumber = view.viewItem(itemList);
        itemList.first();
        do{
            count++;
            if(count == itemNumber){
                cart.setName(itemList.getString("name"));
                cart.setPrice(Double.parseDouble(itemList.getString("price")));
                cart.setProduct_code(Integer.parseInt(itemList.getString("code")));
                cart.setQuantity(1);
                cart.setType(itemList.getString("type"));
            }
        }while(itemList.next());
        database.close();
        view.sccessful(0);
    }
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
    public void show(){
        View view = new View();
        view.showCart(cart);
        
    }
    public void genrateBill() {
        View view = new View();
        view.bill(cart);
    }
}
