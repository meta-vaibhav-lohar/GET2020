package client;

import java.io.IOException;
import java.sql.SQLException;

import view.View;
import controller.Controller;

/**
 * The Class Client.
 */
public class Client {
    
    /**
     * The main method.
     *
     * @param args the arguments
     * @throws NumberFormatException the number format exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SQLException the SQL exception
     */
    public static void main(String args[]) throws NumberFormatException, IOException, SQLException{
    Controller controller = new Controller();
    View view = new View();
    do{
        controller.selectOperation((view.menu()));  
    }while(true);
    }
}
