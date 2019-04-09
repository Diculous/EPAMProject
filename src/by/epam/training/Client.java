package by.epam.training;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Client {
    private String name;                            //client name
    private HashSet<CreditCard> creditCards;        //array of client's credit cards

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

    void fill() {}                                  //method to replenish bank account

    void block(BankAccount bankAccount) {
        bankAccount.setBlocked(true);
    }   //block bank account

    Payment payment(BankAccount bankAccount, Integer paymentValue) {        //create a payment using bank account and amount of money
                                                                            //realization of payment method is created only for tests
        Payment payment = new Payment(bankAccount, paymentValue);
        System.out.println("Payment Created");

        return bankAccount.isBlocked ? null : payment;
    }
                                                    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(HashSet<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void addCreditCard(CreditCard creditCard) {
        this.creditCards.add(creditCard);
    }
                                                //override hashCode and toString methods
    @Override
    public int hashCode() {
        return Objects.hash(name, creditCards);
    }

    @Override
    public String toString() {
        return "Client: " +
                "name - " + name +
                ", creditCards - " + creditCards;
    }
}