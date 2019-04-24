package by.epam.by.epam.dao;

import by.epam.payments.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao{
    public static final String SQL_SELECT_ALL_ABONENTS = "SELECT * FROM clients"; //SELECT ALL
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
}