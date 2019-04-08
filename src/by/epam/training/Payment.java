package by.epam.training;

public class Payment {
    BankAccount bankAccount;
    Integer paymentValue;

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
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Payment{" +
                "bankAccount=" + bankAccount +
                ", paymentValue=" + paymentValue +
                '}';
    }
}
