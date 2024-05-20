public class DebitBankCard extends BankCard {
    private double balance;

    public DebitBankCard(String number, User user, double balance) {
        super(number, user);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}