package by.epam.payments;

import by.epam.dao.ClientDao;

import java.util.List;

public class ClientMain {
    public static void main(String[] args) {

       // Utility utility = new Utility();
      //  utility.getConnection();

        Client clientZero = new Client(7, "Seventh", "New York", "425345", "243");

        ClientDao clientDao = new ClientDao();
        List<Client> all = clientDao.findAll();
        for(Client cl : all) {
            System.out.println(cl);
        }
        System.out.println("");
      //  clientDao.insertClient(clientZero);

        all = clientDao.findAll();
        for(Client cl : all) {
            System.out.println(cl);
        }

     /*   Set<Payment> payments = new HashSet<>();

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
        bankAccount.setAccountNumber(1254144556L);
        bankAccount2.setAccountNumber(114425254556L);
        System.out.println(bankAccount.hashCode());
        System.out.println(bankAccount.hashCode());
        System.out.println(bankAccount2.hashCode());
        System.out.println(bankAccount2.hashCode());
        */
    }
}