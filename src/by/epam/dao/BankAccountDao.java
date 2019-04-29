package by.epam.dao;

import by.epam.interfacesDao.DAOBankAccount;
import by.epam.payments.BankAccount;
import by.epam.util.SQLDaoFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDao implements DAOBankAccount {
    private static final String SQL_SELECT_ALL_BANK_ACCOUNTS =
            "SELECT idAccount, accNumber, isBlocked FROM bank.accounts " +
            "GROUP BY idAccount\n" +
            "ORDER BY idAccount;";
    private static final String SQL_SELECT_CARDS_FOR_ACCOUNT = "SELECT cardNumber FROM bank.cards WHERE AccID=";
    private static final String SQL_CREATE_NEW_ACCOUNT = "INSERT INTO accounts(accountNumber , isBlocked) VALUES(?,?)";
    private static final String SQL_UPDATE_ACCOUNT = "UPDATE bank.accounts SET accountNumber=?, isBlocked=? WHERE idAccount=?";
    private static final String SQL_DELETE_ACCOUNT = "DELETE FROM bank.accounts WHERE idAccount=?";

    @Override
    public List<BankAccount> findAll() {
        List<BankAccount> bankAccounts = new ArrayList<>();
        Connection cn = SQLDaoFactory.createConnection();
        Statement st = null;
        Statement st2 = null;
        ArrayList<Long> cards;
        try {
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_BANK_ACCOUNTS);
            while(resultSet.next()) {
                st2 = cn.createStatement();
                ResultSet resultSet2 = st2.executeQuery(SQL_SELECT_CARDS_FOR_ACCOUNT + resultSet.getInt("idAccount"));

                cards = new ArrayList<>();
                BankAccount bankAccount = new BankAccount();
                bankAccount.setAccountNumber(resultSet.getLong("accNumber"));
                bankAccount.setBlocked(resultSet.getBoolean("isBlocked"));

                while (resultSet2.next()) {
                    cards.add(resultSet2.getLong("cardNumber"));
                }
                bankAccount.setCreditCards(cards);
                bankAccounts.add(bankAccount);
            }
        }
        catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        }
        finally {
            try {
                st.close();
                st2.close();
                cn.close();
            }
            catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }

        return bankAccounts;
    }

    @Override
    public boolean insertBankAccount(BankAccount bankAccount) {

        return false;
    }

    @Override
    public boolean updateBnakAccount(BankAccount creditCard) {
        return false;
    }

    @Override
    public boolean deleteBankAccount(BankAccount bankAccount) {
        return false;
    }
}
