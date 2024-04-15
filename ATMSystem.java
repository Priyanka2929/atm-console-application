import java.util.Scanner;

// Class representing the ATM
class ATM {
    private double balance;

    public ATM(double balance) {
        this.balance = balance;
    }

    public double checkBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
    
    public void refill(double amount) {
        balance += amount;
    }
}

// Class representing the Admin
class Admin {
    public void refillATM(ATM atm, double amount) {
        atm.refill(amount);
        System.out.println("ATM refilled with: $" + amount);
    }
}

// Class representing the User
class User {
    public void checkBalance(ATM atm) {
        System.out.println("Your balance: $" + atm.checkBalance());
    }

    public void withdraw(ATM atm, double amount) {
        atm.withdraw(amount);
    }
}

// Main class for running the ATM system
public class ATMSystem {
    public static void main(String[] args) {
        ATM atm = new ATM(1000); // Initial ATM balance
        Admin admin = new Admin();
        User user = new User();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the ATM System!");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminMenu(atm, admin, scanner);
                    break;
                case 2:
                    userMenu(atm, user, scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminMenu(ATM atm, Admin admin, Scanner scanner) {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Refill ATM");
        System.out.println("2. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int adminChoice = scanner.nextInt();

        switch (adminChoice) {
            case 1:
                System.out.print("Enter refill amount: $");
                double refillAmount = scanner.nextDouble();
                admin.refillATM(atm, refillAmount);
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void userMenu(ATM atm, User user, Scanner scanner) {
        System.out.println("\nUser Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                user.checkBalance(atm);
                break;
            case 2:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                user.withdraw(atm, withdrawAmount);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
