package Assignment6Controller;

import Assignment6Model.BankAccount;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AccountDTO {
    static AccountDAO accountDAO = new AccountDAO();

    public static List<BankAccount> findAccountsByCustomerID(int customerID) {
        List<BankAccount> accounts = new ArrayList<>();
        try {
            accounts = accountDAO.getAccountsByCustomerID(customerID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public static int performUpdate (BankAccount account) {
        int updateResult = -1;
        try {
            updateResult = accountDAO.update(account);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        if (updateResult != -1)
            System.out.println("\nUpdate Successful");
        System.out.println("Account Details:\n" + account.toString());
            return updateResult;
    }
}
