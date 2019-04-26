package by.epam.payments;

import by.epam.dao.CardTypeDao;
import by.epam.dao.ClientDao;
import by.epam.dao.CreditCardDao;
import by.epam.dao.OperationTypeDao;

import java.util.ArrayList;
import java.util.List;

public class ClientMain {
    public static void main(String[] args) {

       // Utility utility = new Utility();
      //  utility.getConnection();

        List<OperationType> operationTypes = new ArrayList<>();
        CreditCardDao creditCardDao = new CreditCardDao();
        OperationTypeDao operationTypeDao = new OperationTypeDao();
        OperationType operationType = new OperationType("rerefill");

        operationTypes = operationTypeDao.findAll();

        for(OperationType op : operationTypes) {
            System.out.println(op);
        }

        //creditCardDao.deleteCard(creditCard);

      /*  Client clientZero = new Client(7, "Seventh", "New York", "425345", "243");
        CardType cardTypeZero = new CardType("Gold", 10);

        ClientDao clientDao = new ClientDao();
        CardTypeDao cardType = new CardTypeDao();

        List<CardType> cardTypes = cardType.findAll();

        for (CardType ct : cardTypes) {
            System.out.println(ct);
        }

        cardType.updateCardType(cardTypeZero, "Goldenous");

        cardTypes = cardType.findAll();

        for (CardType ct : cardTypes) {
            System.out.println(ct);
        }

        /*
       // List<Client> all = clientDao.findAll();
      //  for(Client cl : all) {
       //     System.out.println(cl);
      //  }

        for(CardType cl : cardTypes) {
            System.out.println(cl);
        }

       // System.out.println();
      //  clientDao.insertClient(clientZero);
        cardType.insertCardType(cardTypeZero);
        cardTypes = cardType.findAll();

      //  all = clientDao.findAll();
      //  for(Client cl : all) {
      //      System.out.println(cl);
      //  }

       // cardTypes = cardType.findAll();

        System.out.println();

        for(CardType cl : cardTypes) {
            System.out.println(cl);
        }

        cardType.deleteCardType(cardTypeZero);
        cardTypes = cardType.findAll();

        System.out.println();

        for(CardType cl : cardTypes) {
            System.out.println(cl);
        }
*/
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