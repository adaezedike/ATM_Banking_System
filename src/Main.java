import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<String> transactions = new ArrayList<>();

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
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
                    withdraw(account, scanner);
                    break;
                case 2:
                    deposit(account, scanner);
                    break;

                case 3:
                    checkBalance(account);
                    break;

                case 4:
                    showTransactionHistory(account);
                    break;

                default:
                    System.out.println("invalid option choose 1-5");
            }
        }

        scanner.close();

    }

    public static void withdraw(BankAccount account, Scanner scanner) {
        System.out.println("How much do you want to Withdraw");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            transactions.add("Withdraw: -£" + amount);
            System.out.println("Your available Balance is " + account.getBalance());
        }

    }

    public static void deposit(BankAccount account, Scanner scanner) {
        System.out.println("How much do you want to Deposit");
        double deposit = scanner.nextDouble();
       if (account.deposit(deposit)) {
        transactions.add("Deposit: +£" + deposit);
        System.out.println("Your available Balance is " + account.getBalance());
}
    }

    public static void checkBalance(BankAccount account) {
        System.out.println("Your balance is £" + account.getBalance());
    }


    public static void showTransactionHistory(BankAccount account) {
        System.out.println("\n===== Transaction History =====");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }

        }
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
