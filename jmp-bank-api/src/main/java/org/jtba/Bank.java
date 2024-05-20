package org.jtba;


import BankCard.java; // Import the BankCard class
import User.java; // Import the User class
import BankCardType.java;

public interface Bank {
    BankCard createBankCard(User user, BankCardType type);
}