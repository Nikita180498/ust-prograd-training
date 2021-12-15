public class CoinProbability {

    double possibleOutcomes = 2;

    public double probability(double favorableOutcomes, double possibleOutcomes){
        if(favorableOutcomes == 0){
            throw new IllegalArgumentException(("Favorable Outcomes Cant be Zero"));
        }

        return favorableOutcomes/possibleOutcomes;

    }

    public double equalProbability(double favorableOutcomes, double possibleOutcomes){
        double tail = 1- (favorableOutcomes/possibleOutcomes);
        return  tail;
    }

    public double twoEventsOccurringTogether(double event1, double event2){
        return  probability(event1,possibleOutcomes) * probability(event2,possibleOutcomes);
    }

    public double twoEventsNotOccurringTogether(double event1, double event2){
        if(event1 ==1){
            return 1 - probability(event1,possibleOutcomes);
        }
        else {
            return 1 - probability(event2,possibleOutcomes);
        }
    }
    public double eitherEventsOccurring(double event1, double event2){
        return  probability(event1,possibleOutcomes) + probability(event2,possibleOutcomes) - twoEventsOccurringTogether(event1,event2);

    }

}
