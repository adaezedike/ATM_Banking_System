import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<String> transactions = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double balance = 1000;

        while (true) {

            displayMenu();
            int option = scanner.nextInt();
            if (option == 5) {
                System.out.println("Thank you for choosing AA Bank");
                
                break;
            }
            switch (option) {
                case 1:
                    balance = withdraw(balance, scanner);
                    break;
                case 2:
                    balance = deposit(balance, scanner);
                    break;

                case 3:
                    checkBalance(balance);
                    break;

                case 4:
                    showTransactionHistory(balance);
                    break;

                default:
                    System.out.println("invalid option choose 1-5");
            }
        }

        scanner.close();

    }

    public static double withdraw(double balance, Scanner scanner) {
        System.out.println("How much do you want to Withdraw");

        // double balance=1000;
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Enter a valid amount");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactions.add("Withdraw: -£" + amount);
            System.out.println("Your available Balance is " + balance);
        }

        return balance;

    }

    public static double deposit(double balance, Scanner scanner) {
        System.out.println("How much do you want to Deposit");
        double deposit = scanner.nextDouble();
        if (deposit > 0) {
            balance += deposit;
            transactions.add("Deposit: +£" + deposit);  
            System.out.println("Your available Balance is " + balance);
        } else {
            System.out.println("Enter a valid amount");
        }
        return balance;
    }

    public static void checkBalance(double balance) {
        System.out.println("Your balance is £" + balance);
    }

    public static void showTransactionHistory(double balance) {
        System.out.println("\n===== Transaction History =====");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }

        }  
            System.out.println("Current Balance: £" + balance);
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
