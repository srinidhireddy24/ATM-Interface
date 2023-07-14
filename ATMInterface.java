import java.util.Scanner;

public class ATMInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static ATMSystem atmSystem = new ATMSystem();

    public static void main(String[] args) {
        showWelcomeMessage();

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();

            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            loggedIn = atmSystem.login(userId, pin);
            if (!loggedIn) {
                System.out.println("Invalid User ID or PIN. Please try again.");
            }
        }

        showMenu();
    }

    private static void showWelcomeMessage() {
        System.out.println("Welcome to the ATM System!");
    }

    private static void showMenu() {
        boolean quit = false;
        while (!quit) {
            System.out.println("ATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    atmSystem.showTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    atmSystem.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    atmSystem.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter the recipient's user ID: ");
                    String recipientUserId = scanner.nextLine();
                    System.out.print("Enter the amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    atmSystem.transfer(recipientUserId, transferAmount);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

class ATMSystem {
    private String userId = "srinidhi"; // User ID for demo purposes
    private String pin = "240903"; // PIN for demo purposes
    private double balance = 20000.0; // Initial balance for demo purposes

    public boolean login(String userId, String pin) {
        return this.userId.equals(userId) && this.pin.equals(pin);
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        // Retrieve and display transaction history
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
            System.out.println("..............");
            // Update transaction history
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
        } else {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
            // Update transaction history
        }
    }

    public void transfer(String recipientUserId, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            // Perform transfer to recipient's account
            System.out.println("Transfer successful. New balance: " + balance);
            // Update transaction history
        }
    }
}