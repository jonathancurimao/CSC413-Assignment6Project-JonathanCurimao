/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author karunmehta
 */
public class AddressDataConnection extends DataConnection {
    


    // SQL queries to be used to persist customer business objects as needed by the DAO
    private static final String INSERT_SQL = "INSERT INTO customeraddress (streetnum, streetname, city, state, zip, custid) VALUES (?, ?, ?, ?,?,?)";
    private static final String SELECT_SQL_BYID = "SELECT * FROM customeraddress WHERE custid = ?";
    private static final String UPDATE_SQL = "UPDATE customeraddress SET streetnum = ?, streetname = ?, city = ? WHERE custid = ?";
    private static final String DELETE_SQL = "DELETE FROM customeraddress WHERE custid = ?";
    private static final String SELECT_BY_CITY = "SELECT custid FROM customeraddress WHERE city = ?";

    private static final String UPDATE_ADDRESS_SQL = "UPDATE customeraddress SET streetnum = ?, streetname = ?, city = ?, state = ?, zip = ? WHERE custid = ?";
 
    public AddressDataConnection()  { } 
    
    public static String getInsert() {
        
        return INSERT_SQL;
    }
    
    public static String getUpdate() {
        
        return UPDATE_SQL;
    }
    
    public static String getSelect() {
        
        return SELECT_SQL_BYID;
    }
    
    public static String getDelete() {
        
        return DELETE_SQL;
    }
    public static String getSelectByCity() {
        return SELECT_BY_CITY;
    }

    public static String getUpdateAddress() {
        return UPDATE_ADDRESS_SQL;
    }
    
}