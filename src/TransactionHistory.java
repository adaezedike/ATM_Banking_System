import java.util.ArrayList;

class TransactionHistory {
    private ArrayList<String> transactions = new ArrayList<>();

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    public void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }

    }
}