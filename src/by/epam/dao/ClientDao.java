package by.epam.dao;

import by.epam.payments.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao{
    private static final String SQL_SELECT_ALL_ABONENTS = "SELECT * FROM clients";
    private static final String SQL_CREATE_NEW_CLIENT = "INSERT INTO clients(name, adress, passportNumber, dateOfBirth) VALUES(?,?,?,?)";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/bank";
    private final String USER = "root";
    private final String PASS = "root";

    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_ABONENTS);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("idClient"));
                client.setName(resultSet.getString("name"));
                client.setAdress(resultSet.getString("adress"));
                client.setPassport(resultSet.getString("passportNumber"));
                client.setDateOfBirth(resultSet.getString("dateOfBirth"));
                clients.add(client);
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
        return clients;
    }

    public boolean insertClient(Client client) {
        boolean flag = false;
        Connection cn = null;
        PreparedStatement st = null;

        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.prepareStatement(SQL_CREATE_NEW_CLIENT);
            st.setString(1, client.getName());
            st.setString(2, client.getAdress());
            st.setString(3, client.getPassport());
            st.setString(4, client.getDateOfBirth());
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