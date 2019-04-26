package by.epam.dao;

import by.epam.payments.CardType;
import by.epam.payments.CreditCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreditCardDao {
    private static final String SQL_SELECT_ALL_CARDS = "SELECT idCard, cardNumber, cardtype.cardType, accNumber FROM bank.cards JOIN bank.cardtype ON cardtype.idCardType=cards.CardType " +
            "                                                                                                                   JOIN bank.accounts ON accounts.idAccount=cards.AccID";
    private static final String SQL_CREATE_CARD = "INSERT INTO cards(cardNumber, cardType, AccID) VALUES(?,(SELECT idCardType FROM bank.cardtype WHERE cardType=?)," +
            "                                                                                              (SELECT idAccount FROM bank.accounts WHERE accNumber=?))";
    private static final String SQL_UPDATE_CURRENT_CARD = "UPDATE bank.cards SET cardNumber=?, cardType=(SELECT idCardType FROM bank.cardtype WHERE cardType=?)," +
            "                                                                                  cards.AccID=(SELECT idAccount FROM bank.accounts WHERE accNumber=?) WHERE cardNumber=?";
    private static final String SQL_DELETE_CURRENT_CARD = "DELETE FROM bank.cards WHERE cardNumber=?";

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/bank";
    private final String USER = "root";
    private final String PASS = "root";

    public List<CreditCard> findAll() {
        List<CreditCard> cardTypes = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_CARDS);
            while (resultSet.next()) {
                CreditCard creditCard = new CreditCard();
                creditCard.setCardNumber(resultSet.getLong("cardNumber"));
                creditCard.setAccount(resultSet.getLong("accNumber"));
                creditCard.setCardType(resultSet.getString("cardtype.cardType"));
                cardTypes.add(creditCard);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        return cardTypes;
    }

    public boolean insertCard(CreditCard creditCard) {
        boolean flag = false;
        Connection cn = null;
        PreparedStatement st = null;

        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.prepareStatement(SQL_CREATE_CARD);
            st.setLong(1, creditCard.getCardNumber());
            st.setString(2, creditCard.getCardType());
            st.setLong(3, creditCard.getAccount());
            st.executeUpdate();
            flag = true;
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean updateCardType(CreditCard creditCard, Long oldCreditCard) {
        boolean flag = false;
        Connection cn = null;
        PreparedStatement st = null;

        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.prepareStatement(SQL_UPDATE_CURRENT_CARD);
            st.setLong(1, creditCard.getCardNumber());
            st.setString(2, creditCard.getCardType());
            st.setLong(3, creditCard.getAccount());
            st.setLong(4, oldCreditCard);
            st.executeUpdate();
            flag = true;
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean deleteCard(CreditCard creditCard) {
        boolean flag = false;
        Connection cn = null;
        PreparedStatement st = null;

        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.prepareStatement(SQL_DELETE_CURRENT_CARD);
            st.setLong(1, creditCard.getCardNumber());
            st.executeUpdate();
            flag = true;
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
