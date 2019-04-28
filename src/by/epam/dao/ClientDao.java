package by.epam.dao;

import by.epam.payments.Client;
import by.epam.util.SQLDaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao{
    private static final String SQL_SELECT_ALL_ABONENTS = "SELECT idClient, name, address, passportNumber, dateOfBirth FROM bank.clients \n" +
                                                          "LEFT JOIN bank.accounts ON accounts.ownerID=clients.idClient\n" +
                                                          "ORDER BY idClient;";
    private static final String SQL_SELECT_ACCOUNTS_FOR_CLIENT = "SELECT accNumber FROM bank.accounts JOIN bank.clients ON accounts.ownerID=clients.idClient WHERE idClient=";
    private static final String SQL_CREATE_NEW_CLIENT = "INSERT INTO clients(name, adress, passportNumber, dateOfBirth) VALUES(?,?,?,?)";

    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        Connection cn = SQLDaoFactory.createConnection();
        Statement st = null;
        Statement st2 = null;
        ArrayList<Long> accounts = new ArrayList<>();
        try {
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_ABONENTS);
            while (resultSet.next()) {

                st2 = cn.createStatement();
                ResultSet resultSet2 = st2.executeQuery(SQL_SELECT_ACCOUNTS_FOR_CLIENT + resultSet.getInt("idClient"));

                    Client client = new Client();
                    client.setId(resultSet.getInt("idClient"));
                    client.setName(resultSet.getString("name"));
                    client.setAddress(resultSet.getString("address"));
                    client.setPassport(resultSet.getString("passportNumber"));
                    client.setDateOfBirth(resultSet.getString("dateOfBirth"));
                    accounts.add(resultSet.getLong("accNumber"));

                    client.setAccounts(accounts);

                    clients.add(client);

            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            try {
            st.close();
            cn.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        return clients;
    }

    public boolean insertClient(Client client) {
        boolean flag = false;
        Connection cn = SQLDaoFactory.createConnection();
        PreparedStatement st = null;

        try {
            st = cn.prepareStatement(SQL_CREATE_NEW_CLIENT);
            st.setString(1, client.getName());
            st.setString(2, client.getAddress());
            st.setString(3, client.getPassport());
            st.setString(4, client.getDateOfBirth());
            st.executeUpdate();
            flag = true;
        }
        catch (SQLException e) {
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