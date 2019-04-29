package by.epam.interfacesDao;

import by.epam.payments.BankAccount;

import java.util.List;

public interface DAOBankAccount {
    List<BankAccount> findAll();
    boolean insertBankAccount(BankAccount bankAccount);
    boolean updateBnakAccount(BankAccount creditCard);
    boolean deleteBankAccount(BankAccount bankAccount);
}
