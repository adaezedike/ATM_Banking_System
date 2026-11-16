public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        if (balance < 0) {
            System.out.println("Initial balance cannot be negative");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            System.out.println("Invalid deposit amount.");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;            
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(0.0);
        System.out.println("Initial Balance: " + account.getBalance());

        if (account.deposit(500.0)) {
            System.out.println("Deposit successful.");
        }else{
            System.out.println("Deposit failed.");
        }
        System.out.println("Balance after deposit: " + account.getBalance());

        if (account.withdraw(200.0)) {
            System.out.println("Withdrawal successful.");
        }else{
            System.out.println("Withdrawal failed.");
        }
        System.out.println("Balance after withdrawal: " + account.getBalance());

    }
}
