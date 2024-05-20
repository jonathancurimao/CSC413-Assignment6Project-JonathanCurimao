/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Controller.*;
import Assignment6Model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author karunmehta
 */
public class CustomerDTO {
    
    private int id;
    private String username;
    private String email;
    private String phone;
    private List address;
   
    static CustomerDAO cd = new CustomerDAO();

    //default custructor
    public CustomerDTO() {
        

    }
    
    public static BankCustomer customerByID(int anId) {
        
        BankCustomer anCustomer = null;
        
        try {
            anCustomer = cd.get(anId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(anCustomer != null) System.out.println(anCustomer.toString()); 
            
        System.out.println("\nFetched Customer with ID: " + anId + " Customer Details:\n" + anCustomer.toString());        
        return anCustomer;
        
}
    
    public static int performUpdate(BankCustomer aCustomer) {

        int updateResult = -1;
        
        try {
            updateResult = cd.update(aCustomer);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nUpdate Successful");
         System.out.println("Customer Details:\n" + aCustomer.toString());
        return updateResult;        
    }

    public static int performCreate(HashMap hm) {

        int updateResult = -1;
        
        BankCustomer bc = new BankCustomer();
        
        bc.setEmail((String)hm.get("email"));
        bc.setLastName((String)hm.get("lname"));
        bc.setFirstName((String)hm.get("firstName"));
        bc.setPhone((String)hm.get("phone"));
        bc.setBirthday((String)hm.get("birthday"));
               
        try {
            updateResult = cd.create(bc);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nCustomer Create Successful");
        System.out.println("Customer Details:\n" + bc.toString());
        return updateResult;        
    }


    public static List<BankCustomer> findCustomersByCity (String city) {
        List<BankCustomer> customers = new ArrayList<>();
        CustomerDAO customerDAO = new CustomerDAO();
        try {
            PreparedStatement pStatement = CustomerDAO.connection.prepareStatement(AddressDataConnection.getSelectByCity());
            pStatement.setString(1, city);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                int custId = result.getInt("custid");
                BankCustomer bankcustomer = customerDAO.get(custId);
                if (bankcustomer != null) {
                    customers.add(bankcustomer); // uses the list to add the bankcustomer object
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static int updateAddress(CustomerAddress address) {
        int updateResult = -1;
        try {
            updateResult = cd.updateAddress(address);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        if (updateResult != -1) System.out.println("\nAddress Update Successful");
        System.out.println("Address Details:\n" + address.toString());
        return updateResult;
    }

    // method that calls the getallCustomers() method in CustomerDAO
    public static List<BankCustomer> getAllCustomers() {
        try {
            return cd.getAllCustomers();
        } catch (SQLException e) {
            System.out.println("Error fetching customers: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}