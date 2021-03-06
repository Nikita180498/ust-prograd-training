import exceptions.InsufficientFundsException;
import org.junit.jupiter.api.*;

class WalletTest {
    private Wallet wallet;

    @BeforeEach
    void setup() {
        wallet = new Wallet();
    }

    //    As a wallet owner, I would like to be able to know that 74.85 rupees is equal to 1 dollar.
    @Test
    public void verifySeventyFourRupeesEightyFiveIsOneDollar() {
        Assertions.assertEquals(1, wallet.rupeesToDollars(74.85));
    }

    @Test
    public void verifySetPreferredCurrencyOnlyAcceptsValidCurrencies() {
        Assertions.assertAll(
                () -> {
                    wallet.setPreferredCurrency("INR");
                    Assertions.assertEquals("INR", wallet.getPreferredCurrency());
                },
                () -> {
                    wallet.setPreferredCurrency("USD");
                    Assertions.assertEquals("USD", wallet.getPreferredCurrency());
                },
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> wallet.setPreferredCurrency("SOME"))
        );
    }

    @Nested
    class verifyDepositFunctionality {
        //    As a wallet owner I would like to be able to put money into my wallet so that I can take it out later.
        @Test
        public void verifyDepositFunctionalityWithSingleDeposit() {
            wallet.deposit(50);
            Assertions.assertEquals(50, wallet.getBalance());
        }

        @Test
        public void verifyDepositFunctionalityWithMultipleDeposits() {
            wallet.deposit(50);
            Assertions.assertEquals(50, wallet.getBalance());

            wallet.deposit(150);
            Assertions.assertEquals(200, wallet.getBalance());

            wallet.deposit(100);
            wallet.deposit(20);
            Assertions.assertEquals(320, wallet.getBalance());
        }

        @Test
        public void verifyDepositFunctionalityWithNegativeDeposit() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> wallet.deposit(-50));
        }

        //    As a wallet owner, I want to know the total money my wallet has for the preferred currency. When Rs.50 & $1 added to my wallet, Then the sum of money in the wallet is Rs.124.85, (Given preferred currency is Rs.)
        @Test
        @DisplayName("50 INR + 1 USD = 124 INR when preferred currency is INR")
        public void verifyMultipleCurrencyDepositWhenPreferredCurrencyIsINR() {
            wallet.setPreferredCurrency("INR");
            wallet.deposit(50, "INR");
            wallet.deposit(1, "USD");

            double balance = wallet.getBalance();
            Assertions.assertEquals(124.85, balance);
        }

        //    As a wallet owner, I want to know the total money my wallet has for the preferred currency. When Rs.74.85, $1, Rs.149.7 added to my wallet, Then sum of money in the wallet is $4, (Given preferred currency is $)
        @Test
        @DisplayName("74.85 INR + 1 USD + 149.7 INR = 4 USD, when preferred currency is USD")
        public void verifyMultipleCurrencyDepositWhenPreferredCurrencyIsUSD() {
            wallet.setPreferredCurrency("USD");
            wallet.deposit(74.85, "INR");
            wallet.deposit(1, "USD");
            wallet.deposit(149.7, "INR");

            double balance = wallet.getBalance();
            Assertions.assertEquals(4, balance);
        }
    }

    @Nested
    class verifyWithdrawFunctionality {
        //    As a wallet owner I would like to be able to take a specified amount of money out of the wallet.
        @Test
        public void verifyWithdrawFunctionalityWithSingleWithdrawal() throws InsufficientFundsException {
            wallet.deposit(50);
            Assertions.assertEquals(50, wallet.getBalance());
            wallet.withdraw(10);
            Assertions.assertEquals(40, wallet.getBalance());
        }

        @Test
        public void verifyWithdrawFunctionalityWithMultipleWithdrawal() throws InsufficientFundsException {
            wallet.deposit(50);
            Assertions.assertEquals(50, wallet.getBalance());
            wallet.withdraw(10);
            Assertions.assertEquals(40, wallet.getBalance());

            wallet.deposit(100);
            Assertions.assertEquals(140, wallet.getBalance());
            wallet.withdraw(50);
            Assertions.assertEquals(90, wallet.getBalance());

            wallet.deposit(10);
            Assertions.assertEquals(100, wallet.getBalance());
            wallet.withdraw(100);
            Assertions.assertEquals(0, wallet.getBalance());
        }

        @Test
        public void verifyWithdrawFunctionalityWithNegativeWithdrawal() {
            wallet.deposit(50);
            Assertions.assertThrows(IllegalArgumentException.class, () -> wallet.withdraw(-20));
        }

        @Test
        public void verifyWithdrawFunctionalityWithOverWithdrawal() {
            wallet.deposit(50);
            Assertions.assertThrows(InsufficientFundsException.class, () -> wallet.withdraw(100));
        }
    }

}






















//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CurrencyConverterTest {
//
//    CurrencyConverter currencyConverter = new CurrencyConverter();
//
//   @Nested
//    class ConvertCurrency {
//        @Test
//        public void checksIfSeventyFourPointEightFiveRupeesIsEqualToOneDollar() {
//            double actualCurrency = currencyConverter.rupeeToDollar(74.85);
//            double expectedCurrency = 1;
//            assertEquals(expectedCurrency, actualCurrency);
//        }
//
//    }
////    @Nested
////    class AddingMoneyToWallet{
////
////       @Test
////        public void addingMoneyToWallet(){
////           double actualCurrency = currencyConverter.addingMoneyToWallet(50);
////           double expectedCurrency = 50;
////
////           assertEquals(expectedCurrency,actualCurrency);
////       }
////
////    }
//    @Nested
//    class AddingRupeesAndDollar{
//       @Test
//        public void checksAddingFiftyRupeesAndOneDollarGivesOneTwentyFourPointEightFive(){
//           double actualCurrency = 50 + currencyConverter.dollarToRupees(1);
//           double expectedCurrency = 124.85;
//           assertEquals(expectedCurrency,actualCurrency);
//
//       }
//
//       @Test
//        public void checkAddingSeventyFourPointEightFiveAndOneDollarAndOneFortyNinePointSevenGivesFourDollar(){
//           double actualCurrency = 1 + currencyConverter.rupeeToDollar(74.85)+currencyConverter.rupeeToDollar(149.7);
//           double expectedCurrency = 4;
//           assertEquals(expectedCurrency,actualCurrency);
//       }
//
//    }
////    @Nested
////    class RetrievingAmount{
////       @Test
////        public void checksRetrievingSpecificAmount(){
////           double actualCurrency = currencyConverter.retrieveCurrency();
////       }
////    }
//
//
//
//}
//
//
//
//////    As a wallet owner, I would like to be able to know that 74.85 rupees is equal to 1 dollar.
//////        As a wallet owner I would like to be able to put money into my wallet so that I can take it out later.
//////        As a wallet owner, I want to know the total money my wallet has for the preferred currency. When Rs.50 & $1 added to my wallet, Then the sum of money in the wallet is Rs.124.85, (Given preferred currency is Rs.)
//////As a wallet owner, I want to know the total money my wallet has for the preferred currency. When Rs.74.85, $1, Rs.149.7 added to my wallet, Then sum of money in the wallet is $4, (Given preferred currency is $)
//////        As a wallet owner I would like to be able to take a specified amount of money out of the wallet.
////[11:07 am, 13/12/2021] +91 6303 262 822: public class CurrencyConverter {
////
////
////}