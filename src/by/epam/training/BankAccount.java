package by.epam.training;

import java.util.Objects;

public class BankAccount {
    private Long accountNumber;             //account number in payment system
    protected Boolean isBlocked = false;    //blocked account indicator

                                                                                //getters and setters
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