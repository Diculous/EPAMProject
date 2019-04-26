package by.epam.payments;

import java.util.Objects;

public class Client {
    private int id;
    private String name;                            //client name
    private String adress;                            //client name
    private String passport;
    private String dateOfBirth;

    public Client() {
    }

    public Client(int id, String name, String adress, String passport, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.passport = passport;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // private HashSet<CreditCard> creditCards;        //array of client's credit cards

  /*  public Client() {
        this.creditCards = new HashSet<>();
    }

    public Client(int id ,String name, HashSet<CreditCard> creditCards) {
        this.id = id;
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
    public int getId() { return id;}

    public void setId(int id) {this.id = id;}
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
                     */                           //override hashCode and toString methods
    @Override
    public int hashCode() {
        return Objects.hash(name, adress);
    }

    @Override
    public String toString() {
        return "Client: " +
                "id - " + id +
                ", name - " + name +
                ", adress - " + adress +
                ", passport - " + passport +
                ", date - " + dateOfBirth;
    }
}