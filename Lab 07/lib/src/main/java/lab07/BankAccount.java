package lab07;

/* BankAccount

 * A bank account has a balance and an interest rate.
 * (note - in real life, NEVER use floating point numbers
 * to represent currency - use a specialized data type like
 * Java's BigDecimal instead.
 *
 * The rules of bank accounts:
 *
 *  Interest rates and balances can never be negative
 *  Accounts are either open or closed - if they're open,
 *  they can be closed if they have < 1 cent left in them.
 *  Attempting to close an account with >= 1 cent should
 *  throw an IllegalStateException.
 *
 */

public class BankAccount {

    private float balance;
    private float interestRate;
    private boolean open;

    public BankAccount() {
        this(0, 0);
    }

    public BankAccount(float balance, float interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
        this.open = true;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float newBalance) {
        this.balance = newBalance;
    }

    public float getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(float newInterestRate) {
        this.interestRate = newInterestRate;
    }

    public void applyInterest() {
        float oldBalance = this.balance;
        float newInterest = this.calculateInterest();
        this.setBalance(oldBalance + newInterest);
    }

    private float calculateInterest() {
        return this.balance * this.interestRate;
    }

    public void close() {
        if (!this.open) return;
        this.open = false;
    }
}
