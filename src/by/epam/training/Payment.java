package by.epam.training;

import java.util.Objects;

public class Payment {
    private BankAccount bankAccount;
    private Integer paymentValue;

    public Payment() {
    }

    public Payment(BankAccount bankAccount, Integer paymentValue) {
        this.bankAccount = bankAccount;
        this.paymentValue = paymentValue;
    }

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

    @Override
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
