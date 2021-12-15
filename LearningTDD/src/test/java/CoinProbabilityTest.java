import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinProbabilityTest {

    CoinProbability coinProbability = new CoinProbability();

    @Nested
    class TestEqualProbability{
        @Test
        public void checkProbabilityOfHeadIsEqualToProbabilityOfTailInACoinToss(){
            double actualProbability = coinProbability.equalProbability(1,2);
            double expectedProbability = 0.5;
            assertEquals(expectedProbability,actualProbability);
        }
    }
    @Nested
    class TestTwoEventsOccurring{
        @Test
        public void checkProbabilityOfTwoEventsOccurringTogetherInCoinToss(){
            double actualProbability = coinProbability.twoEventsOccurringTogether(1,1);
            double expectedProbability = 0.25;
            assertEquals(expectedProbability,actualProbability);
        }
    }

    @Nested
    class EventsNotOccurrence {

        @Test
        public void checkProbabilityOfHeadEventsOccurringInCoinToss() {
            double actualProbability = coinProbability.twoEventsNotOccurringTogether(1, 0);
            double expectedProbability = 0.5;
            assertEquals(expectedProbability, actualProbability);
        }

        @Test
        public void checkProbabilityOfSecondEventsOccurringInCoinToss() {
            double actualProbability = coinProbability.twoEventsNotOccurringTogether(0, 1);
            double expectedProbability = 0.5;
            assertEquals(expectedProbability, actualProbability);
        }
    }
    @Nested
    class EitherEventsOccurrence {

        @Test
        public void checkProbabilityOfEitherEventsOccurringInCoinToss() {
            double actualProbability = coinProbability.eitherEventsOccurring(1, 1);
            double expectedProbability = 0.75;
            assertEquals(expectedProbability, actualProbability);
        }

        @Test
        public void checkIfFavorableOutcomeIsZero() {
            assertThrows(IllegalArgumentException.class, () -> {
                coinProbability.probability(0, 2);
            });
        }
    }
}






//As a statistician, I want to be able to know that the probability of a heads in a coin toss
// is equal to the probability of a tails in a coin toss.
//--->
// As a statistician, I want to be able to know the probability of two events occurring together.
//---> (1/2)*(1/2)->1/4->0.25
// As a statistician, I want to be able to know the probability of an event not occurring.
//1-Probability-->1/2-->0.5
// As a statistician, I want to be able to know the probability of either two events occurring.
//(1/2)+(1/2)-(1/4)-->0.75