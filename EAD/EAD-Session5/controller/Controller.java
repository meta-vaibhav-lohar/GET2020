package controller;

import java.io.IOException;
import java.sql.SQLException;

import facade.ShopingCardOperation;

/**
 * The Class Controller.
 */
public class Controller {

    /**
     * Select operation.
     *
     * @param parseInt the parse int
     * @throws SQLException the SQL exception
     * @throws NumberFormatException the number format exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void selectOperation(int parseInt) throws SQLException, NumberFormatException, IOException {
        ShopingCardOperation operation = new ShopingCardOperation();
        
        switch(parseInt){
        case 1 : operation.addition(); 
            break;
        case 2 : operation.edit();
            break;
        case 3 : operation.show();
            break;
        case 4 : operation.genrateBill();
            break;
        case 5 : System.exit(0);
            break;
        default :
            System.out.println("Wrong Input try agaian...");
        }
    }

}
