package org.jtbi;

import org.jtba.Bank;


public class BankImpl implements Bank {
    public BankCard createBankCard(User user, BankCardType type) {
        if (type == BankCardType.CREDIT) {
            return new CreditCard(user);
        } else if (type == BankCardType.DEBIT) {
            return new DebitCard(user);
        }
        return null;
    }
}