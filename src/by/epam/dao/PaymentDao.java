package by.epam.dao;

import by.epam.payments.Payment;
import by.epam.util.SQLDaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao {
    private static final String SQL_SELECT_ALL_PAYMENTS = "SELECT idPayment, accNumber, operationtype.operationType, paymentValue FROM bank.payments " +
            "JOIN bank.operationtype ON operationtype.idOperationType=payments.operationType \n" +
            "JOIN bank.accounts ON accounts.idAccount=payments.AccID";
    private static final String SQL_CREATE_PAYMENT = "INSERT INTO bank.payments(paymentValue, operationType, AccID) VALUES(?,(SELECT idOperationType FROM bank.operationtype WHERE operationType=?)," +
            "                                                                                              (SELECT idAccount FROM bank.accounts WHERE accNumber=?))";
    private static final String SQL_UPDATE_PAYMENT = "UPDATE bank.payments SET paymentValue=?, operationType=(SELECT idOperationType FROM bank.operationType WHERE operationType=?)," +
            "                                                                                  payments.AccID=(SELECT idAccount FROM bank.accounts WHERE accNumber=?) WHERE idPayment=?";
    private static final String SQL_DELETE_PAYMENT = "DELETE FROM bank.payments WHERE idPayment=?";

    public List<Payment> findAll() {
        List<Payment> payments = new ArrayList<>();
        Connection cn = SQLDaoFactory.createConnection();
        Statement st = null;
        try {
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_PAYMENTS);
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setPaymentValue(resultSet.getInt("paymentValue"));
                payment.setBankAccount(resultSet.getLong("accNumber"));
                payment.setPaymentType(resultSet.getString("operationType"));
                payments.add(payment);
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
        return payments;
    }

    public boolean insertPayment(Payment payment) {
        boolean flag = false;
        Connection cn = SQLDaoFactory.createConnection();
        PreparedStatement st = null;

        try {
            st = cn.prepareStatement(SQL_CREATE_PAYMENT);
            st.setInt(1, payment.getPaymentValue());
            st.setString(2, payment.getPaymentType());
            st.setLong(3, payment.getBankAccount());
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

    public boolean updatePayment(Payment payment, Integer id) {
        boolean flag = false;
        Connection cn = SQLDaoFactory.createConnection();
        PreparedStatement st = null;

        try {
            st = cn.prepareStatement(SQL_UPDATE_PAYMENT);
            st.setInt(1, payment.getPaymentValue());
            st.setString(2, payment.getPaymentType());
            st.setLong(3, payment.getBankAccount());
            st.setInt(4, id);
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

    public boolean deletePayment(Integer id) {
        boolean flag = false;
        Connection cn = SQLDaoFactory.createConnection();
        PreparedStatement st = null;

        try {
            st = cn.prepareStatement(SQL_DELETE_PAYMENT);
            st.setInt(1, id);
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