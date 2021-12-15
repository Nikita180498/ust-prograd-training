import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

   private Calculator calculator;

   @BeforeEach
   public void setup(){
      calculator = new Calculator();
   }

   //****** Addition ******

   @Nested
   class TestingAdditionFunction{
      @Test
      public void fivePlusFiveTen(){

         double answer = calculator.addition(5,5);
         double expected = 10;
         Assertions.assertEquals(answer, expected);
      }
      @Test
      public void fivePlusZeroFive(){

         double answer = calculator.addition(5,0);
         double expected = 5;
         Assertions.assertEquals(answer, expected);
      }
   }

   //****** Subtraction ******

   @Nested
   class TestingSubtractionFunction{
      @Test
      public void fiveMinusFiveZero(){

         double answer = calculator.subtraction(5,5);
         double expected = 0;
         Assertions.assertEquals(answer, expected);
      }
      @Test
      public void fiveMinusZeroFive(){

         double answer = calculator.subtraction(5,0);
         double expected = 5;
         Assertions.assertEquals(answer, expected);
      }
   }

   //****** Multiplication ******

   @Nested
   class TestingMultiplicationFunction{
      @Test
      public void fiveIntoFiveTwentyFive(){

         double answer = calculator.multiplication(5,5);
         double expected = 25;
         Assertions.assertEquals(answer, expected);
      }
      @Test
      public void fiveIntoZeroZero(){

         double answer = calculator.multiplication(5,0);
         double expected = 0;
         Assertions.assertEquals(answer, expected);
      }
   }

   //****** Division ******

   @Nested
   class TestingDivisionFunction{
      @Test
      public void fiveDivideFiveOne(){

         double answer = calculator.division(5,5);
         double expected = 1;
         Assertions.assertEquals(answer, expected);
      }
      @Test
      public void fiveDivideZeroExceptionDivideByZero(){
         Assertions.assertThrows(ArithmeticException.class, () -> calculator.division(5,0));
      }
   }


}

