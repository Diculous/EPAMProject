package by.epam.training;

public class CreditCard {
    private Long cardNumber;
    private BankAccount account;

    public CreditCard() {
    }

    public CreditCard(Long cardNumber, BankAccount account) {
        this.cardNumber = cardNumber;
        this.account = account;
    }

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber=" + cardNumber +
                ", account=" + account.toString() +
                '}';
    }
}