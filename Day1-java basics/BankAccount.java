import java.util.Scanner;

public class BankAccount {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        float balance = 0f;
        while(true){
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.print("Choice 4 to exit: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    float amount;
                    System.out.print("Amount to deposit: ");
                    amount = sc.nextFloat();
                    balance = balance + amount;
                }
                case 2 -> {
                    System.out.print("Amount to withdraw: ");
                    float amount = sc.nextFloat();
                    balance = balance - amount;
                }
                case 3 -> System.out.println("Your balance: " + balance);
                case 4 -> System.exit(0);
                default -> System.out.println("Wrong choice...");
            }

        }

    }
}