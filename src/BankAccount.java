
public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        if (balance < 0) {
            System.out.println("Initial balance cannot be negative.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid deposit amount.");
            return false;
        }

        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }

        balance -= amount;
        return true;
    }
}
