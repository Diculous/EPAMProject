package by.epam.dao;

import by.epam.payments.CardType;
import by.epam.payments.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardTypeDao {
    private static final String SQL_SELECT_ALL_TYPES_OF_CARDS = "SELECT * FROM cardType";
    private static final String SQL_CREATE_NEW_CARD_TYPE = "INSERT INTO cardType(cardType, cashbackBonus) VALUES(?,?)";
    private static final String SQL_UPDATE_CURRENT_CARD_TYPE = "UPDATE bank.cardType SET cardType=?, cashbackBonus=? WHERE cardType=?";
    private static final String SQL_DELETE_CURRENT_CARD_TYPE = "DELETE FROM bank.cardType WHERE cardType=?";

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/bank";
    private final String USER = "root";
    private final String PASS = "root";

    public List<CardType> findAll() {
        List<CardType> cardTypes = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_TYPES_OF_CARDS);
            while (resultSet.next()) {
                CardType cardType = new CardType();
                cardType.setCardType(resultSet.getString("cardType"));
                cardType.setCashBack(resultSet.getInt("cashbackBonus"));
                cardTypes.add(cardType);
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

    public boolean insertCardType(CardType cardType) {
        boolean flag = false;
        Connection cn = null;
        PreparedStatement st = null;

        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.prepareStatement(SQL_CREATE_NEW_CARD_TYPE);
            st.setString(1, cardType.getCardType());
            st.setInt(2, cardType.getCashBack());
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