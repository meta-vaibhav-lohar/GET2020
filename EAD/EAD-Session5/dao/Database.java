package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Class Database.
 */
public class Database {
    
    /** The jdbc driver. */
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    /** The db url. */
    private final String DB_URL = "jdbc:mysql://localhost/studentdetails";
    
    /** The D B user. */
    private final String DB_user  = "root";
    
    /** The db pass. */
    private final String DB_PASS = "root";
    
    /** The con. */
    private Connection con = null;
    
    /** The stm. */
    private Statement stm = null;
    
    /** The rs. */
    private ResultSet rs = null;
    
    /** The dc. */
    private static Database DC = new Database();
    
    
    /**
     * Instantiates a new database.
     */
    private Database(){}
    
    /**
     * Gets the single instance of Database.
     *
     * @return single instance of Database
     */
    public static Database getInstance(){
        return DC;
    }
    
    /**
     * Connection.
     */
    public void connection(){
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, DB_user,
                    DB_PASS);
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }
    
    /**
     * Show items.
     *
     * @return the result set
     * @throws SQLException the SQL exception
     */
    public ResultSet showItems() throws SQLException{
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT code, name, type, price FROM item";
        rs =  stm.executeQuery(strQuery);
        return rs;
    }
    
    /**
     * Close.
     *
     * @throws SQLException the SQL exception
     */
    public void close() throws SQLException{
        con.close();
    }

}
