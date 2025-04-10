import java.util.Scanner;

// BankAccount class with encapsulation
class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance can't be negative. Setting to 0.");
            this.balance = 0;
        }
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Current Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Error: Insufficient funds. Current Balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Current Balance: " + balance);
        }
    }
}

public class BasicBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Account
        System.out.println("Create Account:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(name, accountNumber, initialBalance);

        // Operations
        System.out.print("\nEnter amount to Deposit: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);

        System.out.print("Enter amount to Withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);

        scanner.close();
    }
}
