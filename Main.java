import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double balance = 1000;

        while (true) {

            menu();
            int option = scanner.nextInt();
            if (option == 4) {
                System.out.println("Thank you for choosing AA BAnk");
                break;
            }
            switch (option) {
                case 1:
                    balance = withdrawal(balance, scanner);
                    break;
                case 2:
                    balance = depositMoney(balance, scanner);
                    break;

                case 3:
                    checkBalance(balance);
                    break;

                default:
                    System.out.println("invalid option choose 1-4");
            }
        }

        scanner.close();

    }

    public static double withdrawal(double balance, Scanner scanner) {
        System.out.println("How much do you want to Withdraw");

        // double balance=1000;
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Enter a valid amount");
        } else if (amount > balance) {
            System.out.println("insufficient funds");
        } else {
            balance -= amount;
            System.out.println("Your available Balance is " + balance);
        }

        return balance;

    }

    public static double depositMoney(double balance, Scanner scanner) {
        System.out.println("How much do you want to Deposit");
        double deposit = scanner.nextDouble();
        if (deposit > 0) {
            balance += deposit;
            System.out.println("Your available Balance is " + balance);
        } else {
            System.out.println("Enter a valid amount");
        }
        return balance;
    }

    public static void checkBalance(double balance) {
        System.out.println("Your balance is £" + balance);
    }

    public static void menu() {
        System.out.println("\n===== AA BANK =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
}
