package by.epam.training;

import java.util.HashSet;
import java.util.Set;

public class ClientMain {
    public static void main(String[] args) {
        Set<Payment> payments = new HashSet<>();

        BankAccount bankAccount = new BankAccount();
        CreditCard creditCard = new CreditCard(125565545667654L, bankAccount);
        Client client = new Client();
        client.addCreditCard(creditCard);

        payments.add(client.payment(bankAccount, 125));
        payments.add(client.payment(bankAccount, 13325));

        BankAccount bankAccount2 = new BankAccount();
        CreditCard creditCard2 = new CreditCard(12556555667654L, bankAccount2);
        Client client2 = new Client();
        client2.addCreditCard(creditCard2);

        payments.add(client2.payment(bankAccount2, 142));

        client2.block(bankAccount2);
        System.out.println(bankAccount2);

        for (Payment pay : payments
             ) {
            System.out.println(pay);
        }
    }
}