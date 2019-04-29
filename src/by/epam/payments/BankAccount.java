package by.epam.payments;

import java.util.List;
import java.util.Objects;

public class BankAccount {
    private Long accountNumber;             //account number in payment system
    private Boolean isBlocked = false;    //blocked account indicator
    private List<Long> creditCards;
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