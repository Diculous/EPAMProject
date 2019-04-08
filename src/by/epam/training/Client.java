package by.epam.training;

import java.util.HashSet;
import java.util.Set;

public class Client {
    private String name;
    private HashSet<CreditCard> creditCards;

    public Client() {
        this.creditCards = new HashSet<>();
    }

    public Client(String name, HashSet<CreditCard> creditCards) {
        this.name = name;
        this.creditCards = creditCards;
    }

    public Client(String name, CreditCard creditCard) {
        this.name = name;
        this.creditCards = new HashSet<>();
        creditCards.add(creditCard);
    }

    void fill() {}

    void block(BankAccount bankAccount) {
        bankAccount.setBlocked(true);
    }

    Payment payment(BankAccount bankAccount, Integer paymentValue) {

        Payment payment = new Payment(bankAccount, paymentValue);
        System.out.println("Payment Created");

        return bankAccount.isBlocked ? null : payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(HashSet<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void addCreditCard(CreditCard creditCard) {
        this.creditCards.add(creditCard);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", creditCards=" + creditCards +
                '}';
    }

}
