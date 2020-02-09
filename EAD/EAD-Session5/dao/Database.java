package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/shoping";
    private final String DB_user  = "root";
    private final String DB_PASS = "root";
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private static Database DC = new Database();
    
    
    private Database(){}
    
    public static Database getInstance(){
        return DC;
    }
    
    public void connection(){
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, DB_user,
                    DB_PASS);
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }
    
    public ResultSet showItems() throws SQLException{
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT * FROM item";
        rs =  stm.executeQuery(strQuery);
        return rs;
    }
    
    public void close() throws SQLException{
        con.close();
    }

}
