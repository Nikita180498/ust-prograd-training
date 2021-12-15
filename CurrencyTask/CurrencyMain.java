package CurrencyTask;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CurrencyMain {

    public static void main(String[] args) throws IOException {

        CurrencyConverter currencyConverter=new CurrencyConverter();

        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.info("Program Started...\n");

        System.out.println("1.INR To USD");
        System.out.println("2.INR To GBP");
        System.out.println("3.INR To EUR");
        System.out.println("4.INR To AUD");
        System.out.println("5.INR To CAD");
        System.out.println("Enter your choice:");

        int choice=sc.nextInt();

        switch (choice) {
            case 1 -> {
                logger.info("User selected INR to USD");
                System.out.print("Enter rupee amount: ");
                double amountInRupees = sc.nextDouble();
                logger.info("User entered amount : " +amountInRupees );
                if (amountInRupees < 0) {
                    throw new IllegalArgumentException("Amount can't be zero or negative...");
                } else {
                    System.out.printf("Amount In USD : %.2f ",currencyConverter.rupeeToDollar(amountInRupees));
                }
            }

            case 2 -> {
                logger.info("User selected INR to GBP  ");
                System.out.print("Enter rupee amount: ");
                double amountInRupees = sc.nextDouble();
                logger.info("User entered amount: " +amountInRupees );
                if (amountInRupees < 0) {
                    throw new IllegalArgumentException("Amount can't be zero or negative...");
                } else {
                    System.out.printf("Amount In GBP : %.2f " , currencyConverter.rupeeToPound(amountInRupees));
                }
            }

            case 3 -> {
                logger.info("User selected INR to EUP ");
                System.out.print("Enter rupee amount: ");
                double amountInRupees = sc.nextDouble();
                logger.info("User entered amount : " +amountInRupees );
                if (amountInRupees < 0) {
                    throw new IllegalArgumentException("Amount can't be zero or negative...");
                } else {
                    System.out.printf("Amount In EUP : %.2f " , currencyConverter.rupeeToEuro(amountInRupees));
                }
            }

            case 4 -> {
                logger.info("User selected INR to AUD ");
                System.out.print("Enter rupee amount: ");
                double amountInRupees = sc.nextDouble();
                logger.info("User entered amount : " +amountInRupees );
                if (amountInRupees < 0) {
                    throw new IllegalArgumentException("Amount can't be zero or negative...");
                } else {
                    System.out.printf("Amount In USD : %.2f" , currencyConverter.rupeeToAustralianDollar(amountInRupees));
                }
            }

            case 5 -> {
                logger.info("User selected INR to CAD");
                System.out.print("Enter rupee amount: ");
                double amountInRupees = sc.nextDouble();
                logger.info("User entered amount : " +amountInRupees );
                if (amountInRupees < 0) {
                    throw new IllegalArgumentException("Amount can't be zero or negative...");
                } else {
                    System.out.printf("Amount In CAD : %.2f " , currencyConverter.rupeeToCanadaDollar(amountInRupees));
                }
            }

            default -> {
                System.out.println("Incorrect Choice");
            }
        }
        logger.info("Program Stopped...");
    }
}
