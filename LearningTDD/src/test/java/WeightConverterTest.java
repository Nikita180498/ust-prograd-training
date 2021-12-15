import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterTest {

    WeightConverter weightConverter = new WeightConverter();

    @Nested
    class GramToGramTest{
        @Test
        public void checkIfOneGramIsEqualToGram(){
            double actualWeight = weightConverter.gramToGram(1);
            double expectedWeight = 1;
            assertEquals(expectedWeight, actualWeight);
        }
    }
    @Nested
    class KilogramToGramTest{
        @Test
        public void checkIfOneGramIsEqualToGram(){
            double actualWeight = weightConverter.gramToGram(1);
            double expectedWeight = 1;
            assertEquals(expectedWeight, actualWeight);
        }
    }

}