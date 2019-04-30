package by.epam.dao;

import by.epam.interfacesDao.DAOPayment;
import by.epam.payments.Payment;
import by.epam.util.ConfigurationManager;
import by.epam.util.SQLDaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao implements DAOPayment {

    public List<Payment> findAll() {
        List<Payment> payments = new ArrayList<>();
        Connection cn = SQLDaoFactory.createConnection();
        Statement st = null;
        try {
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(ConfigurationManager.getPropertySQL("SQL_SELECT_ALL_PAYMENTS"));
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
            st = cn.prepareStatement(ConfigurationManager.getPropertySQL("SQL_CREATE_PAYMENT"));
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
            st = cn.prepareStatement(ConfigurationManager.getPropertySQL("SQL_UPDATE_PAYMENT"));
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
            st = cn.prepareStatement(ConfigurationManager.getPropertySQL("SQL_DELETE_PAYMENT"));
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