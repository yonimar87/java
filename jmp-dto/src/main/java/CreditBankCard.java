public class CreditBankCard extends BankCard {
    private int creditLimit;

    public CreditBankCard(String number, User user, int creditLimit) {
        super(number, user);
        this.creditLimit = creditLimit;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }
}