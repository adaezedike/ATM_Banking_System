
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        TransactionHistory history = new TransactionHistory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int option = scanner.nextInt();

            if (option == 5) {
                System.out.println("Thank you for choosing AA Bank");
                break;
            }

            switch (option) {
                case 1:
                    withdraw(account, scanner, history);
                    break;

                case 2:
                    deposit(account, scanner, history);
                    break;

                case 3:
                    checkBalance(account);
                    break;

                case 4:
                    showTransactionHistory(account, history);
                    break;

                default:
                    System.out.println("Invalid option. Choose 1-5.");
            }
        }

        scanner.close();
    }

    public static void withdraw(BankAccount account, Scanner scanner, TransactionHistory history) {
        System.out.println("How much do you want to withdraw?");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            history.addTransaction("Withdraw: -£" + amount);
            System.out.println("Your available balance is £" + account.getBalance());
        }
    }

    public static void deposit(BankAccount account, Scanner scanner, TransactionHistory history) {
        System.out.println("How much do you want to deposit?");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            history.addTransaction("Deposit: +£" + amount);
            System.out.println("Your available balance is £" + account.getBalance());
        }
    }

    public static void checkBalance(BankAccount account) {
        System.out.println("Your balance is £" + account.getBalance());
    }

    public static void showTransactionHistory(BankAccount account, TransactionHistory history) {
        System.out.println("\n===== Transaction History =====");

        history.displayTransactions();

        System.out.println("Current Balance: £" + account.getBalance());
        System.out.println("--- end ---");
    }

    public static void displayMenu() {
        System.out.println("\n===== AA BANK =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }
}
