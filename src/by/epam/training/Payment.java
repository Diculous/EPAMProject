package by.epam.training;

import java.util.Objects;

public class Payment {
    private BankAccount bankAccount;        //used bank account
    private Integer paymentValue;           //amount of money used in payment

    public Payment() {
    }

    public Payment(BankAccount bankAccount, Integer paymentValue) {
        this.bankAccount = bankAccount;
        this.paymentValue = paymentValue;
    }
                                                                        //getters and setters
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Integer getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(Integer paymentValue) {
        this.paymentValue = paymentValue;
    }

    @Override                                                                 //override hashCode and toString methods
    public int hashCode() {
        return Objects.hash(bankAccount, paymentValue);
    }

    @Override
    public String toString() {
        return "Payment: " +
                bankAccount +
                ", paymentValue - " + paymentValue;
    }
}
