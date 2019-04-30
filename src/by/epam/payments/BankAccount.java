package by.epam.payments;

import java.util.List;
import java.util.Objects;

public class BankAccount {
    private int idAccount;
    private Long accountNumber;             //account number in payment system
    private Boolean isBlocked = false;    //blocked account indicator
    private int ownerId;
    private List<Long> creditCards;

    public BankAccount() {
    }

    public BankAccount(int idAccount, Long accountNumber, Boolean isBlocked, int ownerId) {
        this.idAccount = idAccount;
        this.accountNumber = accountNumber;
        this.isBlocked = isBlocked;
        this.ownerId = ownerId;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public List<Long> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<Long> creditCards) {
        this.creditCards = creditCards;
    }

    @Override                               //override hashCode and toString methods
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "BankAccount: " +
                "accountNumber - " + accountNumber +
                ", isBlocked - " + isBlocked;
    }
}