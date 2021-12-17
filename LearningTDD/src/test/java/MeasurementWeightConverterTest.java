import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MeasurementWeightConverterTest {
    MeasurementConverter measurementConverter = new MeasurementConverter();
    @Nested
    public class TestWeightMeasurements{
        @Nested
        public class TestDifferentWeights{
            @Test
            public void checkIfOneGramIsEqualToOneGram(){
                double actualValue=measurementConverter.baseToBase(1);
                double expectedValue=1;
                Assertions.assertEquals(expectedValue,actualValue);
            }
            @Test
            public void checkIfZerPointOneKilogramIsEqualToOneHundredGram(){
                double actualValue=measurementConverter.kiloToBase(0.1);
                double expectedValue=100;
                Assertions.assertEquals(expectedValue,actualValue);
            }
            @Test
            public void checkAdditionOfTenGramAndOneKilogramIsThousandAndTenGrams(){
                double actualValue=10+measurementConverter.kiloToBase(1);
                double expectedValue=1010;
                Assertions.assertEquals(expectedValue,actualValue);
            }
            @Test
            public void checkSubtractionOfOnePointFiveKilogramAndFiveHundredGramIsOneKilogram(){
                double actualValue=1.5-measurementConverter.baseToKilo(500);
                double expectedValue=1;
                Assertions.assertEquals(expectedValue,actualValue);
            }
        }
    }

}