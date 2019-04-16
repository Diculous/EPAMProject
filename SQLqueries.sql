CREATE DATABASE Bank;

CREATE TABLE bank.accounts (
idAccount int(11) NOT NULL AUTO_INCREMENT,
accNumber int(20) NOT NULL,
PRIMARY KEY (idAccount)

SELECT * FROM bank.accounts;

SELECT accNumber FROM bank.accounts;

SELECT accNumber FROM bank.accounts where accNumber BETWEEN 100000 and 300000;

SELECT SUM(paymentValue) FROM bank.payments;

SELECT MAX(paymentValue) FROM bank.payments;

INSERT INTO bank.accounts VALUES (4, 12345)

DELETE FROM bank.accounts WHERE (idAccount = 4);

UPDATE bank.accounts SET accNumber = 54321 WHERE idAccount = 3;

SELECT clients.name, cards.cardNumber 
FROM bank.clients 
JOIN bank.cards 
ON clients.idClient = cards.OwnerID;

SELECT clients.name, cards.cardNumber, accounts.accNumber 
FROM bank.clients 
JOIN bank.cards 
ON clients.idClient = cards.OwnerID
 
JOIN bank.accounts 
ON cards.AccID = accounts.idAccount;
