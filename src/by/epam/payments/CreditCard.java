package by.epam.payments;

import java.util.Objects;

public class CreditCard {
    private Long cardNumber;            //card number
    private BankAccount account;        //bank account linked to the credit card

    public CreditCard() {
    }

    public CreditCard(Long cardNumber, BankAccount account) {
        this.cardNumber = cardNumber;
        this.account = account;
    }
                                                            // getters and setters
    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    @Override                                               //override hashCode and toString methods
    public int hashCode() {
        return Objects.hash(cardNumber);
    }

    @Override
    public String toString() {
        return "CreditCard: " +
                "cardNumber - " + cardNumber +
                ", " + account.toString();
    }
}