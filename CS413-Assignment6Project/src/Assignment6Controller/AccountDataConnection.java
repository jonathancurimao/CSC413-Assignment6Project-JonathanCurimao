/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

/**
 * @author karunmehta
 */
public class AccountDataConnection extends DataConnection {

    // SQL queries to be used to persist account business objects as needed by the DAO
    private static final String INSERT_SQL = "INSERT INTO bankaccount (cust_id, balance, create_date, acct_type) VALUES (?, ?, ?, ?)";
    private static final String SELECT_SQL_BYID = "SELECT * FROM bankaccount WHERE acct_type = ?";
    private static final String UPDATE_SQL = "UPDATE bankaccount SET cust_id = ?, balance = ?, create_date = ?, acct_type = ? WHERE acct_num = ?";
    private static final String DELETE_SQL = "DELETE FROM bankaccount WHERE acct_type = ?";
    private static final String SELECT_BY_CUSTOMERID = "SELECT * FROM bankaccount WHERE cust_id = ?";

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

    public static String getSelectByCustomerId() {
        return SELECT_BY_CUSTOMERID;
    }
}
