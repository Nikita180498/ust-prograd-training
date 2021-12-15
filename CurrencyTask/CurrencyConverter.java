package CurrencyTask;

public class CurrencyConverter {
    public double rupeeToDollar(double moneyInRupee){
        return moneyInRupee / 74.85;
    }
    public double rupeeToPound(double moneyInRupee){
        return moneyInRupee / 99.91;
    }
    public double rupeeToEuro(double moneyInRupee){
        return moneyInRupee / 85.67;
    }
    public double rupeeToAustralianDollar(double moneyInRupee){
        return moneyInRupee / 53.63;
    }
    public double rupeeToCanadaDollar(double moneyInRupee){
        return moneyInRupee / 59.11;
    }
}



















//import java.util.Scanner;
//
//public class KboatRupeeDollar
//{
//    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Type 1 for Rupee to Dollar conversion: ");
//        System.out.println("Type 2 for Dollar to Rupee conversion: ");
//        System.out.print("Enter your choice: ");
//        int choice = in.nextInt();
//        switch (choice) {
//            case 1:
//            System.out.print("Enter rupee amount: ");
//            double r1 = in.nextDouble();
//            double d1 = r1 / 77;
//            System.out.println(r1 + " rupees => " + d1 + " dollars");
//            break;
//
//            case 2:
//            System.out.print("Enter dollar amount: ");
//            double d2 = in.nextDouble();
//            double r2 = d2 * 77;
//            System.out.println(d2 + " dollars => " + r2 + " rupees");
//            break;
//
//            default:
//            System.out.println("Incorrect Choice");
//        }
//    }
//}