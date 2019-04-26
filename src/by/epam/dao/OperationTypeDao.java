package by.epam.dao;

import by.epam.payments.OperationType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationTypeDao {

    private static final String SQL_SELECT_ALL_TYPES_OF_PAYMENTS = "SELECT * FROM operationtype";
    private static final String SQL_CREATE_NEW_PAYMENT_TYPE = "INSERT INTO operationtype(operationType) VALUE (?)";
    private static final String SQL_UPDATE_PAYMENT_TYPE = "UPDATE bank.operationtype SET operationtype=? WHERE operationtype=?";
    private static final String SQL_DELETE_PAYMENT_TYPE = "DELETE FROM bank.operationtype WHERE operationtype=?";

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/bank";
    private final String USER = "root";
    private final String PASS = "root";

    public List<OperationType> findAll() {
        List<OperationType> operationTypes = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_TYPES_OF_PAYMENTS);
            while (resultSet.next()) {
                OperationType operationType = new OperationType();
                operationType.setOperationType(resultSet.getString("OperationType"));
                operationTypes.add(operationType);
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
        return operationTypes;
    }

    public boolean insertOperationType(OperationType operationType) {
        boolean flag = false;
        Connection cn = null;
        PreparedStatement st = null;

        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.prepareStatement(SQL_CREATE_NEW_PAYMENT_TYPE);
            st.setString(1, operationType.getOperationType());
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

    public boolean updateOperationType(OperationType operationType, String oldOperationType) {
        boolean flag = false;
        Connection cn = null;
        PreparedStatement st = null;

        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.prepareStatement(SQL_UPDATE_PAYMENT_TYPE);
            st.setString(1, operationType.getOperationType());
            st.setString(2, oldOperationType);
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

    public boolean deleteOperationType(OperationType operationType) {
        boolean flag = false;
        Connection cn = null;
        PreparedStatement st = null;

        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection established");
            st = cn.prepareStatement(SQL_DELETE_PAYMENT_TYPE);
            st.setString(1, operationType.getOperationType());
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