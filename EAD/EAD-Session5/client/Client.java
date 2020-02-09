package client;

import java.io.IOException;
import java.sql.SQLException;

import view.View;
import controller.Controller;

public class Client {
    public static void main(String args[]) throws NumberFormatException, IOException, SQLException{
    Controller controller = new Controller();
    View view = new View();
    do{
        controller.selectOperation((view.menu()));  
    }while(true);
    }
}
